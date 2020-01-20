package com.example.proyectsoreonline.utils;


import com.example.proyectsoreonline.BuildConfig;


import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public abstract class BaseServiceBuilder<T extends  Object>{
    protected Retrofit.Builder mBuilder ;
    protected BaseServiceBuilder(){
        this(new GenericInterceptor());
    }

    //interceptor custom
    public BaseServiceBuilder(Interceptor interceptor){
        final HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();
        okHttpClientBuilder.interceptors().clear();
        okHttpClientBuilder
                .addInterceptor(loggingInterceptor)
                .readTimeout(5, TimeUnit.SECONDS)
                .writeTimeout(5, TimeUnit.SECONDS)
                .connectTimeout(5, TimeUnit.SECONDS)
                .retryOnConnectionFailure(false)
                .addInterceptor(interceptor);

        OkHttpClient client = okHttpClientBuilder.build();

        if(BuildConfig.DEBUG) {

            mBuilder = new Retrofit.Builder()
                    .baseUrl(BuildConfig.BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create());
        } else {
            mBuilder = new Retrofit.Builder()
                    .baseUrl(BuildConfig.BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create());
        }

    }




    public abstract T build();
}