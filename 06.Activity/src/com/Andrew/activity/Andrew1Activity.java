package com.Andrew.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class Andrew1Activity extends Activity {

	private final static String TAG= "Andrew1Activity";
	Button btn1=null;
	Button btn2=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"onCreate !");
        setContentView(R.layout.activity_andrew1);

        btn1 = (Button)findViewById(R.id.l1_button1); 
        btn2 = (Button)findViewById(R.id.l1_button2);
        
        btn1.setOnClickListener(btn1_listener);
        btn2.setOnClickListener(btn2_listener);
        
          
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


    private OnClickListener btn1_listener = new OnClickListener()
	{
		
		@Override
		public void onClick(View v)
		{
			// TODO Auto-generated method stub
			Log.i(TAG,"btn1");
			Intent intent = new Intent();
			intent.setClass(Andrew1Activity.this, Andrew2Activity.class);
			startActivity(intent);
		}
	};
    
    private OnClickListener btn2_listener = new OnClickListener()
	{
		
		@Override
		public void onClick(View v)
		{
			// TODO Auto-generated method stub
			Log.i(TAG,"btn2");
			Intent intent = new Intent();
			intent.setClass(Andrew1Activity.this, Andrew2Activity.class);
			startActivity(intent);
		}
	};
	
	
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.andrew1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
