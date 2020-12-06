package com.example.retrofit_kcb;

import androidx.appcompat.app.AppCompatActivity;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


import com.example.retrofit_kcb.model.kb;
import android.app.DownloadManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.retrofit_kcb.model.Token;
import com.example.retrofit_kcb.network.QZService;
import com.example.retrofit_kcb.network.kbnetwork;

import java.util.List;

public class MainActivity extends AppCompatActivity {
public String token;
public static String tokenkey;
TextView textView;
String ss="课表：\n\n";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=(TextView)findViewById(R.id.text);
//new Thread(new Runnable() {
//    @Override
//    public void run() {
//        try {
//            OkHttpClient client = new OkHttpClient();//创建Okhttpclient;
//            RequestBody requestBody=new FormBody.Builder()
//                   .add("method","authUser").add("xh","18408000935").add("pwd","15098608048as")
//           .add("xnxqid","2020-2021-1")
//           .add("zc","13")
//                    .build();
//            Request request = new Request.Builder().url("http://218.75.197.123:83/app.do")
//.addHeader("token","eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2MDcwODg5MzgsImF1ZCI6IjE4NDA4MDAwOTM1In0.pTKRPboLWoA3rZSXOFKgyQajGmSnKHA7iDc5tOVI_xc")
//                    .post(requestBody)
//                    .build();//创建Request对象
//            Response response = client.newCall(request).execute();
//            String res=response.body().string();
//            Log.d("傻子", "run: "+res);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
//}).start();

     final    kbnetwork kbnetwork=new kbnetwork();
        kbnetwork.searchToken("学号", "密码", new Callback<Token>() {
            @Override
            public void onResponse(Call<Token> call, Response<Token> response) {
                Token token=response.body();

                Log.d("傻子", "onResponse: "+token.token);
   tokenkey=token.token;
                kbnetwork.searchKb("学号", "密码", "13", "2020-2021-1",tokenkey, new Callback<List<kb>>() {

                    @Override
                    public void onResponse(Call<List<kb>> call, Response<List<kb>> response) {
                        List<kb> kb=response.body();
                        for(int i=0;i<kb.size();i++){
                          ss=ss+"周次 第几节： "+kb.get(i).kcsj+"  课程名称： "+kb.get(i).kcmc+"  开始时间："+kb.get(i).kssj+"\n\n";
                        }
                        textView.setText(ss);

                    }

                    @Override
                    public void onFailure(Call<List<kb>> call, Throwable t) {
                        Toast.makeText(MainActivity.this,""+"我出错了"+t.getMessage(),Toast.LENGTH_LONG).show();
                        Log.d("傻子", "onResponse: "+t.getMessage());
                    }
                });

            }

            @Override
            public void onFailure(Call<Token> call, Throwable t) {
                Toast.makeText(MainActivity.this,""+"我出错了",Toast.LENGTH_LONG).show();
            }
        });



}
}