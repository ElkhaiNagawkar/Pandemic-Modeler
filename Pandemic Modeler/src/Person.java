/**
 * Program Name: Person.java
 * Purpose: This class will hold the information for each person on screen.
 * Coder: Elkhai Nagawkar (1115993) for Sec 04, Bruno Magalhaes (1132360) section 3
 * Date: Jul 25, 2024
 */
import java.awt.*;

public class Person
{
	private int xCoord;
	private int yCoord;
	private int diam;
	private Color color;
	
	/*
	 * Immunity status explained:
	 * 1 = 20% immunity (no Vaccine 80% to get infected)
	 * 2 = 40% immunity (one Vaccine 60% to get infected)
	 * 3 = 60% immunity (natural Immunity 40% to get re-infected)
	 * 4 = 70% immunity (two Vaccine 30% to get infected)
	 * 5 = 90% immunity (three Vaccine 10% to get infected)
	 * */
	private int immunityStatus;
	private boolean isAlive;
	private boolean isInfected;
	//This variable means if a person has been re-infected after recovering
	private boolean hasBeenInfected;
	private int cycleCounter;

	private int xIncrement;
	private int yIncrement;
	
	public Person(int diam, Color color, int widthValue, int heightValue, int immunityStatus, boolean isInfected, boolean isAlive) {

		int randomX, randomY;
		this.diam = diam;
		this.color = color;
		this.immunityStatus = immunityStatus;
		this.isAlive = isAlive;
		this.isInfected = isInfected;
		this.cycleCounter = 0;
		this.hasBeenInfected = false;

		
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
			
			if(this.xIncrement ==0 && this.yIncrement ==0)
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
	
	public boolean getIsAlive()
	{
		return isAlive;
	}

	public void setAlive(boolean isAlive)
	{
		if(!isAlive) {
			this.isInfected=false;
		}
		this.isAlive = isAlive;
	}

	public boolean isInfected()
	{
		return isInfected;
	}

	public void setInfected(boolean isInfected)
	{
		if(this.color.equals(Color.GREEN)) {
			this.hasBeenInfected=true;
		}
		this.isInfected = isInfected;
	}

	public int getCycleCounter()
	{
		return cycleCounter;
	}


	public void setCycleCounter(int cycleCounter)
	{
		this.cycleCounter = cycleCounter;
	}


	public int getImmunityStatus()
	{
		return immunityStatus;
	}


	public void setImmunityStatus(int immunityStatus)
	{		
		this.immunityStatus = immunityStatus;
	}
	
	public boolean getHasBeenInfected() {
		return hasBeenInfected;
	}
	
}
//end class
