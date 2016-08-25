package com.youxin.xrecyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayoutDirection;

import java.util.ArrayList;
import java.util.List;



public class  MainActivity extends AppCompatActivity {
    private XRecyclerView mXRecyclerView;
    private MyReadCircleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mXRecyclerView = (XRecyclerView) findViewById(R.id.xrecycleview);
        // 设置 刷新的方向
        mXRecyclerView.setDirection(SwipyRefreshLayoutDirection.BOTH);
        // 是否自动加载
        mXRecyclerView.setAutoLoadEnable(false);
        adapter = new MyReadCircleAdapter(this, null);
        mXRecyclerView.setAdapter(adapter);

        // 设置 监听器


        // 如果自己想写 加载的过程 ，或者是 想在中间做什么处理 ，可以用这个没有进一步封装的 监听器
//        mXRecyclerView.setXRecyclerViewListener(new XRecyclerView.XRecyclerViewListener() {
//            @Override
//            public void onRefresh() {
//
//            }
//
//            @Override
//            public void onLoadMore() {
//
//            }
//        });

        // 用这个 已经封装的监听器，解决了很多问题，同时节省了很多代码， 我平时就用的这个，只需要关心请求只有填充数据的
        mXRecyclerView.setSimpleXRecyclerViewListener(new XRecyclerView.OnNeedPostRequestListener() {
            @Override
            public void postRequest() {
                mXRecyclerView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        getData();
                    }
                },2000);
            }
        });
        getData();
    }

    /**
     *   一个列表的相关的页面 数据的填充 就这么几行代码搞定。
     */
    private void getData() {
        List<String> list = new ArrayList<String>();
        list.add("adfa");
        list.add("adfa");
        list.add("adfa");

        mXRecyclerView.stopRefreshAndLoadMore();

        // 根据 XRecyclerView 的状态来判断是刷新还是上拉加载，从而来选择是 更新填充列表和重新填充列表
        if (mXRecyclerView.CURRENT_STATE == mXRecyclerView.PULL_TO_REFRESH) {
            adapter.updata(list);
        } else if (mXRecyclerView.CURRENT_STATE == mXRecyclerView.LOAD_MORE) {
            adapter.addAllItem(list);
        }



    }


}
