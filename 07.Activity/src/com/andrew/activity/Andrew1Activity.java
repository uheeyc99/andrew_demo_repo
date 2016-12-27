package com.andrew.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Andrew1Activity extends Activity {
	
	Button btn1=null;
	EditText ed1=null;
	String CONTENT = "CONTENT_VALUE";
	private final static String TAG= "Andrew1Activity";
    @Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dndrew1);
		btn1 = (Button) findViewById(R.id.button1_l1);
		ed1 = (EditText) findViewById(R.id.editText1_l1);
		btn1.setOnClickListener(listener1);
		Toast.makeText(Andrew1Activity.this, "Activity Start", Toast.LENGTH_SHORT).show();
		if (0 == 1)
		{
			if ((null != savedInstanceState))
			{
				Toast.makeText(Andrew1Activity.this, "....", Toast.LENGTH_SHORT).show();
				if (savedInstanceState.containsKey(CONTENT))
				{
					Toast.makeText(Andrew1Activity.this, "re status", Toast.LENGTH_SHORT).show();
					ed1.setText(savedInstanceState.getString(CONTENT));
				}

			}
		}
	}
    
    
    private OnClickListener listener1 = new OnClickListener()
	{
		
		@Override
		public void onClick(View v)
		{
			// TODO Auto-generated method stub
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

	@Override
	protected void onSaveInstanceState(Bundle outState)
	{
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
		Log.d(TAG,"onSaveInstanceState !");
		String string=ed1.getText().toString();
		outState.putString(CONTENT, string);
		Toast.makeText(Andrew1Activity.this, "save status", Toast.LENGTH_SHORT).show();
		
	}      
    
    
    
}
