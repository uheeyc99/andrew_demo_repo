package com.andrew07.service03_thread;

import com.andrew07.service03_thread.service.Andrew01Service;
import com.andrew07.service03_thread.service.Andrew02ServiceIntent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class AndrewMainActivity extends Activity {
	private static String TAG = "AndrewMainActivity";
	Button btn1,btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_andrew_main);
        btn1 = (Button) findViewById(R.id.button1);
        btn2= (Button) findViewById(R.id.button2);
        btn1.setOnClickListener(listener);
        btn2.setOnClickListener(listener);
        
    }

    OnClickListener listener = new OnClickListener()
	{
    	
		@Override
		public void onClick(View v)
		{
			Button btn = (Button) v;
			Intent service = new Intent();
			Log.i(TAG, "主线程ID： " + Thread.currentThread().getId()+ " 点击一次按钮");
			// TODO Auto-generated method stub
			switch (btn.getId())
			{

			case R.id.button1:
				service.setClass(AndrewMainActivity.this,Andrew01Service.class );
				Log.i(TAG, "1");
				startService(service);
				break;	
			case R.id.button2:
				service.setClass(AndrewMainActivity.this, Andrew02ServiceIntent.class);
				Log.i(TAG, "2");
				startService(service);
				break;
			default:
				break;
			}
			
		}
	};
    
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.andrew_main, menu);
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
