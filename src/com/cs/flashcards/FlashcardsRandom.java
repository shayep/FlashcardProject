package com.cs.flashcards;
import java.util.ArrayList;

import android.content.Context;
import android.graphics.drawable.Drawable;

public class FlashcardsRandom
{
	private ArrayList<String> flashcards = new ArrayList<String>();
	private ArrayList<String> flashcardsFilled = new ArrayList<String>();

	private ArrayList<Integer> temp = new ArrayList<Integer>();
	private ArrayList<Integer> tempFilled = new ArrayList<Integer>();

	private ArrayList<Integer> ints = new ArrayList<Integer>();
	
	private ArrayList<String> alg2 = new ArrayList<String>();
	private ArrayList<String> precalc = new ArrayList<String>();
	
	private ArrayList<String> alg2F = new ArrayList<String>();
	private ArrayList<String> precalcF = new ArrayList<String>();
	
	private ArrayList<String> x1 = new ArrayList<String>();
	private ArrayList<String> x1F = new ArrayList<String>();
	
	private ResourceHelper help = new ResourceHelper();
	
	private int subjectId;
	
	boolean sides = false;


	private int counter;
	private int length;
	private int numCards;

	public FlashcardsRandom()
	{
		
		counter = (int)(Math.random() * flashcards.size());
		ints.add(counter, 0);
		numCards = 0;
		subjectId = 0; //0 = algebra, 1 = precalc,  2 = authors
		
		String[] names = {"blue", "green", "lavender", "magenta", "orange", "purple", "robinsegg", "scarlet",
				"teal", "yellow"};
		
		String[] namesFlip = {"blueflip", "greenflip", "lavenderflip", "magentaflip", "orangeflip",
				"purpleflip", "robinseggflip", "scarletflip", "tealflip", "yellowflip"};
		
		String[] c1 = {"select", "a1", "a2", "a3", "a4", "a5", "a6", "a7", "a8", "a9", "a10"};
		String[] c2 = {"absvalineqblank", "arithseqblank", "arithseriesblank", "comnumblank", "factorpatternsblank",
				"geoseqblank", "geoseriesblank", "halfangleidblank", "ingeoserblank", "lawcosiblank",
				"lawcosiiblank", "probabilityblank", "proprnumblank", "quadeqblank", "relfuncblank"};
		
		String[] c1f = {"select", "a1filled", "a2filled", "a3filled", "a4filled", "a5filled", 
				"a6filled", "a7filled", "a8filled", "a9filled", "a10filled"};
		String[] c2f = {"absvalineq", "arithseq", "arithseries", "comnum", "factorpatterns",
				"geoseq", "geoseries", "halfangleid", "ingeoser", "lawcosi",
				"lawcosii", "probability", "proprnum", "quadeq", "relfunc"};
		
		String[] x1N = {"header"};
		
		for (int i=0; i<names.length; i++)
		{
			flashcards.add(names[i]);
			flashcardsFilled.add(namesFlip[i]);
		}
		
		for (int j=0; j<c1.length; j++)
		{
			alg2.add(c1[j]);
			alg2F.add(c1f[j]);
		}
		
		for (int k=0; k<c2.length; k++)
		{
			precalc.add(c2[k]);
			precalcF.add(c2f[k]);
		}

		for (int k=0; k<x1N.length; k++)
		{
			x1.add(x1N[k]);
			x1F.add(x1N[k]);
		}
		
		length = alg2.size();
		temp.add(0);

	}

	public int next(Context context)
	{
		numCards++;
		
		if (subjectId == 2)
			counter = (int)((Math.random() * length));
		else
			counter = (int)(Math.random() * (length - 1) + 1);
		
			temp.add(counter);
			goToFront();
	
		return getSide(context);

	}
	
	public void goToFront()
	{
		if (sides)
		{
			sides = false;
		}
	}
	
	public void setSubjectId(int x)
	{

		if (x == 0)
			length = alg2.size();
		else if (x == 1)
			length = precalc.size();
		else
			length = x1.size();
		
		temp.add(0);
		
		subjectId = x;
	}

	public int previous(Context context)
	{
		numCards--;
		
		if (temp.size() > 1)
			temp.remove(temp.size()-1);
	
	
		counter = temp.get(temp.size() - 1);
		
		goToFront();
		
		return getSide(context);
	}

	public int getSide(Context context)
	{
		int resId = 0;
		if (sides == false)
		{
			if (subjectId == 0) {
				String n = alg2.get(counter);
				resId = ResourceHelper.getResId(n, context, Drawable.class);
			} else if (subjectId == 1) {
				String n = precalc.get(counter);
				resId = ResourceHelper.getResId(n, context, Drawable.class);			
			} else {
				String n = x1.get(counter);
				resId = ResourceHelper.getResId(n, context, Drawable.class);							
			}
		}
		
		else 
		{
			if (subjectId == 0) {
				String n = alg2F.get(counter);
				resId = ResourceHelper.getResId(n, context, Drawable.class);
			} else if (subjectId == 1) {
				String n = precalcF.get(counter);
				resId = ResourceHelper.getResId(n, context, Drawable.class);			
			} else {
				String n = x1F.get(counter);
				resId = ResourceHelper.getResId(n, context, Drawable.class);							
			}

			// String n = flashcardsFilled.get(counter);
			// resId = ResourceHelper.getResId(n, context, Drawable.class);
		}
		
		return resId;
	}
	
	public int flip(Context context)
	{
		if (sides)
			sides = false;
		else
			sides = true;
		
		return getSide(context);
	}
	
	public void add(String s)
	{
		if (subjectId == 0) {
			alg2.add(s);
		} else if (subjectId == 1) {
			precalc.add(s);
		} else {
			x1.add(s);
		}

	}
	
	public void addFilled(String s)
	{
		if (subjectId == 0) {
			alg2F.add(s);
		} else if (subjectId == 1) {
			precalcF.add(s);
		} else {
			x1F.add(s);
		}
	}
}