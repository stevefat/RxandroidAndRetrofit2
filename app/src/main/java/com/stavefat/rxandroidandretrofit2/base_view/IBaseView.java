package com.stavefat.rxandroidandretrofit2.base_view;

import com.stavefat.rxandroidandretrofit2.bean.BaseInfo;

import java.util.List;

/**
 * ================================================
 * ProjectName: RxandroidAndRetrofit2
 * Author: ngh(stevefat)
 * CreateDate :16-7-8下午4:13
 * ================================================
 */
public interface IBaseView {


    //显示dialog加载数据
    void showProgressDialog();
    //显示数据
    void showData(List<? extends BaseInfo> list);

    //加载数据完成关闭dialog
    void dismissProgressDialog();
}
