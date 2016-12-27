package com.Andrew.filedemo;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.http.util.EncodingUtils;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class filetest2 extends Activity
{
	
	TextView t_filename,t_text;
	Button btn1,btn2;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.file1);
		eric_function();
	}

	private void eric_function()
	{
		// TODO Auto-generated method stub
		t_filename = (TextView) findViewById(R.id.editText_filename);
		t_text = (TextView) findViewById(R.id.editText_content);
		btn1 = (Button) findViewById(R.id.button_read);
		btn2 = (Button) findViewById(R.id.button_write);
		btn1.setOnClickListener(listener1);
		btn2.setOnClickListener(listener1);
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
			// TODO Auto-generated method stub
			
			if(btnButton.getId()== R.id.button_read){
				Toast.makeText(filetest2.this, "read", Toast.LENGTH_SHORT).show();
				file_operation_read();
			}
			if(btnButton.getId()== R.id.button_write){
				Toast.makeText(filetest2.this, "write", Toast.LENGTH_SHORT).show();
				file_operation_write();
			}
			
		}



	};
	
	
	void file_operation_write() throws IOException
	{
		String filename = t_filename.getText().toString();
		String text_content = t_text.getText().toString();
		
		FileOutputStream fOutputStream=openFileOutput(filename, MODE_PRIVATE);
		byte[] bytes = text_content.getBytes();
		fOutputStream.write(bytes,0,bytes.length);
		fOutputStream.close();
			
	}
	void file_operation_read() throws IOException 
	{

		String filename = t_filename.getText().toString();
		
		FileInputStream fileInputStream = openFileInput(filename);
		int length = fileInputStream.available();
	
		byte[] bytes = new byte[length];
		fileInputStream.read(bytes,0,length);
		fileInputStream.close();
		String string = EncodingUtils.getString(bytes, "UTF-8");		
		t_text.setText(string);
		
	}

	//************************************************************************************

}
