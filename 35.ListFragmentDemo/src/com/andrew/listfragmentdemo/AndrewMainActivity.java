package com.andrew.listfragmentdemo;

import com.andrew.listfragmentdemo.LeftFragment.MyListener;
import com.andrew.listfragmentdemo.R;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.TextView;

//http://www.jcodecraeer.com/a/anzhuokaifa/androidkaifa/2012/1016/441.html
public class AndrewMainActivity extends Activity implements MyListener{

	FragmentManager manager;
	FragmentTransaction transaction;
	
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
		manager = getFragmentManager();
		transaction = manager.beginTransaction();
		RightFragment rightFragment = new RightFragment();
		LeftFragment leftFragment = new LeftFragment();
		transaction.add(R.id.left_layout, leftFragment, "leftfragment");
		transaction.add(R.id.right_layout, rightFragment, "rightfragment");
		transaction.commit();
    }


	
    public void showMessage(int index) 
    { 
        if (1 == index) 
            showMessageView.setText("1"); 
        if (2 == index) 
            showMessageView.setText("2"); 
        if (3 == index) 
            showMessageView.setText("3"); 
    } 
    private TextView showMessageView;
	@Override
	protected void onResume()
	{
		// TODO Auto-generated method stub
		super.onResume();
		showMessageView = (TextView) findViewById(R.id.right_show_message);
	}

}
