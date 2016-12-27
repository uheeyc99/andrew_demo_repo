package com.andrew02.service_bind;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class BinderService01 extends Service
{
	private static final String TAG = "BinderService01";
	
	private EricBinder01 binder = new EricBinder01();  //实例
	public class EricBinder01 extends Binder  //方法
	{
		public BinderService01 eric_getService()
		{
			Log.i(TAG, "getService()");
			return BinderService01.this;
		}
	}

	public void MyMethod()
	{
		Log.i(TAG, "MyMethod()");
		try
		{
			Thread.sleep(3000);
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public IBinder onBind(Intent intent)
	{
		// TODO Auto-generated method stub
		Log.i(TAG, "onBind()");
		return binder;    //启动Service 时返回binder  (即service)实例
	}

	@Override
	public boolean onUnbind(Intent intent)
	{
		// TODO Auto-generated method stub
		Log.i(TAG, "onUnbind()");
		return super.onUnbind(intent);
	}

	@Override
	public void onCreate()
	{
		// TODO Auto-generated method stub
		Log.i(TAG, "onCreate()");
		super.onCreate();
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId)
	{
		// TODO Auto-generated method stub
		Log.i(TAG, "onStartCommand()");
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public void onDestroy()
	{
		// TODO Auto-generated method stub
		Log.i(TAG, "onDestroy()");
		super.onDestroy();
	}

	@Override
	public void onRebind(Intent intent)
	{
		// TODO Auto-generated method stub
		Log.i(TAG, "onRebind()");
		super.onRebind(intent);
	}

}
