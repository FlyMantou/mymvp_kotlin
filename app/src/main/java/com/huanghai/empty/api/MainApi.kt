package com.huanghai.empty.api



import com.huanghai.empty.bean.MyListBean
import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable

/**
 * Created by huanghai on 2017/4/6.
 */

interface MainApi {


    /**
     * 加载列表
     */
    @GET("unity")
    fun getMyList(@Query("key") key: String, @Query("num") num: Int, @Query("page") page: Int): Observable<MyListBean>


}
