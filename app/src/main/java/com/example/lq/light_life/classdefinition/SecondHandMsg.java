package com.example.lq.light_life.classdefinition;

/**
 * Created by LQ on 2017/9/25.
 */

//主页二手交易页面下recyclerView中的简介信息
public class SecondHandMsg {
    private String  pname;
    private String  phone;
    private String  tname;
    private int imageId;
    public SecondHandMsg(String  pname, String  phone, String  tname, int imageId){
        this.pname = pname;
        this.phone = phone;
        this.tname = tname;
        this.imageId = imageId;
    }
    public String getPname(){
        return pname;
    }
    public String getPhone(){
        return phone;
    }
    public String getTname(){
        return tname;
    }
    public int getImageId(){
        return imageId;
    }
}
