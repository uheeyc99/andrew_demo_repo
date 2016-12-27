package com.andrew.servicedemo;

import com.andrew.servicedemo.services.Service3Thread;
import com.andrew.servicedemo.services.Service3ThreadIntent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class activity3thread extends Activity
{
	String TAG="activity3thread";
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
			
			if(btn.getId() == R.id.button1){  // 调用线程执行函数  新建并行
				intent.setClass(activity3thread.this, Service3Thread.class);
				Log.i(TAG, "Active thread ID=" + Thread.currentThread().getId());
				startService(intent);
			}
			else
			if(btn.getId() == R.id.button2){  //排队
				intent.setClass(activity3thread.this, Service3ThreadIntent.class);
				Log.i(TAG, "Active thread ID=" + Thread.currentThread().getId());
				startService(intent);
			}			
			
			
		}
	};
	
}
