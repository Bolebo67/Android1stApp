package com.example.myapplication;

import retrofit2.converter.gson.GsonConverterFactory;

import retrofit2.Retrofit;


public class RetrofitClient {

//    private static  final String BASE_URL = "http://10.100.0.183:8080/api/";
private static  final String BASE_URL = "http://10.0.2.2:8080/api/";
    private static RetrofitClient mInstance;
    private final Retrofit retrofit;
    private RetrofitClient(){
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    public static synchronized  RetrofitClient getInstance(){
        if(mInstance == null){
            mInstance = new RetrofitClient();
        }
        return mInstance;
    }
    public API getAPI(){
        return  retrofit.create(API.class);
    }
}