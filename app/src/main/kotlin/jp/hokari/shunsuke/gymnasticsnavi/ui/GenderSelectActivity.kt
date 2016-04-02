package jp.hokari.shunsuke.gymnasticsnavi.ui

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Button
import jp.hokari.shunsuke.gymnasticsnavi.R
import jp.hokari.shunsuke.gymnasticsnavi.databinding.ActivityGenderSelectBinding
import jp.hokari.shunsuke.gymnasticsnavi.util.LogUtil

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
            LogUtil.d("onClick Male Button")
            MainActivity.startMainActivity(this@GenderSelectActivity, MainActivity.Genre.MALE)
        })

        binding.btnFemale.setOnClickListener(View.OnClickListener {
            LogUtil.d("onClick Female Button")
            MainActivity.startMainActivity(this@GenderSelectActivity, MainActivity.Genre.FEMALE)
        })
    }
}