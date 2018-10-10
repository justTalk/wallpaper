package com.yf.wallpaper.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yf.wallpaper.R;
import com.yf.wallpaper.activity.HomeActivity;
import com.yf.wallpaper.constant.MagicNumber;

public class SplashFragment extends AbstractFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_splash, null);
        postDelayTask();
        return root;
    }

    private void postDelayTask(){
        postDelayRunable(new Runnable() {
            @Override
            public void run() {
               jumpToHome();
            }
        }, MagicNumber.DELAY_TIME_2000);
    }

    private void jumpToHome(){
        Activity activity = getActivity();
        if (activity != null) {
            Intent intent = new Intent(getContext(), HomeActivity.class);
            startActivity(intent);
            activity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            activity.finish();
        }
    }
}
