package com.andrew02.service_bind;



import com.andrew02.service_bind.BinderService01.EricBinder01;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class AndrewMainActivity extends Activity {
	Button btn1,btn2,btn3;
	BinderService01 service01;
	private static final String TAG = "AndrewMainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = (Button) findViewById(R.id.button1);
        btn2 = (Button) findViewById(R.id.button2);
        btn3 = (Button) findViewById(R.id.button3);
        btn1.setOnClickListener(listener);
        btn2.setOnClickListener(listener);
        btn3.setOnClickListener(listener);
        btn2.setClickable(false);
        btn3.setClickable(false);
    }
    
    OnClickListener listener = new OnClickListener()
	{
		
		@Override
		public void onClick(View v)
		{
			
			// TODO Auto-generated method stub
			Button btnButton = (Button) v;
			//Intent intent = new Intent();
			switch (btnButton.getId())
			{
			case R.id.button1:
				eric_bind();
				btn2.setClickable(true);
				btn3.setClickable(true);
				break;
			case R.id.button2:
				eric_unbind();
				btn2.setClickable(false);
				break;
			case R.id.button3:
				service01.MyMethod();
				break;				
			default:
				break;
			}
			
		}


		private void eric_bind()
		{
			// TODO Auto-generated method stub
			Intent intent = new Intent();
			intent.setClass(AndrewMainActivity.this, BinderService01.class);
			bindService(intent, conn, Context.BIND_AUTO_CREATE);
			Log.i(TAG, "eric_bind()");
			
		}
		
		private void eric_unbind()
		{
			// TODO Auto-generated method stub
			Log.i(TAG, "eric_unbind()");
			unbindService(conn);
			
		}
		
		ServiceConnection conn = new ServiceConnection()
		{
			
			@Override
			public void onServiceDisconnected(ComponentName name)
			{
				
				// TODO Auto-generated method stub
				Log.i(TAG, "onServiceDisconnected()");
				
			}
			
			@Override
			public void onServiceConnected(ComponentName name, IBinder service)
			{
				
				// TODO Auto-generated method stub
				Log.i(TAG, "onServiceConnected()");
				EricBinder01 mybinder = (EricBinder01)service;
				service01 = mybinder.eric_getService();
				
			}
		};
		
		
	};
	
	

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
