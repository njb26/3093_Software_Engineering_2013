package com.uc.memeapp;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.mindspiker.mstwitter.MSTwitter;
import com.mindspiker.mstwitter.MSTwitter.MSTwitterResultReceiver;


public class TestActivity extends Activity implements OnClickListener {
	private String mImagePath = "";
	/**
	 * Consumer Key generated when you registered your app at
	 * https://dev.twitter.com/apps/
	 */
	public static final String CONSUMER_KEY = "gXOzF2ixLR9lfOsj0u0W7Q";
	/**
	 * Consumer Secret generated when you registered your app at
	 * https://dev.twitter.com/apps/
	 */
	public static final String CONSUMER_SECRET = "nNbLXptxNbRtODd48GMyVP19VnmmqKTBe1uNIvxxwU";
	/** module level variables used in different parts of this module */
	private static final String TAG = "TestActivity:: ";
	private MSTwitter mMSTwitter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_test);
		try {
			System.loadLibrary("MSTwitter");
			System.loadLibrary("twitter4j-core-3.0.3-javadoc");
			System.loadLibrary("twitter4j-core-3.0.3-sources");
		} catch (UnsatisfiedLinkError e) {
			Log.e(TAG, e.toString());
		}
		ImageView displayImage = (ImageView) findViewById(R.id.test);
		byte[] byteArray = getIntent().getByteArrayExtra("testtest");
		mImagePath = getIntent().getStringExtra("Path");
		Bitmap caller = BitmapFactory.decodeByteArray(byteArray, 0,
				byteArray.length);
		displayImage.setImageBitmap(caller);

		// setup button to call local tweet() function
		ImageButton tweetButton = (ImageButton) findViewById(R.id.post_Button);
		tweetButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				tweet();
			}
		});
		
		 final EditText tweetEditText = (EditText) findViewById(R.id.editText1);
		 tweetEditText.setOnClickListener(new OnClickListener(){
			 @Override
			 public void onClick(View v){
				if(v.getId() == R.id.editText1)
				{
						tweetEditText.setText("");
				}
			 }
		 });

		// button to go to MainActivity
		Button returnButton = (Button) findViewById(R.id.homeButton);
		returnButton.setOnClickListener(this);

		// make a MSTwitter event handler to receive tweet send events
		MSTwitterResultReceiver myMSTReceiver = new MSTwitterResultReceiver() {
			@Override
			public void onRecieve(int tweetLifeCycleEvent, String tweetMessage) {
				handleTweetMessage(tweetLifeCycleEvent, tweetMessage);
			}
		};

		// create module level MSTwitter object.
		// This object can be destroyed and recreated without interrupting the
		// send tweet process.
		// So no need to save and pass back in savedInstanceState bundle.
		mMSTwitter = new MSTwitter(this, CONSUMER_KEY, CONSUMER_SECRET,
				myMSTReceiver);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// This MUST MUST be done for authorization to work.
		mMSTwitter.onCallingActivityResult(requestCode, resultCode, data);
	}

	/**
	 * Send tweet using MSTwitter object created in onCreate()
	 */
	private void tweet() {
		// assemble data

		// get text from layout control
		 EditText tweetEditText = (EditText) findViewById(R.id.editText1);
		String textToTweet = tweetEditText.getText().toString();
		

		// use MSTwitter function to save image to file because startTweet()
		// takes an image path
		

		// start the tweet
		mMSTwitter.startTweet(textToTweet, mImagePath);
	}

	@SuppressLint("SimpleDateFormat")
	private void handleTweetMessage(int event, String message) {

		String note = "";
		switch (event) {
		case MSTwitter.MSTWEET_STATUS_AUTHORIZING:
			note = "Authorizing app with twitter.com";
			break;
		case MSTwitter.MSTWEET_STATUS_STARTING:
			note = "Tweet data send started";
			break;
		case MSTwitter.MSTWEET_STATUS_FINSIHED_SUCCCESS:
			note = "Tweet sent successfully";
			break;
		case MSTwitter.MSTWEET_STATUS_FINSIHED_FAILED:
			note = "Tweet failed:" + message;
			break;
		}

		// add note to results TextView
		SimpleDateFormat timeFmt = new SimpleDateFormat("h:mm:ss.S");
		String timeS = timeFmt.format(new Date());
		TextView resultsTV = (TextView) findViewById(R.id.resultsTextView);
		resultsTV.setText(resultsTV.getText() + "\n[Message received at "
				+ timeS + "]\n" + note);
	}

	@Override
	public void onClick(View v) {
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.test, menu);
		return true;
	}

}
