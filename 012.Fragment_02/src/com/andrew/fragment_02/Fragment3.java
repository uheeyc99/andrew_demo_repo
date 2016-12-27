package com.andrew.fragment_02;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 *************************************************************** 
 * 
 * @版权 LinFeng
 * 
 * @作者 LinFeng
 * 
 * @版本 1.0
 * 
 * @创建日期 2016-6-6
 * 
 * @功能描述 
 ***************************************************************** 
 */

/**
 * 这里要注意，Fragment是要引入android.support.v4.app.Fragment这个包里面的，不是那个app.fragment那个包哦
 * @author LinFeng
 *
 */
public class Fragment3 extends Fragment{
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment3, container,false);
        return view;
    }

}