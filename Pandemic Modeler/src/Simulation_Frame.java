/**
 * Program Name: Simulation_Frame.java
 * Purpose: This file will hold a class where the Simulation for the program will occur
 * Coder: Elkhai Nagawkar (1115993) for Sec 04
 * Date: Jul 24, 2024
 */

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;


public class Simulation_Frame extends JPanel
{
	private int perNoVax, perOneVax, perTwoVax, perThreeVax, perNatural, perPop;
	private Person[] personArr;
	private int WIDTH = 800, HEIGHT = 700;
	private final int LAG_TIME = 50;
	private Timer time;
	private final int IMG_DIM =10;
	
	public Simulation_Frame(int percentNoVax, int percentOneVax, int percentTwoVax, int percentThreeVax, int percentNatural, int percentPop)
	{	
		this.time = new Timer(LAG_TIME, new BounceListener());
		
		this.perNoVax = percentNoVax;
		this.perOneVax = percentOneVax;
		this.perTwoVax = percentTwoVax;
		this.perThreeVax = percentThreeVax;
		this.perNatural = percentNatural;
		//Added one here as the first person will always be infected
		this.perPop = percentPop + 1;

		if(perPop >= 1000 && perPop <= 2000) {
			WIDTH = 1000;
			HEIGHT = 900;
		}else if(perPop >= 2000)
		{
			WIDTH = 1200;
			HEIGHT = 1000;
		}
		
		personArr = new Person[perPop];
		personArr[0] = new Person(IMG_DIM, Color.RED, WIDTH, HEIGHT);
		
		//Getting people in numbers instead of percent. This will be used to populate the array
		int numNoVax = (int)(((double)(perPop) - 1) * ((double)(perNoVax) / 100.0));		
		int numOneVax = (int)(((double)(perPop) - 1) * ((double)(perOneVax) / 100.0));
		int numTwoVax = (int)(((double)(perPop) - 1) * ((double)(perTwoVax) / 100.0));
		int numThreeVax = (int)(((double)(perPop) - 1) * ((double)(perThreeVax) / 100.0));
		int numNaturalImm = (int)(((double)(perPop) - 1) * ((double)(perNatural) / 100.0));
			
		int index = 1;
		
		for(int i = 0; i < numNoVax; i++) {
			personArr[index] = new Person(IMG_DIM, Color.BLUE, WIDTH, HEIGHT);
			index++;
		}
		
		for(int i = 0; i < numOneVax; i++) {
			personArr[index] = new Person(IMG_DIM, Color.CYAN, WIDTH, HEIGHT);
			index++;
		}

		for(int i = 0; i < numTwoVax; i++) {
			personArr[index] = new Person(IMG_DIM, Color.YELLOW, WIDTH, HEIGHT);
			index++;
		}
		
		for(int i = 0; i < numThreeVax; i++) {
			personArr[index] = new Person(IMG_DIM, Color.MAGENTA, WIDTH, HEIGHT);
			index++;
		}
		
		for(int i = 0; i < numNaturalImm; i++) {
			personArr[index] = new Person(IMG_DIM, Color.GREEN, WIDTH, HEIGHT);
			index++;
		}
		
		
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT) );
		this.setBackground(Color.WHITE);
		this.time.start();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		for(int i = 0; i < personArr.length; i++) {
			g.setColor(personArr[i].getColor());
			g.fillOval(personArr[i].getxCoord(), personArr[i].getyCoord(), personArr[i].getDiam(), personArr[i].getDiam());
		}//draw circle
	}
	
	private class BounceListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			for(int i = 0; i < personArr.length; i++)
			{
				calcPosition(personArr[i]);
			}
			
			int deltaX;
			int deltaY;
			
			int firstPersonX,  firstPersonY, secondPersonX, secondPersonY;
			
			for(int i = 0; i < personArr.length -1; i++) {
				firstPersonX = personArr[i].getxCoord();
				firstPersonY = personArr[i].getyCoord();
				
				for(int j = i+1; j < personArr.length; j++) {
					secondPersonX = personArr[j].getxCoord();
					secondPersonY = personArr[j].getyCoord();
					
					deltaX = firstPersonX - secondPersonX;
					deltaY = firstPersonY - secondPersonY;
					
					if(Math.sqrt(deltaX *deltaX + deltaY * deltaY) <= IMG_DIM) {
						personArr[i].setxIncrement(personArr[i].getxIncrement() * -1);
						personArr[i].setyIncrement(personArr[i].getyIncrement() * -1);
						
						personArr[j].setxIncrement(personArr[j].getxIncrement() * -1);
						personArr[j].setyIncrement(personArr[j].getyIncrement() * -1);
						
						int firstPersonNewxIncrement = (int)(Math.random()*11 - 5);
						int firstPersonNewyIncrement = (int)(Math.random()*11 - 5);
						int secondPersonNewxIncrement = (int)(Math.random()*11 - 5);
						int secondPersonNewyIncrement = (int)(Math.random()*11 - 5);
						
						personArr[i].setxIncrement(firstPersonNewxIncrement);
						personArr[i].setyIncrement(firstPersonNewyIncrement);
						personArr[j].setxIncrement(secondPersonNewxIncrement);
						personArr[j].setyIncrement(secondPersonNewyIncrement);
						
						
						if(personArr[i].getColor().equals(Color.RED) && personArr[j].getColor().equals(Color.BLUE)) {
							int chance = (int)(Math.random()*10 + 1);
							
							if(chance <= 8) {
								personArr[j].setColor(personArr[i].getColor());
							}
						}
						if(personArr[j].getColor().equals(Color.RED) && personArr[i].getColor().equals(Color.BLUE))
						{
							int chance = (int)(Math.random()*10 + 1);
							if(chance <= 8) {							
								personArr[i].setColor(personArr[j].getColor());
							}
						}
						
						if(personArr[i].getColor().equals(Color.RED) && personArr[j].getColor().equals(Color.CYAN)) {
							int chance = (int)(Math.random()*10 + 1);
							
							if(chance <= 6) {
								personArr[j].setColor(personArr[i].getColor());
							}
						}
						
						if(personArr[j].getColor().equals(Color.RED) && personArr[i].getColor().equals(Color.CYAN))
						{
							int chance = (int)(Math.random()*10 + 1);
							if(chance <= 6) {							
								personArr[i].setColor(personArr[j].getColor());
							}
						}
						
						if(personArr[i].getColor().equals(Color.RED) && personArr[j].getColor().equals(Color.YELLOW)) {
							int chance = (int)(Math.random()*10 + 1);
							
							if(chance <= 3) {
								personArr[j].setColor(personArr[i].getColor());
							}
						}
						
						if(personArr[j].getColor().equals(Color.RED) && personArr[i].getColor().equals(Color.YELLOW))
						{
							int chance = (int)(Math.random()*10 + 1);
							if(chance <= 3) {							
								personArr[i].setColor(personArr[j].getColor());
							}
						}
						
						if(personArr[i].getColor().equals(Color.RED) && personArr[j].getColor().equals(Color.MAGENTA)) {
							int chance = (int)(Math.random()*10 + 1);
							
							if(chance <= 1) {
								personArr[j].setColor(personArr[i].getColor());
							}
						}
						
						if(personArr[j].getColor().equals(Color.RED) && personArr[i].getColor().equals(Color.MAGENTA))
						{
							int chance = (int)(Math.random()*10 + 1);
							if(chance <= 1) {							
								personArr[i].setColor(personArr[j].getColor());
							}
						}
						
						if(personArr[i].getColor().equals(Color.RED) && personArr[j].getColor().equals(Color.GREEN)) {
							int chance = (int)(Math.random()*10 + 1);
							
							if(chance <= 4) {
								personArr[j].setColor(personArr[i].getColor());
							}
						}

						if(personArr[j].getColor().equals(Color.RED) && personArr[i].getColor().equals(Color.GREEN))
						{
							int chance = (int)(Math.random()*10 + 1);
							if(chance <= 4) {							
								personArr[i].setColor(personArr[j].getColor());
							}
						}						
					}//end if
				}//end inner loop
			}//end outer loop
			repaint();
		}//end method
	}//end listener
	
	public void calcPosition(Person person) {
		if(person.getxCoord() >= WIDTH - person.getDiam()) 
		{
			person.setxIncrement(person.getxIncrement() * -1);
		}
		
		if(person.getxCoord() <= 0)
		{
			person.setxIncrement(person.getxIncrement() * -1);;
		}
		
		
		if(person.getyCoord() >= HEIGHT - person.getDiam() )
		{
			person.setyIncrement(person.getyIncrement() * -1);
		}
		
		if(person.getyCoord() <= 0)
		{
			person.setyIncrement(person.getyIncrement() * -1);;
		}
		
		person.setxCoord(person.getxCoord() + person.getxIncrement());
		person.setyCoord(person.getyCoord() + person.getyIncrement());
	}
	
}
//end class
