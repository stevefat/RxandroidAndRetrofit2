package com.stavefat.rxandroidandretrofit2.activity;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.stavefat.rxandroidandretrofit2.R;
import com.stavefat.rxandroidandretrofit2.bean.BaseInfo;
import com.stavefat.rxandroidandretrofit2.bean.BookCatalog;
import com.stavefat.rxandroidandretrofit2.inteface.RecyItemClick;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * ================================================
 * ProjectName: RxandroidAndRetrofit2
 * Author: ngh(stevefat)
 * CreateDate :16-7-8下午5:03
 * ================================================
 */
public class RecyViewAdapter extends RecyclerView.Adapter<RecyViewAdapter.ViewHolder> {

    private Context mContext;
    private List<BaseInfo> bookCatalogs;
    private RecyItemClick click;
    private LayoutInflater inflater;

    public void setClick(RecyItemClick click) {
        this.click = click;
    }

    public RecyViewAdapter(Context mContext, List<BaseInfo> bookCatalogs) {
        this.mContext = mContext;
        this.bookCatalogs = bookCatalogs;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.recyview_item, null);
        ViewHolder holder = new ViewHolder(view);


        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        BookCatalog catalog = (BookCatalog) bookCatalogs.get(position);

        holder.textView.setText(catalog.getText());

        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click.OnItemClick(v, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return bookCatalogs.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textView);

        }
    }
}
