package com.andrew22.viewpager02.pagertitlestrip;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends Activity {
	ViewPager viewPager;
	View view1,view2,view3;
	List<View> vlist;
	List<String> tlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        LayoutInflater inflater1 = getLayoutInflater();
        Vholder vholder = new Vholder(); 
        view1 = inflater1.inflate(R.layout.layout1, null);
        view2 = inflater1.inflate(R.layout.layout2, null);
        view3 = inflater1.inflate(R.layout.layout3, null);
        
        vlist = new ArrayList<View>();
        vlist.add(view1);
        vlist.add(view2);
        vlist.add(view3);
        
        tlist= new ArrayList<String>();
        tlist.add("ตฺ1าณ");
        tlist.add("ตฺ2าณ");
        tlist.add("ตฺ3าณ");
        
        
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        
        vholder.tlist = tlist;
        vholder.vlist = vlist;
        viewPager.setAdapter(new pageAdapter2(vholder));
        
    }


    
    
    
}
