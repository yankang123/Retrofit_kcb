package com.example.retrofit_kcb.network;

import com.example.retrofit_kcb.model.Token;
import com.example.retrofit_kcb.model.kb;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class kbnetwork {
    private  QZService qzService=ServiceCreater.getInstance().create(QZService.class);
    public void searchToken(String xh,String pwd, Callback<Token> callback){
        Call<Token> call=qzService.gettoken(xh,pwd);
call.enqueue(callback);
    }


    public  void searchKb(String xh,String pwd,String zc,String xn,String token, Callback<List<kb>> callback){
        Call<List<kb>> call=qzService.getkb(xh,pwd,zc,xn,token);
        call.enqueue(callback);
    }
}
