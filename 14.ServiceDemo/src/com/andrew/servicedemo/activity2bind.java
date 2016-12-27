package com.andrew.servicedemo;

import com.andrew.servicedemo.services.Service2Bind;
import com.andrew.servicedemo.services.Service2Bind.Andrew_Service_Binder2;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class activity2bind extends Activity
{
	String TAG="activity2bind";
	Button btn1,btn2,btn3;
	Service2Bind service2;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_andrew_view);
		eric_function();
	}

	private void eric_function()
	{
		btn1 = (Button) findViewById(R.id.button1);
		btn2 = (Button) findViewById(R.id.button2);
		btn1.setOnClickListener(listener1);
		btn2.setOnClickListener(listener2);

	}
	

	
	
	
	OnClickListener listener1 = new OnClickListener()
	{

		public void onClick(View v)
		{

			Intent service = new Intent();
			Log.i(TAG, "Clicked Button1");
			service.setClass(activity2bind.this, Service2Bind.class);
			bindService(service, conn1, Context.BIND_AUTO_CREATE); //onBindÊ±µ÷ÓÃconn1
			
		}
	};
	
	private ServiceConnection conn1 = new ServiceConnection()
	{
		
		@Override
		public void onServiceDisconnected(ComponentName name)
		{
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onServiceConnected(ComponentName name, IBinder service)
		{
			Log.i(TAG, "Bind");
			Andrew_Service_Binder2 service_binder = (Andrew_Service_Binder2) service;
			service2 = (Service2Bind) service_binder.get_binder();
			//service2.andrew_get_method();
			
		}
	};
	
	
	
	OnClickListener listener2 = new OnClickListener()
	{
		
		@Override
		public void onClick(View v)
		{
			// TODO Auto-generated method stub
			Log.i(TAG, "Clicked Button2");
			service2.andrew_get_method();
		}
	};


	
}
