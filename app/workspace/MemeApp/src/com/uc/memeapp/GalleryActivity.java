/**
 * @author Niklas Bauer
 */
package com.uc.memeapp;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

    public class GalleryActivity extends Activity {

    //not used... yet	
    Bitmap selectedContactPicture;    

    /** Called when the activity is first created. */
     @Override
     public void onCreate(Bundle savedInstanceState) {
    	 super.onCreate(savedInstanceState);
    	 setContentView(R.layout.activity_gallery);
    	 
    	 /* Creates the intent to select content from the device*/
    	 Intent photoPickerIntent = new Intent(Intent.ACTION_GET_CONTENT);
    	 /*Wants to select an image*/
    	 photoPickerIntent.setType("image/*");
    	 /**
    	  * Launches activity to then select an image
    	  * Done in onActivityResult
    	  */
    	 startActivityForResult(photoPickerIntent,1); 
     }
     /**
      * Activity for photograph selection is launched
      * @param requestCode , what type of action is taken, in this case ACTION_GET_CONTENT
      * @param resultCode , if the action is completed
      * @param imageReturnedIntent , the image that the user has selected 
      *  */
     @Override
     protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) 
     { 
         super.onActivityResult(requestCode, resultCode, imageReturnedIntent); 
             if(resultCode == RESULT_OK)
             {
            	 /**opens the selection activity for photographs*/
                Uri selectedImage = imageReturnedIntent.getData();
                // InputStream imageStream = null;
                Cursor cursor = getContentResolver().query(selectedImage, new String[] { android.provider.MediaStore.Images.ImageColumns.DATA }, null, null, null);
                cursor.moveToFirst();
                cursor.close();
                //commented out, approaching it in a different method, the one used above 
                /* try 
                 {
                     imageStream = getContentResolver().openInputStream(imageReturnedIntent.getData());
                 } 
                catch (FileNotFoundException e) 
                {
                  e.printStackTrace();
                 }

                 BitmapFactory.Options options = new BitmapFactory.Options();
                 options.inSampleSize =8;

                 selectedContactPicture = BitmapFactory.decodeStream(imageStream,null,options);
                 setContactPicture.setBackgroundDrawable(new BitmapDrawable(selectedContactPicture)); */
             }
             //if result is not ok... kinda self explanatory
             else{
            	 throw new IllegalArgumentException("Activity did not return a picture");
             }
            }
         
     
    /** 
     * for the two buttons, accept, and take another photo
     * */
    public void onClick(View v) {
		switch(v.getId()){
			/* Select, or loads, the image on to the PhotoEditActivity so that the user can add text*/
			case (R.id.load_image):
				Intent intent = new Intent(this, PhotoEditActivity.class);
				startActivity(intent);
				break;
			/* If the user did not like the selected image, then it will relaunch the selection*/
			case(R.id.get_new_image):
				Intent photoPickerIntent = new Intent(Intent.ACTION_GET_CONTENT);
	    	 	photoPickerIntent.setType("image/*");
				startActivityForResult(photoPickerIntent, 1);
				break;
		
		}
    }
}
    