package com.example.lq.light_life.ui.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lq.light_life.R;
import com.example.lq.light_life.ui.adapter.ViewPagerAdapter;

import java.util.ArrayList;


/**
 * Created by LQ on 2017/10/22.
 */

public class LightLifeFrag extends Fragment {
    View viewContent;
    private ViewPager viewPager;
    private TabLayout tabLayout;
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

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {

        viewContent = inflater.inflate(R.layout.frag_light_life,container,false);

        //页面
        viewPager = (ViewPager) viewContent.findViewById(R.id.viewPager);
        tabLayout = (TabLayout) viewContent.findViewById(R.id.tablayout);

//        final Context context = getContext();
//
//        final FloatingDraftButton floatingDraftButton = (FloatingDraftButton)viewContent.findViewById(R.id.floatingActionButton);
//        FloatingActionButton liveness = (FloatingActionButton)viewContent.findViewById(R.id.floatingActionButton_liveness);
//        FloatingActionButton floatingActionButton2 = (FloatingActionButton)viewContent.findViewById(R.id.floatingActionButton_2);
//        FloatingActionButton floatingActionButton3 = (FloatingActionButton)viewContent.findViewById(R.id.floatingActionButton_3);
//        FloatingActionButton floatingActionButton4 = (FloatingActionButton)viewContent.findViewById(R.id.floatingActionButton_4);
//        FloatingActionButton floatingActionButton5 = (FloatingActionButton)viewContent.findViewById(R.id.floatingActionButton_5);
//
//        floatingDraftButton.registerButton(liveness);
//        floatingDraftButton.registerButton(floatingActionButton2);
//        floatingDraftButton.registerButton(floatingActionButton3);
//        floatingDraftButton.registerButton(floatingActionButton4);
//        floatingDraftButton.registerButton(floatingActionButton5);
//
//        floatingDraftButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(final View v) {
//                //弹出动态Button
//                AnimationUtil.slideButtons(context,floatingDraftButton);
//            }
//        });
//        liveness.setOnClickListener(new View.OnClickListener() {
//                                        @Override
//                                        public void onClick(View v) {
//                                            //关闭动态Button
//                                            // AnimationUtil.slideButtons(MainActivity.this,floatingDraftButton);
//                                            // Toast.makeText(getApplicationContext(), "liveness", Toast.LENGTH_SHORT).show();    }});
//                                        }
//                                    }
        //ViewPager适配器
        pagerAdapter = new ViewPagerAdapter(getFragmentManager(),titleList,fragmentArrayList);
        viewPager.setAdapter(pagerAdapter);

        //绑定，将ViewPager和tablayout两个控件绑定
        tabLayout.setupWithViewPager(viewPager);

        viewPager.setCurrentItem(2);

        // 缓存的viewiew需要判断是否已经被加过parent，
        // 如果有parent需要从parent删除，要不然会发生这个view已经有parent的错误。
        ViewGroup parent = (ViewGroup) viewContent.getParent();
        if (parent != null) {
            parent.removeView(viewContent);
        }
        return viewContent;
    }

}
