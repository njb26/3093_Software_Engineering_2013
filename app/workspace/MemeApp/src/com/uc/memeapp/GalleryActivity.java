package com.uc.memeapp;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

    public class GalleryActivity extends Activity {

    Bitmap selectedContactPicture;
    

     /** Called when the activity is first created. */
     @Override
     public void onCreate(Bundle savedInstanceState) {
    	 Intent photoPickerIntent = new Intent(Intent.ACTION_GET_CONTENT);
    	 photoPickerIntent.setType("image/*");
    	 startActivityForResult(photoPickerIntent,1); 
     }

     @Override
     protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) 
     { 
         super.onActivityResult(requestCode, resultCode, imageReturnedIntent); 

             if(resultCode == RESULT_OK)
             {  
                 Uri selectedImage = imageReturnedIntent.getData();
                // InputStream imageStream = null;
                Cursor cursor = getContentResolver().query(selectedImage, new String[] { android.provider.MediaStore.Images.ImageColumns.DATA }, null, null, null);
                cursor.moveToFirst();
                cursor.close();
                 // try 
                 //{
                   //  imageStream = getContentResolver().openInputStream(imageReturnedIntent.getData());
                 //} 
                 //catch (FileNotFoundException e) 
                 //{
                   //  e.printStackTrace();
                // }

                 //BitmapFactory.Options options = new BitmapFactory.Options();
                 //options.inSampleSize =8;

               //  selectedContactPicture = BitmapFactory.decodeStream(imageStream,null,options);
                // setContactPicture.setBackgroundDrawable(new BitmapDrawable(selectedContactPicture));
             }
         
     }
    
    public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
			case (R.id.load_image):
				Intent intent = new Intent(this, PhotoEditActivity.class);
				startActivity(intent);
				break;
			case(R.id.get_new_image):
				Intent photoPickerIntent = new Intent(Intent.ACTION_GET_CONTENT);
	    	 	photoPickerIntent.setType("image/*");
				startActivityForResult(photoPickerIntent, 1);
				break;
		
		}
    }
}
    