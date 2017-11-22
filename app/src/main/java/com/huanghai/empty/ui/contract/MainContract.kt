package com.huanghai.empty.ui.contract

import com.myhuanghai.mvpcore.base.CoreBaseModel
import com.myhuanghai.mvpcore.base.CoreBasePresenter
import com.myhuanghai.mvpcore.base.CoreBaseView

/**
 * Created by huanghai on 2017/4/8.
 */

interface MainContract {
    abstract class MainPresenter : CoreBasePresenter<MainModel, MainView>() {
        abstract fun getTabList()
    }

    interface MainModel : CoreBaseModel {
        val tabs: Array<String>
        val tabsIcon: IntArray
    }

    interface MainView : CoreBaseView {
        fun showTabList(mTabs: Array<String>, mTabsIcons: IntArray)
    }


    abstract class F1Presenter:CoreBasePresenter<F1Model,F1View>(){

    }

    interface F1Model:CoreBaseModel{

    }

    interface F1View:CoreBaseView{

    }
}
