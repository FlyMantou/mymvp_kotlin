package com.huanghai.empty

import android.content.Context
import android.util.DisplayMetrics
import android.view.WindowManager

import com.myhuanghai.mvpcore.CoreApp

/**
 * Created by huanghai on 2017/4/6.
 */

class App : CoreApp() {
    override fun setBaseUrl(): String {
        return "http://www.myhuanghai.com/tp5/public/index.php/"
        // return "http://news-at.zhihu.com/api/4/";
    }


    override fun onCreate() {
        super.onCreate()
        //初始化屏幕宽高
        getScreenSize()
    }

    fun getScreenSize() {
        val windowManager = this.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val dm = DisplayMetrics()
        val display = windowManager.defaultDisplay
        display.getMetrics(dm)
        DIMEN_RATE = dm.density / 1.0f
        DIMEN_DPI = dm.densityDpi
        SCREEN_WIDTH = dm.widthPixels
        SCREEN_HEIGHT = dm.heightPixels
        if (SCREEN_WIDTH > SCREEN_HEIGHT) {
            val t = SCREEN_HEIGHT
            SCREEN_HEIGHT = SCREEN_WIDTH
            SCREEN_WIDTH = t
        }
    }

    companion object {

        var SCREEN_WIDTH = -1
        var SCREEN_HEIGHT = -1
        var DIMEN_RATE = -1.0f
        var DIMEN_DPI = -1
    }
}
