package jp.hokari.shunsuke.gymnasticsnavi

import android.os.Bundle
import android.support.v7.app.ActionBarActivity

/**
 * スプラッシュアクティビティ
 *
 * Created by shunsuke on 16/02/21.
 */
class SplashActivity : ActionBarActivity() {

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        nextStartActivity()
    }

    private fun nextStartActivity() {
        // TODO: 遷移先を決定
    }
}