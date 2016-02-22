package jp.hokari.shunsuke.gymnasticsnavi

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.ActionBarActivity
import android.util.Log
import jp.hokari.shunsuke.gymnasticsnavi.databinding.ActivityClassSelectBinding

/**
 * クラス選択画面
 *
 * Created by shunsukehokari on 2016/02/22.
 */
class ClassSelectActivity : ActionBarActivity() {

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityClassSelectBinding>(this, R.layout.activity_class_select)

        // 初心者クラスのクリックイベント
        binding.btnBeginnerClass.setOnClickListener({
            Log.d("aaa", "beginner class button clicked")
        })

        // 体操競技クラスのクリックイベント
        binding.btnProfessionalClass.setOnClickListener({
            Log.d("aaa", "professional class button clicked")
            startActivity(Intent(this@ClassSelectActivity, GenderSelectActivity::class.java))
        })
    }
}