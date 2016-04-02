package jp.hokari.shunsuke.gymnasticsnavi.ui

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v7.app.AppCompatActivity
import android.util.Log
import jp.hokari.shunsuke.gymnasticsnavi.R
import jp.hokari.shunsuke.gymnasticsnavi.databinding.ActivityMainBinding
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {

    public enum class Genre(var arrayResId : Int) {
        MALE(R.array.male_tabs),
        FEMALE(R.array.female_tabs),
        BEGINNER(R.array.beginner_tabs)
    }
    companion object {
        private val ARG_GENRE = "ARG_GENRE"

        fun startMainActivity(context: Context, genre: Genre) {
            var intent : Intent = Intent(context, MainActivity::class.java)
            intent.putExtra(ARG_GENRE, genre)
            context.startActivity(intent)
        }
    }

    private var mPagerAdapter : SectionsPagerAdapter by Delegates.notNull()
    private var mBinding : ActivityMainBinding by Delegates.notNull()

    override public fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mBinding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        setupView()
    }

    private fun setupView() {
        var genre : Genre = intent.getSerializableExtra(ARG_GENRE) as Genre

        var array = resources.getStringArray(genre.arrayResId)

        for(aaa in array) {
            Log.d("aaa", "aaa " + aaa);
        }

        mPagerAdapter = SectionsPagerAdapter(supportFragmentManager, resources.getStringArray(genre.arrayResId))
        mBinding.pager.setAdapter(mPagerAdapter)

        // タブ
        mBinding.tabLayout.setupWithViewPager(mBinding.pager)
    }

    private class SectionsPagerAdapter(fragmentManager: FragmentManager, tabs: Array<String>) : FragmentPagerAdapter(fragmentManager) {
        private  val mTabsName = tabs
        override fun getPageTitle(position: Int): CharSequence? {
            return mTabsName.get(position)
        }

        override fun getCount(): Int {
            return mTabsName.count()
        }

        override fun getItem(p0: Int): Fragment? {
            return SampleFragment()
        }

    }
}
