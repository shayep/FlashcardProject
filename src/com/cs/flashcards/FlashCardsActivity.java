package com.cs.flashcards;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class FlashCardsActivity extends Activity 
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
        Button alg2button = (Button)(findViewById(R.id.alg2Button));
        Button precalcButton = (Button)(findViewById(R.id.precalcButton));
        Button xButton = (Button)(findViewById(R.id.xButton));
        
        nextButton.setOnClickListener(mNextButtonListener);
        prevButton.setOnClickListener(mPrevButtonListener);
        flipButton.setOnClickListener(mFlipButtonListener);
        alg2button.setOnClickListener(mAlg2ButtonListener);
        precalcButton.setOnClickListener(mPrecalcButtonListener);
        xButton.setOnClickListener(mXButtonListener);
        
        ImageView flash = (ImageView) findViewById(R.id.cardImageView);
		flash.setImageResource(R.drawable.select);
        
        myCards.goToFront();
        
    }
    
    View.OnClickListener mNextButtonListener = new OnClickListener()
    {
    	public void onClick(View v)
    	{
    		Log.d("FlashCarsActivity", "Entered Next Click");
    		ImageView flash = (ImageView) findViewById(R.id.cardImageView);
    		flash.setImageResource(myCards.next(FlashCardsActivity.this));
    	}
    };
    
    View.OnClickListener mPrevButtonListener = new OnClickListener()
    {
    	public void onClick(View v)
    	{
    		ImageView flash = (ImageView) findViewById(R.id.cardImageView);
    		flash.setImageResource(myCards.previous(FlashCardsActivity.this));
    	}
    };
    
    View.OnClickListener mFlipButtonListener = new OnClickListener()
    {
    	public void onClick(View v)
    	{
            Log.d("FlashCarsActivity", "Entered Flip Click");

    		ImageView flash = (ImageView) findViewById(R.id.cardImageView);
    		flash.setImageResource(myCards.flip(FlashCardsActivity.this));
    	}
    };
    
    View.OnClickListener mAlg2ButtonListener = new OnClickListener()
    {
    	public void onClick(View v)
    	{
    		myCards.setSubjectId(0);
    		ImageView flash = (ImageView) findViewById(R.id.cardImageView);
    		flash.setImageResource(myCards.next(FlashCardsActivity.this));
    	}
    };
    
    View.OnClickListener mPrecalcButtonListener = new OnClickListener()
    {
    	public void onClick(View v)
    	{
            myCards.setSubjectId(1);
    		ImageView flash = (ImageView) findViewById(R.id.cardImageView);
    		flash.setImageResource(myCards.next(FlashCardsActivity.this));
    	}
    };
    
    View.OnClickListener mXButtonListener = new OnClickListener()
    {
    	public void onClick(View v)
    	{
            myCards.setSubjectId(2);
    		ImageView flash = (ImageView) findViewById(R.id.cardImageView);
    		flash.setImageResource(myCards.next(FlashCardsActivity.this));
    	}
    };    
}