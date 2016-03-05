package jp.hokari.shunsuke.gymnasticsnavi.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import jp.hokari.shunsuke.gymnasticsnavi.databinding.FragmentSampleBinding


/**
 * まだ出来ていない画面の代替画面(Fragment)
 *
 * Created by shunsuke on 16/03/06.
 */
class SampleFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val binding = FragmentSampleBinding.inflate(inflater, container, false)

        return binding.root
    }
}