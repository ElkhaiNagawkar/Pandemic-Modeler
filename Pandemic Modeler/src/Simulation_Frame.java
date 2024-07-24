/**
 * Program Name: Simulation_Frame.java
 * Purpose: This file will hold a class where the Simulation for the program will occur
 * Coder: Elkhai Nagawkar (1115993) for Sec 04
 * Date: Jul 24, 2024
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Simulation_Frame extends JFrame
{
	private int numNoVax, numOneVax, numTwoVax, numThreeVax, numNatural, numPop;
	
	public Simulation_Frame(){
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(900, 600); //width and height in pixels
		this.setLocationRelativeTo(null); //Centers the JFrame on the desktop
		this.setLayout(new GridLayout(1, 2, 50, 10));
		this.setVisible(true);
	}
	
	public void setValues(int numNoVax, int numOneVax, int numTwoVax, int numThreeVax, int numNatural, int numPop) {
		this.numNoVax = numNoVax;
		this.numOneVax = numOneVax;
		this.numTwoVax = numTwoVax;
		this.numThreeVax = numThreeVax;
		this.numNatural = numNatural;
		this.numPop = numPop;		
	}
	
}
//end class
