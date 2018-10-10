package com.yf.wallpaper.fragment;

import android.app.Activity;
import android.view.View;

import com.yf.base.BaseFragmentActivity;
import com.yf.base.fragment.BaseFragment;

public abstract class AbstractFragment extends BaseFragment {
    @Override
    protected View onCreateView() {
        return null;
    }

    protected View getRootView(){
        Activity activity = getActivity();
        if (activity instanceof BaseFragmentActivity){
            return ((BaseFragmentActivity) activity).getFragmentContainer();
        }
        return activity.getWindow().getDecorView();
    }

    protected void postDelayRunable(Runnable runnable, int duration){
        getRootView().postDelayed(runnable, duration);
    }
}
