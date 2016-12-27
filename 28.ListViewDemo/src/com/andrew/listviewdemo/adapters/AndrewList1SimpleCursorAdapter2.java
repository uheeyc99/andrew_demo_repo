package com.andrew.listviewdemo.adapters;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.andrew.listviewdemo.R;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.widget.SimpleCursorAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class AndrewList1SimpleCursorAdapter2 extends Activity
{
	ListView listView,listView2;
	List<Map<String, Object>> list;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.simple_listview1_layout);
		eric_function();
	}

	private void eric_function()
	{
		// TODO Auto-generated method stub
		listView  = (ListView) findViewById(R.id.listView1_3);
		
		Cursor cursor = getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
		String[] from = {ContactsContract.Data.DISPLAY_NAME};
		int[] to = {R.id.textView1};

		
		ListAdapter adapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_1, cursor, from, to,0); // 
		//setListAdapter(adapter);    
		listView.setAdapter(adapter); 
		//
		list = buildListForSimpleAdapter();
		SimpleAdapter adapter1 = new SimpleAdapter(this, list,
				R.layout.simple_listview1, 
				new String[]{"img","title","info"}, 
				new int[]{R.id.imageView1,R.id.textView1,R.id.textView2});		
		listView2  = (ListView) findViewById(R.id.listView1_3);
		listView2.setAdapter(adapter1);
	}

	private List<Map<String, Object>> buildListForSimpleAdapter()
	{
		HashMap<String, Object> map = null;
		ArrayList<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		
		map = new HashMap<String, Object>();
		map.put("title", "a1...");
		map.put("info", "A1...");
		map.put("img", R.drawable.ak2);
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put("title", "a2...");
		map.put("info", "A2...");
		map.put("img", R.drawable.ak2);
		list.add(map);		
		return list;
	}	
	
	
}
