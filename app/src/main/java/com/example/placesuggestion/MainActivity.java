package com.example.placesuggestion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int[] mDrawableImages ;
    int mCurrentIndex=0, random;
    String[] mPlacesName;
    ImageView mPlaceImage;
    TextView mPlaceName;
    Button mNextButton,mPreviousButton;
    Random mRandomPlace;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPlaceImage=findViewById(R.id.placeImage);
        mPlaceName=findViewById(R.id.placeName);
        mRandomPlace=new Random();
        mDrawableImages=new int[]{R.drawable.beach,R.drawable.shop,R.drawable.football,R.drawable.museum,R.drawable.park,R.drawable.walking,R.drawable.swimming};
        Resources res = getResources();
        mPlacesName = res.getStringArray(R.array.placesName);
        mPlaceImage.setImageDrawable(ContextCompat.getDrawable(this,mDrawableImages[0]));
        mPlaceName.setText(mPlacesName[0]);



    }

    public void ShowNextImage(View view){


      try {
          mCurrentIndex++;
          if(mCurrentIndex==7)mCurrentIndex=0;
          mPlaceImage.setImageDrawable(ContextCompat.getDrawable(this,mDrawableImages[mCurrentIndex]));
          mPlaceName.setText(mPlacesName[mCurrentIndex]);

      }catch (ArrayIndexOutOfBoundsException e){
          Toast.makeText(this,"The NextPlaces Finish",Toast.LENGTH_SHORT).show();
      }
    }

    public void ShowPreviousImage(View view){

        try {

            if (mCurrentIndex == 0) mCurrentIndex = 7;
            mCurrentIndex--;
            mPlaceImage.setImageDrawable(ContextCompat.getDrawable(this, mDrawableImages[mCurrentIndex]));
            mPlaceName.setText(mPlacesName[mCurrentIndex]);
        }catch (ArrayIndexOutOfBoundsException e) {
            Toast.makeText(this,"The PreviousPlaces Finish",Toast.LENGTH_SHORT).show();

        }

    }
    public void RandomPlace(View view){

        int previouse=random;
        while (previouse==random)
        {    random = mRandomPlace.nextInt(7);}

        mPlaceImage.setImageDrawable(ContextCompat.getDrawable(this, mDrawableImages[random]));
        mPlaceName.setText(mPlacesName[random]);



    }
}
