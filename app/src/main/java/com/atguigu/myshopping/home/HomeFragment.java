package com.atguigu.myshopping.home;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.atguigu.myshopping.R;
import com.atguigu.myshopping.base.BaseFragment;

/**
 * Created by ${
 * 李岩
 * QQ/微信: 642609666} on 2/23 0023.
 * 功能:主页fragment
 */

public class HomeFragment extends BaseFragment {
    private TextView mTextView;

    public HomeFragment() {
        super();
    }

    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.fragment_home,null);
        Log.e("TAG", "主页视图初始化");
        return view;
    }

    @Override
    public void initData() {
        super.initData();
        mTextView.setText("主页数据绑定");
        Log.e("TAG", "主页数据初始化");
    }
}
