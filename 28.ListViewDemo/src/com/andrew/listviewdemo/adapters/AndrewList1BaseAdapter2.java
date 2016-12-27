package com.andrew.listviewdemo.adapters;

import java.util.ArrayList;
import java.util.HashMap;
import com.andrew.listviewdemo.R;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class AndrewList1BaseAdapter2 extends Activity
{
	
	ListView listView ;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.simple_listview1_layout);
		listView = (ListView) findViewById(R.id.listView1_3);
		eric_function();
		
	}

private void eric_function()
	{
		// TODO Auto-generated method stub
		Andrew_BaseAdapter andrew_BaseAdapter = new Andrew_BaseAdapter(this);
		listView.setAdapter(andrew_BaseAdapter);
	}


private ArrayList<HashMap<String, Object>> getDate()
{
	ArrayList<HashMap<String, Object>>  arrayList = new ArrayList<HashMap<String,Object>>();
	HashMap<String, Object> hashMap = null;
	
	for(int i=0;i<30;i++){
		hashMap = new HashMap<String, Object>();
		hashMap.put("Title", i+"^_^");
		hashMap.put("Text", i+"..");
		arrayList.add(hashMap);
	}
	return arrayList;
	
	
}


//**************************************************************	
private class Andrew_BaseAdapter extends BaseAdapter
{

	private LayoutInflater mInflater;
	

	public Andrew_BaseAdapter(AndrewList1BaseAdapter2 andrewList1BaseAdapter2)
	{
		// TODO Auto-generated constructor stub
		this.mInflater = LayoutInflater.from(andrewList1BaseAdapter2);
	}


	@Override
	public int getCount()
	{
		// TODO Auto-generated method stub
		return getDate().size();
		
	}



	@Override
	public Object getItem(int position)
	{
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public long getItemId(int position)
	{
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
        ViewHolder holder;        
        Log.v("MyListViewBase", "getView " + position + " " + convertView);
       if (convertView == null) {
              convertView = mInflater.inflate(R.layout.simple_listview2,null);
              holder = new ViewHolder();
               /**得到各个控件的对象*/                    
              holder.title = (TextView) convertView.findViewById(R.id.textView21);
              holder.text = (TextView) convertView.findViewById(R.id.textView22);
              holder.bt = (Button) convertView.findViewById(R.id.button21);
              holder.image = (ImageView) convertView.findViewById(R.id.imageView21);
              convertView.setTag(holder);               
       }
       else{
               holder = (ViewHolder)convertView.getTag();             
       }		
       	holder.title.setText(getDate().get(position).get("Title").toString());
       	holder.text.setText(getDate().get(position).get("Text").toString());
       // holder.image.setImageResource(R.drawable.ic_launcher);
       	holder.bt.setOnClickListener(new OnClickListener()
		{
			
			@Override
			public void onClick(View v)
			{
				Button btnButton = (Button) v;
				Toast.makeText(AndrewList1BaseAdapter2.this, "Clicked", Toast.LENGTH_SHORT).show();
				
				String string = btnButton.getText().toString();
				if(string != "Clicked")
					btnButton.setText("selected");
				else {
					btnButton.setText("not select");
				}
			}
		});
       	
       	return convertView;		

	}

	public final class ViewHolder{
		public TextView title;
		public TextView text;
		public Button bt;
		public ImageView image;
	}

}
	
	
}
