package com.andrew.logservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class AndrewLogService extends Service
{
	private final String TAG = "AndrewLogService";
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
		Log.i(TAG, "onStartCommand");
		andrew_log("onStartCommand");
		return super.onStartCommand(intent, flags, startId);
	}

	protected void andrew_log(String string) {
		// TODO Auto-generated method stub
		Intent intent = new Intent();
		intent.setAction("andrew_log.eric");
		intent.putExtra("text",string);
		sendBroadcast(intent);
		
	}	
	
}
