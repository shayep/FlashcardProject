package com.cs.flashcards;

//import java.lang.reflect.Field;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class FlashcardsOrganized extends Activity 
{
    /** Called when the activity is first created. */
    
	FlashcardsRandom myCards = new FlashcardsRandom();
	
	ResourceHelper help = new ResourceHelper();
	
	@Override
    public void onCreate(Bundle savedInstanceState) 
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button nextButton = (Button)(findViewById(R.id.nextButton));
        Button prevButton = (Button)(findViewById(R.id.prevButton));
        Button flipButton = (Button)(findViewById(R.id.flipButton));
        
        nextButton.setOnClickListener(mNextButtonListener);
        prevButton.setOnClickListener(mPrevButtonListener);
        flipButton.setOnClickListener(mFlipButtonListener);
        
        ImageView flash = (ImageView) findViewById(R.id.cardImageView);
		flash.setImageResource(R.drawable.a1);
        
        myCards.goToFront();
        
    }
    
    View.OnClickListener mNextButtonListener = new OnClickListener()
    {
    	public void onClick(View v)
    	{
    		Log.d("FlashCarsActivity", "Entered Next Click");
    		ImageView flash = (ImageView) findViewById(R.id.cardImageView);
    		flash.setImageResource(myCards.next(FlashcardsOrganized.this));
    	}
    };
    
    View.OnClickListener mPrevButtonListener = new OnClickListener()
    {
    	public void onClick(View v)
    	{
    		ImageView flash = (ImageView) findViewById(R.id.cardImageView);
    		flash.setImageResource(myCards.previous(FlashcardsOrganized.this));
    	}
    };
    
    View.OnClickListener mFlipButtonListener = new OnClickListener()
    {
    	public void onClick(View v)
    	{
            Log.d("FlashCarsActivity", "Entered Flip Click");

    		ImageView flash = (ImageView) findViewById(R.id.cardImageView);
    		flash.setImageResource(myCards.flip(FlashcardsOrganized.this));
    	}
    };
    
    
    
    /*public static int getResId(String variableName, Context context, Class<?> c) 
     * {

        	try 
        	{
            	Field idField = c.getDeclaredField(variableName);
            	return idField.getInt(idField);
        	} 
        
        	catch (Exception e) 
    	{
            e.printStackTrace();
            return -1;
        } 
    }*/
    
    
}