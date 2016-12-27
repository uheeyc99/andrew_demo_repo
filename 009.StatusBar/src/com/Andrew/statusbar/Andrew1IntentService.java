package com.Andrew.statusbar;

import java.net.URL;
import java.sql.Date;

import android.R.integer;
import android.annotation.SuppressLint;
import android.app.IntentService;
import android.app.Notification;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.text.format.DateFormat;
import android.util.Log;
import android.widget.RemoteViews;
import android.widget.Toast;

@SuppressLint("NewApi") public class Andrew1IntentService extends IntentService
{
	private final String TAG="Andrew1IntentService";
	
	
	public Andrew1IntentService()
	{
		super("Andrew1IntentService");
	}

	
	
	protected void onHandleIntent(Intent intent)
	{
		Bundle bundle;
		bundle = intent.getExtras();
		Character which = bundle.getChar("which");
		switch(which){
		case '1':
			Andrew_BasicNotifications();
			break;
			
		case '2':
			Andrew_customnotifications();
			break;
			
		case '3':
			
			break;
		default:
			break;
		}
		
		//
		


	}



	private void Andrew_BasicNotifications()
	{
		//Intent intent  = new Intent(this, Andrew1Activity.class);
        Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.baidu.com"));
		PendingIntent pendingIntent = PendingIntent.getActivity(this , 0 , intent, 0);
		
		NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
		
		builder.setSmallIcon(R.drawable.ic_launcher);
		builder.setContentIntent(pendingIntent);
		builder.setAutoCancel(true);
		builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher));
        builder.setContentTitle("Andrew title");
        builder.setContentText("Time to learn about notifications!");
        builder.setSubText("Tap to view documentation about notifications.");
        builder.setTicker("new notification!!!");
        //builder.setSound(Uri.parse("fbsd204"));
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(0, builder.build());		

	}
	
	
	private void Andrew_customnotifications()
	{
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);

        //Create Intent to launch this Activity again if the notification is clicked.
        Intent i = new Intent(this, Andrew2Activity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        PendingIntent intent = PendingIntent.getActivity(this, 0, i,
                PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(intent);



        // Sets the ticker text
        builder.setTicker(getResources().getString(R.string.custom_notification));

        // Sets the small icon for the ticker
        builder.setSmallIcon(R.drawable.ic_stat_custom);

        // Cancel the notification when clicked
        builder.setAutoCancel(true);

		builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher));
        builder.setContentTitle("Andrew title");
        builder.setContentText("Time to learn about notifications!");
        builder.setSubText("Tap to view documentation about notifications.");        
        
        
        
        // Build the notification
        Notification notification = builder.build();

        // Inflate the notification layout as RemoteViews
       // RemoteViews contentView = new RemoteViews(getPackageName(), R.layout.notification);
        RemoteViews contentView = new RemoteViews(getPackageName(), R.layout.activity_andrew2);
        // Set text on a TextView in the RemoteViews programmatically.
      //  final String time = DateFormat.getTimeInstance().format(new Date()).toString();
        String time = "2016-06-06";
        final String text = getResources().getString(R.string.collapsed, time);
       contentView.setTextViewText(R.id.textView, text);
        
        contentView.setTextViewText(R.id.l2textView1, text);
        

        /* Workaround: Need to set the content view here directly on the notification.
         * NotificationCompatBuilder contains a bug that prevents this from working on platform
         * versions HoneyComb.
         * See https://code.google.com/p/android/issues/detail?id=30495
         */
        notification.contentView = contentView;

        RemoteViews expandedView =
                new RemoteViews(getPackageName(), R.layout.notification_expanded);
        notification.bigContentView = expandedView;


        // START_INCLUDE(notify)
        // Use the NotificationManager to show the notification
        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nm.notify(0, notification);     
        
	}

}
