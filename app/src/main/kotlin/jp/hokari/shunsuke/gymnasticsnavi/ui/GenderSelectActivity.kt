package jp.hokari.shunsuke.gymnasticsnavi.ui

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.jakewharton.rxbinding.view.RxView
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

        RxView.clicks(binding.btnMale).subscribe { MainActivity.startMainActivity(this@GenderSelectActivity, MainActivity.Genre.MALE) }
        RxView.clicks(binding.btnFemale).subscribe { MainActivity.startMainActivity(this@GenderSelectActivity, MainActivity.Genre.FEMALE) }
    }
}