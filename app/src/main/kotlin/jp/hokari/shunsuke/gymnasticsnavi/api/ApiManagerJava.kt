package jp.hokari.shunsuke.gymnasticsnavi.api

import com.facebook.stetho.okhttp3.StethoInterceptor
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import java.lang.reflect.Type
import java.util.Arrays

import jp.hokari.shunsuke.gymnasticsnavi.api.service.GymnastNaviApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import timber.log.Timber

/**
 * Created by shunsukehokari on 2016/11/28.
 */

object ApiManagerJava {
    private val BASE_URL = "http://weather.livedoor.com"

    private var sApiService: GymnastNaviApiService? = null

    @Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
    @Retention(RetentionPolicy.RUNTIME)
    annotation class ErrorHandling(vararg val value: Type = arrayOf(Type.NetworkError, Type.ApiError)) {
        enum class Type {
            NetworkError, ApiError
        }
    }

    init {
        val loggingInterceptor = HttpLoggingInterceptor { message -> Timber.d(message) }
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .addNetworkInterceptor(StethoInterceptor())
                .build()

        val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(CustomRxJavaCallAdapterFactory())
                .build()

        sApiService = retrofit.create(GymnastNaviApiService::class.java)
    }

    fun myApi(): GymnastNaviApiService {
        return sApiService
    }

    private class CustomRxJavaCallAdapterFactory : CallAdapter.Factory() {
        private val mFactory = RxJavaCallAdapterFactory.create()

        private var mIsNetworkError: Boolean = false
        private var mIsApiError: Boolean = false

        override fun get(returnType: Type, annotations: Array<Annotation>, retrofit: Retrofit): CallAdapter<*> {
            val callAdapter = mFactory.get(returnType, annotations, retrofit)

            Observable.from(annotations).subscribe { annotation ->
                if (annotation.annotationType() == ErrorHandling::class.java) {
                    val types = Arrays.asList<Type>(*(annotation as ErrorHandling).value())
                    mIsNetworkError = types.contains(ErrorHandling.Type.NetworkError)
                    mIsApiError = types.contains(ErrorHandling.Type.ApiError)
                }
            }

            return CallAdapterWrapper(callAdapter, mIsNetworkError, mIsApiError)
        }

        private inner class CallAdapterWrapper private constructor(private val mBaseCallAdapter: CallAdapter<*>, private val mIsNetworkError: Boolean, private val mIsApiError: Boolean) : CallAdapter<Observable<*>> {

            override fun responseType(): Type {
                return mBaseCallAdapter.responseType()
            }

            override fun <R> adapt(call: Call<R>): Observable<R> {
                var observable = (mBaseCallAdapter.adapt(call) as Observable<R>)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .unsubscribeOn(Schedulers.io())


                if (mIsNetworkError) {
                    observable = observable.onErrorResumeNext { throwable ->
                        Observable.create<Any> { subscriber ->
                            Timber.d("====NetworkError")
                            //                            subscriber.onError(throwable);
                            subscriber.onCompleted()
                        }
                    }
                }

                if (mIsApiError) {
                    observable = observable.concatMap<R>({ response ->
                        Observable.create({ subscriber ->
                            if (response is Response<*> && !(response as Response<*>).isSuccessful) {
                                Timber.d("====ApiError")
                            } else {
                                Timber.d("====ResponseType = " + (response as Response<*>).code())
                                subscriber.onNext(response)
                                subscriber.onCompleted()
                            }
                        } as Observable.OnSubscribe<R>)
                    })
                }

                return observable
            }
        }
    }
}
