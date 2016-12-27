package com.andrew06.activity01_lifecycle;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class AndrewMainActivity extends Activity {
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_andrew_main);
        sendlog(Thread.currentThread().getStackTrace()[2].getMethodName());
        
    }

    
	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		sendlog(Thread.currentThread().getStackTrace()[2].getMethodName());
		super.onRestart();
	}


	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		sendlog(Thread.currentThread().getStackTrace()[2].getMethodName());
		super.onStop();
	}


	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		sendlog(Thread.currentThread().getStackTrace()[2].getMethodName());
		super.onDestroy();
	}


	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		sendlog(Thread.currentThread().getStackTrace()[2].getMethodName());
		super.onPause();
	}


	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		sendlog(Thread.currentThread().getStackTrace()[2].getMethodName());
		super.onResume();
	}


	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		//Thread.currentThread().getStackTrace()[2].getMethodName();
		sendlog(Thread.currentThread().getStackTrace()[2].getMethodName());
		super.onStart();
	}


	protected void sendlog(String string) {
		// TODO Auto-generated method stub
		Intent intent = new Intent();
		intent.setAction("andrew_log.eric");
		intent.putExtra("data",string+","+getRunningActivityName());
		sendBroadcast(intent);
		
	}   
	private String getRunningActivityName(){          
        ActivityManager activityManager=(ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);  
        String runningActivity=activityManager.getRunningTasks(1).get(0).topActivity.getClassName();  
        return runningActivity;                 
}		
	
}
