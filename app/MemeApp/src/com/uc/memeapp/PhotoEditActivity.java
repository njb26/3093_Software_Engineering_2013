/**
 /* @author Niklas Bauer
 */
package com.uc.memeapp;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.widget.EditText;
import android.widget.ImageView;

public class PhotoEditActivity extends Activity {
	public int topMaxLines = 3;
	public int bottomMaxLines = 3;
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
		
			EditText topEditText= (EditText) findViewById(R.id.topInputText);
			EditText bottomEditText= (EditText) findViewById(R.id.bottomInputText);
			
			topEditText.setHorizontallyScrolling(false);
			topEditText.setMaxLines(topMaxLines);
			topEditText.setTextSize(25);
			//topEditText.setInputType(0x00001001);
			
			bottomEditText.setMaxLines(bottomMaxLines);
			bottomEditText.setHorizontallyScrolling(false);			
			bottomEditText.setTextSize(25);
			//bottomEditText.setInputType(0x00001001);
		
			topEditText.addTextChangedListener(new TextWatcher() {
				
				EditText topEditText= (EditText) findViewById(R.id.topInputText);

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                    int after) {}

            @Override
            public void afterTextChanged(Editable s) {
            	int currLineCount = topEditText.getLineCount();
            	if(currLineCount > topMaxLines){
            		topMaxLines++;
            		topEditText.setMaxLines(topMaxLines);
            		topEditText.setTextSize((float) 75/topMaxLines);
            	}
            	

            }
        });
			
			bottomEditText.addTextChangedListener(new TextWatcher() {
				
				EditText bottomEditText= (EditText) findViewById(R.id.bottomInputText);

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                    int after) {}

            @Override
            public void afterTextChanged(Editable s) {
            	int currLineCount = bottomEditText.getLineCount();
            	if(currLineCount > bottomMaxLines){
            		bottomMaxLines++;
            		bottomEditText.setMaxLines(bottomMaxLines);
            		bottomEditText.setTextSize((float) 75/bottomMaxLines);
            	}

            }
        });

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.photo_edit, menu);
		return true;
	}

}
