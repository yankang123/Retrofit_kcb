package com.example.retrofit_kcb;

public class Reposity {
private static Reposity reposity;
private Reposity(){

}
public static Reposity getReposity(){
if (reposity==null){
reposity=new Reposity();
}
return reposity;
}

}
