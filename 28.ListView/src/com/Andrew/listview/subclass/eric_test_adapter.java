package com.Andrew.listview.subclass;

import java.net.ContentHandler;
import java.util.List;
import java.util.Map;

import com.Andrew.listview.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class eric_test_adapter extends BaseAdapter
{
	private static final OnClickListener Listener = null;
	private LayoutInflater mInflater;
	private List<Map<String, Object>> mData;

	public eric_test_adapter(Context context, List<Map<String, Object>> mData)
	{
		this.mInflater = LayoutInflater.from(context);
		this.mData = mData;
	}

	// ************************************************************
	public int getCount()
	{

		return mData.size();
	}

	@Override
	public Object getItem(int position)
	{

		return position;
	}

	@Override
	public long getItemId(int position)
	{

		return position;
	}

	public final class Andrew_ViewHolder
	{
		public ImageView img;
		public TextView title;
		public TextView info;
		public Button btn;
	}

	public View getView(int position, View convertView, ViewGroup parent)
	{
		Andrew_ViewHolder holder = null;
		if (convertView == null)
		{
			holder = new Andrew_ViewHolder();
			convertView = mInflater.inflate(R.layout.activity_andrew4list, null);
			holder.img = (ImageView) convertView.findViewById(R.id.imageView2);
			holder.title = (TextView) convertView.findViewById(R.id.textView21);
			holder.info = (TextView) convertView.findViewById(R.id.textView22);
			holder.btn = (Button) convertView.findViewById(R.id.button20);
			convertView.setTag(holder);
		}else{
			holder = (Andrew_ViewHolder) convertView.getTag();
		}
		
		
		holder.img.setImageResource(R.drawable.ic_launcher);
		holder.title.setText((String) mData.get(position).get("title"));
		holder.info.setText((String) mData.get(position).get("info"));

		holder.btn.setOnClickListener(listener1);

		return convertView;
	}

	OnClickListener listener1 = new OnClickListener()
	{
		
		@Override
		public void onClick(View v)
		{
			Button btnButton = (Button)v;
			btnButton.setText("done");
			
		}
	};
	
	
}
