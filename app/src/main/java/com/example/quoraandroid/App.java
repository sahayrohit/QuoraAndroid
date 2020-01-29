package com.example.quoraandroid;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class App {


    static Retrofit retrofit;
    static Retrofit getRetrofit(){
        if(retrofit==null){
            OkHttpClient client = new OkHttpClient.Builder().build();
            retrofit=new Retrofit.Builder().baseUrl("").addConverterFactory(GsonConverterFactory.create()).client(client).build();
        }
        return retrofit;
    }
}
