package com.andrew.listviewdemo.adapters;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.andrew.listviewdemo.R;


import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class AndrewList1SimpleAdapter1 extends ListActivity
{

	private OnItemClickListener listener1 = new OnItemClickListener()
	{

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position, long id)
		{
			// TODO Auto-generated method stub
			Toast.makeText(AndrewList1SimpleAdapter1.this, "Clicked" + position, Toast.LENGTH_SHORT).show();
		}
		
	};

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		refreshListItems();
	}

	private void refreshListItems()
	{
		
		ListView listView = getListView();
		listView.setOnItemClickListener(listener1);
		
		SimpleAdapter adapter = new SimpleAdapter(this, get_data(),
				R.layout.simple_listview1, 
				new String[]{"img","title","info"}, 
				new int[]{R.id.imageView1,R.id.textView1,R.id.textView2});
		setListAdapter(adapter);
		
	}

	private List<? extends Map<String, ?>> get_data()
	{
		// TODO Auto-generated method stub
		HashMap<String, Object> map = null;
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String,Object>>();
		
		map = new HashMap<String, Object>();
		map.put("title", "a1");
		map.put("info", "A1");
		map.put("img", R.drawable.ak2);
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put("title", "a2");
		map.put("info", "A2");
		map.put("img", R.drawable.ak2);
		list.add(map);		
				
		
		return list;
	}

}
