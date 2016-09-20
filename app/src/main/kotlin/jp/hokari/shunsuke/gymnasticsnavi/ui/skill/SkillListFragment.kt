package jp.hokari.shunsuke.gymnasticsnavi.ui.skill

import android.content.Context
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.ListFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import jp.hokari.shunsuke.gymnasticsnavi.R
import jp.hokari.shunsuke.gymnasticsnavi.databinding.ItemSkillBinding
import jp.hokari.shunsuke.gymnasticsnavi.model.SkillData
import jp.hokari.shunsuke.gymnasticsnavi.ui.common.ModalActivity

/**
 * 技一覧Fragment
 *
 * Created by shunsuke on 16/04/03.
 */
class SkillListFragment : ListFragment() {
    private var mSkillListAdapter: SkillListAdapter? = null

     override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setupSkillList()
    }

    private fun setupSkillList() {
        // 仮データ TODO:あとで消す
        val item1 : SkillData = SkillData(1, "後方跳び", "A", 0, 0, 0)
        val item2 : SkillData = SkillData(2, "後方抱え込み宙返り", "A", 0, 0, 0)
        val item3 : SkillData = SkillData(3, "後方屈伸宙返り", "A", 0, 0, 0)
        val item4 : SkillData = SkillData(4, "後方伸身宙返り", "A", 0, 0, 0)
        val item5 : SkillData = SkillData(5, "後方伸身１回ひねり", "B", 0, 0, 0)
        val item6 : SkillData = SkillData(6, "後方伸身２回ひねり", "C", 0, 0, 0)
        val item7 : SkillData = SkillData(7, "後方伸身３回ひねり", "D", 0, 0, 0)
        val item8 : SkillData = SkillData(8, "後方伸身４回ひねり", "F", 0, 0, 0)
        val array = arrayOf(item1, item2, item3, item4, item5, item6, item7, item8)

        mSkillListAdapter = SkillListAdapter(getActivity(), array)
        listAdapter = mSkillListAdapter
    }


    private class SkillListAdapter(context : Context, items: Array<SkillData>) : BaseAdapter() {

        val mContext = context;
        val mList : Array<SkillData> = items

        override fun getCount() : Int {
            return mList.size
        }

        override fun getItemId(position: Int): Long {
            return mList[position].id
        }

        override fun getItem(position : Int) : SkillData {
            return mList[position]
        }

        override fun getView(position : Int, convertView : View?, parent : ViewGroup) : View {
            val binding: ItemSkillBinding?
            if (convertView == null) {
                binding = DataBindingUtil.inflate<ItemSkillBinding>(LayoutInflater.from(mContext), R.layout.item_skill, parent, false)
            } else {
                binding = DataBindingUtil.bind(convertView)
            }

            binding.skillName.text = getItem(position).skillName
            binding.skillDifficulty.text = getItem(position).difficulty
            binding.root.setOnClickListener {
                ModalActivity.startModal(mContext, getItem(position).skillName)
            }

            return binding.root;
        }
    }
}