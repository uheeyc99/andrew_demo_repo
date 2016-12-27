package com.andrew.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Andrew2Activity extends Activity
{
	private final static String TAG= "Andrew2Activity";
	Button btn1 = null;
	Button btn2 = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dndrew2);
		btn1 = (Button) findViewById(R.id.button1_l2);
		btn2 = (Button) findViewById(R.id.button2_l2);
		btn1.setOnClickListener(listener1);
		btn2.setOnClickListener(listener2);
		
	}
	
	
private OnClickListener listener1 = new OnClickListener()
{
	
	@Override
	public void onClick(View v)
	{
		// TODO Auto-generated method stub
		Intent intent =new Intent();
		intent.setClass(Andrew2Activity.this, Andrew1Activity.class);
		startActivity(intent);
	}
};	
	
private OnClickListener listener2 = new OnClickListener()
{
	
	@Override
	public void onClick(View v)
	{
		// TODO Auto-generated method stub
		finish();
	}
};		
	
	
	
	
	
	
	
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
