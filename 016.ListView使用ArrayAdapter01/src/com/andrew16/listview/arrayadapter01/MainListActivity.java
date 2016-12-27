package com.andrew16.listview.arrayadapter01;


import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;


public class MainListActivity extends ListActivity {

	private static final String[]  str1 = new String[] {"第一行","第二行","第三行","第四行"};
	ListView listView =null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        ListAdapter listAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, str1);
        setListAdapter(listAdapter);
    }

}
