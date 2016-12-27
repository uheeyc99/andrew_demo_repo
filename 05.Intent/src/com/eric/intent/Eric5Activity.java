package com.eric.intent;

import android.R.integer;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Eric5Activity extends Activity
{
	public final static int RESULT_CODE_3 = 3;
	Button btn1;
	EditText et1,et2;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_eric5);
		
		btn1 = (Button)findViewById(R.id.button_l5b1);
		et1 = (EditText)findViewById(R.id.edittext_l5e1);
		et2 = (EditText)findViewById(R.id.edittext_l5e2);
		btn1.setOnClickListener(listener1);
		
	}
	
	
	private OnClickListener listener1 = new OnClickListener()
	{
		
		@Override
		public void onClick(View v)
		{
			String value1,value2;
			
			value1=et1.getText().toString();
			value2=et2.getText().toString();
			Intent intent = new Intent();
			intent.putExtra("back_message1", value1);
			intent.putExtra("back_message2", value2);
			setResult(RESULT_CODE_3, intent);
			finish();
			
			
		}
	};

}
