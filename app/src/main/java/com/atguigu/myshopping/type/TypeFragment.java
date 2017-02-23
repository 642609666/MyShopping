package com.atguigu.myshopping.type;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.atguigu.myshopping.base.BaseFragment;

/**
 * Created by ${
 * 李岩
 * QQ/微信: 642609666} on 2/23 0023.
 * 功能:分页fragment
 */

public class TypeFragment extends BaseFragment {
    private TextView mTextView;

    @Override
    public View initView() {
        mTextView = new TextView(mContext);
        mTextView.setTextSize(30);
        Log.e("TAG", "分页视图初始化");
        return mTextView;
    }

    @Override
    public void initData() {
        super.initData();
        mTextView.setText("分页数据绑定");
        Log.e("TAG", "分页数据初始化");
    }
}
