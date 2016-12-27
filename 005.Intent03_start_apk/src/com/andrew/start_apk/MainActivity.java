package com.andrew.start_apk;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //View view = getWindow().getDecorView();
        //view.setVisibility(View.GONE);
        start_another_apk();
        finish();
    }

    private void start_another_apk() {
		// TODO Auto-generated method stub
		Intent mIntent = new Intent( ); 
		mIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        ComponentName comp = new ComponentName("com.tencent.mm", "com.tencent.mm.ui.LauncherUI");  
        mIntent.setComponent(comp);   
        mIntent.setAction("android.intent.action.VIEW");   
        startActivity(mIntent);				
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
