package com.uc.memeapp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;


public class ImageAdapter extends BaseAdapter {
	private Context mContext;

	public ImageAdapter(Context c) {
		mContext = c;
	}

	public int getCount() {
		return mThumbIds.length;
	}

	public Object getItem(int position) {
		return null;
	}

	public long getItemId(int position) {
		return 0;
	}

	// create a new ImageView for each item referenced by the Adapter
	public View getView(int position, View convertView, ViewGroup parent) {
		ImageView imageView;
		if (convertView == null) { // if it's not recycled, initialize some
									// attributes
			imageView = new ImageView(mContext);
			imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
			imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
			imageView.setPadding(8, 8, 8, 8);
		} else {
			imageView = (ImageView) convertView;
		}

		imageView.setImageResource(mThumbIds[position]);
		return imageView;
	}

	// references to our images
	private Integer[] mThumbIds = {
            R.drawable.all_the_things, R.drawable.asian_dad, R.drawable.bad_advice_cat,
            R.drawable.brace_yourself, R.drawable.business_cat, R.drawable.condescending_wonka,
            R.drawable.conspiracy_keanu, R.drawable.dwight_schrute, R.drawable.first_world_problems,
            R.drawable.good_guy_greg, R.drawable.hipster_kitty, R.drawable.lazy_senior,
            R.drawable.most_interesting_cat, R.drawable.most_interesting_man, R.drawable.one_does_not_simply, 
            R.drawable.pedobear, R.drawable.philosoraptor, R.drawable.scumbag_steve, 
            R.drawable.skeptical_fry, R.drawable.socially_awesome_penguin, R.drawable.socially_awkward_penguin,
            R.drawable.success_kid, R.drawable.successful_black_man, R.drawable.ten_guy,
            R.drawable.why_not_zoidberg, R.drawable.y_u_no, R.drawable.yo_dawg
    };
}
