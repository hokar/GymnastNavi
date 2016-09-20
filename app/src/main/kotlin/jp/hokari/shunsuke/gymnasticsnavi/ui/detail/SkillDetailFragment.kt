package jp.hokari.shunsuke.gymnasticsnavi.ui.detail

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import jp.hokari.shunsuke.gymnasticsnavi.R
import jp.hokari.shunsuke.gymnasticsnavi.databinding.FragmentSkillDetailBinding
import jp.hokari.shunsuke.gymnasticsnavi.ui.MainActivity

/**
 * 技詳細画面
 *
 * Created by shunsuke on 2016/09/20.
 */
class SkillDetailFragment: Fragment() {

    private var mBinding: FragmentSkillDetailBinding? = null

    companion object {
        private val ARG_GENRE = "ARG_GENRE"

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) : View? {
        super.onCreateView(inflater, container, savedInstanceState)

        mBinding = DataBindingUtil.inflate(LayoutInflater.from(activity), R.layout.fragment_skill_detail, container, false)

        return mBinding?.root
    }
}
