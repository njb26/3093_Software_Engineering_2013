package com.uc.memeapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class MainActivity extends Activity implements OnClickListener {
	private ImageButton takeButton;
	private ImageButton selectButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        takeButton = (ImageButton) findViewById(R.id.imgButton_take);
        selectButton = (ImageButton) findViewById(R.id.imgButton_grab);
        
        takeButton.setOnClickListener(this);
        selectButton.setOnClickListener(this);
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
		case (R.id.imgButton_grab):
			Intent intent = new Intent(this, SelectionActivity.class);
		startActivity(intent);
		break;
		
		/*case R.id.imgButton_take:
			Intent intent = new Intent(this, cameraActivity.class);
			startActivity(intent);
			break;*/
		
		}
		
	}
    
}
