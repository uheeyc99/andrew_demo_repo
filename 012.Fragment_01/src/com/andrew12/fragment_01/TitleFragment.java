package com.andrew12.fragment_01;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

public class TitleFragment extends Fragment {

	private ImageButton mLeftMenu;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState)
	{
		View view = inflater.inflate(R.layout.title_fragment, container, false);
		view.setBackgroundColor(Color.BLACK);  //eric
		
		mLeftMenu = (ImageButton) view.findViewById(R.id.id_title_left_btn);
		mLeftMenu.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				Toast.makeText(getActivity(),
						"i am an ImageButton in TitleFragment ! ",
						Toast.LENGTH_SHORT).show();
			}
		});
		return view;
	}
}
