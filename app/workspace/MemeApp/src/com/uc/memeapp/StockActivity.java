package com.uc.memeapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
/**
 * Creates the gridview, and the onclicklistener for the images
 * calls the ImageAdapter class to populate the gridview
 * TODO: set it up so that more images can be displayed
 * TODO: increase sizes of images on large screen
 * TODO: add text underneath to label the images
 * @author Niklas
 *
 */
public class StockActivity extends Activity {	
		
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        // Auto-generated method stub
		 	this.requestWindowFeature(Window.FEATURE_NO_TITLE);
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_stock);
	        GridView gridview = (GridView) findViewById(R.id.gridview);
	        gridview.setAdapter(new ImageAdapter(this));

	        gridview.setOnItemClickListener(new OnItemClickListener() {
	            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
	                Intent mInDisplay=new Intent(StockActivity.this, PhotoEditActivity.class);
	                mInDisplay.putExtra("caller", "stock");
	                mInDisplay.putExtra("Index", position);
	                startActivity(mInDisplay);
	            }
	        });
	    }
	 
	 /**
	  * Gracefully handle back button actions
	  */
		public void onBackPressed(){
			super.onBackPressed();
		}

}
