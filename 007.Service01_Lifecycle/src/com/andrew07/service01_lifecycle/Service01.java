package com.andrew07.service01_lifecycle;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class Service01 extends Service
{

	@Override
	public void onCreate()
	{
		// TODO Auto-generated method stub
		sendlog(Thread.currentThread().getStackTrace()[2].getMethodName());
		super.onCreate();
	}

	@Override
	@Deprecated
	public void onStart(Intent intent, int startId)
	{
		// TODO Auto-generated method stub
		sendlog(Thread.currentThread().getStackTrace()[2].getMethodName());
		super.onStart(intent, startId);
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId)
	{
		// TODO Auto-generated method stub
		sendlog(Thread.currentThread().getStackTrace()[2].getMethodName());
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public void onDestroy()
	{
		// TODO Auto-generated method stub
		sendlog(Thread.currentThread().getStackTrace()[2].getMethodName());
		super.onDestroy();
	}

	@Override
	public IBinder onBind(Intent intent)
	{
		// TODO Auto-generated method stub
		
		sendlog(Thread.currentThread().getStackTrace()[2].getMethodName());
		return null;
	}
	
	protected void sendlog(String string) {
		// TODO Auto-generated method stub
		Intent intent = new Intent();
		intent.setAction("andrew_log.eric");
		intent.putExtra("data",string);
		sendBroadcast(intent);
		
	}    
}
