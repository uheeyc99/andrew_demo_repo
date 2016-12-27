package com.Andrew.broadcastreceiver.receiver02;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class EricReceiver02 extends BroadcastReceiver
{
	private final String tag="MyReceiver2";
	int i = 0;
	@Override
	public void onReceive(Context context, Intent intent)
	{
		// TODO Auto-generated method stub
		Log.i(tag, "onReceiver" + " " + i);
		i++;
	}
	public EricReceiver02()  //启动时时执行一次，说明onReceive()执行完毕后，其生命周期不结束
	{
		super();
		// TODO Auto-generated constructor stub
		Log.i(tag, "EricReceiver02");
		
	}

}
