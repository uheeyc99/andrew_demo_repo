package com.andrew.autostart;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.util.Log;

public class ServiceInMemory extends Service
{
	private final String tag = "ServiceInMemory";
	MyReveiver02 rec= new MyReveiver02();
	@Override
	public IBinder onBind(Intent arg0)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId)
	{
		// TODO Auto-generated method stub
		flags = Service.START_REDELIVER_INTENT;
		
		Log.i(tag, "onStartCommand");
		reg_func();
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public void onDestroy()
	{
		// TODO Auto-generated method stub
		Log.i(tag, "onDestroy");
        //Intent intent = new Intent(this, ServiceInMemory.class);
        //this.startService(intent);
		
		super.onDestroy();
	}

	private void reg_func()
	{
		// TODO Auto-generated method stub
		IntentFilter intentFilter = new IntentFilter();
		intentFilter.addAction("eric_action02");
		intentFilter.addAction("eric_action03");
		registerReceiver(rec,intentFilter);		
	}

	

	
}
