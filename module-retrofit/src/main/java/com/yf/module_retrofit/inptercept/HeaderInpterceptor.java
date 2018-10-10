package com.yf.module_retrofit.inptercept;

import android.text.TextUtils;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class HeaderInpterceptor implements Interceptor {
    private static final String HEADER_USER_AGENT_KEY = "User-Agent";
    private static final String HEADER_ACCEPT_LANGUAGE_KEY = "Accept-Language";
    private static final String HEADER_PROXY_CONNECTION_KEY = "Proxy-Connection";
    private static final String HEADER_CACHE_CONTROL_KEY = "Cache-Control";
    private static final String HEADER_AUTHORIZATION_KEY = "Authorization";


    private static final String HEADER_USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36 Edge/16.16299";
    private static final String HEADER_ACCEPT_LANGUAGE = "zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5";
    private static final String HEADER_PROXY_CONNECTION = "keep-alive";
    private static final String HEADER_CACHE_CONTROL = "max-age=0";
    private static String mAuthToken;

    @Override
    public Response intercept(Chain chain) throws IOException {
        //统一设置请求头
        Request original = chain.request();
        Request.Builder requestBuilder = original.newBuilder();
        requestBuilder.header(HEADER_USER_AGENT_KEY, HEADER_USER_AGENT);
        requestBuilder.header(HEADER_ACCEPT_LANGUAGE_KEY, HEADER_ACCEPT_LANGUAGE);
        requestBuilder.header(HEADER_PROXY_CONNECTION_KEY, HEADER_PROXY_CONNECTION);
        requestBuilder.header(HEADER_CACHE_CONTROL_KEY, HEADER_CACHE_CONTROL);
        if (!TextUtils.isEmpty(mAuthToken)) {
            requestBuilder.header(HEADER_AUTHORIZATION_KEY, mAuthToken);
        }
        requestBuilder.method(original.method(), original.body());
        Request request = requestBuilder.build();
        return chain.proceed(request);
    }
}
