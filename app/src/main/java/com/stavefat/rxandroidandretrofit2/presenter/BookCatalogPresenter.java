package com.stavefat.rxandroidandretrofit2.presenter;

import android.net.IpPrefix;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.stavefat.rxandroidandretrofit2.base_view.IBaseView;
import com.stavefat.rxandroidandretrofit2.bean.BookCatalog;
import com.stavefat.rxandroidandretrofit2.model.BookCatalogModel;
import com.stavefat.rxandroidandretrofit2.utils.AppLogger;

import java.io.IOException;
import java.util.List;

import okhttp3.ResponseBody;
import rx.Subscriber;

/**
 * ================================================
 * ProjectName: RxandroidAndRetrofit2
 * Author: ngh(stevefat)
 * CreateDate :16-7-8下午4:10
 * ================================================
 */
public class BookCatalogPresenter implements IPresenter {


    private IBaseView baseView;
    private BookCatalogModel bookCatalogModel = new BookCatalogModel();

    private Subscriber<ResponseBody> subscriber;

    public BookCatalogPresenter(IBaseView baseView) {
        this.baseView = baseView;
    }

    public void loadDataBookCalog(String act, int sid) {
        baseView.showProgressDialog();
        subscriber = new Subscriber<ResponseBody>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                AppLogger.e(e.toString());
            }

            @Override
            public void onNext(ResponseBody responseBody) {

                try {
                    String str = responseBody.string();
                    //这里需要解析返回json数据
                    JSONObject json = JSON.parseObject(str);

                    AppLogger.e(json.toString());
                    String status = json.getString("status");
                    String data = json.getString("data");
                    if (status.equals("success")) {
                        List<BookCatalog> catalogList = JSON.parseArray(data, BookCatalog.class);
                        baseView.showData(catalogList);
                        baseView.dismissProgressDialog();

                    }


                } catch (IOException e) {
                    e.printStackTrace();
                }

            }


        };
        bookCatalogModel.getBookCatalog(act, sid, subscriber);
    }


    @Override
    public void doClear() {
        if (subscriber != null) {
            subscriber.unsubscribe();
        }

        baseView = null;
    }
}
