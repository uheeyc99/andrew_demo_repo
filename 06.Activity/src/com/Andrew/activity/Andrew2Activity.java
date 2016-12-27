package com.Andrew.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class Andrew2Activity extends Activity
{
	private final static String TAG= "Andrew2Activity";
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_andrew2);
	}
	
    protected void onStart(){
    	
    	super.onStart();
    	Log.d(TAG,"onStart !");
    }
    protected void onRestart()
    {
    	super.onRestart();
    	Log.d(TAG,"onRestart !");
    }
    
    
    
    protected void onResume()
    {
    	super.onResume();
    	Log.d(TAG,"onResume !");
    }
    
    protected void onPause()
    {
    	super.onPause();
    	Log.d(TAG,"onPause !");
    }    

    protected void onStop()
    {
    	super.onStop();
    	Log.d(TAG,"onStop !");
    }    

    protected void onDestory()
    {
    	super.onDestroy();
    	Log.d(TAG,"onDestroy !");
    }    
	
	

}
