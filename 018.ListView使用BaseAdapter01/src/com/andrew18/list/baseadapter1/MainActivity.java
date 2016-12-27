package com.andrew18.list.baseadapter1;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;



public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView  listView = (ListView) findViewById(R.id.listView1);
        MyAdapter adapter = new MyAdapter(this,getData());
        listView.setAdapter(adapter);
    }

    //***********************************************************************
    private List<Map<String, Object>> getData() {
		// TODO Auto-generated method stub
    	List<Map<String, Object>> list = null;
    	Map<String, Object> map=null;
    	list = new ArrayList<Map<String, Object>>();
    	
    	map = new HashMap<String, Object>();
    	map.put("title", "T1.....................");
    	map.put("content","C1,,,,,,,,,,,,,,,,,,,");
    	map.put("img", R.drawable.ic_launcher);
    	list.add(map);
 
    	map = new HashMap<String, Object>();
    	map.put("title", "T2");
    	map.put("content","C2");
    	map.put("img", R.drawable.ic_launcher);
    	list.add(map);    	
    	
		return list;
	}
    //***********************************************************************

	public class MyAdapter extends BaseAdapter{
		private LayoutInflater mInflater;
		private List<Map<String,Object>> mData;
		MyAdapter(Context context,List<Map<String, Object>> mData1){
			//根据context上下文加载布局
			this.mInflater = LayoutInflater.from(context);
			//将传入的数据保存在mData中
			this.mData=mData1;
		}
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			//在此适配器中所代表的数据集中的条目数
			return mData.size();
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			//自定义的一个类用来缓存convertview
			ViewHolder holder=null;  
			
			//It reuses the convertView passed to getView() to avoid inflating View when it is not necessary
			if(null == convertView){
				//It uses the ViewHolder pattern to avoid calling findViewById() when it is not necessary
				holder = new ViewHolder();
				//根据自定义的Item布局加载布局
				convertView=mInflater.inflate(R.layout.vlist,null);
				holder.img = (ImageView)convertView.findViewById(R.id.img);
				holder.info = (TextView)convertView.findViewById(R.id.info);
				holder.title=(TextView)convertView.findViewById(R.id.title);
				holder.viewBtn = (Button)convertView.findViewById(R.id.view_btn);
				//将设置好的布局保存到缓存中，并将其设置在Tag里，以便后面方便取出Tag
				convertView.setTag(holder);
			}else {

				holder = (ViewHolder)convertView.getTag();
			}
			
			holder.img.setBackgroundResource((Integer)mData.get(position).get("img"));
			holder.title.setText((String)mData.get(position).get("title"));
			holder.info.setText((String)mData.get(position).get("content"));
			holder.viewBtn.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					showInfo();
					
				}
			});
				

			return convertView;
		}

		
		
    }
	protected void showInfo() {
		new AlertDialog.Builder(this)
		.setTitle("我的listview")
		.setMessage("介绍...")
		.setPositiveButton("确定", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
			}
		})
		.show();
		
	}	
	final public class ViewHolder{
		public ImageView img;
		public TextView title;
		public TextView info;
		public Button viewBtn;
	}
    //***********************************************************************

}
