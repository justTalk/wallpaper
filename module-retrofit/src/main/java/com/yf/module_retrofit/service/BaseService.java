package com.yf.module_retrofit.service;

import com.yf.module_retrofit.BaseDataWrapper;
import com.yf.module_retrofit.model.Test;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BaseService {
    @GET("support/official-document")
    Flowable<BaseDataWrapper<Test>> test(@Query("messageType") int messageType,
                                        @Query("countryCode") String countryCode,
                                        @Query("lang") String lang,
                                        @Query("platform") int platform);
}
