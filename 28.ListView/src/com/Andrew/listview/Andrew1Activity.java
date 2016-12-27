package com.Andrew.listview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;


public class Andrew1Activity extends Activity {

    Button btn1,btn2,btn3,btn4;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_andrew1);
        btn1 = (Button) findViewById(R.id.button1);
        btn2 = (Button) findViewById(R.id.button2);
        btn3 = (Button) findViewById(R.id.button3);
        btn4 = (Button) findViewById(R.id.button4);
        btn1.setOnClickListener(listener1);
        btn2.setOnClickListener(listener1);
        btn3.setOnClickListener(listener1);
        btn4.setOnClickListener(listener1);
    }
    
    OnClickListener listener1 = new OnClickListener()
	{
		
		@Override
		public void onClick(View v)
		{
			Button btnButton = (Button) v;
			Intent intent = new Intent();
			switch(btnButton.getId()){
			case R.id.button1:
				intent.setClass(Andrew1Activity.this, AndrewTestListActivity1.class);
				startActivity(intent);
				break;
			case R.id.button2:
				intent.setClass(Andrew1Activity.this, AndrewTestListActivity2.class);
				startActivity(intent);
				break;
			case R.id.button3:
				intent.setClass(Andrew1Activity.this, AndrewTestListActivity3.class);
				startActivity(intent);
				break;	
			case R.id.button4:
				intent.setClass(Andrew1Activity.this, AndrewTestListActivity4.class);
				startActivity(intent);
				break;					
			default:
				break;
			}
			
			
			
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
