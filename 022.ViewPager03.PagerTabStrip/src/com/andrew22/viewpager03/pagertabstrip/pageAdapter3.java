package com.andrew22.viewpager03.pagertabstrip;

import java.util.List;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v4.view.PagerAdapter;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.RelativeSizeSpan;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;





public class pageAdapter3 extends PagerAdapter
{
	List<View> vlist;
	List<String> tlist;
	Context f_context;
	public pageAdapter3(Context context,List<String> tList,List<View> vList)
	{
		// TODO Auto-generated constructor stub

		this.tlist = tList;
		this.vlist = vList;
		this.f_context = context;
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
		return vlist.get(position);  //isViewFromObject 中的arg1
	}

	//******************************************************************
	@Override
	public CharSequence getPageTitle(int position)
	{
		// TODO Auto-generated method stub
		//return super.getPageTitle(position);
		//return tlist.get(position);
		return eric_getPageTitle(position);
	}


	private CharSequence eric_getPageTitle(int position)
	{

		SpannableStringBuilder ssb = new SpannableStringBuilder("  "+tlist.get(position)); // space added before text
											// for
		Drawable myDrawable = f_context.getResources().getDrawable(
				R.drawable.ic_launcher);
		myDrawable.setBounds(0, 0, myDrawable.getIntrinsicWidth(),
				myDrawable.getIntrinsicHeight());
		ImageSpan span = new ImageSpan(myDrawable,
				ImageSpan.ALIGN_BASELINE);

		ForegroundColorSpan fcs = new ForegroundColorSpan(Color.GREEN);// 字体颜色设置为绿色
		ssb.setSpan(span, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);// 设置图标
		ssb.setSpan(fcs, 1, ssb.length(),
				Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);// 设置字体颜色
		ssb.setSpan(new RelativeSizeSpan(1.2f), 1, ssb.length(),
				Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		return ssb;
	}

		
	
}
