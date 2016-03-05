package jp.hokari.shunsuke.gymnasticsnavi.ui

import android.content.Context
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v7.app.AppCompatActivity
import jp.hokari.shunsuke.gymnasticsnavi.R
import jp.hokari.shunsuke.gymnasticsnavi.databinding.ActivityMainBinding
import java.util.*
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {

    private var mPagerAdapter : SectionsPagerAdapter by Delegates.notNull()
    private var mBinding : ActivityMainBinding by Delegates.notNull()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mBinding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        setupView()
    }

    fun setupView() {
        mPagerAdapter = SectionsPagerAdapter(supportFragmentManager, this)
        mBinding.pager.setAdapter(mPagerAdapter)

        // タブ
        mBinding.tabLayout.setupWithViewPager(mBinding.pager)
    }

    class SectionsPagerAdapter(fragmentManager: FragmentManager, context: Context) : FragmentPagerAdapter(fragmentManager) {
        private val mContext : Context = context

        private  val mTabsName : ArrayList<Int> = arrayListOf(
                R.string.tab_floor,
                R.string.tab_pommel_horse,
                R.string.tab_rings,
                R.string.tab_vaults,
                R.string.tab_parallel_bar,
                R.string.tab_horizontal_bar
        )
        override fun getPageTitle(position: Int): CharSequence? {
            return mContext.getString(mTabsName.get(position))
        }

        override fun getCount(): Int {
            return mTabsName.count()
        }

        override fun getItem(p0: Int): Fragment? {
            return SampleFragment()
        }

    }
}
