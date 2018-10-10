package com.yf.wallpaper.activity;

import android.os.Bundle;

import com.yf.base.BaseFragmentActivity;
import com.yf.base.utils.StatusBarHelper;
import com.yf.wallpaper.R;
import com.yf.wallpaper.fragment.HomeFragment;

public class HomeActivity extends BaseFragmentActivity {
    @Override
    protected int getContextViewId() {
        return R.id.home_id;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startFragment(new HomeFragment());
    }

    @Override
    protected void initScreenStatus() {
        super.initScreenStatus();
        StatusBarHelper.setStatusBarLightMode(this);
        StatusBarHelper.translucent(this);
    }
}
