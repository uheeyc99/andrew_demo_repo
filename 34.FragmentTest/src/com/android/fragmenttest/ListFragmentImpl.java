package com.android.fragmenttest;

import android.app.ListFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListFragmentImpl extends ListFragment
{
	private static final String TAG = "ListFragmentImpl";
	private ListView selfList;
    String[] cities = {
         "Shenzhen",
         "Beijing",
         "Shanghai",
         "Guangzhou",
         "Wuhan",
         "Tianjing",
         "Changsha",
         "Xi'an",
         "Chongqing",
         "Guilin",
    };
    
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setListAdapter(new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_list_item_1, cities));
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{

		return inflater.inflate(R.layout.list_fragment_impl, container, false);
	}

	@Override
	public void onListItemClick(ListView l, View v, int position, long id)
	{
		//super.onListItemClick(l, v, position, id);
		Log.d(TAG, "onListItemClick");
	}

	
	
	
}
