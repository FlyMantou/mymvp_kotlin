package com.huanghai.empty.ui.presenter

import com.huanghai.empty.ui.contract.MainContract

/**
 * Created by huanghai on 2017/4/8.
 */

class MainPresenter : MainContract.MainPresenter() {
    override fun getTabList() {
        mView.showTabList(mModel.tabs, mModel.tabsIcon)
    }

    override fun onStart() {
        getTabList()
    }
}
