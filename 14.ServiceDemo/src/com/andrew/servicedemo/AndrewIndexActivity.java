package com.andrew.servicedemo;


import java.util.ArrayList;
import java.util.List;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;


public class AndrewIndexActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        eric_function();
    }

    private void eric_function()
	{
		ListView listView=getListView();
		ListAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, get_data());
		listView.setAdapter(adapter);
    	listView.setOnItemClickListener(new OnItemClickListener()
		{

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id)
			{
				Intent intent;
				switch(position){
				case 0:
					intent= new Intent(AndrewIndexActivity.this,activity1normal.class);
					startActivity(intent);
					break;
				case 1:
					intent= new Intent(AndrewIndexActivity.this,activity2bind.class);
					startActivity(intent);					
					break;
				case 2:
					intent= new Intent(AndrewIndexActivity.this,activity3thread.class);
					startActivity(intent);					
					break;					
				default:
					break;
				
				}
				
			}
    		
		});
	}

	private List<String> get_data()
	{
		List<String> list=new ArrayList<String>();
		
		list.add("1.normal");
		list.add("2.bind");
		list.add("3.thread");
	
		return list;
	}

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.andrew_main, menu);
        
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
