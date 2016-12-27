package com.andrew07.service03_thread.service;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class Andrew02ServiceIntent extends IntentService //���߳�ִ���������ŶӲ������˳�
{
	//private static String TAG = "ServiceIntent";
	private static String TAG = "Andrew02Service";
	public Andrew02ServiceIntent()
	{
		
		//Log.i(TAG, "onCreate");
		super("Andrew02ServiceIntent");    //�����߳�ʱִ��
		Log.i(TAG,"Andrew02ServiceIntent");
	}
	
	@Override
	protected void onHandleIntent(Intent intent)//ÿ�ε���¼����Ŷ�ִ��
	{
		// TODO Auto-generated method stub
		Log.i(TAG,"onHandleIntent"+"ID: " + Thread.currentThread().getId()+ "��Ӧ��ť");

		Log.i(TAG, "ִ�����һ�ε��");
	}	
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId)
	{
		// TODO Auto-generated method stub
		Log.i(TAG,"onStartCommand");//ÿ�ε���¼�ʱִ��
		return super.onStartCommand(intent, flags, startId);
	}	
	
	@Override
	public void onCreate()
	{
		// TODO Auto-generated method stub
		Log.i(TAG,"onCreate"); //�����߳�ʱִ��
		super.onCreate();
	}

	@Override
	public void onStart(Intent intent, int startId)
	{
		// TODO Auto-generated method stub
		Log.i(TAG,"onStart");  //ÿ�ε���¼�ʱִ��
		super.onStart(intent, startId);
	}



	@Override
	public void onDestroy()
	{
		// TODO Auto-generated method stub
		Log.i(TAG,"onDestroy  ִ������������е�������������߳�");
		super.onDestroy();
	}



}
