package com.Andrew.listview;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.ListActivity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;



public class AndrewTestListActivity2 extends Activity
{
	ListView listView;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_andrew1list);
		//ListAdapter adapter = new ArrayAdapter<String>(this, R.id.textView2, eric_getdata());
        ListAdapter adapter = new ArrayAdapter<String>(this, R.layout.activity_andrew1list, R.id.textView2, eric_getdata()); 

        listView = (ListView) findViewById(R.id.listView1);
		listView.setAdapter(adapter);
		
    }
	private List<String> eric_getdata()
	{
		List<String> dataList = new ArrayList<String>();
		dataList.add("1");
		dataList.add("3");
		dataList.add("3");
		dataList.add("4");
		dataList.add("5");
		dataList.add("6");
		dataList.add("7");
		dataList.add("8");
		dataList.add("9");
		dataList.add("a");
		dataList.add("b");
		return dataList;
	}
    
}