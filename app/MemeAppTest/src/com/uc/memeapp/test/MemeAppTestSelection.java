package com.uc.memeapp.test;

import android.app.Activity;
import android.app.Instrumentation.ActivityMonitor;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.ImageButton;

import com.uc.memeapp.GalleryActivity;
import com.uc.memeapp.SelectionActivity;
import com.uc.memeapp.StockActivity;

public class MemeAppTestSelection extends ActivityInstrumentationTestCase2<SelectionActivity>{

	private SelectionActivity mActivity;
	private ImageButton mGalleryButton;
	private ImageButton mStockButton;
	private ActivityMonitor activityMonitorStock;
	private ActivityMonitor activityMonitorGallery;
	
	public MemeAppTestSelection() {
		super("com.uc.memeapp.SelectionActivity", SelectionActivity.class);
	}
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		// opens Main Activity
		mActivity = getActivity();

		setActivityInitialTouchMode(false);
		mGalleryButton = (ImageButton) mActivity
				.findViewById(com.uc.memeapp.R.id.imgButton_gallery);
		mStockButton = (ImageButton) mActivity
				.findViewById(com.uc.memeapp.R.id.imgButton_stock);
		
	}

	public void testOpenNextActivity() {
				
		assertNotNull(mActivity);
		// register next activity to be monitored
		activityMonitorGallery = getInstrumentation().addMonitor(
				GalleryActivity.class.getName(), null, false);
		activityMonitorStock= getInstrumentation().addMonitor(
				StockActivity.class.getName(), null, false);

		// begin to run it
		
		mActivity.runOnUiThread(new Runnable() {
			@Override			
			public void run() {
				//mStockButton.performClick();
				 mGalleryButton.performClick();
			}				
		});
		
		/*Activity nextActivity = getInstrumentation()
				.waitForMonitorWithTimeout(activityMonitorStock,
						5000);*/
		 Activity nextActivity =
		 getInstrumentation().waitForMonitorWithTimeout(activityMonitorGallery,
		 10000);
		 
		assertNotNull(nextActivity);
		nextActivity.finish();
	}
}








	

	
	