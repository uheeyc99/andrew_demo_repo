package com.andrew.tabdemo;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TextView;
import android.widget.Toast;
/*
 * 
 1、TabHost　　　　可自定义id
 2、TabWidget　　　必须设置android:id为@android:id/tabs
 3、FrameLayout　  必须设置android:id为@android:id/tabcontent
 * 
 */

public class Andrew2Activity extends Activity
{
	TabHost tabHost;
	TextView tv1;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.demo2);
		
		tabHost = (TabHost) findViewById(R.id.mytab2);
		
		
		tabHost.setup();  //Activity
		
		
  
        
        
        tabHost.addTab(tabHost.newTabSpec("1").setIndicator("green").setContent(R.id.widget_layout_green2));
        tabHost.addTab(tabHost.newTabSpec("2").setIndicator("yellow").setContent(R.id.widget_layout_yellow2));
        tabHost.addTab(tabHost.newTabSpec("3").setIndicator("blue").setContent(R.id.widget_layout_blue2));
 
        TabHost.TabSpec tab1spec= tabHost.newTabSpec("4");
        tab1spec.setIndicator("red");
        tab1spec.setContent(R.id.widget_layout_red2);
        tabHost.addTab(tab1spec);
        
        tabHost.setBackgroundResource(R.drawable.ic_launcher);
        tabHost.setOnTabChangedListener(listener1);
        tabHost.setCurrentTab(1);
     		

	}

	OnTabChangeListener listener1 = new OnTabChangeListener()
	{
		
		@Override
		public void onTabChanged(String tabId)
		{
			// TODO Auto-generated method stub
			Toast.makeText(Andrew2Activity.this, tabId, Toast.LENGTH_SHORT).show();
			
		}
	};
	

	
	
	
}
