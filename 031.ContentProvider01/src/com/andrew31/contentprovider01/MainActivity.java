package com.andrew31.contentprovider01;



import java.util.Date;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;

import android.net.Uri;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentActivity;


import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends FragmentActivity {
	Button insert,delete,query,update,querys;
	TextView tv1;
	ListView listView=null;
	String[] strs= {"数据库为空"};
	Uri uri = Uri.parse("content://com.andrew.contentprovider.eric_authorty_1/path1");
	
    Fragment f1;
	
    private FragmentManager manager;
    private FragmentTransaction transaction;	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        init_buton();
        init_fragment();
        
    }

    
    
	private void init_fragment()
	{
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();        
        f1 = new ListFragmentView();
        transaction.replace(R.id.fl_content, f1);
        transaction.commit();
	}



	private void init_buton() {
		
		insert=(Button) findViewById(R.id.insert);
		delete=(Button) findViewById(R.id.delete);
		query=(Button) findViewById(R.id.query);
		querys=(Button) findViewById(R.id.querys);
		update=(Button) findViewById(R.id.update);
		
		insert.setOnClickListener(listener_insert);
		delete.setOnClickListener(listener_delete);
		query.setOnClickListener(listener_query);
		querys.setOnClickListener(listener_querys);
		update.setOnClickListener(listener_update);		
		
	}
	
	private OnClickListener listener_insert = new View.OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			ContentResolver cr = getContentResolver();
			ContentValues cv = new ContentValues();
			cv.put("title", "jiaoshou");
			cv.put("name", "name1");
			cv.put("mark", "0");
			cv.put("date_added", Long.toString((new Date()).getTime()));
			System.out.println((new Date()).toString());
			Uri returnUri = cr.insert(uri, cv);
			System.out.println(returnUri.toString());
			System.out.println(cr.getType(uri));  // eric	
			((ListFragmentView) f1).show_listview_content();
			
		}
	};
	private OnClickListener listener_delete = new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			ContentResolver cr = getContentResolver();
			cr.delete(uri, "mark=?", new String[]{"1"});//删除mark为1的那些列
			
			((ListFragmentView) f1).show_listview_content();		
		}
	};
	
	private OnClickListener listener_update = new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			ContentResolver cr = getContentResolver();
			ContentValues cv = new ContentValues();
			cv.put("date_added", Long.toString((new Date()).getTime()) + " .");
			cv.put("mark", "1");
			int uri2 = cr.update(uri, cv, "mark=?", new String[]{"0"});
			System.out.println("updated"+":"+uri2);
			
			((ListFragmentView) f1).show_listview_content();
		}
	};	
	private OnClickListener listener_query = new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			ContentResolver cr = getContentResolver();
			// 查找id为1的数据
			Cursor c = cr.query(uri, null, "name=?", new String[] { "name1" }, null);
			//这里必须要调用 c.moveToFirst将游标移动到第一条数据,不然会出现index -1 requested , with a size of 1错误；cr.query返回的是一个结果集。
			if (c.moveToFirst() == false) {
				// 为空的Cursor
				return;
			}
			
			//int name_index = c.getColumnIndex("name");
			//System.out.println(c.getString(name_index));
			int count = c.getCount();
			Log.i("TAG","gggggggggggggg " + count );
			String idString;
			String nameString;
			String  time_string;
			int id_index;
			int name_index;
			int time_index;
			
			
			do{
				id_index = c.getColumnIndex("_id");//第一列
				idString = c.getString(id_index);//从本行中取第一列
				
				
				name_index = c.getColumnIndex("name");//第一列
				nameString = c.getString(name_index);//从本行中取第一列
				
				
				time_index = c.getColumnIndex("date_added");//第三列
				time_string = c.getString(time_index);  //从本行中取第三列
				//c.getColumnName(time_index);   //返回值应该是 "date_added"
				//c.getColumnCount(); //返回列的个数
				Log.i("TAG","index:"+time_index + ","+time_string + ";"+ name_index + " " + nameString+";" +c.getPosition()+","+ c.getColumnName(0));
				Toast.makeText(MainActivity.this, idString + ":" +time_string, Toast.LENGTH_SHORT).show();
			}while(c.moveToNext()); //取得每个符合条件的行的值
			c.close();
			
			((ListFragmentView) f1).show_listview_content();
		}
	};	
	
	private OnClickListener listener_querys = new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			ContentResolver cr = getContentResolver();
			// 查找id为1的数据
			Cursor c = cr.query(uri, null, "name=?", new String[] { "name1" }, "_ID desc");
			//这里必须要调用 c.moveToFirst将游标移动到第一条数据,不然会出现index -1 requested , with a size of 1错误；cr.query返回的是一个结果集。
			if (c.moveToFirst() == false) {
				// 为空的Cursor
				return;
			}
			
			//int name_index = c.getColumnIndex("name");
			//System.out.println(c.getString(name_index));
			int count = c.getCount();
			Log.i("TAG","gggggggggggggg " + count );
			String idString;
			String nameString;
			String  time_string;
			int id_index;
			int name_index;
			int time_index;
			
			
			do{
				id_index = c.getColumnIndex("_id");//第一列
				idString = c.getString(id_index);//从本行中取第一列
				
				
				name_index = c.getColumnIndex("name");//第一列
				nameString = c.getString(name_index);//从本行中取第一列
				
				
				time_index = c.getColumnIndex("date_added");//第三列
				time_string = c.getString(time_index);  //从本行中取第三列
				//c.getColumnName(time_index);   //返回值应该是 "date_added"
				//c.getColumnCount(); //返回列的个数
				Log.i("TAG","index:"+time_index + ","+time_string + ";"+ name_index + " " + nameString+";" +c.getPosition()+","+ c.getColumnName(0));
				Toast.makeText(MainActivity.this, idString + ":" +time_string, Toast.LENGTH_SHORT).show();
			}while(c.moveToNext()); //取得每个符合条件的行的值
			c.close();
			
			((ListFragmentView) f1).show_listview_content();
		}
	};
}
