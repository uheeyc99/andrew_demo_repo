package com.andrew.autostart;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyReveiver01 extends BroadcastReceiver
{
	//adb shell am broadcast -a android.intent.action.BOOT_COMPLETED -c android.intent.category.HOME -n com.andrew.autostart/MyReveiver
	private final String tag =  "MyReveiver01";
	@Override
	public void onReceive(Context arg0, Intent arg1)
	{
		// TODO Auto-generated method stub
		Log.i(tag, "onReceive " + arg1.getAction());
        Intent intent = new Intent(arg0, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        arg0.startActivity(intent);
        Toast.makeText(arg0, arg1.getAction(), Toast.LENGTH_LONG).show();
	}

}
