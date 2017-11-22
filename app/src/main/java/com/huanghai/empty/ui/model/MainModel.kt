package com.huanghai.empty.ui.model

import com.huanghai.empty.R
import com.huanghai.empty.ui.contract.MainContract

/**
 * Created by huanghai on 2017/4/8.
 */

class MainModel : MainContract.MainModel {
    override//暂时不从网络取
    val tabs: Array<String>
        get() = arrayOf("教学楼", "操场", "食堂", "商店", "宿舍")

    override val tabsIcon: IntArray
        get() = intArrayOf(R.drawable.r_1, R.drawable.r_2, R.drawable.r_3, R.drawable.r_4, R.drawable.r_5)
}
