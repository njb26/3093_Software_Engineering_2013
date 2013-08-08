/**
 * @author Niklas Bauer
 */

package com.uc.memeapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class SelectionActivity extends Activity implements OnClickListener {
	private ImageButton galleryButton;
	private ImageButton stockButton;

	/**
	 * Creates the two buttons when the activity loads
	 * 
	 * @param savedInstanceState
	 *            , passed in to the super
	 * @return void
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_selection);
		/* Button if they wish to select any image in the device's photo gallery */
		galleryButton = (ImageButton) findViewById(R.id.imgButton_gallery);
		/*
		 * Button if the user wishes to select an image provided by the app, a
		 * stock image
		 */
		stockButton = (ImageButton) findViewById(R.id.imgButton_stock);

		galleryButton.setOnClickListener(this);
		stockButton.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	/**
	 * Gracefully handle back button actions
	 */
	public void onBackPressed(){
		super.onBackPressed();
	}
		
	/**
	 * Called when either of the buttons are pressed, launches the correct
	 * activity
	 * 
	 * Swtich statement for the two buttons first is to launch the selection
	 * from the photo gallery second is to launch the stock photo selection
	 * activity
	 * 
	 * @param View
	 *            v, the view of the button that is pressed call its getId() to
	 *            verify which button it is
	 * @return void
	 */
	@Override
	public void onClick(View v) {
		Intent intent;
		switch (v.getId()) {
		case (R.id.imgButton_gallery):
			intent = new Intent(this, GalleryActivity.class);
			startActivity(intent);
			break;
		case (R.id.imgButton_stock):
			intent = new Intent(this, StockActivity.class);
			startActivity(intent);
			break;

		}

	}

}