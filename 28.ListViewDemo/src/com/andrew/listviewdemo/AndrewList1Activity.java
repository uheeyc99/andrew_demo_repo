package com.andrew.listviewdemo;

import java.util.ArrayList;
import java.util.List;

import com.andrew.listviewdemo.adapters.AndrewList1ArrayAdapter1;
import com.andrew.listviewdemo.adapters.AndrewList1ArrayAdapter2;
import com.andrew.listviewdemo.adapters.AndrewList1BaseAdapter1;
import com.andrew.listviewdemo.adapters.AndrewList1BaseAdapter2;
import com.andrew.listviewdemo.adapters.AndrewList1SimpleAdapter1;
import com.andrew.listviewdemo.adapters.AndrewList1SimpleAdapter2;
import com.andrew.listviewdemo.adapters.AndrewList1SimpleAdapter3;
import com.andrew.listviewdemo.adapters.AndrewList1SimpleCursorAdapter1;
import com.andrew.listviewdemo.adapters.AndrewList1SimpleCursorAdapter2;



import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;


public class AndrewList1Activity extends ListActivity {


	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.index);
        refreshListItems();
    }

    private void refreshListItems()
	{
		// TODO Auto-generated method stub
    	ListView listView;
    	
    	ListAdapter listAdapter = new ArrayAdapter<String>(this, 
    			android.R.layout.simple_list_item_1,
    			get_list());
    	
    	listView = getListView();  // because  ListActivity

    	
    	setListAdapter(listAdapter);
    	listView.setOnItemClickListener(listener1);
    	listView.setBackgroundColor(Color.YELLOW);    	
	}

    private OnItemClickListener listener1 = new OnItemClickListener()
	{

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position, long id)
		{
			// TODO Auto-generated method stub
			//Toast.makeText(AndrewList1Activity.this, "Clicked "+ position +" "+ id, Toast.LENGTH_LONG).show();
			Intent intent;
			switch (position)
			{
			case 0:
				intent = new Intent(AndrewList1Activity.this, AndrewList1ArrayAdapter1.class);
				startActivity(intent);
				break;
			case 1:
				intent = new Intent(AndrewList1Activity.this, AndrewList1ArrayAdapter2.class);
				startActivity(intent);
				break;
			case 2:
				intent = new Intent(AndrewList1Activity.this, AndrewList1SimpleAdapter1.class);
				startActivity(intent);
				break;				
			case 3:
				intent = new Intent(AndrewList1Activity.this, AndrewList1SimpleAdapter2.class);
				startActivity(intent);
				break;				
			case 4:
				intent = new Intent(AndrewList1Activity.this, AndrewList1SimpleAdapter3.class);
				startActivity(intent);
				break;							
			case 5:
				intent = new Intent(AndrewList1Activity.this, AndrewList1SimpleCursorAdapter1.class);
				startActivity(intent);
				break;		
			case 6:
				intent = new Intent(AndrewList1Activity.this, AndrewList1SimpleCursorAdapter2.class);
				startActivity(intent);
				break;	
			case 7:
				intent = new Intent(AndrewList1Activity.this, AndrewList1BaseAdapter1.class);
				startActivity(intent);
				break;				
			case 8:
				intent = new Intent(AndrewList1Activity.this, AndrewList1BaseAdapter2.class);
				startActivity(intent);
				break;					
			default:
				break;
			}
		}
    	
    	
	};
    
    
    
	private List<String> get_list()
	{
		// TODO Auto-generated method stub
		List<String> dataList = new ArrayList<String>();
		dataList.add("ArrayAdapter1");
		dataList.add("ArrayAdapter2");
		dataList.add("SimpleAdapter1");
		dataList.add("SimpleAdapter2");
		dataList.add("SimpleAdapter3");
		dataList.add("SimpleCursorAdapter1");
		dataList.add("SimpleCursorAdapter2");
		dataList.add("BaseAdapter1");
		dataList.add("BaseAdapter2");
		return dataList;
	}

	
	
	
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.andrew_list1, menu);
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
