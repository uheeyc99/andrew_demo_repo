package com.Andrew.radiobuttondemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;


public class Andrew1Activity extends Activity {

	RadioGroup rgGenderGroup;
	RadioGroup queGroup;
	
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_andrew1);
        Andrew1_handle();
        
    }

    
    
    private void Andrew1_handle()
	{
		rgGenderGroup = (RadioGroup) findViewById(R.id.l1_radioGroup1);
		queGroup = (RadioGroup) findViewById(R.id.l1_radioGroup2);
		
		
		rgGenderGroup.setOnCheckedChangeListener(listener1);
		
	}

    OnCheckedChangeListener listener1 = new OnCheckedChangeListener()
	{
		
		
		public void onCheckedChanged(RadioGroup group, int checkedId)
		{
			
				if(checkedId == R.id.l1g1_radio0){
					Toast.makeText(Andrew1Activity.this, "male", Toast.LENGTH_SHORT).show();
					
					
				}else{
					
					Toast.makeText(Andrew1Activity.this, "female", Toast.LENGTH_SHORT).show();
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
