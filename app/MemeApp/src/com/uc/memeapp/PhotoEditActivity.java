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
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

public class PhotoEditActivity extends Activity implements OnClickListener {
	public int topMaxLines = 3;
	public int bottomMaxLines = 3;
	public EditText topEditText;
	public EditText bottomEditText;
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
		//if GalleryActivity or if camera activity
		else if(caller.equals("Gallery") || caller.equals("camera")){
			//Uri of image is passed as a string, parses the string and loads it as a Uri
			 String receivedPath = getIntent().getStringExtra("path");
			 Uri receivedUri = Uri.parse(receivedPath);
			 displayImage.setImageURI(receivedUri);
		}
		
			ImageButton deleteButton = (ImageButton) findViewById(R.id.imgButton_delete);
			deleteButton.setOnClickListener(this);
			
			//Create the two editText objects
			topEditText= (EditText) findViewById(R.id.topInputText);
			bottomEditText= (EditText) findViewById(R.id.bottomInputText);
			
			//cant scroll right, number of lines, and font size set
			topEditText.setHorizontallyScrolling(false);
			topEditText.setMaxLines(topMaxLines);
			topEditText.setTextSize(25);
			
			bottomEditText.setMaxLines(bottomMaxLines);
			bottomEditText.setHorizontallyScrolling(false);			
			bottomEditText.setTextSize(25);
		
			topEditText.addTextChangedListener(new TextWatcher() {
				
				EditText topEditText= (EditText) findViewById(R.id.topInputText);

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                    int after) {}

            //if font goes past max lines, decrement font and increase number of lines
            //more lines of text at a smaller size now allowed to be typed in
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
			//same as for the top EditText
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
	public void onClick(View v) {
		switch(v.getId()){
		case(R.id.imgButton_delete):{
			topEditText.setText("");
			bottomEditText.setText("");
		}
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.photo_edit, menu);
		return true;
	}

}
