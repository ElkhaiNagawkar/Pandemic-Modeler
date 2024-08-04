/**
 * Program Name: Report_Frame.java
 * Purpose: This is a JFrame that will show when the simulation ends
 * Coder: Elkhai Nagawkar (1115993) for Sec 04, Bruno Magalhaes (1132360) section 3
 * Date: Aug 4, 2024
 */
import java.awt.*;
import java.awt.event.*;
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
	
	JPanel topPanel = new JPanel(new GridLayout(4,4,10,10));
	JPanel bottomPane = new JPanel();
	
	JTextField infectedTextBox = new JTextField(0+"");
	JTextField unvaccinatedTextBox = new JTextField(0+"");
	JTextField deadTextBox = new JTextField(0+"");
	JTextField oneShotTextBox = new JTextField(0+"");
	JTextField twoShotTextBox = new JTextField(0+"");
	JTextField threeShotTextBox = new JTextField(0+"");
	JTextField naturalImmunityTextBox = new JTextField(0+"");
	JTextField recoveredTextBox = new JTextField(0+"");
	
	public Report_Frame(Person[] personArr) {
		super("Report");

		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setSize(800,800); //width and height in pixels
		this.setLocationRelativeTo(null); //Centers the JFrame on the desktop
		this.setLayout(new GridLayout(2, 1, 10, 10)); //Anonymous object... NOTE: Default layout for JFrame is borderlayout
		
		
		this.add(topPanel);
		this.add(bottomPane);
		
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
		
		
		topPanel.add(new JLabel("% of population that is infected: "));
		topPanel.add(infectedTextBox);
		infectedTextBox.setText((infectedCounter/personArr.length)*100+"");
		infectedTextBox.setEditable(false);
		
		topPanel.add(new JLabel("% of unvaccinated that is infected: "));
		topPanel.add(unvaccinatedTextBox);
		unvaccinatedTextBox.setText((unvaccinatedCounter/personArr.length)*100+"");
		unvaccinatedTextBox.setEditable(false);

		topPanel.add(new JLabel("% of one-shot-vaccinated that is infected: "));
		topPanel.add(oneShotTextBox);
		oneShotTextBox.setText((oneShotCounter/personArr.length)*100+"");
		oneShotTextBox.setEditable(false);
		
		topPanel.add(new JLabel("% of two-shot-vaccinated that is infected: "));
		topPanel.add(twoShotTextBox);
		twoShotTextBox.setText((twoShotCounter/personArr.length)*100+"");
		twoShotTextBox.setEditable(false);
		
		topPanel.add(new JLabel("% of three-shot-vaccinated that is infected: "));
		topPanel.add(threeShotTextBox);
		threeShotTextBox.setText((threeShotCounter/personArr.length)*100+"");
		threeShotTextBox.setEditable(false);
		
		topPanel.add(new JLabel("% of naturally immune that got re-infected: "));
		topPanel.add(naturalImmunityTextBox);
		naturalImmunityTextBox.setText((naturalImmunityCounter/personArr.length)*100+"");
		naturalImmunityTextBox.setEditable(false);
		
		topPanel.add(new JLabel("% of population that recovered: "));
		topPanel.add(recoveredTextBox);
		recoveredTextBox.setText((recoveredCounter/personArr.length)*100+"");
		recoveredTextBox.setEditable(false);
		



		
		this.setVisible(true);
	}//End Constructor 
	
	
}//End Class
