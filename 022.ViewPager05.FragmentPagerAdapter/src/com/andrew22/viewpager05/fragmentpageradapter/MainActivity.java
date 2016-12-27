package com.andrew22.viewpager05.fragmentpageradapter;

import java.util.ArrayList;
import java.util.List;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;


public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        List<Fragment> list = new ArrayList<Fragment>();
        list.add(new Fragment01());
        list.add(new Fragment02());
        list.add(new Fragment03());
        
        PagerAdapter pagerAdapter = new FragAdapter01(getSupportFragmentManager(), list);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(pagerAdapter);
        
    }


}
