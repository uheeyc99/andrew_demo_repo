package com.andrew22.viewpager03.pagertabstrip;

import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends Activity {
	ViewPager viewPager;
	View v1,v2,v3;
	List<String> tlist;
	List<View> vlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        LayoutInflater inflater1 = getLayoutInflater();
        v1 = inflater1.inflate(R.layout.layout1, null);
        v2 = inflater1.inflate(R.layout.layout2, null);
        v3 = inflater1.inflate(R.layout.layout3, null);
        vlist = new ArrayList<View>();
        vlist.add(v1);
        vlist.add(v2);
        vlist.add(v3);
        
        tlist = new ArrayList<String>();
        tlist.add("a");
        tlist.add("s");
        tlist.add("d");
        
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new pageAdapter3(this,tlist, vlist));
       
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
