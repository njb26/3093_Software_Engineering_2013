package com.uc.memeapp;

import android.hardware.Camera;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class CameraActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_camera);
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
			camera = Camera.open();
		}
		catch(Exception e){
			//Catch if camera fails to open
		}
		return camera; //Returns null if camera fails to open Be sure to null check!
	}

}