package com.andrew.tabdemo;


import android.R.integer;
import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.TabHost;
/*
TabActivity
1、TabHost　　　　必须设置android:id为@android:id/tabhost
2、TabWidget　　　必须设置android:id为@android:id/tabs
3、FrameLayout　  必须设置android:id为@android:id/tabcontent
*/
public class Andrew1TabActivity extends TabActivity {
	TabHost tabHost;
	WebView webView;
    @SuppressWarnings("deprecation")
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo1);
        tabHost = getTabHost();
        
        TabHost.TabSpec tab1spec= tabHost.newTabSpec("new");
        tab1spec.setIndicator("蓝色");
        tab1spec.setContent(R.id.widget_layout_blue);
        tabHost.addTab(tab1spec);        
        
        tabHost.addTab(tabHost.newTabSpec("aaa").setIndicator("web-百度").setContent(R.id.widget_layout_red));
        tabHost.addTab(tabHost.newTabSpec("bbb").setIndicator("黄色").setContent(R.id.widget_layout_yellow));
        

        
  
        
    }

    
    
    
    private void eee()
	{
		// TODO Auto-generated method stub
        webView = (WebView) findViewById(R.id.webView1);
    	
       // getWindow().requestFeature(Window.FEATURE_PROGRESS);
        webView.getSettings().setJavaScriptEnabled(true);      
        webView.loadUrl("http://www.baidu.com");
	}




	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.andrew1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
    	Intent intent = new Intent();
        int id = item.getItemId();
        if (id == R.id.action_settings) {
        	finish();
            return true;
        }
        
        if (id == R.id.page1) {
        	intent.setClass(Andrew1TabActivity.this, Andrew2Activity.class);
        	startActivity(intent);
            return true;
        }
        
        if (id == R.id.page2) {
        	finish();
            return true;
        }        
        
        
        
        
        
        return super.onOptionsItemSelected(item);
    }
}
