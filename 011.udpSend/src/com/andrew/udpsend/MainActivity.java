package com.andrew.udpsend;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;
import java.net.UnknownHostException;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends Activity {
	private DatagramPacket dataPacket;
	private DatagramSocket udpSocket;
	//MulticastSocket multicastSocket=new MulticastSocket(10006);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        new send_thread("09").start();
        
    }

    private void eric() {
		// TODO Auto-generated method stub
		
	}
    private void eric(String a) {
 		// TODO Auto-generated method stub
 		
 	}    
    private void eric(String a,String b) {
 		// TODO Auto-generated method stub
 		
 	}   
    
	private class send_thread extends Thread{
    	String tString="ssssssssssssssss";
    	String udp_addr="255.255.255.255";
    	int udp_port=10006;
    	public  send_thread(String str1)
		{
    		tString=str1;
    		
		}
		@Override
		public void run()
		{
			send(tString);
		}
		void send(String s0)
		{
			
			int MAX_DATA_PACKET_LENGT = 40;
			byte[] buffer = new byte[MAX_DATA_PACKET_LENGT];
			// TODO Auto-generated method stub
			super.run();
			
			try
			{
				udpSocket = new DatagramSocket(21567);
			} catch (SocketException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dataPacket = new DatagramPacket(buffer,MAX_DATA_PACKET_LENGT);
			String str = s0;
			byte out [] = str.getBytes();
			dataPacket.setData(out);
			dataPacket.setLength(out.length);
			dataPacket.setPort(udp_port);
			
			InetAddress broadcastAddr = null;
			try
			{
				broadcastAddr = InetAddress.getByName(udp_addr);
			
			} catch (UnknownHostException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			dataPacket.setAddress(broadcastAddr);
			

				try
				{
					udpSocket.send(dataPacket);
				} catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			
		}
    	
    }
    

}
