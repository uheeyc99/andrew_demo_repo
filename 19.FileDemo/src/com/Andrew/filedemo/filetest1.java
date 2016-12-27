package com.Andrew.filedemo;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import org.apache.http.util.EncodingUtils;


import android.R.integer;
import android.app.Activity;

import android.os.Bundle;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class filetest1 extends Activity
{
	
	TextView t1,t2;
	Button btn1,btn2;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE); 
		setContentView(R.layout.file1);
		eric_function();
	}

	private void eric_function()
	{
		// TODO Auto-generated method stub
		t1 = (TextView) findViewById(R.id.editText_filename);
		t2 = (TextView) findViewById(R.id.editText_content);
		btn1 = (Button) findViewById(R.id.button_read);
		btn2 = (Button) findViewById(R.id.button_write);
		btn1.setOnClickListener(listener1);
		btn2.setOnClickListener(listener1);
		t1.setText("pptp.txt");
	}

	OnClickListener listener1 = new OnClickListener()
	{
		
		@Override
		public void onClick(View v)
		{
			Button btnButton = (Button)v;
			try
			{
				button_click_function(btnButton);
			} catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


		}

		private void button_click_function(Button btnButton) throws IOException
		{
			
			
			if(btnButton.getId()== R.id.button_read){
				Toast.makeText(filetest1.this, "read", Toast.LENGTH_SHORT).show();
				file_operation_read();
			}

			
		}



	};
	


	void file_operation_read() throws IOException
	{
			InputStream inputStream = getResources().getAssets().open("pptp.txt");
			int length = inputStream.available();
			byte[] buffer = new byte[length];
			inputStream.read(buffer);
			inputStream.close();
			String string= EncodingUtils.getString(buffer, "UTF-8");
			t2.setText(string);
			
	
	}

	//************************************************************************************

}
