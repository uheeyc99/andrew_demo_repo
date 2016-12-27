package com.Andrew.handlerdemo;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainActivity extends Activity {
	Button btn1=null;
	private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1= (Button) findViewById(R.id.button1);
        btn1.setOnClickListener(listener1);
        
		Looper looper = Looper.getMainLooper();
		handler2 = new ActivityHandler(looper);
		
    }

    OnClickListener listener1 = new OnClickListener()
	{
		
		@Override
		public void onClick(View v)
		{
			// TODO Auto-generated method stub
			btn1.setText("999");
			Log.i(TAG, "onClick");
			Intent intent = new Intent();
			intent.setClass(MainActivity.this, ExampleService1.class);
			startService(intent);
		}
	};
	public ActivityHandler  handler2;
	private class ActivityHandler extends Handler{
		
		public ActivityHandler(Looper looper)
		{
			//Log.i(TAG, "ActivityHandler");
			super(looper);
			Log.i(TAG, "ActivityHandler");
		}

		@Override
		public void handleMessage(Message msg)
		{
			// TODO Auto-generated method stub
			Log.i(TAG, "handleMessage2  "+msg.what);
			switch(msg.what)
			{
				case 1:
					//Log.i(TAG, "Message "+msg.obj);
					btn1.setText("a");
					break;
				
				case 2:
					//Log.i(TAG, "Message "+msg.obj);
					btn1.setText("b");
					break;
			
				default:
					break;
			}
			//super.handleMessage(msg);
			//stopSelf();
		}
		
	}
	
	
	
	
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
