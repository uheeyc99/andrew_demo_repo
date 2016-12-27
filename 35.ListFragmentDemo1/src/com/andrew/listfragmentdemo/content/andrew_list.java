package com.andrew.listfragmentdemo.content;
import com.andrew.listfragmentdemo.R;
import android.app.ListFragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.andrew.listfragmentdemo.content.andrew_content;
public class andrew_list extends ListFragment
{
	private static final String TAG = "andrew_list";
    String[] cities = {
            "Shenzhen",
            "Beijing",
            "Shanghai",

       };
    android.app.FragmentManager fragmentManager; 
   	@Override
   	public void onCreate(Bundle savedInstanceState)
   	{
   		// TODO Auto-generated method stub
   		super.onCreate(savedInstanceState);
   		this.setListAdapter(new ArrayAdapter<String>(getActivity(),
   				android.R.layout.simple_list_item_1, cities));
   		Log.d(TAG, "onCreate");

   	}
   	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		//return super.onCreateView(inflater, container, savedInstanceState);
		Log.d(TAG, "onCreateView");
		return inflater.inflate(R.layout.list_fragment_index_list, container, false);
	}



	@Override
	public void onListItemClick(ListView l, View v, int position, long id)
	{
		// TODO Auto-generated method stub
		//super.onListItemClick(l, v, position, id);
		Log.d(TAG, "clicked"+position);
		if(position == 0){
			
			
		}
		if(position == 1){
			
		}
		
	}

	
	
}
