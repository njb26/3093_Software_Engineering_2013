package com.uc.memeapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

public class StockActivity extends Activity {	
		
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        // TODO Auto-generated method stub
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
	

}
