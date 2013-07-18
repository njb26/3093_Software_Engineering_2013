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
	
	/**
	 * -Sets the layout to be the one defined in the activity_photo_edit.xml file
	 * -Depending on which activity called it, Stock or Gallery, loads a photo
	 * 		in a different manner due to nature of how images are sent
	 * Todo's listed in order of importance:
	 * TODO:Implement ability to put text on image
	 * TODO: pass the image Uri to a "posting Activity" to be posted
	 * TODO:Implement ability to save the image
	 * @param savedInstanceState
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_photo_edit);	
		
		//caller is the activity that initiated this activity
		String caller = getIntent().getStringExtra("caller");
		ImageView displayImage = (ImageView) findViewById(R.id.image_to_edit);
		//if StockActivity
		if (caller.equals("stock")) {
			Bundle bdl = getIntent().getExtras();
			//gets index of array where stock photo is held, returns that Drawable
			int index = bdl.getInt("Index");
			displayImage.setImageResource(ImageAdapter.mThumbIds[index]);
		}
		//if GalleryActivity
		else if(caller.equals("Gallery")){
			//Uri of image is passed as a string, parses the string and loads it as a Uri
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
