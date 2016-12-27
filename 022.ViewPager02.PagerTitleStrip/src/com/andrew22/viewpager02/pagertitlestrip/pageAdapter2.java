package com.andrew22.viewpager02.pagertitlestrip;

import java.util.List;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;





public class pageAdapter2 extends PagerAdapter
{
	List<View> vlist;
	List<String> tlist;
	public pageAdapter2(Vholder vholder)
	{
		// TODO Auto-generated constructor stub

		this.tlist = vholder.tlist;
		this.vlist = vholder.vlist;
	}
	
	
	@Override
	public int getCount()
	{
		// TODO Auto-generated method stub
		return vlist.size();
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
		container.removeView(vlist.get(position));
	}
	@Override
	public Object instantiateItem(ViewGroup container, int position)
	{
		// TODO Auto-generated method stub
		//return super.instantiateItem(container, position);
		container.addView(vlist.get(position));
		return vlist.get(position);  //isViewFromObject ÖÐµÄarg1
	}

	//******************************************************************
	@Override
	public CharSequence getPageTitle(int position)
	{
		// TODO Auto-generated method stub
		//return super.getPageTitle(position);
		return tlist.get(position).toString();
	}

		
	
}
