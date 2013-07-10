/**
 /* @author Niklas Bauer
 */
package com.uc.memeapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ImageView;

public class PhotoEditActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_photo_edit);
		Intent receivedPhotoIntent = getIntent();
		int receivedMessage = receivedPhotoIntent.getIntExtra("photo", 1);
		Drawable imageToDisplay = getResources().getDrawable(receivedMessage);
		ImageView displayImage = (ImageView)findViewById(R.id.image_to_edit);
		displayImage.setImageDrawable(imageToDisplay);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.photo_edit, menu);
		return true;
	}

}
