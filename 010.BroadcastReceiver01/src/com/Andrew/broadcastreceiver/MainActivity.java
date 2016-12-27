package com.Andrew.broadcastreceiver;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainActivity extends Activity {
	protected static final String ACTION_1 = "eric_broad_action1";
	Button btnBroadcastButton = null;
	protected String tag = "Activity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        btnBroadcastButton = (Button) findViewById(R.id.button1);
        btnBroadcastButton.setOnClickListener(listener1);
    }






	OnClickListener listener1 = new OnClickListener()
	{
		
		@Override
		public void onClick(View v)
		{
			// TODO Auto-generated method stub
			Intent intent1 = new Intent();
			//intent1.setAction(ACTION_1);
			//intent1.setAction("andrew_log.eric");
			intent1.setAction("eric_action01");
			sendBroadcast(intent1);			
			
			intent1.setAction("eric_action02");
			sendBroadcast(intent1);
			
			intent1.setAction("eric_action03");
			sendBroadcast(intent1);
		}
		
	};
    

}
