package com.cs.flashcards;
import android.content.Context;
import android.content.res.Resources;

public class ResourceHelper
{
	public static int getResId(String variableName, Context context, Class<?> c) 
	{

		Resources r = context.getResources();
		int drawableId = r.getIdentifier(variableName, "drawable", "com.cs.flashcards");
		
		return drawableId;

    }
	
}