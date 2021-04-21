package ie.tudublin;

import java.util.ArrayList;


import processing.core.PApplet;

public class ScoreDisplay extends PApplet{
	//array list for holding instances of the note class
	ArrayList<Note> notes = new ArrayList<Note>();

	String score = "DEFGABcd";
	//String score = "D2E2F2G2A2B2c2d2";
	//String score = "DEF2F2F2EFA2A2B2AFD2E2D2D2D2";
	
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
		String type;
		for(Note n : notes)
		{
			if(n.getDuration() == 2)
			{
				type = "Crotchet";
			}
			else{
				type = "Quaver";
			}
			System.out.println(n.getNote() + "   " + n.getDuration() + "   " + type);
		}
		
	}

		
	public void drawLines()
	{
		float lineMax = height / 3;
		float lineMin = height - lineMax;
		float topBorder = height * 0.2f;
		float border = width * 0.1f;
		fill(0);
		stroke(0);
		for(int i = 0; i < 5; i ++)
		{
			float y = map(i,0,5,lineMin,lineMax);
			line(border,y,width-border, y);
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
		drawLines();
		drawNotes();
		
	}

	void drawNotes()
	{		
		float lineMax = height / 3;
		float lineMin = height - lineMax;
		float border = width * 0.1f;

		float diameter = 25;
		float radius = diameter/2;

		int i = 0;
		fill(0);
		strokeWeight(2);
		for(Note n : notes)
		{
			float x = PApplet.map(i,0,notes.size(),border, width-border);
			text(n.getNote(), x, border);
			//total available space on the y-axis is lineMin - lineMax
			float space = lineMin - lineMax;
			//finding the height of each line
			float line = space/5  + radius;
			float y = 0;

			switch(n.getNote()){
				case 'D' :
					y = lineMin + line/3;
					break;
				
				case 'E' :
					y = (lineMin - line/3) + radius;
					break;

				case 'F' :
					y = (lineMin - (2*line)/3) + radius;
					break;

				case 'G' :
					y = (lineMin - (3*line)/3) + radius;
					break;

				case 'A' :
					y = (lineMin - (4*line)/3) + radius;
					break;

				case 'B' :
					y = (lineMin - (5*line)/3) + radius;
					break;

				case 'c' :
					y = (lineMin - (6*line)/3) + radius;
					break;

				case 'd' :
					y = (lineMin - (7*line)/3) + radius;
					break;
				}

			line(x + radius, y, x + radius, y - line);
			ellipse(x,y,diameter,diameter);

			if(n.getDuration() == 1)
			{
				line(x + radius, y-line, x + (2 * radius), y - (line * 0.90f));
			}
			
			

			i = i + 1;
		}
		
	}
}
