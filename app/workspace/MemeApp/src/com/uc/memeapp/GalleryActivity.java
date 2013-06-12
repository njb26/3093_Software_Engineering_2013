package com.uc.memeapp;

import java.io.FileNotFoundException;
import java.io.InputStream;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;

    public class GalleryActivity extends Activity {

    Bitmap selectedContactPicture;
    

     /** Called when the activity is first created. */
     @Override
     public void onCreate(Bundle savedInstanceState) {
    	 Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
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
                 InputStream imageStream = null;
                 try 
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
                // setContactPicture.setBackgroundDrawable(new BitmapDrawable(selectedContactPicture));
             }
         
     }
    }