package com.andrew.servicedemo.services;

import java.io.FileDescriptor;
import java.io.PrintWriter;

import android.app.Service;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;
import android.util.Log;

public class Service3Thread extends Service
{
	String TAG="Service3Thread";

	@Override
	public void onCreate()
	{
		Log.i(TAG, "onCreate");    // startService 运行一次
		super.onCreate();

	}



	@Override
	public int onStartCommand(Intent intent, int flags, int startId)
	{
		
		//return super.onStartCommand(intent, flags, startId);
		Log.i(TAG, "Service thread ID=" + Thread.currentThread().getId());
		new MyThread().start();
		return START_STICKY;		
		
		
	}



	@Override
	public IBinder onBind(Intent intent)
	{
		Log.i(TAG, "onBind");
		return null;
	}


	@Override
	public void onDestroy()
	{
		Log.i(TAG, "onDestroy");
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



	@Override
	public boolean onUnbind(Intent intent)
	{
		Log.i(TAG, "onUnbind");
		return super.onUnbind(intent);
	}



	@Override
	public void onRebind(Intent intent)
	{
		Log.i(TAG, "onRebind");
		super.onRebind(intent);
	}



	@Override
	public void onTaskRemoved(Intent rootIntent)
	{
		Log.i(TAG, "onTaskRemoved");
		super.onTaskRemoved(rootIntent);
	}



	@Override
	protected void dump(FileDescriptor fd, PrintWriter writer, String[] args)
	{
		Log.i(TAG, "dump");
		super.dump(fd, writer, args);
	}
	
	
	private class MyThread extends Thread{

		@Override
		public void run()
		{
			
			super.run();
			try
			{
				//Toast.makeText(ExampleService3.this, "Service thread ID=" + Thread.currentThread().getId(), Toast.LENGTH_SHORT).show();
				Log.i(TAG, "Function thread ID=" + Thread.currentThread().getId());
				Thread.sleep(5000);
				
			} catch (InterruptedException e)
			{
				
				e.printStackTrace();
			}	

			
			
		}
		
		
	}	
	

}
