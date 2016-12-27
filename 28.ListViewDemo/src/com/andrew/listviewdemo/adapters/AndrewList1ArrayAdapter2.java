package com.andrew.listviewdemo.adapters;

import java.util.ArrayList;
import java.util.List;

import com.andrew.listviewdemo.R;

import android.app.ListActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class AndrewList1ArrayAdapter2 extends ListActivity
{

	private OnItemClickListener listener1 = new OnItemClickListener()
	{

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position, long id)
		{
			// TODO Auto-generated method stub
			Toast.makeText(AndrewList1ArrayAdapter2.this, "click ", Toast.LENGTH_SHORT).show();
			
		}
	};
	
	private OnItemLongClickListener listener2 = new OnItemLongClickListener()
	{

		@Override
		public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id)
		{
			// TODO Auto-generated method stub
			Toast.makeText(AndrewList1ArrayAdapter2.this, "long click ", Toast.LENGTH_SHORT).show();
			return false;
		}
	};
	
	private OnItemSelectedListener listener3 = new OnItemSelectedListener()
	{

		@Override
		public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
		{
			// TODO Auto-generated method stub
			Toast.makeText(AndrewList1ArrayAdapter2.this, "selected ", Toast.LENGTH_SHORT).show();
			
		}

		@Override
		public void onNothingSelected(AdapterView<?> parent)
		{
			// TODO Auto-generated method stub
			Toast.makeText(AndrewList1ArrayAdapter2.this, "nothing selected ", Toast.LENGTH_SHORT).show();
			
		}
	};

	





	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.index);
		requestWindowFeature(Window.FEATURE_NO_TITLE);//»•µÙ±ÍÃ‚¿∏
		refreshListItems();
	}

	private void refreshListItems()
	{
		// TODO Auto-generated method stub
		ListView listView = getListView();
		listView.setBackgroundColor(Color.GRAY);
		listView.setOnItemClickListener(listener1);
		listView.setOnItemLongClickListener(listener2);
		listView.setOnItemSelectedListener(listener3);
		
    	ListAdapter arrayAdapter = new ArrayAdapter<String>(this, 
				R.layout.simple_list_item_1_eric, 
				get_data());
		setListAdapter(arrayAdapter);

	}

	
	
	private List<String> get_data()
	{
		// TODO Auto-generated method stub
		List<String> dataList = new ArrayList<String>();
		dataList.add("a");
		dataList.add("b");
		dataList.add("c");
		dataList.add("d");
		dataList.add("e");
		return dataList;
	}

}
