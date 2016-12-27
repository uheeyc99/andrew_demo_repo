package com.Andrew05intent02_activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Andrew04Activity extends Activity
{
	public final static int RESULT_CODE_1 = 01;
	public final static int RESULT_CODE_2 = 02;
	Button btnButton;
	TextView textView;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_andrew_04);
		eric_function();
	}
	private void eric_function()
	{
		// TODO Auto-generated method stub
		textView = (TextView) findViewById(R.id.editText41);
		btnButton = (Button) findViewById(R.id.button41);
		btnButton.setOnClickListener(new OnClickListener()
		{
			
			@Override
			public void onClick(View v)
			{
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.putExtra("result1", textView.getText().toString());
				setResult(RESULT_CODE_1, intent);
				finish();
			}
		});
	}

}
