/**
 * Program Name: Report_Frame.java
 * Purpose: This is a JFrame that will show when the simulation ends
 * Coder: Elkhai Nagawkar (1115993) for Sec 04, Bruno Magalhaes (1132360) section 3
 * Date: Aug 4, 2024
 */
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

import javax.swing.*;

public class Report_Frame extends JFrame{
	JLabel label = new JLabel();
	
	double infectedCounter=0;
	double unvaccinatedCounter=0;
	double oneShotCounter=0;
	double twoShotCounter=0;
	double threeShotCounter=0;
	double naturalImmunityCounter=0;
	double recoveredCounter=0;
	
	double unvaccinatedMortality=0;
	double oneShotMortality=0;
	double twoShotMortality=0;
	double threeShotMortality=0;
	double naturalMortality=0;
	
	JPanel topPanel = new JPanel(new GridLayout(4,4,10,10));
	JPanel bottomPanel = new JPanel(new GridLayout(5,2,10,10));
	
	JTextField infectedTextBox = new JTextField(0+"");
	JTextField unvaccinatedTextBox = new JTextField(0+"");
	JTextField deadTextBox = new JTextField(0+"");
	JTextField oneShotTextBox = new JTextField(0+"");
	JTextField twoShotTextBox = new JTextField(0+"");
	JTextField threeShotTextBox = new JTextField(0+"");
	JTextField naturalImmunityTextBox = new JTextField(0+"");
	JTextField recoveredTextBox = new JTextField(0+"");
	
	JTextField oneShotMortalityTextBox = new JTextField(0+"");
	JTextField twoShotMortalityTextBox = new JTextField(0+"");
	JTextField threeShotMortalityTextBox = new JTextField(0+"");
	JTextField naturalMortalityTextBox = new JTextField(0+"");
	JTextField unvaccinatedMortalityTextBox = new JTextField(0+"");
	
