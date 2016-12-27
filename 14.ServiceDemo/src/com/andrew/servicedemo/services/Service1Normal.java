package com.andrew.servicedemo.services;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import android.app.Service;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;
import android.util.Log;

public class Service1Normal extends Service
{
	String TAG="Service1Normal";

	@Override
	public void onCreate()
	{
		Log.i(TAG, "onCreate");    // startService 运行一次
		super.onCreate();

	}



	@Override
	public int onStartCommand(Intent intent, int flags, int startId)
	{
		Log.i(TAG, "onStartCommand");  // 每次点击运行一次
		return super.onStartCommand(intent, flags, startId);
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
	
	
	
	

}
