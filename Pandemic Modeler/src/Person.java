/**
 * Program Name: Person.java
 * Purpose: This class will hold the information for each person on screen.
 * Coder: Elkhai Nagawkar (1115993) for Sec 04
 * Date: Jul 25, 2024
 */
import java.awt.*;

public class Person
{
	private int xCoord;
	private int yCoord;
	private int diam;
	private Color color;
	
	private int xIncrement;
	private int yIncrement;
	
	public Person(int diam, Color color, int widthValue, int heightValue) {

		int randomX, randomY;
		this.diam = diam;
		this.color = color;
		
		boolean loopflag1 = true;
		
	  //loop 
		while(loopflag1)
		{
			//generate a random value using widthValue
			randomX = (int)(Math.random() * widthValue);
			if(randomX >= 0 && randomX <= widthValue - this.diam)
			{
				//we have a valid x value, assign it to xCoord
				this.xCoord = randomX;
				//System.out.println("STUB:Valid random xCoord value of " + randomX);
				loopflag1 = false;
			}
		}//end while
		
		loopflag1 = true;
		while(loopflag1)
		{
			//repeat for yCoord
			randomY = (int)(Math.random() * heightValue);
			if(randomY >= 0 && randomY <= heightValue - this.diam)
			{
				//we have a valid y value, assign it to yCoord
				this.yCoord = randomY;
				//System.out.println("STUB:Valid random yCoord value of " + randomY);
			  loopflag1 = false;
			}
		}//end while
		
		boolean loopFlag = true;
		while(loopFlag)
		{
			this.xIncrement = (int)(Math.random()*11 - 5);
			this.yIncrement = (int)(Math.random()*11 - 5);
			//Changed HERE REMEMBER IF DOES NOT WORK yIncrement to xIncrement in if
			if(this.xIncrement ==0 && this.xIncrement ==0)
			{
			  //run it again
				this.xIncrement = (int)(Math.random()*11 - 5);
				this.yIncrement = (int)(Math.random()*11 - 5);
			}
			else
			{
				loopFlag = false;
			}
		}//end loop
	}//end constructor

	public int getxCoord()
	{
		return xCoord;
	}

	public void setxCoord(int xCoord)
	{
		this.xCoord = xCoord;
	}

	public int getyCoord()
	{
		return yCoord;
	}

	public void setyCoord(int yCoord)
	{
		this.yCoord = yCoord;
	}

	public int getDiam()
	{
		return diam;
	}

	public void setDiam(int diam)
	{
		this.diam = diam;
	}

	public Color getColor()
	{
		return color;
	}

	public void setColor(Color color)
	{
		this.color = color;
	}

	public int getxIncrement()
	{
		return xIncrement;
	}

	public void setxIncrement(int xIncrement)
	{
		this.xIncrement = xIncrement;
	}

	public int getyIncrement()
	{
		return yIncrement;
	}

	public void setyIncrement(int yIncrement)
	{
		this.yIncrement = yIncrement;
	}
	
	
}
//end class
