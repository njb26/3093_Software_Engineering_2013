package com.uc.memeapp;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ImageView;

public class TestActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test);
		
		ImageView displayImage = (ImageView) findViewById(R.id.test);
		byte[] byteArray = getIntent().getByteArrayExtra("testtest");
		Bitmap caller = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
		displayImage.setImageBitmap(caller);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.test, menu);
		return true;
	}

}
