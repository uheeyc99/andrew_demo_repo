package com.Andrew.broadcastreceiver.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class EricReceiver01 extends BroadcastReceiver
{

	private final String tag="MyReceiver1";
	int i=0;
	@Override
	public void onReceive(Context context, Intent intent)
	{
		// TODO Auto-generated method stub
		Log.i(tag, "onReceiver"+" "+i);

	}
	public EricReceiver01()
	{
		
		super();
		// TODO Auto-generated constructor stub
		Log.i(tag, "EricReceiver1"); //每次都执行，说明onReceive()执行完毕后，其生命周期结束
	}
}
