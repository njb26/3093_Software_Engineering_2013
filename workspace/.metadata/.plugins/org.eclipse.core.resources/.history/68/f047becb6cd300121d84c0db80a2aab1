package com.uc.memeapp;
package com.uc.memeapp;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;

public class SelectionActivity extends Activity {
	private ImageButton galleryButton;
	private ImageButton stockButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        galleryButton = (ImageButton) findViewById(R.id.imgButton_gallery);
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


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case (R.id.imgButton_gallery):
			Intent intent = new Intent(this, GalleryActivity.class);
		startActivity(intent);
		break;
		
		/*case R.id.imgButton_stock:
			Intent intent = new Intent(this, StockActivity.class);
			startActivity(intent);
			break;*/
		
		}
		
	}
    
}