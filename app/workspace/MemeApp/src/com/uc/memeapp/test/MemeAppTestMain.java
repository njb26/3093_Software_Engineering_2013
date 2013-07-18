package com.uc.memeapp.test;

import android.app.Activity;
import android.app.Instrumentation.ActivityMonitor;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.ImageButton;

import com.uc.memeapp.CameraActivity;
import com.uc.memeapp.MainActivity;
import com.uc.memeapp.StockActivity;

public class MemeAppTestMain extends
		ActivityInstrumentationTestCase2<MainActivity> {

	private MainActivity mActivity;
	private ImageButton mSelectButton;
	private ImageButton mCameraButton;
	private ActivityMonitor activityMonitorSelection;
	ActivityMonitor activityMonitorCamera;

	public MemeAppTestMain() {
		super("com.uc.memeapp.MainActivity", MainActivity.class);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		// opens Main Activity
		mActivity = getActivity();

		setActivityInitialTouchMode(false);
		mSelectButton = (ImageButton) mActivity
				.findViewById(com.uc.memeapp.R.id.imgButton_grab);
		mCameraButton = (ImageButton) mActivity
				.findViewById(com.uc.memeapp.R.id.imgButton_take);
		
	}

	public void testOpenNextActivity() {
				
		assertNotNull(mActivity);
		// register next activity to be monitored
		activityMonitorSelection = getInstrumentation().addMonitor(
				StockActivity.class.getName(), null, false);
		activityMonitorCamera = getInstrumentation().addMonitor(
				CameraActivity.class.getName(), null, false);

		// begin to run it
		
		mActivity.runOnUiThread(new Runnable() {
			@Override			
			public void run() {
				//mSelectButton.performClick();
				 mCameraButton.performClick();
			}				
		});
		
		/*Activity nextActivity = getInstrumentation()
				.waitForMonitorWithTimeout(activityMonitorSelection,
						5000);*/
		 Activity nextActivity =
		 getInstrumentation().waitForMonitorWithTimeout(activityMonitorCamera,
		 5000);
		assertNotNull(nextActivity);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		nextActivity.finish();
	}
}
