package com.example.lq.light_life.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.widget.ContentFrameLayout;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by LQ on 2017/9/25.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<String> titileList;
    private ArrayList<Fragment> fragmenArraytList;

    public ViewPagerAdapter(FragmentManager fm, ArrayList<String> titleList, ArrayList<Fragment> fragmentArrayList) {
        super(fm);
        this.titileList = titleList;
        this.fragmenArraytList = fragmentArrayList;
    }

    public android.support.v4.app.Fragment getItem(int position){
        return fragmenArraytList.get(position);
    }

    @Override
    public int getCount() {
        return fragmenArraytList.size();
    }


    @Override
    public  CharSequence getPageTitle(int position){
        return titileList.get(position);
    }
}
