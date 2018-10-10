package com.yf.module_retrofit;

public abstract  class RetrofitCallBack<T> {
    public void onError(int errorCode, String errorMessage) {}

    public abstract void onSuccess(T t);

    public void onException(Throwable e) {}

    public void onNoNetWork() {}

    public void onFinish(){}
}
