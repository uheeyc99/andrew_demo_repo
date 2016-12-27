package com.Andrew.filedemo;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import android.R.integer;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.Toast;
import android.widget.TabHost.OnTabChangeListener;


public class FileDemoList extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.list);
        eric_function();
    }

    
    
    
    
    private void eric_function()
	{
		ListView listView = getListView();

    		
    	ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, 
    				android.R.layout.simple_list_item_1,
    				get_text_data());
    	setListAdapter(arrayAdapter);
    	listView.setOnItemClickListener(listener1);
		
	}

    OnItemClickListener listener1 = new OnItemClickListener()
	{

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position, long id)
		{
			Intent intent;
			if(position == 0){
				intent = new Intent(FileDemoList.this,filetest0.class);
				startActivity(intent);
			}else
			if(position == 1){
				intent = new Intent(FileDemoList.this,filetest1.class);
				startActivity(intent);
				
			}else			
			if(position == 2){
				intent = new Intent(FileDemoList.this,filetest2.class);
				startActivity(intent);
			}else	
			
			if(position == 3){
				intent = new Intent(FileDemoList.this,filetest3.class);
				startActivity(intent);
			}				
			
			if(position == 4){
				intent = new Intent(FileDemoList.this,filetest4.class);
				startActivity(intent);
			}				
			
			
		}
    	
	};
    
    
	private List<String> get_text_data()
	{
		List<String> list = new ArrayList<String>();
		list.add("0.读取resource内文件");
		list.add("1.读取asset内文件");
		list.add("2.私有文件读写 openFileInput");
		list.add("3.SD卡文件读写FileInputStream");
		list.add("4.File");
		//http://blog.csdn.net/ztp800201/article/details/7322110
		return list;
	}





}
