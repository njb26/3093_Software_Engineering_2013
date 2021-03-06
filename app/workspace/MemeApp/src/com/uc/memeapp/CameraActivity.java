package com.uc.memeapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.Activity;
import android.content.Intent;
import android.hardware.Camera;
import android.hardware.Camera.PictureCallback;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageButton;

public class CameraActivity extends Activity implements OnClickListener {
	private CameraPreview mPreview;
	private Camera mCamera;
	private static final String TAG = "CameraActivity";
	protected static final int MEDIA_TYPE_IMAGE = 1;
	private ImageButton captureButton;
	public static String imagePath = "";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_camera);

		/** Capture button */
		captureButton = (ImageButton) findViewById(R.id.button_capture);
		captureButton.setOnClickListener(this);

		// Create an instance of Camera
		mCamera = getCameraInstance();

		// Create a preview view and set it as the content.
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

	public static Camera getCameraInstance() {
		Camera camera = null;
		try {
			camera = Camera.open(0);
			camera.setDisplayOrientation(90);
			System.out.println(Integer
					.toString(Camera.CameraInfo.CAMERA_FACING_FRONT));
			Log.d(CameraActivity.TAG, "getCameraInstance()open:: " + camera);
		} catch (Exception e) {
			// Catch if camera fails to open
		}
		return camera; // Returns null if camera fails to open Be sure to null
						// check!
	}

	/** Create a File for saving a new picture */
	private static File getOutputMediaFile(int type) {
		Log.d(TAG, Environment.getExternalStorageState());

		File mediaStorageDir = new File(
				Environment
						.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
				"InstaMeme");

		// This location works best if you want the created images to be shared
		// between applications and persist after your app has been uninstalled.

		/** Errs if storage directory does not exist */
		if (!mediaStorageDir.exists()) {
			if (!mediaStorageDir.mkdirs()) {
				Log.d("InstaMeme", "failed to create directory");
				return null;
			}
		}

		// Create a media file name
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss")
				.format(new Date());
		File mediaFile;
		if (type == MEDIA_TYPE_IMAGE) {
			mediaFile = new File(mediaStorageDir.getPath() + File.separator
					+ "IMG_" + timeStamp + ".jpg");
		} else {
			return null;
		}
		imagePath = mediaFile.getAbsolutePath();
		return mediaFile;
	}

	/** Actually do the saving of the object */
	private PictureCallback mPicture = new PictureCallback() {

		@Override
		public void onPictureTaken(byte[] data, Camera camera) {

			File pictureFile = getOutputMediaFile(MEDIA_TYPE_IMAGE);
			if (pictureFile == null) {
				Log.d(CameraActivity.TAG,
						"Error creating media file, check storage permissions: ");
				return;
			}
			galleryAddPic(pictureFile);
			try {
				FileOutputStream fos = new FileOutputStream(pictureFile);
				fos.write(data);
				fos.close();

			} catch (FileNotFoundException e) {
				Log.d(TAG, "File not found: " + e.getMessage());
			} catch (IOException e) {
				Log.d(TAG, "Error accessing file: " + e.getMessage());
			}
		}
	};

	/**
	 * handler method for back button use
	 */
	@Override
	public void onBackPressed() {
		super.onBackPressed();
		releaseCamera();
	}

	/**
	 * release camera on system pause
	 */
	@Override
	protected void onPause() {
		super.onPause();
		releaseCamera(); // release the camera immediately on pause event
	}

	/**
	 * releases the camera when called. This is a must to avoid crashing the
	 * application.
	 */
	public void releaseCamera() {
		if (mCamera != null) {
			mCamera.release(); // release the camera for other applications
			mCamera = null;
		}
	}

	/**
	 * resets the camera after pause
	 */
	public void resetCam() {
		mPreview = new CameraPreview(this, mCamera);
		FrameLayout preview = (FrameLayout) findViewById(R.id.camera_preview);
		preview.addView(mPreview);
	}
	/**
	 * runs the gallery scanner to find new files for a specific file.
	 * @param file
	 */

	public void galleryAddPic(File file) {

		Uri contentUri = Uri.fromFile(file);
		Intent mediaScanIntent = new Intent(
				Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, contentUri);
		sendBroadcast(mediaScanIntent);
		launchPhotoEdit(contentUri);
	}

	/**
	 * Launches photo edit activity on taking of photo
	 * @param content
	 */
	public void launchPhotoEdit(Uri content) {
		Intent mInDisplay = new Intent(CameraActivity.this,
				PhotoEditActivity.class);
		mInDisplay.putExtra("caller", "camera");
		mInDisplay.putExtra("path", content.toString());
		startActivity(mInDisplay);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case (R.id.button_capture):
			mCamera.takePicture(null, null, mPicture);
		}

	}

}
