package com.uc.memeapp.test;

import android.hardware.Camera;
import android.test.ActivityInstrumentationTestCase2;
import com.uc.memeapp.CameraActivity;

public class MemeAppTestCamera extends
		ActivityInstrumentationTestCase2<CameraActivity> {
	private CameraActivity mActivity;
	//private Camera mCamera = Camera; //Looking into applications of this
	private Camera.CameraInfo info = new android.hardware.Camera.CameraInfo();

	public MemeAppTestCamera() {
		super("com.uc.memeapp", CameraActivity.class);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		setActivityInitialTouchMode(false);

		mActivity = getActivity();
	}

	
	public void testCameraOrientation() {
		assertTrue(info.orientation == 0);
		try {
			super.tearDown();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void testCameraReleased(){
		
		Camera mCamera = mActivity.getCameraInstance();
		mActivity.releaseCamera();
		assertNull(mCamera);		
		
	}
	
}
