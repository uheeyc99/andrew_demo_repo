package com.andrew.listviewdemo.adapters;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import android.R.anim;
import android.R.string;
import android.app.ListActivity;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

public class AndrewList1ArrayAdapter1 extends ListActivity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		//setContentView(android.R.layout.simple_list_item_1);
		refreshListItems();
	}

	private void refreshListItems()
	{
		// TODO Auto-generated method stub
		ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, 
				android.R.layout.simple_list_item_1,
				get_text_data());
		setListAdapter(arrayAdapter);
	}

	private List<String> get_text_data()
	{
		// TODO Auto-generated method stub
	
		List<String> dataString = new ArrayList<String>();
		dataString.add("a");
		dataString.add("s");
		dataString.add("d");
		
		return dataString;
		
	}


	
}
