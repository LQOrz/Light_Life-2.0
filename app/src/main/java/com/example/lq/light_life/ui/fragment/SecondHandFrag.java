package com.example.lq.light_life.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lq.light_life.R;
import com.example.lq.light_life.ui.adapter.SecondHandAdapter;
import com.example.lq.light_life.classdefinition.SecondHandMsg;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LQ on 2017/9/25.
 */

public class SecondHandFrag extends Fragment  {

    View mView;
    private List<SecondHandMsg> secondHandMsgList = new ArrayList<>();
    private SwipeRefreshLayout swipeRefreshMsg;
    SecondHandAdapter secondHandAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.frag_second_hand, container, false);
        initSecondHandMsg();//初始化二手咨询信息
        RecyclerView recyclerView = (RecyclerView) mView.findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        secondHandAdapter = new SecondHandAdapter(secondHandMsgList);
        recyclerView.setAdapter(secondHandAdapter);




        return mView;
    }

    private void initSecondHandMsg() {
        for (int i = 0; i < 50; i++) {
            SecondHandMsg apple = new SecondHandMsg("姓名：小红", "电话：12345678910", "交易物品：手机", R.drawable.phone);
            secondHandMsgList.add(apple);
            SecondHandMsg bag = new SecondHandMsg("姓名：杨幂", "电话：12328333910", "交易物品：书包", R.drawable.bag);
            secondHandMsgList.add(bag);
            SecondHandMsg bicycle = new SecondHandMsg("姓名：吴亦凡", "电话：1234588586910", "交易物品：自行车", R.drawable.bicycle);
            secondHandMsgList.add(bicycle);
            SecondHandMsg hat = new SecondHandMsg("姓名：赵丽颖", "电话：12345669810", "交易物品：围巾和帽子", R.drawable.hat);
            secondHandMsgList.add(hat);
            SecondHandMsg wallet = new SecondHandMsg("姓名：李易峰", "电话：12345369910", "交易物品：钱包", R.drawable.wallet);
            secondHandMsgList.add(wallet);
            SecondHandMsg grape = new SecondHandMsg("姓名：王二小", "电话：832345678910", "交易物品：新鲜葡萄", R.drawable.grape);
            secondHandMsgList.add(grape);
            SecondHandMsg pineapple = new SecondHandMsg("姓名：小花", "电话：56985678910", "交易物品：新鲜果汁", R.drawable.pineapple);
            secondHandMsgList.add(pineapple);
            SecondHandMsg strawberry = new SecondHandMsg("姓名：大王", "电话：14569673910", "交易物品：新鲜草莓", R.drawable.strawberry);
            secondHandMsgList.add(strawberry);
            SecondHandMsg zidian = new SecondHandMsg("姓名：迪丽热巴", "电话：18796256480", "交易物品：牛津大字典", R.drawable.zidian);
            secondHandMsgList.add(zidian);
            SecondHandMsg cherry = new SecondHandMsg("姓名：樱桃小丸子", "电话：1523098080", "交易物品：新鲜樱桃", R.drawable.cherry);
            secondHandMsgList.add(cherry);

        }
    }



}