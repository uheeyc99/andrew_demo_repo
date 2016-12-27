package com.example.webviewdemo;


import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;



public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WebView webview;
        webview = new WebView(this);
       // setContentView(R.layout.activity_main);
        setContentView(webview);
      // webview = (WebView) findViewById(R.id.webView1);
       webview.getSettings().setJavaScriptEnabled(true);
       webview.loadUrl("http://www.qycam.com");
       final Activity activity = this;
       webview.setWebChromeClient(new WebChromeClient() {
         public void onProgressChanged(WebView view, int progress) {
           // Activities and WebViews measure progress with different scales.
           // The progress meter will automatically disappear when we reach 100%
           activity.setProgress(progress * 1000);
         }
       });
       
       webview.setWebViewClient(new WebViewClient() {
    	   public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
    	     Toast.makeText(activity, "Oh no! " + description, Toast.LENGTH_SHORT).show();
    	   }
    	 });

       
 
       
    }

    

    
    
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
