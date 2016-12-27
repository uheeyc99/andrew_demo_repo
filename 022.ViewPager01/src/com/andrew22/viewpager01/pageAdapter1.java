package com.andrew22.viewpager01;

import java.util.List;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;





public class pageAdapter1 extends PagerAdapter
{
	List<View> list;
	public pageAdapter1(List<View> vlist)
	{
		// TODO Auto-generated constructor stub
		this.list = vlist;
	}
	
	
	@Override
	public int getCount()
	{
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1)
	{
		// TODO Auto-generated method stub
		return ( arg0== arg1);
	}
	@Override
	public void destroyItem(ViewGroup container, int position, Object object)
	{
		// TODO Auto-generated method stub
		//super.destroyItem(container, position, object);
		container.removeView(list.get(position));
	}
	@Override
	public Object instantiateItem(ViewGroup container, int position)
	{
		// TODO Auto-generated method stub
		//return super.instantiateItem(container, position);
		container.addView(list.get(position));
		return list.get(position);  //isViewFromObject ÖÐµÄarg1
	}

	

}
