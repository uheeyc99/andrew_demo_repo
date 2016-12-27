package com.Andrew05intent02_activity;

import android.R.string;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Andrew01Activity extends Activity {
	private final static int REQUEST_CODE_1 = 01;
	private final static int REQUEST_CODE_2 = 02;
	Button btn1,btn2,btn3;
	TextView textView;
	EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_andrew_01);
        textView = (TextView) findViewById(R.id.textView1);
        btn1 = (Button) findViewById(R.id.button1);
        btn2 = (Button) findViewById(R.id.button2);
        btn3 = (Button) findViewById(R.id.button3);
        btn1.setOnClickListener(listener);
        btn2.setOnClickListener(listener);
        btn3.setOnClickListener(listener);
    }

    OnClickListener listener = new OnClickListener()
	{
		
		@Override
		public void onClick(View v)
		{
			
			// TODO Auto-generated method stub
			Button btnButton = (Button) v;
			switch (btnButton.getId())
			{
			case R.id.button1:
				Intent intent1 = new Intent(Andrew01Activity.this,Andrew02Activity.class);
				startActivity(intent1);
				break;
			
			case R.id.button2:
				Intent intent2 = new Intent(Andrew01Activity.this,Andrew03Activity.class);
				editText =  (EditText) findViewById(R.id.editText1);
				intent2.putExtra("key", editText.getText().toString());
				startActivity(intent2);				
				break;
			case R.id.button3:
				Intent intent3 = new Intent(Andrew01Activity.this,Andrew04Activity.class);
				startActivityForResult(intent3, REQUEST_CODE_1);
				break;
				
			default:
				Toast.makeText(Andrew01Activity.this, "err", Toast.LENGTH_SHORT).show();
				break;
			}
			
		}
	};
    
    
    
    
    @Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data)
	{
		// TODO Auto-generated method stub
		//super.onActivityResult(requestCode, resultCode, data);
    	Intent intent = data;
    	Bundle bundle;
    	
    	if(REQUEST_CODE_1 ==requestCode ){
    		if(Andrew04Activity.RESULT_CODE_1 == resultCode){
    			bundle = intent.getExtras();
    			String string =bundle.getString("result1");
    			textView.setText(string);
    		}
    		
    	}
    	
    	
    	
    	
	}

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.andrew_main, menu);
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
