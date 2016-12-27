package com.andrew.tabtest1;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabSpec;
import android.widget.TabWidget;
import android.widget.Toast;


public class AndrewTabActivity extends Activity {
	TabHost tabHost;
	String[] tab_list = {"aa1","aa2","aa3"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo2);
        eric_function();
        
    }

    private void eric_function()
	{
		// TODO Auto-generated method stub
    	tabHost = (TabHost) findViewById(R.id.mytab1);
    	tabHost.setup();
    	 
    	//tabHost.setBackgroundColor(Color.argb(150, 20, 80, 150));
    	tabHost.setBackgroundResource(R.drawable.ic_launcher);
    	
    	
    	//
    	TabSpec tabSpec;
    	// 1
    	tabSpec = tabHost.newTabSpec(tab_list[0]);
    	tabSpec.setIndicator("a.1");
    	tabSpec.setContent(R.id.widget_layout_blue2);
    	tabHost.addTab(tabSpec);
    	// 2
    	tabSpec = tabHost.newTabSpec(tab_list[1]);
    	tabSpec.setIndicator("a2");
    	tabSpec.setContent(R.id.widget_layout_green2);
    	tabHost.addTab(tabSpec);    	
    	// 3
    	tabSpec = tabHost.newTabSpec(tab_list[2]);
    	tabSpec.setIndicator("a3");
    	tabSpec.setContent(R.id.widget_layout_red2);
    	tabHost.addTab(tabSpec);    	
    	//
		tabHost.setOnTabChangedListener(listener1);
    	//
		
		
		
		
	}
    
    
    
    
	private OnTabChangeListener listener1 = new OnTabChangeListener()
	{
		
		@Override
		public void onTabChanged(String tabId)
		{
			// TODO Auto-generated method stub
			Toast.makeText(AndrewTabActivity.this, "You Clicked " + tabId, Toast.LENGTH_SHORT).show();
			dialog_clicked(tabId);
		}

		private void dialog_clicked(String tabId)
		{
			// TODO Auto-generated method stub
			AlertDialog.Builder builder = new AlertDialog.Builder(AndrewTabActivity.this);
			Dialog dialog;
			builder.setTitle("°¡Ñ½");
			builder.setMessage("you clicked " + tabId +" tab !");
			builder.setPositiveButton("^_^", button_listener );
			dialog = builder.create();
			dialog.show();
		}
		
		
		private OnClickListener button_listener = new OnClickListener()
		{
			
			@Override
			public void onClick(DialogInterface dialog, int which)
			{
				// TODO Auto-generated method stub
				dialog.cancel();
			}
		};
		
		
	};
	
	
	
    OnPageChangeListener listener2 = new OnPageChangeListener()
	{
		
		@Override
		public void onPageSelected(int arg0)
		{
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2)
		{
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onPageScrollStateChanged(int arg0)
		{
			// TODO Auto-generated method stub
			
		}
	};
    

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.andrew_tab, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
