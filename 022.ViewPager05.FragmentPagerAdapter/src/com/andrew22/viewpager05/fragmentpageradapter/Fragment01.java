package com.andrew22.viewpager05.fragmentpageradapter;

import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class Fragment01 extends Fragment
{
	@Override
	@Nullable
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.layout1, container, false);
		Button btn1= (Button) view.findViewById(R.id.fragment1_btn);
		btn1.setOnClickListener(listener);
		return view;
		//return super.onCreateView(inflater, container, savedInstanceState);
		
	}

	View.OnClickListener listener = new View.OnClickListener()
	{
		
		@Override
		public void onClick(View v)
		{
			// TODO Auto-generated method stub
			Toast.makeText(getContext(), "clicked", Toast.LENGTH_SHORT).show();
		}
	};
}