	public Report_Frame(Person[] personArr) {
		super("Report");

		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setSize(1000,600); //width and height in pixels
		this.setLocationRelativeTo(null); //Centers the JFrame on the desktop
		this.setLayout(new GridLayout(2, 1, 10, 10)); //Anonymous object... NOTE: Default layout for JFrame is borderlayout
		
		
		this.add(topPanel);
		this.add(bottomPanel);
		
		for(int i=0;i<personArr.length;i++) {
			if(personArr[i].getColor().equals(Color.RED)) {
				infectedCounter++;
			}
			
			if(personArr[i].getImmunityStatus() == 1 && personArr[i].getColor().equals(Color.RED)) {
				unvaccinatedCounter++;
			}
			else if(personArr[i].getImmunityStatus() == 2 && personArr[i].getColor().equals(Color.RED)) {
				oneShotCounter++;
			}
			else if(personArr[i].getImmunityStatus() == 4 && personArr[i].getColor().equals(Color.RED)) {
				twoShotCounter++;
			}
			else if(personArr[i].getImmunityStatus() == 5 && personArr[i].getColor().equals(Color.RED)) {
				threeShotCounter++;
			}
			else if(personArr[i].getImmunityStatus() == 3 && personArr[i].getColor().equals(Color.RED)) {
				naturalImmunityCounter++;
			}
			
			if(personArr[i].getColor().equals(Color.GREEN)) {
				recoveredCounter++;
			}
		}//End For loop
		
		DecimalFormat df = new DecimalFormat("#.##");
		topPanel.add(new JLabel("% of population that is infected: "));
		topPanel.add(infectedTextBox);
		infectedTextBox.setText(df.format((infectedCounter/personArr.length)*100));
		infectedTextBox.setEditable(false);
		
		topPanel.add(new JLabel("% of unvaccinated that is infected: "));
		topPanel.add(unvaccinatedTextBox);
		unvaccinatedTextBox.setText(df.format((unvaccinatedCounter/personArr.length)*100));
		unvaccinatedTextBox.setEditable(false);

		topPanel.add(new JLabel("% of one-shot-vaccinated that is infected: "));
		topPanel.add(oneShotTextBox);
		oneShotTextBox.setText(df.format((oneShotCounter/personArr.length)*100));
		oneShotTextBox.setEditable(false);
		
		topPanel.add(new JLabel("% of two-shot-vaccinated that is infected: "));
		topPanel.add(twoShotTextBox);
		twoShotTextBox.setText(df.format((twoShotCounter/personArr.length)*100));
		twoShotTextBox.setEditable(false);
		
		topPanel.add(new JLabel("% of three-shot-vaccinated that is infected: "));
		topPanel.add(threeShotTextBox);
		threeShotTextBox.setText(df.format((threeShotCounter/personArr.length)*100));
		threeShotTextBox.setEditable(false);
		
		topPanel.add(new JLabel("% of naturally immune that got re-infected: "));
		topPanel.add(naturalImmunityTextBox);
		naturalImmunityTextBox.setText(df.format((naturalImmunityCounter/personArr.length)*100));
		naturalImmunityTextBox.setEditable(false);
		
		topPanel.add(new JLabel("% of population that recovered: "));
		topPanel.add(recoveredTextBox);
		recoveredTextBox.setText(df.format((recoveredCounter/personArr.length)*100));
		recoveredTextBox.setEditable(false); 
		
		for(int i=0;i<personArr.length;i++) {
			if(!personArr[i].getIsAlive() && personArr[i].getImmunityStatus()==1) {
				unvaccinatedMortality++;
			}
			else if(!personArr[i].getIsAlive() && personArr[i].getImmunityStatus()==2) {
				oneShotMortality++;
			}
			else if(!personArr[i].getIsAlive() && personArr[i].getImmunityStatus()==3) {
				naturalMortality++;
			}
			else if(!personArr[i].getIsAlive() && personArr[i].getImmunityStatus()==4) {
				twoShotMortality++;
			}
			else if(!personArr[i].getIsAlive() && personArr[i].getImmunityStatus()==5) {
				threeShotMortality++;
			}
		}
		
		unvaccinatedCounter=0;
		oneShotCounter=0;
		naturalImmunityCounter=0;
		twoShotCounter=0;
		threeShotCounter=0;
		
		for(int i=0;i<personArr.length;i++) {
			if(personArr[i].getImmunityStatus()==1) {
				unvaccinatedCounter++;
			}
			else if(personArr[i].getImmunityStatus()==2) {
				oneShotCounter++;
			}
			else if(personArr[i].getImmunityStatus()==3) {
				naturalImmunityCounter++;
			}
			else if(personArr[i].getImmunityStatus()==4) {
				twoShotCounter++;
			}
			else if(personArr[i].getImmunityStatus()==5) {
				threeShotCounter++;
			}
		}

		bottomPanel.add(new JLabel("Unvaccinated mortalty rate: "));
		bottomPanel.add(unvaccinatedMortalityTextBox);
		unvaccinatedMortalityTextBox.setEditable(false);
		unvaccinatedMortalityTextBox.setText(df.format((unvaccinatedMortality/unvaccinatedCounter)*100));
		
		bottomPanel.add(new JLabel("One Shot mortalty rate: "));
		bottomPanel.add(oneShotMortalityTextBox);
		oneShotMortalityTextBox.setEditable(false);
		oneShotMortalityTextBox.setText(df.format((oneShotMortality/oneShotCounter)*100));
		
		bottomPanel.add(new JLabel("Two Shot mortalty rate: "));
		bottomPanel.add(twoShotMortalityTextBox);
		twoShotMortalityTextBox.setEditable(false);
		twoShotMortalityTextBox.setText(df.format((twoShotMortality/twoShotCounter)*100));
		
		bottomPanel.add(new JLabel("Three Shot mortalty rate: "));
		bottomPanel.add(threeShotMortalityTextBox);
		threeShotMortalityTextBox.setEditable(false);
		threeShotMortalityTextBox.setText(df.format((threeShotMortality/threeShotCounter)*100));
		
		bottomPanel.add(new JLabel("Natural mortalty rate: "));
		bottomPanel.add(naturalMortalityTextBox);
		naturalMortalityTextBox.setEditable(false);
		naturalMortalityTextBox.setText(df.format((naturalMortality/naturalImmunityCounter)*100));
		

		
		this.setVisible(true);
	}//End Constructor 
	
	
}//End Class
