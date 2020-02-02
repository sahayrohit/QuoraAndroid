package com.example.quoraandroid;

import android.app.Application;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class App extends Application {

        static Retrofit retrofit, retrofit2,retrofit3, retrofit5;

        public static Retrofit getRetrofit(){
            if (retrofit==null){
             OkHttpClient client = new OkHttpClient.Builder().build();
             retrofit= new Retrofit.Builder()
                     .baseUrl("http://172.16.20.165:8111/")
                     .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setLenient().create()))
                     .client(client)
                     .build();
            }
            return retrofit;
        }


//    static Retrofit retrofit1,retrofit2,retrofit3,retrofit4,retrofit5;
//
//
//
    static Retrofit getRetrofitCategories(){
        if(retrofit5==null){
            OkHttpClient client = new OkHttpClient.Builder().build();
            retrofit5=new Retrofit.Builder().baseUrl("http://172.16.20.83:8080/").addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setLenient().create())).client(client).build();
        }
        return retrofit5;
    }
//
////raghav
//    static Retrofit getRetrofitProfile(){
//        if(retrofit4==null){
//
//            OkHttpClient client = new OkHttpClient.Builder().build();
//            retrofit4 = new Retrofit.Builder().baseUrl("http://172.16.20.119:8080").addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setLenient().create())).client(client).build();
//        }
//        return retrofit4;
//    }
//
    static Retrofit getRetrofitAds(){
        if(retrofit3==null){
            OkHttpClient client = new OkHttpClient.Builder().build();
            retrofit3=new Retrofit.Builder().baseUrl("http://172.16.20.83:8080/").addConverterFactory(GsonConverterFactory.create()).client(client).build();
        }
        return retrofit3;
    }
//
//    static Retrofit getRetrofit(){
//        if(retrofit==null){
//            OkHttpClient client = new OkHttpClient.Builder().build();
//            retrofit=new Retrofit.Builder().baseUrl("http://172.16.20.110:8080").addConverterFactory(GsonConverterFactory.create()).client(client).build();
//        }
//        return retrofit;
//    }
//
//    static Retrofit getRetrofitCategory(){
//        if(retrofit1==null){
//            OkHttpClient client = new OkHttpClient.Builder().build();
//            retrofit1=new Retrofit.Builder().baseUrl("http://10.177.68.118:8080").addConverterFactory(GsonConverterFactory.create()).client(client).build();
//        }
//        return retrofit1;
//    }
    static Retrofit getRetrofitRegistration(){
        if(retrofit2==null){
            OkHttpClient client = new OkHttpClient.Builder().build();
            retrofit2=new Retrofit.Builder().baseUrl("http://172.16.20.121:8080/").addConverterFactory(GsonConverterFactory.create()).client(client).build();
        }
        return retrofit2;
    }
}
