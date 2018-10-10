package com.yf.module_retrofit;

public class BaseDataWrapper<T> {
    private T data;
    private int stateCode;
    private String msg;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isResult() {
        return stateCode == 200;
    }


    public int getStateCode() {
        return stateCode;
    }

    public void setStateCode(int stateCode) {
        this.stateCode = stateCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "BaseDataWrapper{" +
                "data=" + data +
                ", errCode=" + stateCode +
                ", errMessage='" + msg + '\'' +
                '}';
    }
}
