package com.andrew16.listview.arrayadapter03;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {

	private String[] strs = new String[]{"a","b","c","d"};
	ListView listView=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListAdapter listAdapter = new ArrayAdapter<String>(this,
        		//android.R.layout.simple_list_item_1, 
        		//android.R.layout.simple_list_item_checked,
        		//android.R.layout.simple_list_item_multiple_choice,
        		android.R.layout.simple_list_item_single_choice,
        		strs); 
        listView = (ListView) findViewById(R.id.listView1);
        listView.setAdapter(listAdapter);
        //listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        listView.setOnItemClickListener(listener1);
        
    }
    
    OnItemClickListener listener1 = new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			// TODO Auto-generated method stub
			TextView textView = (TextView) findViewById(R.id.textView1);
			switch(position){
				case 0:
						Toast.makeText(MainActivity.this, "1", Toast.LENGTH_SHORT).show();
						textView.setText("你选择了第" + position + "行");
					break;
				case 1:
						Toast.makeText(MainActivity.this, "2", Toast.LENGTH_SHORT).show();
						textView.setText("你选择了第" + position + "行");
					break;			
			}
			
		}
	};


}
