package com.stavefat.rxandroidandretrofit2.activity;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.stavefat.rxandroidandretrofit2.R;
import com.stavefat.rxandroidandretrofit2.base_view.IBaseView;
import com.stavefat.rxandroidandretrofit2.bean.BaseInfo;
import com.stavefat.rxandroidandretrofit2.bean.BookCatalog;
import com.stavefat.rxandroidandretrofit2.inteface.RecyItemClick;
import com.stavefat.rxandroidandretrofit2.presenter.BookCatalogPresenter;
import com.stavefat.rxandroidandretrofit2.utils.DialogLoding;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * ================================================
 * ProjectName: RxandroidAndRetrofit2
 * Author: ngh(stevefat)
 * CreateDate :16-7-8下午5:02
 * ================================================
 */
public class MainActivity extends AppCompatActivity implements IBaseView {


    RecyclerView recyview;
    List<BaseInfo> bookCatalogs = new ArrayList<>();
    BookCatalogPresenter bookCatalogPresenter;
    RecyViewAdapter adapter;

    Dialog dialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        initView();

    }

    private void initView() {
        recyview = (RecyclerView) findViewById(R.id.recyview);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyview.setLayoutManager(manager);

        adapter = new RecyViewAdapter(this, bookCatalogs);

        recyview.setAdapter(adapter);

        adapter.setClick(new RecyItemClick() {
            @Override
            public void OnItemClick(View view, int position) {
                Toast.makeText(MainActivity.this, "哈哈，这是一个侧ishi点击事件！", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void OnItemLongClick(View view, int position) {

            }
        });


        dialog = DialogLoding.createLoadingDialog(this, "加载数据中...");

        bookCatalogPresenter = new BookCatalogPresenter(this);

        bookCatalogPresenter.loadDataBookCalog("getcrierionbrief", 51);


    }

    @Override
    public void showProgressDialog() {
        dialog.show();


    }

    @Override
    public void showData(List<? extends BaseInfo> list) {
        bookCatalogs.clear();
        bookCatalogs.addAll(list);

        adapter.notifyDataSetChanged();

    }

    @Override
    public void dismissProgressDialog() {
        dialog.dismiss();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bookCatalogPresenter.doClear();
    }
}
