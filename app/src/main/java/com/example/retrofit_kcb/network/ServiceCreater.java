package com.example.retrofit_kcb.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceCreater  {
private String BASE_URL="http://218.75.197.123:83/";
private Retrofit retrofit;
private static ServiceCreater instance;
private ServiceCreater(){
retrofit= new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();//获得retrofit对象
}//请求路径，转换库
public static ServiceCreater getInstance(){
if(instance==null){
instance=new ServiceCreater();
}
return instance;
}
public <T> T create(Class<T> service){
return retrofit.create(service);//获得接口的动态代理对象，然后可以调用该接口的任意方法
}

}
