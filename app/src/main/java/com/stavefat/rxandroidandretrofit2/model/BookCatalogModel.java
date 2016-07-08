package com.stavefat.rxandroidandretrofit2.model;

import com.stavefat.rxandroidandretrofit2.constant.NetConstant;
import com.stavefat.rxandroidandretrofit2.utils.SupportModelUtils;

import java.util.HashMap;
import java.util.Map;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import rx.Subscriber;

/**
 * ================================================
 * ProjectName: RxandroidAndRetrofit2
 * Author: ngh(stevefat)
 * CreateDate :16-7-8下午3:56
 * ================================================
 */
public class BookCatalogModel {

    private static final String BASE_URL = NetConstant.HOST+"webservice/";

    private Retrofit retrofit = new Retrofit.Builder()
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .client(new OkHttpClient())
            .baseUrl(BASE_URL)
            .build();
    private IBookCatalogService dataServices = retrofit.create(IBookCatalogService.class);

    /**
     * 构造前面的几个参数
     * @return
     */
    private Map<String ,String> getMapParamert(){

        Map<String,String> map = new HashMap<>();
        map.put("validate", "zzsoftmis");
        map.put("dt", "json");
        return map;
    }

    /**
     * 获取图书的目录，通知完成
     * @param act  指令：获取图书目录
     * @param sid  图书的sid
     * @param subscriber  前面注解的返回值，就是这个的参数
     */
    public void getBookCatalog(String act,int sid,Subscriber<ResponseBody> subscriber){
        SupportModelUtils.toSubscribe(dataServices.getBookCatalog(getMapParamert(),act,sid),subscriber);
    }






}
