package com.andrew.autostart;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyReveiver02 extends BroadcastReceiver
{
	//adb shell am broadcast -a android.intent.action.BOOT_COMPLETED -c android.intent.category.HOME -n com.andrew.autostart/MyReveiver
	private final String tag =  "MyReveiver02";
	@Override
	public void onReceive(Context arg0, Intent arg1)
	{
		// TODO Auto-generated method stub
		Log.i(tag, "onReceive " + arg1.getAction());

	}

}
