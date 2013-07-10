package com.uc.memeapp;

import java.io.Console;

import android.hardware.Camera;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.widget.FrameLayout;

public class CameraActivity extends Activity {
private CameraPreview mPreview;
private Camera mCamera;
private static final String TAG = "CameraActivity";

private static android.hardware.Camera.CameraInfo info = new android.hardware.Camera.CameraInfo();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_camera);
		
		// Create an instance of Camera
		mCamera = getCameraInstance();
		
		//Create a preview view and set it as the content.
		mPreview = new CameraPreview(this, mCamera);
		FrameLayout preview = (FrameLayout) findViewById(R.id.camera_preview);
		preview.addView(mPreview);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.camera, menu);
		return true;
	}
	
	public static Camera getCameraInstance(){
		Camera camera = null;
		try{
			camera = Camera.open(0);
			camera.setDisplayOrientation(90);
			System.out.println(Integer.toString(Camera.CameraInfo.CAMERA_FACING_FRONT));
			Log.d(CameraActivity.TAG, "getCameraInstance()open:: " + camera);
		}
		catch(Exception e){
			//Catch if camera fails to open
		}
		return camera; //Returns null if camera fails to open Be sure to null check!
	}

}