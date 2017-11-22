package com.huanghai.empty.ui.activity

import android.os.Bundle

import com.myhuanghai.mvpcore.base.CoreBaseActivity
import com.huanghai.empty.R
import com.huanghai.empty.ui.contract.MainContract
import com.huanghai.empty.ui.fragment.MainFragment
import com.huanghai.empty.ui.model.MainModel
import com.huanghai.empty.ui.presenter.MainPresenter
import com.myhuanghai.mvpcore.base.CoreBaseFragment
import com.myhuanghai.mvpcore.utils.LogUtil

/**
 * Created by huanghai on 2017/4/8.
 */

class MainActivity : CoreBaseActivity<MainPresenter, MainModel>(),
        MainContract, CoreBaseFragment.OnBackToFirstListener {


    override fun initData() {

    }

    override fun getLayoutId(): Int {
        return R.layout.activity_style1main
    }

    override fun initView(savedInstanceState: Bundle?) {
        LogUtil.i("huanghai","触发initView")
        if (savedInstanceState == null) {
            loadRootFragment(R.id.fl_container, MainFragment.newInstance(0))
        }
    }


    override fun onBackToFirstFragment() {
        LogUtil.i("huanghai","触发onBackToFirstFragment")
        //loadRootFragment(R.id.fl_container, MainFragment.newInstance(1))
    }
}
