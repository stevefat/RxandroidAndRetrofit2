package com.stavefat.rxandroidandretrofit2.utils;

import rx.Observable;
import rx.Observer;
import rx.Scheduler;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.observers.Observers;
import rx.observers.Subscribers;
import rx.schedulers.Schedulers;

/**
 * ================================================
 * ProjectName: RxandroidAndRetrofit2
 * Author: ngh(stevefat)
 * CreateDate :16-7-8下午3:45
 * ================================================
 */
public class SupportModelUtils {


    /**
     * 线程处理数据的方式
     *
     * @param observable
     * @param subscriber
     */
    public static void toSubscribe(Observable observable, Subscriber subscriber) {
        observable.subscribeOn(Schedulers.io())   //发送在io 的线程中
                .observeOn(AndroidSchedulers.mainThread())    //运行在android额主线程中
                .subscribe(subscriber);   //发送结果

    }
}
