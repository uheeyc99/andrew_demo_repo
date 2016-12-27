package com.andrew16.listview.arrayadapter02;


import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
/*
 * ����������ʹ��ListView
*/
public class MainActivity extends Activity {

	private static final String[]  strs = new String[] {"��һ��","�ڶ���","������","������"};
	ListView listView = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        ListAdapter listAdapter = new ArrayAdapter<String>(this,
        		android.R.layout.simple_list_item_1, 
        		strs);        
        
        /*
         * ���� a
         * ֱ����ʾListView
        */
        //listView = new ListView(this);
        //listView.setAdapter(listAdapter);
        //setContentView(listView);
        
               
        /*
         *  ���� b
         * ListView������layout��
        */        
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listView1);
        listView.setAdapter(listAdapter);

        
              
        
    }

}
