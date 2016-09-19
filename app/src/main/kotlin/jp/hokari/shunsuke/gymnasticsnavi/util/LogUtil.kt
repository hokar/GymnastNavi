package jp.hokari.shunsuke.gymnasticsnavi.util

import android.util.Log
import jp.hokari.shunsuke.gymnasticsnavi.BuildConfig

/**
 * ログ出力クラス
 *
 * Created by shunsuke on 16/04/03.
 */
class LogUtil {
    companion object {
        private val TAG = "GymnasticsNavi"

        /**
         * dログを出力
         *
         * @param message メッセージ
         */
        fun d(message : String) {
            if (BuildConfig.DEBUG) {
                Log.d(TAG, message)
            }
        }

        /**
         * eログを出力
         *
         * @param message メッセージ
         */
        fun e(message : String) {
            if (BuildConfig.DEBUG) {
                Log.e(TAG, message)
            }
        }

        /**
         * iログを出力
         *
         * @param message メッセージ
         */
        fun i(message : String) {
            if (BuildConfig.DEBUG) {
                Log.i(TAG, message)
            }
        }

        /**
         * vログを出力
         *
         * @param message メッセージ
         */
        fun v(message : String) {
            if (BuildConfig.DEBUG) {
                Log.v(TAG, message)
            }
        }

        /**
         * wログを出力
         *
         * @param message メッセージ
         */
        fun w(message : String) {
            if (BuildConfig.BUILD_TYPE.equals(BuildConfig.DEBUG)) {
                Log.w(TAG, message)
            }
        }
    }
}