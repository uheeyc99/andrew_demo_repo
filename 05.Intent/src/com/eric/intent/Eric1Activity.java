package com.eric.intent;

import java.net.NetPermission;

import android.R.integer;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Eric1Activity extends Activity
{
	private final static int REQUEST_CODE_1 = 1;
	private final static int REQUEST_CODE_2 = 2;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_eric1);
		Button btn1 = (Button) findViewById(R.id.button1);
		btn1.setOnClickListener(btn1_listener);
		Button btn2 = (Button) findViewById(R.id.button2);
		btn2.setOnClickListener(btn2_listener);
		Button btn3 = (Button) findViewById(R.id.button3);
		btn3.setOnClickListener(btn3_listener);
		Button btn4 = (Button) findViewById(R.id.button4);
		btn4.setOnClickListener(btn4_listener);

	}

	private OnClickListener btn1_listener = new OnClickListener()
	{

		@Override
		public void onClick(View v)
		{
			// TODO Auto-generated method stub
			Intent intent = new Intent();
			intent.setClass(Eric1Activity.this, Eric2Activity.class);
			startActivity(intent);

		}
	};

	private OnClickListener btn2_listener = new OnClickListener()
	{

		@Override
		public void onClick(View v)
		{
			// TODO Auto-generated method stub
			Intent intent = new Intent();
			intent.setClass(Eric1Activity.this, Eric3Activity.class);
			intent.putExtra("message1", "hello buddy");
			intent.putExtra("message2", "are you hungry");
			startActivity(intent);

		}
	};

	private OnClickListener btn3_listener = new OnClickListener()
	{

		@Override
		public void onClick(View v)
		{
			// TODO Auto-generated method stub
			Intent intent = new Intent();
			intent.setClass(Eric1Activity.this, Eric4Activity.class);
			intent.putExtra("message1", "hello 4");
			intent.putExtra("message2", "are you hungry");
			startActivityForResult(intent, REQUEST_CODE_1);

		}
	};

	private OnClickListener btn4_listener = new OnClickListener()
	{

		@Override
		public void onClick(View v)
		{
			// TODO Auto-generated method stub
			Intent intent = new Intent();
			intent.setClass(Eric1Activity.this, Eric5Activity.class);
			intent.putExtra("message1", "hello 5");
			startActivityForResult(intent, REQUEST_CODE_2);
		}
	};
	
	
	
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data)
	{
		// TODO Auto-generated method stub
		// super.onActivityResult(requestCode, resultCode, data);
		Bundle bundle;		
		if (requestCode == REQUEST_CODE_1)
		{
			if (resultCode == Eric4Activity.RESULT_CODE_1)
			{
				
				bundle = data.getExtras();
				
				String string = bundle.getString("back_message1");
				TextView tv1 = (TextView) findViewById(R.id.textvew_l1v1);
				tv1.setText(string);

				string = bundle.getString("back_message2");
				Toast.makeText(Eric1Activity.this, string, Toast.LENGTH_SHORT).show();

			}
		}
		
		if (requestCode == REQUEST_CODE_2)
		{

			if (resultCode == Eric5Activity.RESULT_CODE_3)
			{
				String user_id, user_pass;
				bundle = data.getExtras();
				user_id = bundle.getString("back_message1");
				user_pass = bundle.getString("back_message2");
				Toast.makeText(Eric1Activity.this, user_id, Toast.LENGTH_SHORT).show();
				Toast.makeText(Eric1Activity.this, user_pass, Toast.LENGTH_SHORT).show();

			}
		}
		
		
	}

	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.eric1, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings)
		{
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
