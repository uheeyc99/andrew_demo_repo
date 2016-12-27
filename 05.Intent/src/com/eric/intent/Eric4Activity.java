package com.eric.intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Eric4Activity extends Activity
{

	public final static int RESULT_CODE_1 = 1;
	public final static int RESULT_CODE_2 = 2;
	EditText edittext1 = null;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_eric4);
		
		Button l4btn1 = (Button) findViewById(R.id.button_l4b1);
		Button l4btn2 = (Button) findViewById(R.id.button_l4b2);
		l4btn1.setOnClickListener(btn1_listener);
		l4btn2.setOnClickListener(btn2_listener);
		
		edittext1 = (EditText)findViewById(R.id.edittext_l4t1);
		
		Intent intent = getIntent();
		Bundle bundle = intent.getExtras();

	}

	private OnClickListener btn1_listener = new OnClickListener()
	{

		@Override
		public void onClick(View v)
		{
			Intent intent = new Intent();
			String string;
			string = edittext1.getText().toString();
			intent.putExtra("back_message1", string);
			intent.putExtra("back_message2", "I am back 2");
			intent.putExtra("back_message3", "I am back 3");
			setResult(RESULT_CODE_1, intent);
			finish();

		}
	};

	private OnClickListener btn2_listener = new OnClickListener()
	{

		@Override
		public void onClick(View v)
		{
			// TODO Auto-generated method stub

			finish();

		}
	};

}
