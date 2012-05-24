package com.cs.flashcards;
import java.util.*;

public class Flashcards
{
	private ArrayList<String> flashcards = new ArrayList<String>();
	private ArrayList<String> flashcardsFilled = new ArrayList<String>();
	private int counter;

	public Flashcards()
	{
		counter = 0;
	}

	public void next()
	{
		if (counter == flashcards.size()-1)
		{
			counter = 0;
		}

		else
			counter++;

		//display card at counter
	}

	public void previous()
	{
		if (counter == 0)
		{
			counter = flashcards.size()-1;
		}

		else
			counter--;

		//display card at counter
	}

	public void flip()
	{
		//counter = flashcardsFilled.get(counter)
		//display filled in flashcard at the index counter
	}
}