package com.Andrew.checkbox;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.CompoundButton.OnCheckedChangeListener;


public class Andrew1Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_andrew1);
        Andrew_Handle();
    }

    CheckBox cb1,cb2,cb3,cb4;
    private void Andrew_Handle()
	{
		cb1 = (CheckBox) findViewById(R.id.checkBox1);
		cb2 = (CheckBox) findViewById(R.id.checkBox2);
		cb3 = (CheckBox) findViewById(R.id.checkBox3);
		cb4 = (CheckBox) findViewById(R.id.checkBox4);
		cb1.setOnCheckedChangeListener(listener1);
	}
    OnCheckedChangeListener  listener1= new OnCheckedChangeListener()
	{
		
		
		public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
		{
			if(isChecked){
				Toast.makeText(Andrew1Activity.this, "check", Toast.LENGTH_SHORT).show();
			}else{
				
				Toast.makeText(Andrew1Activity.this, "uncheck", Toast.LENGTH_SHORT).show();
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
