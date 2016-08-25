package com.youxin.xrecyclerview.recyclerview;

import android.content.Context;

import com.youxin.xrecyclerview.recyclerview.base.ItemViewDelegate;
import com.youxin.xrecyclerview.recyclerview.base.ViewHolder;

import java.util.List;

/**
 * Created by zhy on 16/4/9.
 */
public abstract class CommonAdapter<T> extends MultiItemTypeAdapter<T> {
    public CommonAdapter(final Context context, final int layoutId, List<T> datas){
        super(context, datas);
        addItemViewDelegate(new ItemViewDelegate<T>()
        {
            @Override
            public int getItemViewLayoutId()
            {
                return layoutId;
            }

            @Override
            public boolean isForViewType( T item, int position)
            {
                return true;
            }

            @Override
            public void convert(ViewHolder holder, T t, int position)
            {
                CommonAdapter.this.convert(holder, t, position);
            }
        });
    }

    protected abstract void convert(ViewHolder holder, T t, int position);

    public T getItem(int positon) {
        return mDatas != null && mDatas.size() > positon ? mDatas.get(positon) : null;
    }


    public void addItem(T item, boolean isNotify) {
        mDatas.add(item);
        if (isNotify)
            notifyDataSetChanged();
    }

    public void addItem(T item) {
        addItem(item, true);
    }

    public void updata(List<T> lists){
        this.mDatas.clear();
        this.mDatas.addAll(lists);
        this.notifyDataSetChanged();
    }

    public void addAllItem(List<T> items, boolean isNotify) {
        mDatas.addAll(items);
        if (isNotify)
            notifyDataSetChanged();
    }

    public void addAllItem(List<T> items) {
        addAllItem(items, true);
    }

    public void clearItems() {
        mDatas.clear();
    }

    public void addAllAndClear(List<T> items) {
        clearItems();
        addAllItem(items);
    }

    public void destroyAdapter() {
        mDatas.clear();
    }

    public List<T> getData() {
        return mDatas;
    }


}
