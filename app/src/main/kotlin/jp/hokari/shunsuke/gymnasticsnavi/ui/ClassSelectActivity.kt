package jp.hokari.shunsuke.gymnasticsnavi.ui

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.jakewharton.rxbinding.view.RxView
import jp.hokari.shunsuke.gymnasticsnavi.R
import jp.hokari.shunsuke.gymnasticsnavi.databinding.ActivityClassSelectBinding

/**
 * クラス選択画面
 *
 * Created by shunsukehokari on 2016/02/22.
 */
class ClassSelectActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityClassSelectBinding>(this, R.layout.activity_class_select)

        // 初心者クラスのクリックイベント
        RxView.clicks(binding.btnBeginnerClass).subscribe { MainActivity.startMainActivity(this@ClassSelectActivity, MainActivity.Genre.BEGINNER) }

        // 体操競技クラスのクリックイベント
        RxView.clicks(binding.btnProfessionalClass).subscribe { startActivity(Intent(this@ClassSelectActivity, GenderSelectActivity::class.java)) }
    }
}