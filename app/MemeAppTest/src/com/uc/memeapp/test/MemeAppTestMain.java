package com.uc.memeapp.test;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.ImageButton;

import com.uc.memeapp.MainActivity;

public class MemeAppTestMain extends
		ActivityInstrumentationTestCase2<MainActivity> {

	public MemeAppTestMain() {
		super("com.uc.memeapp.MainActivity", MainActivity.class);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();

		setActivityInitialTouchMode(false);
		
		Activity mActivity = getActivity();
		
		ImageButton mSelectButton = (ImageButton) mActivity.findViewById(com.uc.memeapp.R.id.imgButton_grab);
		ImageButton mCameraButton = (ImageButton) mActivity.findViewById(com.uc.memeapp.R.id.imgButton_take);

	}
}
