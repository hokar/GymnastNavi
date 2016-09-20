package jp.hokari.shunsuke.gymnasticsnavi.ui.common

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import jp.hokari.shunsuke.gymnasticsnavi.R
import jp.hokari.shunsuke.gymnasticsnavi.databinding.ActivityModalBinding
import jp.hokari.shunsuke.gymnasticsnavi.ui.detail.SkillDetailFragment

/**
 * モーダル起動するアクティビティ
 * TODO:モーダルっぽいアニメーションを実装（実際はmanifestファイルに定義)
 *
 * Created by shunsuke on 2016/09/20.
 */
class ModalActivity: AppCompatActivity() {

    companion object {

        private val TITLE = "TITLE"

        /**
         * 指定した画面をモーダルで起動します
         */
        fun startModal(context: Context, title: String) {
            val intent = Intent(context, ModalActivity::class.java)
            intent.putExtra(TITLE, title)

            context.startActivity(intent)
        }

        /**
         * モーダルを閉じます
         */
        fun dismissModal(activity: ModalActivity) {
            activity.finish()
        }
    }

    private var mBinding: ActivityModalBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView<ActivityModalBinding>(this, R.layout.activity_modal)

        val title = intent.getStringExtra(TITLE)
        mBinding?.navigationTitle = title

        // TODO:呼び出し元で表示させるfragmentを切り替えられるようにする
        val fragment = SkillDetailFragment()
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.commit()
    }
}