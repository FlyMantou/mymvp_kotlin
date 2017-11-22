package com.huanghai.empty

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.myhuanghai.mvpcore.utils.LogUtil
import com.myhuanghai.mvpcore.utils.helper.RxUtil
import com.tbruyelle.rxpermissions.Permission
import com.tbruyelle.rxpermissions.RxPermissions

import java.util.concurrent.TimeUnit

import rx.Observable

/**
 * Created by hpw on 16/10/28.
 */

class SplashActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        LogUtil.i("huanghai","执行++++++++++++++")

        Observable.timer(2000, TimeUnit.MILLISECONDS)
                .compose<Permission>(RxPermissions.getInstance(this).ensureEach(Manifest.permission.READ_PHONE_STATE, Manifest.permission.CAMERA,
                        Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.ACCESS_COARSE_LOCATION))
                .compose<Permission>(RxUtil.rxSchedulerHelper<Permission>())
                .subscribe { permission ->
                    if (permission.granted) {
                        LogUtil.i("huanghai","执行------------")
                        startActivity(Intent(this@SplashActivity,com.huanghai.empty.ui.activity.MainActivity::class.java) )
                        finish()
                    }
                }
    }

}
