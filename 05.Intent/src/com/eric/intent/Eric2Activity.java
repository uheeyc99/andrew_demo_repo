package com.eric.intent;

import javax.security.auth.PrivateCredentialPermission;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Eric2Activity extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_eric2);
		Button btn1 = (Button) findViewById(R.id.button_call);
		Button btn2 = (Button) findViewById(R.id.button_sms);
		btn1.setOnClickListener(btn_listener1);
		btn2.setOnClickListener(btn_listener2);
		
	}

	private OnClickListener btn_listener1 = new OnClickListener()
	{
		
		@Override
		public void onClick(View v)
		{
			// TODO Auto-generated method stub
			Intent intent = new Intent();
			intent.setAction(Intent.ACTION_CALL);
			intent.setData(Uri.parse("tel:10010"));
			startActivity(intent);
		}
	};
	
	private OnClickListener btn_listener2 = new OnClickListener()
	{
		
		@Override
		public void onClick(View v)
		{
			// TODO Auto-generated method stub
			Intent intent = new Intent();
			intent.setAction(Intent.ACTION_SENDTO);
			intent.setData(Uri.parse("smsto:10010"));
			intent.putExtra("sms_body", "hello");
			startActivity(intent);
		}
	};	
	
	
}
