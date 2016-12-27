package com.andrew16.listview.arrayadapter02;


import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
/*
 * 在主界面中使用ListView
*/
public class MainActivity extends Activity {

	private static final String[]  strs = new String[] {"第一行","第二行","第三行","第四行"};
	ListView listView = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        ListAdapter listAdapter = new ArrayAdapter<String>(this,
        		android.R.layout.simple_list_item_1, 
        		strs);        
        
        /*
         * 方案 a
         * 直接显示ListView
        */
        //listView = new ListView(this);
        //listView.setAdapter(listAdapter);
        //setContentView(listView);
        
               
        /*
         *  方案 b
         * ListView绘制在layout中
        */        
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listView1);
        listView.setAdapter(listAdapter);

        
              
        
    }

}
