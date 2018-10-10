package com.yf.module_retrofit;

import com.yf.module_retrofit.inptercept.HeaderInpterceptor;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static final int TYPE_DEFAULT = 0;
    private static final int DEFAULT_TIMEOUT = 10;
    private static volatile RetrofitClient sIntance;
    private Retrofit baseRetrofitClient;

    private static final String BASE_URL_DEBUG = "http://pro-api.51vivalive.com/";
    private static final String BASE_URL_RELEASE = "http://pro-api.51vivalive.com/";

    private RetrofitClient(){
    }

    public static RetrofitClient getInstance(){
        if (sIntance == null) {
            synchronized (RetrofitClient.class){
                if (sIntance == null){
                    sIntance = new RetrofitClient();
                }
            }
        }
        return sIntance;
    }

    private String getUrl(int type){
        if (type == TYPE_DEFAULT) {
            return BuildConfig.DEBUG ? BASE_URL_DEBUG : BASE_URL_RELEASE;
        }
        return null;
    }

    public Retrofit getBaseRetrofitClient(){
        if (baseRetrofitClient == null) {
            initRetrofitClient(TYPE_DEFAULT);
        }
        return baseRetrofitClient;
    }

    private void initRetrofitClient(int type){
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        httpClientBuilder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);

        httpClientBuilder.addInterceptor(new HeaderInpterceptor());

        Retrofit ret = new Retrofit.Builder()
                .client(httpClientBuilder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(getUrl(type))
                .build();

        if (type == TYPE_DEFAULT) {
            baseRetrofitClient = ret;
        }
    }
}
