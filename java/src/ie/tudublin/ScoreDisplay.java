package ie.tudublin;

import java.util.ArrayList;


import processing.core.PApplet;

public class ScoreDisplay extends PApplet{
	//array list for holding instances of the note class
	ArrayList<Note> notes = new ArrayList<Note>();

	//String score = "DEFGABcd";
	//String score = "D2E2F2G2A2B2c2d2";
	String score = "DEF2F2F2EFA2A2B2AFD2E2D2D2D2";
	
	public void settings()
	{
		size(1000, 500);

		// How to convert a character to a number
		char c = '7'; // c holds the character 7 (55)
		int i = c - '0'; // i holds the number 7 (55 - 48) 
		println(i);
	}

	public void loadScore(){
		//populating the array list with contents of the string score
		int length = score.length();
		int duration;
		for(int i=0; i<length; i++)
		{
			char note = score.charAt(i);
			//length - 1 to keep the array in bounds
			if(i < length - 1 && Character.isDigit(score.charAt(i+1)) == true)
			{
				duration = 2;
				i = i + 1; //this will skip the number that follows the note
			}
			else {
				duration = 1;
			}


			Note n = new Note(note,duration);
			notes.add(n);
		}
	}

	public void printScores()
	{
		for(Note n : notes)
		{
			println(n);
		}
	}

	public void setup() 
	{
		loadScore();
		printScores();
		
	}

	public void draw()
	{
		background(255);
		
	}

	void drawNotes()
	{
	}
}
