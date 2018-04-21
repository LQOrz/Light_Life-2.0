package com.example.lq.light_life.others;

import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.lq.light_life.R;
import com.example.lq.light_life.classdefinition.SecondHandMsg;
import com.example.lq.light_life.ui.adapter.ViewPagerAdapter;
import com.example.lq.light_life.ui.fragment.CloudPrintFrag;
import com.example.lq.light_life.ui.fragment.ExtraCurricularFrag;
import com.example.lq.light_life.ui.fragment.NewNavigationFrag;
import com.example.lq.light_life.ui.fragment.SecondHandFrag;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private DrawerLayout mDrawerlayout;
    private ViewPagerAdapter pagerAdapter;

    private NewNavigationFrag newNavigationFrag = new NewNavigationFrag();
    private SecondHandFrag secondHandFrag = new SecondHandFrag();
    private CloudPrintFrag cloudPrintFrag = new CloudPrintFrag();
    private ExtraCurricularFrag extraCurricularFrag = new ExtraCurricularFrag();




    //标签数组
    private ArrayList<String> titleList = new ArrayList<String>(){{
        add("新生导航");
        add("二手资讯");
        add("校园云打印");
        add("课外生活");
    }};
    //碎片数组
    private ArrayList<Fragment> fragmentArrayList = new ArrayList<Fragment>(){{
        add(newNavigationFrag);
        add(secondHandFrag);
        add(cloudPrintFrag);
        add(extraCurricularFrag);
    }};

    //二手交易碎片列表
    private List<SecondHandMsg> secondHandMsgList = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //实例化
        //标题栏
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //
        mDrawerlayout=(DrawerLayout)findViewById(R.id.drawerlayout);
        //侧面信息页
        NavigationView navigationView=(NavigationView)findViewById(R.id.nav_view);
        ActionBar actionBar = getSupportActionBar();

        //页面
        tabLayout = (TabLayout)findViewById(R.id.tablayout);
        viewPager = (ViewPager)findViewById(R.id.viewPager);

        //ViewPager适配器
        pagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(),titleList,fragmentArrayList);
        viewPager.setAdapter(pagerAdapter);

        //绑定，将ViewPager和tablayout两个控件绑定
        tabLayout.setupWithViewPager(viewPager);

        //标题栏
        if (actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.menu);
        }

        navigationView.setCheckedItem(R.id.nav_call);
        navigationView.setNavigationItemSelectedListener(new NavigationView.
                OnNavigationItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                mDrawerlayout.closeDrawers();
                //在这里写具体的菜单选项的实现功能


                return true;
            }
        });
    }

//菜单栏
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                mDrawerlayout.openDrawer(GravityCompat.START);
                break;
            //
            default:
        }
        return true;
    }
}

