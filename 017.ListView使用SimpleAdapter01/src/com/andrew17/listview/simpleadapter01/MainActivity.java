package com.andrew17.listview.simpleadapter01;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;



public class MainActivity extends Activity {

	ListView listView=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        listView = (ListView) findViewById(R.id.listView1);
        String[] from = new String[]{"title","info","img"};
        int[] to = new int[]{R.id.ItemTitle,R.id.ItemText,R.id.ItemImage};
        int resource = R.layout.item;
		 
		        
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, 
        		get_data(),   // maps
        		resource,
        		from, 
        		to);
        
        listView.setAdapter(simpleAdapter);
        listView.setOnItemClickListener(listener1);
        
    }
    
    private OnItemClickListener listener1 = new  OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			// TODO Auto-generated method stub
			TextView textView = (TextView) findViewById(R.id.textView1);
			textView.setText("you clicked" + " " + position);
			
		}
	};
	
	private List<? extends Map<String, ?>> get_data() {
		// TODO Auto-generated method stub
		List<Map<String, Object>> list;
		list = new ArrayList<Map<String, Object>>();
		
		HashMap<String, Object> map = null;
		
		map = new HashMap<String, Object>();
		map.put("title", "t1");
		map.put("info", "C1");
		map.put("img", R.drawable.ic_launcher);
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put("title", "t2");
		map.put("info", "C2");
		map.put("img", R.drawable.ic_launcher);
		list.add(map);	
		
		return list;
	}


}
