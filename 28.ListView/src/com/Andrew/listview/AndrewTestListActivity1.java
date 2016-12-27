package com.Andrew.listview;

import java.util.ArrayList;
import java.util.List;

import android.R.anim;
import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

public class AndrewTestListActivity1 extends ListActivity
{
	ListView listView;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ListAdapter adapter = new ArrayAdapter<String>(this, R.layout.simple_list_item_1, eric_getdata());
        setListAdapter(adapter);
		
    }
	private List<String> eric_getdata()
	{
		List<String> dataList = new ArrayList<String>();
		dataList.add("1");
		dataList.add("3");
		dataList.add("3");
		dataList.add("4");
		return dataList;
	}
    
}
