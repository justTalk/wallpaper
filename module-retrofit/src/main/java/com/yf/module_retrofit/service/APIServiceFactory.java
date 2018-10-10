package com.yf.module_retrofit.service;

import com.yf.module_retrofit.RetrofitClient;

import java.util.HashMap;
import java.util.Map;

public class APIServiceFactory {
    private static Map<Class<?>, Object> mServiceInstanceMap = new HashMap<>();

    /**
     * @param cls
     * @param <T>
     * @return
     */
    @SuppressWarnings({"unchecked"})
    public static synchronized <T> T getServiceInstance(Class<T> cls) {
        if (mServiceInstanceMap.get(cls) == null) {
            mServiceInstanceMap.put(cls, RetrofitClient.getInstance().getBaseRetrofitClient().create(cls));
        }
        return (T) mServiceInstanceMap.get(cls);
    }
}
