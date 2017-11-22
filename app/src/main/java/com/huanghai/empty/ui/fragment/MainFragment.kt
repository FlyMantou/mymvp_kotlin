package com.huanghai.empty.ui.fragment

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.view.View
import com.myhuanghai.mvpcore.base.CoreBaseFragment
import com.myhuanghai.mvpcore.utils.helper.FragmentAdapter
import com.huanghai.empty.Constants
import com.huanghai.empty.R
import com.huanghai.empty.ui.contract.MainContract
import com.huanghai.empty.ui.fragment.child.Fragment1
import com.huanghai.empty.ui.fragment.child.Fragment2
import com.huanghai.empty.ui.fragment.child.Fragment3
import com.huanghai.empty.ui.fragment.child.Fragment4
import com.huanghai.empty.ui.fragment.child.Fragment5
import com.huanghai.empty.ui.model.MainModel
import com.huanghai.empty.ui.presenter.MainPresenter
import com.myhuanghai.mvpcore.utils.LogUtil

import java.util.ArrayList

import kotlinx.android.synthetic.main.app_bar_main.*

/**
 * Created by hpw on 16/10/31.
 */
open class MainFragment : CoreBaseFragment<MainPresenter, MainModel>(),
        MainContract.MainView, Toolbar.OnMenuItemClickListener {
    // protected OnFragmentOpenDrawerListener mOpenDraweListener;
    internal var fragments: MutableList<Fragment> = ArrayList()
    override fun getLayoutId(): Int {
        return R.layout.app_bar_main
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
    }

    override fun onDetach() {
        super.onDetach()
        //mOpenDraweListener = null;
    }

    override fun onMenuItemClick(item: MenuItem): Boolean {
        val id = item.itemId

        if (id == R.id.day) {//关于我
            //activity.startActivity(Intent(activity, AboutMeActivity::class.java))
            return true
        }
        return false
    }


    override fun initUI(view: View, savedInstanceState: Bundle?) {

        toolbar!!.title = "首页"
        toolbar!!.setNavigationIcon(R.mipmap.ic_launcher)
        toolbar!!.setNavigationOnClickListener { v ->

        }

        toolbar!!.inflateMenu(R.menu.fragment_main_menu)
        toolbar!!.setOnMenuItemClickListener(this)
    }

    override fun showTabList(mTabs: Array<String>, mTabsIcons: IntArray) {
        LogUtil.i("huanghai","showTabList执行")
        //TabLayout配合ViewPager有时会出现不显示Tab文字的Bug,需要按如下顺序
        for (i in mTabs.indices) {
            tabs!!.addTab(tabs!!.newTab().setText(mTabs[i]).setIcon(mTabsIcons[i]))

            when (i) {
                0 -> fragments.add(Fragment1())
                1 -> fragments.add(Fragment2())
                2 -> fragments.add(Fragment3())
                3 -> fragments.add(Fragment4())
                else -> fragments.add(Fragment5())
            }
        }

        val position = arguments.getInt(Constants.ARG_POSITION, 1)
        viewpager!!.adapter = FragmentAdapter(childFragmentManager, fragments)
        viewpager!!.currentItem = position//要设置到viewpager.setAdapter后才起作用
        tabs!!.setupWithViewPager(viewpager)
        tabs!!.verticalScrollbarPosition = position
        for (i in mTabs.indices) {
            tabs!!.getTabAt(i)!!.setText(mTabs[i]).setIcon(mTabsIcons[i])
        }
    }

    override fun showError(msg: String) {

    }

    companion object {


        fun newInstance(position: Int): MainFragment {
            val fragment = MainFragment()
            val bundle = Bundle()
            bundle.putInt(Constants.ARG_POSITION, position)
            fragment.arguments = bundle
            return fragment
        }
    }

}
