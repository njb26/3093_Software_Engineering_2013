/**
 /* @author Niklas Bauer
 */
package com.uc.memeapp;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ImageView;

public class PhotoEditActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_photo_edit);		
		String caller = getIntent().getStringExtra("caller");
		ImageView displayImage = (ImageView) findViewById(R.id.image_to_edit);
		if (caller.equals("stock")) {
			Bundle bdl = getIntent().getExtras();
			int index = bdl.getInt("Index");
			displayImage.setImageResource(ImageAdapter.mThumbIds[index]);
		}
		else if(caller.equals("Gallery")){
			 String receivedPath = getIntent().getStringExtra("path");
			 Uri receivedUri = Uri.parse(receivedPath);
			 displayImage.setImageURI(receivedUri);
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.photo_edit, menu);
		return true;
	}

}
