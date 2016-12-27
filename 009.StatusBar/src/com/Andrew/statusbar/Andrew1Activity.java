package com.Andrew.statusbar;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;


public class Andrew1Activity extends ListActivity {

    Button btn1,btn2,btn3,btn4,btn5;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
    	ListAdapter listAdapter = new ArrayAdapter<String>(this, 
    			android.R.layout.simple_list_item_1,
    			get_textlist());
    	ListView listView=getListView();// because  ListActivity
    	listView.setOnItemClickListener(listener);
    	setListAdapter(listAdapter);
    }

    
    private List<String> get_textlist()
	{
		// TODO Auto-generated method stub
    	List<String> textList = new  ArrayList<String>();
		textList.add("notify 1");
		textList.add("notify 2");
		textList.add("...");
		textList.add("...");
		textList.add("...");
		textList.add("...");
		textList.add("...");
		textList.add("...");
		textList.add("...");
		textList.add("...");
		textList.add("...");
		textList.add("...");
		textList.add("...");
		return textList;
	}

    OnItemClickListener listener = new OnItemClickListener()
	{

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position, long id)
		{
			// TODO Auto-generated method stub
			char which= '0';
			Intent intent = new Intent();
			intent.setClass(Andrew1Activity.this, Andrew1IntentService.class);
			switch(position){
				case 0:
					which = '1';
					break;
				case 1:
					which = '2';
					break;
				default:
					break;
			
			}
			intent.putExtra("which", which);
			startService(intent);
		}
    	
	};


    
}
