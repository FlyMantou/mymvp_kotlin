package com.huanghai.empty.ui.fragment.child

import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.huanghai.empty.ui.contract.MainContract
import com.huanghai.empty.ui.model.child.F1Model
import com.huanghai.empty.ui.presenter.child.F1Presenter
import com.myhuanghai.mvpcore.base.CoreBaseFragment
import com.myhuanghai.mvpcore.widget.recyclerview.CoreRecyclerView
import com.myhuanghai.mvpcore.widget.recyclerview.recyclerviewpager.LoopRecyclerViewPager


/**
 * Created by hpw on 16/10/31.
 */
class Fragment2 : CoreBaseFragment<F1Presenter, F1Model>(), MainContract.F1View {
    internal var coreRecyclerView: CoreRecyclerView? = null
    internal var vpTop: LoopRecyclerViewPager? = null

    override fun getLayoutId(): Int {
        return 0
    }

    override fun getLayoutView(): View? {
        val textView = TextView(mContext)
        textView.text = "Fragment2"
        return textView
    }

    override fun initUI(view: View, savedInstanceState: Bundle?) {

    }

    override fun initData() {

    }



    override fun showError(msg: String) {

    }


}
