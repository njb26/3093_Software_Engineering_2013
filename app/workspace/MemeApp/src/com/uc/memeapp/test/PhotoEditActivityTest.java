package com.uc.memeapp.test;

import android.content.res.Resources;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.EditText;
import android.widget.ImageView;

import com.uc.memeapp.PhotoEditActivity;
import com.uc.memeapp.R;

public class PhotoEditActivityTest extends ActivityInstrumentationTestCase2<PhotoEditActivity> {
	
	private PhotoEditActivity mActivity;
	
	public PhotoEditActivityTest() {
		super("com.uc.memeapp", PhotoEditActivity.class);
	}
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		setActivityInitialTouchMode(false);
		mActivity = getActivity();
	}
	
	/*
	public void testLineWrapping(){
		EditText testEditTop = mActivity.topEditText;
		EditText testEditBottom = mActivity.bottomEditText;
		
		ImageView testImage = (ImageView) mActivity.findViewById(R.id.image_to_edit);
		Resources res = mActivity.getResources();
		testImage.setImageDrawable(res.getDrawable(R.drawable.bad_advice_cat));
		
		testEditTop.setText("This is a long sequence to test whether or not the lines will wrap");
		testEditBottom.setText("This is a long sequence to test whether or not the lines will wrap");
		
		assertTrue(testEditTop.getLineCount() > 1);
		assertTrue(testEditBottom.getLineCount() > 1);
		assertTrue(mActivity.topMaxLines >3);
		assertTrue(mActivity.bottomMaxLines >3);
	}
	
	public void testWordSizeDecrement(){
		EditText testEditTop = mActivity.topEditText;
		EditText testEditBottom = mActivity.bottomEditText;
		
		ImageView testImage = (ImageView) mActivity.findViewById(R.id.image_to_edit);
		Resources res = mActivity.getResources();
		testImage.setImageDrawable(res.getDrawable(R.drawable.bad_advice_cat));
		
		testEditTop.setText("This is a long sequence to test whether or not the font will decrement");
		testEditBottom.setText("This is a long sequence to test whether or not the font will decrement");
		
		assertTrue(testEditTop.getTextSize() < 25);
		assertTrue(testEditBottom.getTextSize() < 25);
	}
*/
}
