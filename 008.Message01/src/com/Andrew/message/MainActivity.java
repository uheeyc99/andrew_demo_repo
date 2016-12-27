package com.Andrew.message;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity {
	private final String TAG ="MainActivity";
	Button btn1=null;
	TextView tv1=null;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        btn1 = (Button) findViewById(R.id.button1);
        btn1.setOnClickListener(listener1);
        tv1 = (TextView) findViewById(R.id.textView1);
        
    }

    OnClickListener listener1 = new OnClickListener()
	{
		
		@Override
		public void onClick(View v)
		{
			// TODO Auto-generated method stub
			Log.i(TAG, "onclick");
			new HandleClickThread().start();
			
			
		}
	};
    
	Handler  handler = new Handler(){

		@Override
		public void handleMessage(Message msg)
		{
			// TODO Auto-generated method stub
			//super.handleMessage(msg);
			Log.i(TAG, "handleMessage");
			if(msg.what == 1){
				tv1.getText();
				tv1.setText("a "+ tv1.getText());
				
			}
		}
		
	};
	
	
	
	public class HandleClickThread extends Thread{

		@Override
		public void run()
		{
			// TODO Auto-generated method stub
			//此处处理一些耗时的工作
			// .........
			
			
			//super.run();
			//Message msgMessage= new Message();
			Message msgMessage1 = handler.obtainMessage();
			msgMessage1.what = 1;
			Log.i(TAG, "HandleClickThread");
			handler.sendMessage(msgMessage1);
		}
		
	}
	

}
