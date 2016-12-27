package com.andrew.logservice;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.R.string;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

import android.os.Bundle;
import android.util.Log;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends Activity {
	private final String TAG = "Activity";
	Button btn1=null;
	EditText et1=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "onCreate");
        //Intent intent = new Intent(MainActivity.this, AndrewLogService.class);
       // startService(intent);
        btn1 = (Button) findViewById(R.id.button1);
        et1 = (EditText) findViewById(R.id.editText1);
        btn1.setOnClickListener(listener);
    }

    OnClickListener listener = new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			String text_content = et1.getText().toString();
			//SimpleDateFormat s1= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:SSS");		
			andrew_log(text_content);
			
		}
		
	};
    
    
    
    
    @Override
	protected void onDestroy()
	{
		// TODO Auto-generated method stub
    	Log.i(TAG, "onDestroy");
		super.onDestroy();
	}




	protected void andrew_log(String string) {
		// TODO Auto-generated method stub
		Intent intent = new Intent();
		intent.setAction("andrew_log.eric");
		intent.putExtra("data",string +","+getRunningActivityName());
		sendBroadcast(intent);
		
	}
	private String getRunningActivityName(){          
        ActivityManager activityManager=(ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);  
        String runningActivity=activityManager.getRunningTasks(1).get(0).topActivity.getClassName();  
        return runningActivity;                 
}	

}
