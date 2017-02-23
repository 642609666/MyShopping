package com.atguigu.myshopping;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

import com.atguigu.myshopping.base.BaseFragment;
import com.atguigu.myshopping.cart.CartFragment;
import com.atguigu.myshopping.community.CommunityFragment;
import com.atguigu.myshopping.home.HomeFragment;
import com.atguigu.myshopping.type.TypeFragment;
import com.atguigu.myshopping.user.UserFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.fl_main)
    RelativeLayout flMain;
    private RadioGroup rgMain;
    private List<BaseFragment> mBaseFragments;

    private int position = 0;
    /**
     * 缓存的fragment
     */
    private BaseFragment tempFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        rgMain = (RadioGroup) findViewById(R.id.rg_main);

        //初始化fragment
        initFragment();
        //初始化数据
        initData();
        //监听事件
        initListener();

    }

    private void initListener() {
        //button 的监听
        rgMain.setOnCheckedChangeListener(new MyOnCheckedChangeListener());

        //默认选择位置
        rgMain.check(R.id.rb_home);
    }

    private void initData() {


    }

    class MyOnCheckedChangeListener implements RadioGroup.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId) {
                case R.id.rb_home:
                    position = 0;
                    break;
                case R.id.rb_type:
                    position = 1;
                    break;
                case R.id.rb_community:
                    position = 2;
                    break;
                case R.id.rb_cart:
                    position = 3;
                    break;
                case R.id.rb_user:
                    position = 4;
                    break;
            }
            //根据选择切换不同的fragment
            BaseFragment baseFragment = mBaseFragments.get(position);
            switchFragment(baseFragment);
        }
    }

    private void switchFragment(BaseFragment baseFragment) {
        //不是同一个fragment
        if (tempFragment != baseFragment) {

            //获得管理事务
            FragmentTransaction ft =
                    this.getSupportFragmentManager().beginTransaction();

            //没有被添加过
            if (!baseFragment.isAdded()) {
                //缓存的隐藏
                if (tempFragment != null) {
                    ft.hide(tempFragment);
                }
                //添加
                ft.add(R.id.fl_main, baseFragment);
            } else {
                //缓存的隐藏
                if (tempFragment != null) {
                    ft.hide(tempFragment);
                }
                //显示
                ft.show(baseFragment);
            }
            //提交
            ft.commit();
            tempFragment = baseFragment;
        }
    }

    private void initFragment() {
        mBaseFragments = new ArrayList<>();
        mBaseFragments.add(new HomeFragment());//添加主页
        mBaseFragments.add(new TypeFragment());
        mBaseFragments.add(new CommunityFragment());
        mBaseFragments.add(new CartFragment());
        mBaseFragments.add(new UserFragment());
    }
}
