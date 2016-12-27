package com.andrew.servicedemo;

import com.andrew.servicedemo.services.Service1Normal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class activity1normal extends Activity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_andrew_view);
		eric_function();
	}

	private void eric_function()
	{
		Button btn1 = (Button) findViewById(R.id.button1);
		Button btn2 = (Button) findViewById(R.id.button2);
		btn1.setOnClickListener(listener1);
		btn2.setOnClickListener(listener1);
	}

	OnClickListener listener1 = new OnClickListener()
	{
		
		@Override
		public void onClick(View v)
		{
			Button btn=(Button) v;
			
			Intent intent = new Intent();
			if(btn.getId() == R.id.button1){
				intent.setClass(activity1normal.this, Service1Normal.class);
				startService(intent);
			}
			else
			if(btn.getId() == R.id.button2){
				intent.setClass(activity1normal.this, Service1Normal.class);
				stopService(intent);
			}			
			
			
		}
	};
	
}
