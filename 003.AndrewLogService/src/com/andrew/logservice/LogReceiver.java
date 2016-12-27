package com.andrew.logservice;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class LogReceiver extends BroadcastReceiver
{
	private final String TAG = "LogReceiver";
	SimpleDateFormat f1= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:SSS");
	String data_str,port_str,addr_str;
	int port_int;
	@Override
	public void onReceive(Context context, Intent intent)
	{
		// TODO Auto-generated method stub
		if(intent.getAction().equals("andrew_log.eric")){
			
			Bundle bundle = intent.getExtras();
			//不推荐使用 intent.getExtras().getString("data");
			if(bundle != null){
				data_str = bundle.getString("data");
				port_str = bundle.getString("port");
				addr_str = bundle.getString("addr");
			}
			
			
			
			if(port_str == null){
				port_int = 65535;
			}
			
			if(addr_str == null){
				addr_str = "255.255.255.255";
			}	

			if(data_str == null){
				data_str = "What the hell are you want to send !";
			}	
			
			new log_andrew(addr_str,port_int,data_str).start();
			
		}else {
			Log.i(TAG,"OnReceive " + intent.getAction());
		}
	
		

	}
	private class log_andrew extends Thread{

		String log_addr = "";
		int log_port = 0;
		String log_string="No Data";
		
		public  log_andrew(String addr,int port,String str1)
		{
			log_addr = addr;
			log_port = port;
			log_string = str1;
		}
		@Override
		public void run()
		{
			log_send(log_addr,log_port,log_string);
		}
		
		
		private void log_send(String addr, int port, String tString) {
			
			udp_send(addr,port,tString);
			
			Log.i(TAG, f1.format(new Date())+": " + "sent " 
					+ "{"+tString+"}"
					+ " to "
					+ "(" + addr +","+ port + ")"
					);
			
		}
		
		void udp_send(String dest_addr,int dest_port,String send_data)
		{
			DatagramPacket dataPacket;
			DatagramSocket udpSocket = null;		
			int MAX_DATA_PACKET_LENGT = 10;
			byte[] buffer = new byte[MAX_DATA_PACKET_LENGT]; // ?
			// TODO Auto-generated method stub
			super.run();
			
			try
			{
				udpSocket = new DatagramSocket(dest_port);
			} catch (SocketException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			dataPacket = new DatagramPacket(buffer,MAX_DATA_PACKET_LENGT);
			byte out [] = send_data.getBytes();
			dataPacket.setData(out);
			dataPacket.setLength(out.length);
			dataPacket.setPort(dest_port);
			try {
				dataPacket.setAddress(InetAddress.getByName(dest_addr));
			} catch (UnknownHostException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				udpSocket.send(dataPacket);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			udpSocket.close();
		}
		
	}	


	
	
}
