package jp.hokari.shunsuke.gymnasticsnavi.ui

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.app.ListFragment
import android.support.v7.app.AppCompatActivity
import jp.hokari.shunsuke.gymnasticsnavi.R
import jp.hokari.shunsuke.gymnasticsnavi.databinding.ActivityMainBinding
import jp.hokari.shunsuke.gymnasticsnavi.ui.skill.SkillListFragment

class MainActivity : AppCompatActivity() {

    /**
     * タブタイプ
     *
     * MALE : 男子種目
     * FEMALE : 女子種目
     * BEGINNER : 初心者種目
     */
    public enum class Genre(var arrayResId : Int) {
        MALE(R.array.male_tabs),
        FEMALE(R.array.female_tabs),
        BEGINNER(R.array.beginner_tabs)
    }

    companion object {
        private val ARG_GENRE = "ARG_GENRE"

        /**
         * Activityを起動させる
         *
         * @param context コンテキスト
         * @param genre ジャンル(タブタイプ)
         */
        fun startMainActivity(context: Context, genre: Genre) {
            val intent : Intent = Intent(context, MainActivity::class.java)
            intent.putExtra(ARG_GENRE, genre)
            context.startActivity(intent)
        }
    }

    private var mPagerAdapter: SectionsPagerAdapter? = null
    private var mBinding: ActivityMainBinding? = null

    override public fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        setupView()
    }

    private fun setupView() {
        var genre : Genre = intent.getSerializableExtra(ARG_GENRE) as Genre

        mPagerAdapter = SectionsPagerAdapter(supportFragmentManager, resources.getStringArray(genre.arrayResId))
        mBinding?.pager?.adapter = mPagerAdapter

        // タブ
        mBinding?.tabLayout?.setupWithViewPager(mBinding?.pager)
    }

    // ページャー用アダプター
    private class SectionsPagerAdapter(fragmentManager: FragmentManager, tabs: Array<String>) : FragmentPagerAdapter(fragmentManager) {
        private  val mTabsName = tabs
        override fun getPageTitle(position: Int): CharSequence? {
            return mTabsName.get(position)
        }

        override fun getCount(): Int {
            return mTabsName.count()
        }

        override fun getItem(p0: Int): ListFragment? {
            return SkillListFragment()
        }

    }
}
