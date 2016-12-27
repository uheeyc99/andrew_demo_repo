package com.Andrew.webview;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TabWidget;


public class AndrewMainActivity extends Activity {
	WebView webView;
	TabWidget aTabWidget;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_andrew_main);
        webView = (WebView) findViewById(R.id.webView1);
        webView.getSettings().setJavaScriptEnabled(true);      
        webView.loadUrl("http://www.baidu.com");
        webView.setWebViewClient(client1);
    }

    private WebViewClient client1 =  new WebViewClient(){

		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url)
		{
			// TODO Auto-generated method stub
			
			view.loadUrl(url);
			return true;
			//return super.shouldOverrideUrlLoading(view, url);
		}
    	
    	
    };
    
    
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.andrew_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
