package com.genghis.button;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.location.GpsStatus.Listener;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter.ViewBinder;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;
import android.view.View;

public class EricMainActivity extends Activity {
	Button btn1,btn2,btn3,btn4,btn5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eric_main);
        btn1 = (Button)findViewById(R.id.button1);
        btn2 = (Button)findViewById(R.id.button2);
        btn3 = (Button)findViewById(R.id.button3);
        btn4 = (Button)findViewById(R.id.button4);
        btn5 = (Button)findViewById(R.id.button5);

        btn1.setOnClickListener(new ButtonClick1());

        btn2.setOnClickListener(new View.OnClickListener()//匿名内部类
		{
			
			@Override
			public void onClick(View v)
			{
				// TODO Auto-generated method stub
	    		System.out.println("点击了button2");
	    		Toast.makeText(EricMainActivity.this, "2", Toast.LENGTH_SHORT).show();	
			}
		})      ;  
        btn3.setOnClickListener(listener_eric);
        btn4.setOnClickListener(listener_eric);
    }
    


    private View.OnClickListener listener_eric = new View.OnClickListener()
	{
		
		@Override
		public void onClick(View v)
		{
			// TODO Auto-generated method stub
    		Button btn = (Button)v;
    		switch(btn.getId())
    		{
    		case R.id.button3:
    			Toast.makeText(EricMainActivity.this, "3", Toast.LENGTH_SHORT).show();
    			break;
    		case R.id.button4:
    			Toast.makeText(EricMainActivity.this, "4", Toast.LENGTH_SHORT).show();
    			break;
    			
    		default:
    			break;
    		}
		}
	};
    
    
    
    
    
    
    class ButtonClick1 implements View.OnClickListener
    {

    	@Override
    	public void onClick(View arg0)
    	{
    		// TODO Auto-generated method stub
    		System.out.println("点击了button1");
    		Toast.makeText(EricMainActivity.this, "1", Toast.LENGTH_SHORT).show();

    	}

    }
    

    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.eric_main, menu);
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







