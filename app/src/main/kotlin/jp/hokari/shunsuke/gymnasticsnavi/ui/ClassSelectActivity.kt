package jp.hokari.shunsuke.gymnasticsnavi.ui

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import jp.hokari.shunsuke.gymnasticsnavi.R
import jp.hokari.shunsuke.gymnasticsnavi.databinding.ActivityClassSelectBinding
import jp.hokari.shunsuke.gymnasticsnavi.util.LogUtil

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
        binding.btnBeginnerClass.setOnClickListener({
            LogUtil.d("beginner class button clicked")
            MainActivity.startMainActivity(this@ClassSelectActivity, MainActivity.Genre.BEGINNER)
        })

        // 体操競技クラスのクリックイベント
        binding.btnProfessionalClass.setOnClickListener({
            LogUtil.d("professional class button clicked")
            startActivity(Intent(this@ClassSelectActivity, GenderSelectActivity::class.java))
        })
    }
}