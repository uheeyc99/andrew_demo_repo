package com.eric.intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Eric3Activity extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_eric3);

		String string;
		TextView textview = (TextView) findViewById(R.id.text_l3v1);
		Intent intent = getIntent();
		
		
		Bundle bundle = intent.getExtras();
		
		string =  bundle.getString("message1");
		Toast.makeText(Eric3Activity.this, string, Toast.LENGTH_SHORT).show();
		textview.setText(string);
		
		
		string =  bundle.getString("message2");
		Toast.makeText(Eric3Activity.this, string, Toast.LENGTH_SHORT).show();		
		textview.setText(string);
			
		
	}

}
