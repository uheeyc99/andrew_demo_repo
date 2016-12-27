package com.andrew22.viewpager05.fragmentpageradapter;

import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class FragAdapter01 extends FragmentPagerAdapter
{
	List<Fragment> mFragments;
	public FragAdapter01(FragmentManager fm,List<Fragment> list)
	{
		super(fm);
		// TODO Auto-generated constructor stub
		mFragments = list;
	}

	@Override
	public Fragment getItem(int arg0)
	{
		// TODO Auto-generated method stub
		return mFragments.get(arg0);
	}

	@Override
	public int getCount()
	{
		// TODO Auto-generated method stub
		return mFragments.size();
	}

}
