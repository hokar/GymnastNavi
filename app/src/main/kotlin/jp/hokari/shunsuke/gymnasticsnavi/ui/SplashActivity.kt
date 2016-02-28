package jp.hokari.shunsuke.gymnasticsnavi.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.ActionBarActivity
import jp.hokari.shunsuke.gymnasticsnavi.R

/**
 * スプラッシュアクティビティ
 *
 * Created by shunsuke on 16/02/21.
 */
class SplashActivity : ActionBarActivity() {

    private val NEXT_ACTIVITY_DELAY : Long = 3000L

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        nextStartActivity()
    }

    private fun nextStartActivity() {
        Handler().postDelayed({
            startActivity(Intent(this@SplashActivity, ClassSelectActivity::class.java))
            finish()
        }, NEXT_ACTIVITY_DELAY)
    }
}