package com.andrew.fragment_02;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 *************************************************************** 
 * 
 * @��Ȩ LinFeng
 * 
 * @���� LinFeng
 * 
 * @�汾 1.0
 * 
 * @�������� 2016-6-6
 * 
 * @�������� 
 ***************************************************************** 
 */

/**
 * ����Ҫע�⣬Fragment��Ҫ����android.support.v4.app.Fragment���������ģ������Ǹ�app.fragment�Ǹ���Ŷ
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