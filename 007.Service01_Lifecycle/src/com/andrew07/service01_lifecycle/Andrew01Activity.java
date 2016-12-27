package com.andrew07.service01_lifecycle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class Andrew01Activity extends Activity {

	Button btn1,btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //
        setContentView(R.layout.activity01_andrew);
        btn1=(Button)findViewById(R.id.button1);
        btn2=(Button)findViewById(R.id.button2);
        btn1.setOnClickListener(listener);
        btn2.setOnClickListener(listener);
    }

    OnClickListener listener = new OnClickListener()
	{
		
		@Override
		public void onClick(View v)
		{
			// TODO Auto-generated method stub
			Button btnButton= (Button) v;
			Intent service = new Intent();
			service.setClass(Andrew01Activity.this,Service01.class);
			switch (btnButton.getId())
			{
			case R.id.button1:
				
				startService(service); 
				break;
			case R.id.button2:
				
				stopService(service); 
				break;
				
			default:
				break;
			}
			
		}
	};

}
