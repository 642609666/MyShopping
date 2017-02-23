package com.atguigu.myshopping.home;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.atguigu.myshopping.R;
import com.atguigu.myshopping.base.BaseFragment;
import com.atguigu.myshopping.home.bean.HomeBean;
import com.atguigu.myshopping.utils.Constants;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import okhttp3.Call;


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

    private List<HomeBean> mHomeBeen;
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

        //获得网络数据
        getDataFromNet();
    }


    public void getDataFromNet() {
        OkHttpUtils
                .get()
                .url(Constants.HOME_URL)
                .id(100)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.e("TAG", "请求失败" + e.getMessage());
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.e("TAG", "请求成功");

                        //对数据进行json解析
                        processData(response);
                    }

                });
    }

    private void processData(String json) {
        HomeBean homeBean = JSON.parseObject(json, HomeBean.class);
        HomeBean.ResultBean result = homeBean.getResult();
        Log.e("TAG", "result==" + result.getAct_info().get(0).getName());
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
