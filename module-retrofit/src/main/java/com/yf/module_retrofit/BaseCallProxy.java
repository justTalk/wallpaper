package com.yf.module_retrofit;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class BaseCallProxy {
    public static class Builder<T>{
        Flowable<BaseDataWrapper<T>> mFlowable;
        RetrofitCallBack<T> mCallback;
        RetrofitCallBack<T> mCallbackIO;

        /**
         * 执行订阅，这个动作会触发flowable中的动作开始执行。
         */
        public void doSubscribe() {
            if (mFlowable == null) {
                throw new RuntimeException("flowable can not be NULL !");
            }
            BaseCallProxy.doSubscribe(mFlowable, mCallback,  mCallbackIO);
        }

        /**
         * 创建一个基础的Builder
         *
         * @param flowable 数据源
         * @param callback 基础的回调
         * @param <T>      业务所需的数据实体类型
         * @return this
         */
        public static <T> Builder<T> newInstance(Flowable<BaseDataWrapper<T>> flowable,
                                                 RetrofitCallBack<T> callback) {
            return new Builder<T>().setFlowable(flowable).setCallback(callback);
        }

        public Builder<T> setFlowable(Flowable<BaseDataWrapper<T>> flowable){
            this.mFlowable = flowable;
            return this;
        }

        public Builder<T> setCallback(RetrofitCallBack<T> callback){
            this.mCallback = callback;
            return this;
        }
    }

    private static <T> void doSubscribe(Flowable<BaseDataWrapper<T>> flowable,
                                        final RetrofitCallBack<T> callback, RetrofitCallBack<T> callbackIO){
        flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new MySubscrible<T>() {
                    @Override
                    public void onError(int errorCode, String errorMessage) {
                        if (callback != null) {
                            callback.onError(errorCode, errorMessage);
                        }
                    }

                    @Override
                    public void onSuccess(T t) {
                        if (callback != null) {
                            callback.onSuccess(t);
                        }
                    }

                    @Override
                    public void onException(Throwable e) {
                        if (callback != null) {
                            callback.onException(e);
                        }
                    }
                });
    }
}
