package com.atguigu.myshopping.cart;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.atguigu.myshopping.base.BaseFragment;

/**
 * Created by ${
 * 李岩
 * QQ/微信: 642609666} on 2/23 0023.
 * 功能:购物fragment
 */

public class CartFragment extends BaseFragment {
    private TextView mTextView;

    @Override
    public View initView() {
        mTextView = new TextView(mContext);
        mTextView.setTextSize(30);
        Log.e("TAG", "购物视图初始化");
        return mTextView;
    }

    @Override
    public void initData() {
        super.initData();
        mTextView.setText("购物数据绑定");
        Log.e("TAG", "购物数据初始化");
    }
}
