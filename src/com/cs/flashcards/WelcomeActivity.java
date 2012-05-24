package com.cs.flashcards;

//import java.lang.reflect.Field;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class WelcomeActivity extends Activity 
{
    /** Called when the activity is first created. */
    
	FlashcardsRandom myCards = new FlashcardsRandom();
	private static String choice = "id";
	
	ResourceHelper help = new ResourceHelper();
	
	@Override
    public void onCreate(Bundle savedInstanceState) 
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button alg2button = (Button)(findViewById(R.id.alg2button));
        Button precalcbutton = (Button)(findViewById(R.id.precalcbutton));
        //Button flipButton = (Button)(findViewById(R.id.flipButton));
        
        alg2button.setOnClickListener(mAlgebra2Listener);
        precalcbutton.setOnClickListener(mPrecalculusListener);
        //flipButton.setOnClickListener(mFlipButtonListener);
        
        ImageView flash = (ImageView) findViewById(R.id.cardImageView);
		flash.setImageResource(R.drawable.a1);
        
        myCards.goToFront();
        
    }
	
	View.OnClickListener mAlgebra2Listener = new OnClickListener()
    {
    	public void onClick(View v)
    	{
    		Log.d("WelcomeActivity", "Entered Next Click");
    		Long j = 0L;
    		startFlashcards(j);
    		
    	}
    };
    
    View.OnClickListener mPrecalculusListener = new OnClickListener()
    {
    	public void onClick(View v)
    	{
    		Long k = 1L;
    		startFlashcards(k);
    	}
    };
    
   /* View.OnClickListener mFlipButtonListener = new OnClickListener()
    {
    	public void onClick(View v)
    	{
            Log.d("FlashCarsActivity", "Entered Flip Click");

    		ImageView flash = (ImageView) findViewById(R.id.cardImageView);
    		flash.setImageResource(myCards.flip(WelcomeActivity.this));
    	}
    };*/
    
    public void startFlashcards(Long x)
    {
    	Intent i = new Intent(this, FlashCardsActivity.class);
    	i.putExtra(choice, x);
    	
    	startActivity(i);
    	
    }
    
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