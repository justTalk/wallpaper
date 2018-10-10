package com.yf.module_retrofit;

import io.reactivex.subscribers.ResourceSubscriber;

public abstract class MySubscrible<T> extends ResourceSubscriber<BaseDataWrapper<T>> {
    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public final void onComplete() {
        if (!isDisposed()) {
            dispose();
        }
    }

    @Override
    public final void onError(Throwable e) {
        onException(e);
        if (!isDisposed()) {
            dispose();
        }
    }

    @Override
    public final void onNext(BaseDataWrapper<T> t) {
        if (t.isResult()) {
            onSuccess(t.getData());
        } else {
            onError(t.getStateCode(), t.getMsg());
        }
    }

    public abstract void onError(int errorCode, String errorMessage);

    public abstract void onSuccess(T t);

    public abstract void onException(Throwable e);
}
