package com.youxin.xrecyclerview;


import android.content.Context;

import com.youxin.xrecyclerview.recyclerview.CommonAdapter;
import com.youxin.xrecyclerview.recyclerview.base.ViewHolder;

import java.util.List;

/**
 * Created by anzhuo002 on 2016/8/23.
 */

public class MyReadCircleAdapter extends CommonAdapter<String> {

    public MyReadCircleAdapter(Context context, List<String> datas) {
        super(context,  R.layout.item_my_read_circle, datas);
    }

    @Override
    public void convert(ViewHolder viewHolder, String item, int position) {

        viewHolder.setText(R.id.tv,item);

    }
}






