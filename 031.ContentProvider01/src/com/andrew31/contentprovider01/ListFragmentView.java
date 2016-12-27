package com.andrew31.contentprovider01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import android.support.v4.app.Fragment;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;



public class ListFragmentView extends Fragment{
	SimpleAdapter simpleAdapter;
	ListView listView = null;
	String TAG = "ListFragmentView";
	Uri uri = Uri.parse("content://com.andrew.contentprovider.eric_authorty_1/path1");
	View view1=null;

	@Override
   	public void onCreate(Bundle savedInstanceState)
   	{
   		// TODO Auto-generated method stub
   		
   		super.onCreate(savedInstanceState);
   		Log.d(TAG, "onCreate");
	   
   		
   		
   	}
	
	/**
	 * ˢ��ListView ����ʾ 
	 **/
	public void show_listview_content() {
		// TODO Auto-generated method stub
	    String[] from = new String[]{"t1","t2","t3"};
	    int[] to = new int[]{R.id.Text1,R.id.Text2,R.id.Text3};
	    int resource = R.layout.item;
	    simpleAdapter = new SimpleAdapter(getActivity(), 
	    		get_data(),   
	    		resource,
	    		from, 
	    		to); 
	    
	    listView.setAdapter(simpleAdapter);
	   // setListAdapter(simpleAdapter);
	    simpleAdapter.notifyDataSetChanged();	
	    
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		Log.d(TAG, "onCreateView");
		View view = inflater.inflate(R.layout.list_fragment_index_list, container, false);
		listView = (ListView)view.findViewById(R.id.listView1);
		show_listview_content();
		return view;
	}


	
	private List<? extends Map<String, ?>> get_data() {
		// TODO Auto-generated method stub
		List<Map<String, Object>> list;
		list = new ArrayList<Map<String, Object>>();
		
		HashMap<String, Object> map = null;
		
		//************************************************************************
		// TODO Auto-generated method stub
		ContentResolver cr = getActivity().getApplicationContext().getContentResolver();
		// ����idΪ1������
		Cursor c = cr.query(uri, null, null, null, null);
		int count = c.getCount();
		//�������Ҫ���� c.moveToFirst���α��ƶ�����һ������,��Ȼ�����index -1 requested , with a size of 1����cr.query���ص���һ���������
		if (c.moveToFirst() == false) {
			// Ϊ�յ�Cursor
			Log.i("TAG","no data in table ! "  );
			map = new HashMap<String, Object>();
			map.put("t1", " no data ");
			list.add(map);
			return list;
		}
		count = c.getCount();
		Log.i("TAG", count + " Rows" );
		//System.out.println(c.getCount());
		String  time_string;
		int time_index;
		int i=0;
		do{
			++i;
			map = new HashMap<String, Object>();
			
			map.put("t1", i +" | ");
			
			time_index = c.getColumnIndex("date_added");
			time_string = c.getString(time_index);  
			map.put("t2", time_string+" | ");
			
			time_index = c.getColumnIndex("mark");
			time_string = c.getString(time_index);  
			map.put("t3", time_string+" | ");
			
			list.add(map);			
			
		}while(c.moveToNext()); //ȡ��ÿ�������������е�ֵ
				
		return list;
	}
	


}
