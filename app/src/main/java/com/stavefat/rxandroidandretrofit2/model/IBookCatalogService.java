package com.stavefat.rxandroidandretrofit2.model;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * ================================================
 * ProjectName: RxandroidAndRetrofit2
 * Author: ngh(stevefat)
 * CreateDate :16-7-8下午3:51
 * ================================================
 */
public interface IBookCatalogService {

    /**
     * 获取图书的目录
     * @param map  默认参数
     * @param act  指令
     * @param sid  图书id
     * @return
     */
    @GET("webserviceios21.ashx")
    Observable<ResponseBody> getBookCatalog(@QueryMap Map<String,String> map, @Query("act")String act, @Query("sid")int sid);

    /**
     * 根据图书目录的id 获取张杰内容
     * @param map
     * @param act
     * @param sid
     * @return
     */
    @GET("webserviceios21.ashx")
    Observable<ResponseBody> getBookContent(@QueryMap Map<String,String> map, @Query("act")String act, @Query("sid")String sid);


}
