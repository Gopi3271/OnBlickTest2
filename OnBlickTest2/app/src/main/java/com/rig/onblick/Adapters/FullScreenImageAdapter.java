package com.rig.onblick.Adapters;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.rig.onblick.R;


public class FullScreenImageAdapter extends PagerAdapter {

	private Activity _activity;
	private LayoutInflater inflater;
	// constructor
	public FullScreenImageAdapter(Activity activity,
			int[] imagePaths) {
		this._activity = activity;
		this.imgList = imagePaths;
	}
	int imgList[] = {R.mipmap.new_intro1, R.mipmap.new_intro2, R.mipmap.new_intro3,R.mipmap.new_intro4};

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return imgList.length;
	}

	@Override
	public boolean isViewFromObject(View view, Object object) {
		// TODO Auto-generated method stub
		return view == ((RelativeLayout) object);
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		ImageView imgDisplay;
		inflater = (LayoutInflater) _activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		View viewLayout = inflater.inflate(R.layout.layout_fullscreen_image,
				container, false);
		imgDisplay = (ImageView) viewLayout.findViewById(R.id.imgDisplay);

		imgDisplay.setImageResource(imgList[position]);

//		BitmapFactory.Options options = new BitmapFactory.Options();
//		options.inPreferredConfig = Bitmap.Config.ARGB_8888;
//		Bitmap bitmap = BitmapFactory.decodeFile(_imagePaths.get(position));
//		imgDisplay.setImageBitmap(bitmap);

		((ViewPager)container).addView(viewLayout);



		return viewLayout;
	}
	
	@Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((RelativeLayout) object);
  
    }
}
