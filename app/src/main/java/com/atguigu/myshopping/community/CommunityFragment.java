package com.atguigu.myshopping.community;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.atguigu.myshopping.base.BaseFragment;

/**
 * Created by ${
 * 李岩
 * QQ/微信: 642609666} on 2/23 0023.
 * 功能:发现fragment
 */

public class CommunityFragment extends BaseFragment {
    private TextView mTextView;

    @Override
    public View initView() {
        mTextView = new TextView(mContext);
        mTextView.setTextSize(30);
        Log.e("TAG", "发现视图初始化");
        return mTextView;
    }

    @Override
    public void initData() {
        super.initData();
        mTextView.setText("发现数据绑定");
        Log.e("TAG", "发现数据初始化");
    }
}
