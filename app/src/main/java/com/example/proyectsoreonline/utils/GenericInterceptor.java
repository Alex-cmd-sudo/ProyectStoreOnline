package com.example.proyectsoreonline.utils;


import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;

public class GenericInterceptor implements Interceptor {
    public static final String TAG = GenericInterceptor.class.getSimpleName();
    private static final MediaType JSON_MEDIA_TYPE = MediaType.parse("application/json; charset=UTF-8");
    private static final MediaType TEXT_MEDIA_TYPE = MediaType.parse("text/plain; charset=UTF-8");
    private static final String HEADER_COOKIE_REQUEST = "Cookie";
    private static final String HEADER_COOKIE_RESPONSE = "Set-Cookie";
    private static final String HEADER_CONTENT_TYPE = "Content-Type";
    private static final String HEADER_CONTENT_LENGTH = "Content-Length";
    private static final String HEADER_BAD_RESPONSE = "666";

    @Override
    public Response intercept(Chain chain) throws IOException {

        Request newRequest = chain.request().newBuilder()
                .header(HEADER_CONTENT_TYPE,"text/plain; charset=UTF-8")
                //Aqui pueden ir cabeceras personalizadas
                .build();

        return chain.proceed(newRequest);
    }
}