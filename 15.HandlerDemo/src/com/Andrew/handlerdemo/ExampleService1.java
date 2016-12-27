package com.Andrew.handlerdemo;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

public class ExampleService1 extends Service
{
	//֪ͨMQ��Ҫִ��һ������(sendMessage)������loop���Լ���ʱ��ִ�и�����(handleMessage)�������������첽�ġ�
	private static final String TAG = "ExampleService1";
	
	private ServiceHandler  handler1;//һ���߳̿����ж��Handler������ֻ����һ��Looper��
	private class ServiceHandler extends Handler{
		
		public ServiceHandler(Looper looper)
		{
			super(looper);
		}

		@Override
		public void handleMessage(Message msg)
		{
			// TODO Auto-generated method stub
			switch(msg.what)
			{
				case 1:
					Log.i(TAG, "Message "+msg.obj);
					break;
				
				case 2:
					Log.i(TAG, "Message "+msg.obj);
					break;
			
				default:
					break;
			}
			//super.handleMessage(msg);
			//stopSelf();
		}
		
	}
	
	@Override
	public IBinder onBind(Intent intent)
	{
		// TODO Auto-generated method stub
		Log.i(TAG, "onBind");
		return null;
	}

	@Override
	public void onCreate()
	{
		// TODO Auto-generated method stub
		Looper looper = Looper.getMainLooper();
		handler1 = new ServiceHandler(looper);
		Log.i(TAG, "onCreate");
		super.onCreate();
	}


	@Override
	public int onStartCommand(Intent intent, int flags, int startId)
	{
		// TODO Auto-generated method stub
		Log.i(TAG, "onStartCommand");
		Message msg = handler1.obtainMessage();
		msg.what = 1;
		msg.arg1 =startId;
		msg.obj = "Andrew";
		handler1.sendMessage(msg);
		//return super.onStartCommand(intent, flags, startId);
		return START_STICKY;
	}

	@Override
	public void onDestroy()
	{
		// TODO Auto-generated method stub
		Log.i(TAG, "onDestroy");
		super.onDestroy();
	}

}
