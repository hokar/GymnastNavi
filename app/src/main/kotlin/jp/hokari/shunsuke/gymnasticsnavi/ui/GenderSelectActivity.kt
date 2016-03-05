package jp.hokari.shunsuke.gymnasticsnavi.ui

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import jp.hokari.shunsuke.gymnasticsnavi.R
import jp.hokari.shunsuke.gymnasticsnavi.databinding.ActivityGenderSelectBinding

/**
 * 性別選択画面
 *
 * Created by shunsuke on 16/02/22.
 */
class GenderSelectActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityGenderSelectBinding>(this, R.layout.activity_gender_select)


        binding.btnMale.setOnClickListener(View.OnClickListener {
            Log.d("aaa", "onClick Male Button");
            startActivity(Intent(this@GenderSelectActivity, MainActivity::class.java))
        })

        binding.btnFemale.setOnClickListener(View.OnClickListener {
            Log.d("aaa", "onClick Female Button");
        })
    }
}