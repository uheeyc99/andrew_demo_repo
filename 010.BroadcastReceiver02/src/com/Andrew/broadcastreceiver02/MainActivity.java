package com.Andrew.broadcastreceiver02;

import com.Andrew.broadcastreceiver.receiver02.EricReceiver02;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;



public class MainActivity extends Activity {

	
	protected static final String Eric_Action = "ERIC_ACTION_2";
	Button btnButton=null;
	EricReceiver02 rec = new EricReceiver02();
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnButton = (Button) findViewById(R.id.button1);
        btnButton.setOnClickListener(listener1);
        
    }
    
 
    
    
    OnClickListener listener1 = new OnClickListener()
	{
		
		@Override
		public void onClick(View v)
		{
			// TODO Auto-generated method stub
			Intent intent = new Intent();
			intent.setAction(Eric_Action);
			sendBroadcast(intent);
		}
	};
    

	@Override
	protected void onResume()
	{
		// TODO Auto-generated method stub
		super.onResume();
		IntentFilter intentFilter = new IntentFilter();
		intentFilter.addAction(Eric_Action);
		registerReceiver(rec,intentFilter);
	}

	@Override
	protected void onPause()
	{
		// TODO Auto-generated method stub
		super.onPause();
		unregisterReceiver(rec);
	}

	
	
	
}
