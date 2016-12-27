package com.andrew22.viewpager01;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import java.util.ArrayList;


public class MainActivity extends Activity {
	private View view1,view2,view3;
	private List<View> viewList = null;//view����
	private ViewPager viewPager=null;//��Ӧ��viewPager
	PagerAdapter pagerAdapter01=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        /*
         *   ����Դ�������ϵ�������֣����ʵ������view1,view2,view3��ӵ�viewList��
         **/
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        
        LayoutInflater inflater1 = getLayoutInflater();
        view1 = inflater1.inflate(R.layout.layout1, null);
        view2 = inflater1.inflate(R.layout.layout2, null);
        view3 = inflater1.inflate(R.layout.layout3, null);
        viewList = new ArrayList<View>();      
        viewList.add(view1);
        viewList.add(view2);
        viewList.add(view3);
        
        pagerAdapter01 = new pageAdapter1(viewList);

        viewPager.setAdapter(pagerAdapter01);

		
    }


}
