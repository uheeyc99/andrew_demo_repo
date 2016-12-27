package com.andrew.servicedemo.services;

import java.io.FileDescriptor;
import java.io.PrintWriter;

import android.app.IntentService;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;
import android.util.Log;

public class Service3ThreadIntent extends IntentService
{
	String TAG="Service3ThreadIntent";
	
	//public Service3ThreadIntent(String name)  //替换
	public Service3ThreadIntent()    
	{
		//super(name);//替换
		super("Service3ThreadIntent");
		Log.i(TAG, "Service3ThreadIntent"); // 1
		
	}


	protected void onHandleIntent(Intent intent){  //点击一次后进入队列  ，不一定立即执行
		Log.i(TAG, "onHandleIntent");   // 4
		eric_test_queue();   
	}
	

	@Override
	public void onCreate()    
	{
		Log.i(TAG, "onCreate");    //2
		super.onCreate();

	}



	@Override
	public int onStartCommand(Intent intent, int flags, int startId)  
	{
		Log.i(TAG, "onStartCommand"); // 3
		return super.onStartCommand(intent, flags, startId);
		//return START_STICKY;			
	}



	@Override
	public IBinder onBind(Intent intent)
	{
		Log.i(TAG, "onBind");
		return null;
	}


	@Override
	public void onDestroy()  // 队列完成后执行
	{
		Log.i(TAG, "onDestroy");  // 6
		super.onDestroy();
	}



	@Override
	public void onConfigurationChanged(Configuration newConfig)
	{
		Log.i(TAG, "onConfigurationChanged");
		super.onConfigurationChanged(newConfig);
	}



	@Override
	public void onLowMemory()
	{
		Log.i(TAG, "onLowMemory");
		super.onLowMemory();
	}



	@Override
	public void onTrimMemory(int level)
	{
		Log.i(TAG, "onTrimMemory");
		super.onTrimMemory(level);
	}




	public boolean onUnbind(Intent intent)
	{
		Log.i(TAG, "onUnbind");
		return super.onUnbind(intent);
	}




	public void onRebind(Intent intent)
	{
		Log.i(TAG, "onRebind");
		super.onRebind(intent);
	}




	public void onTaskRemoved(Intent rootIntent)
	{
		Log.i(TAG, "onTaskRemoved");
		super.onTaskRemoved(rootIntent);
	}



	protected void dump(FileDescriptor fd, PrintWriter writer, String[] args)
	{
		Log.i(TAG, "dump");
		super.dump(fd, writer, args);
	}
	
	
	private void eric_test_queue() 
	{
		
		try
		{
			Log.i(TAG, "function thread ID = " + Thread.currentThread().getId());  //5
			Thread.sleep(3000);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		
	}
	

	

}
