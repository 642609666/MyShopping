package com.atguigu.myshopping.home;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.atguigu.myshopping.R;
import com.atguigu.myshopping.base.BaseFragment;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;


/**
 * Created by ${
 * 李岩
 * QQ/微信: 642609666} on 2/23 0023.
 * 功能:主页fragment
 */

public class HomeFragment extends BaseFragment {


    @InjectView(R.id.scan)
    TextView scan;
    @InjectView(R.id.seek)
    TextView seek;
    @InjectView(R.id.message)
    TextView message;
    @InjectView(R.id.rv_home)
    RecyclerView rvHome;
    @InjectView(R.id.top)
    ImageButton top;

    public HomeFragment() {
        super();
    }

    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.fragment_home, null);
        Log.e("TAG", "主页视图初始化");
        ButterKnife.inject(view);
        return view;
    }

    @Override
    public void initData() {
        super.initData();
        Log.e("TAG", "主页数据初始化");
    }



    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.inject(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    @OnClick({R.id.scan, R.id.seek, R.id.message, R.id.top})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.scan:
                Toast.makeText(mContext, "扫一扫", Toast.LENGTH_SHORT).show();
                break;
            case R.id.seek:
                Toast.makeText(mContext, "搜索", Toast.LENGTH_SHORT).show();
                break;
            case R.id.message:
                Toast.makeText(mContext, "消息", Toast.LENGTH_SHORT).show();
                break;
            case R.id.top:
                Toast.makeText(mContext, "顶部", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
