package com.andrew.listviewdemo.adapters;

import com.andrew.listviewdemo.R;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.widget.SimpleCursorAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class AndrewList1SimpleCursorAdapter1 extends Activity
{
	ListView listView;
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
		int[] to = {android.R.id.text1};

		
		ListAdapter adapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_1, cursor, from, to,0); // 
		//setListAdapter(adapter);    
		listView.setAdapter(adapter); 
		
	}

}
