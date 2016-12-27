package com.android.fragmenttest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.ListFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class ListFragmentSelf extends ListFragment
{
private static final String TAG = "ListFragmentSelf";
    
 
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, 
            Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView");
        return inflater.inflate(R.layout.list_fragment_self, container, false);
    }
    

    @Override
    public void onCreate(Bundle savedInstanceState) {
        final String[] from = new String[] {"title", "info"};
        final int[] to = new int[] {R.id.text1, R.id.text2};
        
        Log.d(TAG, "onCreate");
        super.onCreate(savedInstanceState);
        // ����SimpleAdapter����from��to��Ӧ����
        SimpleAdapter adapter = new SimpleAdapter(
                this.getActivity(), getSimpleData(), 
                R.layout.two_textview, from, to);
        this.setListAdapter(adapter);
    }
   
    public void onListItemClick(ListView parent, View v, 
            int position, long id) {
        Log.d(TAG, "onListItemClick");
        Toast.makeText(getActivity(), 
                "You have selected " + position,
                Toast.LENGTH_SHORT).show();
    }
    
    private List<Map<String, Object>> getSimpleData() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("title", "Ferris wheel");
        map.put("info", "Suzhou Ferris wheel");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("title", "Flower");
        map.put("info", "Roser");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("title", "Disk");
        map.put("info", "Song Disk");
        list.add(map);
        
        return list;
    }
}
