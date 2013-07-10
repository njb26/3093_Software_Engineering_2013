package com.uc.memeapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;



public class StockActivity extends Activity implements OnClickListener {
	
	//** I know this  is bad code and isn't scalable. I will fix this, I just want it functional just so I can test it/
		private ImageButton stock01; private ImageButton stock02; private ImageButton stock03;
		private ImageButton stock04; private ImageButton stock05; private ImageButton stock06;
		private ImageButton stock07; private ImageButton stock08; private ImageButton stock09;
		private ImageButton stock10; private ImageButton stock11; private ImageButton stock12;
		private ImageButton stock13; private ImageButton stock14; private ImageButton stock15;
		private ImageButton stock16; private ImageButton stock17; private ImageButton stock18;
		private ImageButton stock19; private ImageButton stock20; private ImageButton stock21;
		private ImageButton stock22; private ImageButton stock23; private ImageButton stock24;
		private ImageButton stock25; private ImageButton stock26; private ImageButton stock27;
		
		
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_stock);
		
		stock01 = (ImageButton)findViewById(R.id.stock01); stock09 = (ImageButton)findViewById(R.id.stock09);
		stock02 = (ImageButton)findViewById(R.id.stock02); stock10 = (ImageButton)findViewById(R.id.stock10);
		stock03 = (ImageButton)findViewById(R.id.stock03); stock11 = (ImageButton)findViewById(R.id.stock11);
		stock04 = (ImageButton)findViewById(R.id.stock04); stock12 = (ImageButton)findViewById(R.id.stock12);
		stock05 = (ImageButton)findViewById(R.id.stock05); stock13 = (ImageButton)findViewById(R.id.stock13);
		stock06 = (ImageButton)findViewById(R.id.stock06); stock14 = (ImageButton)findViewById(R.id.stock14);
		stock07 = (ImageButton)findViewById(R.id.stock07); stock15 = (ImageButton)findViewById(R.id.stock15);
		stock08 = (ImageButton)findViewById(R.id.stock08); stock16 = (ImageButton)findViewById(R.id.stock16);
		
		stock17 = (ImageButton)findViewById(R.id.stock17); stock23 = (ImageButton)findViewById(R.id.stock23);
		stock18 = (ImageButton)findViewById(R.id.stock18); stock24 = (ImageButton)findViewById(R.id.stock24);
		stock19 = (ImageButton)findViewById(R.id.stock19); stock25 = (ImageButton)findViewById(R.id.stock25);
		stock20 = (ImageButton)findViewById(R.id.stock20); stock26 = (ImageButton)findViewById(R.id.stock26);
		stock21 = (ImageButton)findViewById(R.id.stock21); stock27 = (ImageButton)findViewById(R.id.stock27);
		stock22 = (ImageButton)findViewById(R.id.stock22);
		
		stock01.setOnClickListener(this); 
		stock10.setOnClickListener(this); stock19.setOnClickListener(this);
		stock02.setOnClickListener(this); stock11.setOnClickListener(this); stock20.setOnClickListener(this);
		stock03.setOnClickListener(this); stock12.setOnClickListener(this); stock21.setOnClickListener(this); 
		stock04.setOnClickListener(this); stock13.setOnClickListener(this); stock22.setOnClickListener(this);
		stock05.setOnClickListener(this); stock14.setOnClickListener(this); stock23.setOnClickListener(this);
		stock06.setOnClickListener(this); stock15.setOnClickListener(this); stock24.setOnClickListener(this);
		stock07.setOnClickListener(this); stock16.setOnClickListener(this); stock25.setOnClickListener(this);
		stock08.setOnClickListener(this); stock17.setOnClickListener(this); stock26.setOnClickListener(this);
		stock09.setOnClickListener(this); stock18.setOnClickListener(this); stock27.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.stock, menu);
		return true;
	}
	
	@Override
	public void onClick(View v) {
		/** Switch case for the two buttons, imgButton_grab will let launch the activity
		 * to select (grab) a photo from internal memory
		 * imgButton_take will launch the activity to take a photograph		
		 */
		Intent photoIntent = new Intent(this, PhotoEditActivity.class);
		int message = v.getId();
		photoIntent.putExtra("photo", message);
		startActivity(photoIntent);			
		
	}

}
