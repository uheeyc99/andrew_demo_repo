package com.Andrew05intent02_activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Andrew03Activity extends Activity
{
	TextView textView;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_andrew_03);
		Intent intent=getIntent();
		Bundle bundle = intent.getExtras();
		String string = bundle.getString("key");
		textView = (TextView) findViewById(R.id.textView03);
		textView.setText(string);
		
	}

}
