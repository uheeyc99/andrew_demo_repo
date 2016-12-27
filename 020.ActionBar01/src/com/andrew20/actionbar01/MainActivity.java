package com.andrew20.actionbar01;

import android.R.anim;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.widget.SearchView;
import android.widget.ShareActionProvider;
import android.widget.Toast;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("天气");
        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
    	MenuInflater inflater = getMenuInflater();
    	inflater.inflate(R.menu.main, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
       // http://developer.android.com/guide/topics/search/search-dialog.html
        SearchView searchView = (SearchView) searchItem.getActionView(); // 配置SearchView的属性
		//searchItem.setOnActionExpandListener(listener1);  //重写自己的效果
        
        MenuItem shareItem = menu.findItem(R.id.action_1);
        ShareActionProvider provider = (ShareActionProvider)shareItem.getActionProvider();
        provider.setShareIntent(getDefaultIntent());
        
        return super.onCreateOptionsMenu(menu);
    }

    private Intent getDefaultIntent()
	{
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("image/*");
        return intent;
	}

	OnActionExpandListener listener1 = new OnActionExpandListener()
	{
		
		@Override
		public boolean onMenuItemActionExpand(MenuItem item)
		{
			// TODO Auto-generated method stub
			Toast.makeText(MainActivity.this, "onMenuItemActionExpand", Toast.LENGTH_SHORT).show();
			return false;
		}
		
		@Override
		public boolean onMenuItemActionCollapse(MenuItem item)
		{
			// TODO Auto-generated method stub
			Toast.makeText(MainActivity.this, "onMenuItemActionCollapse", Toast.LENGTH_SHORT).show();
			return false;
		}
	};
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_search) {
        	
            return true;
        }
        
        if(id == android.R.id.home){
        	Toast.makeText(MainActivity.this, "home", Toast.LENGTH_SHORT).show();
        	return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
