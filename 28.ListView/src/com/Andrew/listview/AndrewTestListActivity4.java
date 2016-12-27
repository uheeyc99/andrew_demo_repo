package com.Andrew.listview;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.Andrew.listview.subclass.eric_test_adapter;

import android.app.ListActivity;
import android.os.Bundle;

public class AndrewTestListActivity4 extends ListActivity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		
		super.onCreate(savedInstanceState);
		eric_test_adapter adapter = new eric_test_adapter(this,getData());
		setListAdapter(adapter);
	}

	
	
	private List<Map<String, Object>> getData()
	{
		
		List<Map<String, Object>> list;
		list = new ArrayList<Map<String,Object>>();

		Map<String, Object> map;
		
		map = new HashMap<String, Object>();
		map.put("title", "G1");
		map.put("info", "google 1");
		map.put("img", R.drawable.ic_launcher);
		list.add(map);
		
		
		map = new HashMap<String, Object>();
		map.put("title", "G2");
		map.put("info", "google 2");
		map.put("img", R.drawable.ic_launcher);
		list.add(map);		
		
		map = new HashMap<String, Object>();
		map.put("title", "G3");
		map.put("info", "google 3");
		map.put("img", R.drawable.ic_launcher);
		list.add(map);	
		
		map = new HashMap<String, Object>();
		map.put("title", "G4");
		map.put("info", "google 4");
		map.put("img", R.drawable.ic_launcher);
		list.add(map);	
		
		map = new HashMap<String, Object>();
		map.put("title", "G5");
		map.put("info", "google 5");
		map.put("img", R.drawable.ic_launcher);
		list.add(map);			

		map = new HashMap<String, Object>();
		map.put("title", "G6");
		map.put("info", "google 5");
		map.put("img", R.drawable.ic_launcher);
		list.add(map);	
		
		map = new HashMap<String, Object>();
		map.put("title", "G7");
		map.put("info", "google 5");
		map.put("img", R.drawable.ic_launcher);
		list.add(map);	
		
		map = new HashMap<String, Object>();
		map.put("title", "G8");
		map.put("info", "google 5");
		map.put("img", R.drawable.ic_launcher);
		list.add(map);	
		
		map = new HashMap<String, Object>();
		map.put("title", "G9");
		map.put("info", "google 5");
		map.put("img", R.drawable.ic_launcher);
		list.add(map);	
		
		return list;
	}
	

}

