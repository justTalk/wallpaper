package com.yf.module_retrofit.service;

import com.yf.module_retrofit.BaseCallProxy;
import com.yf.module_retrofit.RetrofitCallBack;
import com.yf.module_retrofit.model.Test;

public class ServiceProxy {

    public static BaseService getBaseServiceInstance(){
       return APIServiceFactory.getServiceInstance(BaseService.class);
    }

    public static void test(int messageType, String countryCode, String lang, int platform, RetrofitCallBack<Test> callBack){
        BaseCallProxy.Builder.newInstance(APIServiceFactory.getServiceInstance(BaseService.class).test(messageType, countryCode, lang, platform), callBack).doSubscribe();
    }
}
