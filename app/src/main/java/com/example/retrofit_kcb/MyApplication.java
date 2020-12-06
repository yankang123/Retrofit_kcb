package com.example.retrofit_kcb;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MyApplication extends Application {
private    static Context context;
   public static String token;

    @Override
    public void onCreate() {
        super.onCreate();
        context=getApplicationContext();


        }
public static Context getContext(){
        return context;
}

}
