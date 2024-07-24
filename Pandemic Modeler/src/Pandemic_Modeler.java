/**
 * Program Name: Pandemic_Modeler.java
 * Purpose: This Is the main program of the Pandemic Modeler. This program will imitate the spread of an infection over a 3 week period.
 * Coder: Elkhai Nagawkar (1115993) for Sec 04, /////////ADD YOUR STUFF HERE BRUH
 * Date: Jul 24, 2024
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Pandemic_Modeler extends JFrame
{
	private JPanel percentagePanel, populationSizePanel;
	private JSlider noVaxSlider, oneVaxSlider, twoVaxSlider, threeVaxSlider, naturalImmSlider;
	private JLabel noVaxLabel, oneVaxLabel, twoVaxLabel, threeVaxLabel, nuturalImmLabel, populationLabel;
	private JButton submit;
	private JComboBox<Integer> populationBox;
	Integer[]populationArray = {
      100, 200, 300, 400, 500, 1000, 2000, 3000, 4000, 5000
		};
	
	public Pandemic_Modeler(){
		super("Starting Input"); //Passing title bar text up to super class constructor
		
		//BOILER PLATE CODE for positioning and sizing of the frame
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(400, 600); //width and height in pixels
		this.setLocationRelativeTo(null); //Centers the JFrame on the desktop
		this.setLayout(new GridLayout(1, 2, 50, 10)); //Anonymous object... NOTE: Default layout for JFrame is borderlayout
		
		buildPercentagePanel();
		buildPopulationPanel();
		
		this.add(percentagePanel);
		this.add(populationSizePanel);
		//The last line
		this.setVisible(true);
	}
	
	
	public void buildPercentagePanel() {
		percentagePanel = new JPanel();
		percentagePanel.setLayout(new GridLayout(10, 1, 0, 10));
		
		buildSlidersAndLables();
		
		percentagePanel.add(noVaxLabel);
		percentagePanel.add(noVaxSlider);
		
		percentagePanel.add(oneVaxLabel);
		percentagePanel.add(oneVaxSlider);
		
		percentagePanel.add(twoVaxLabel);
		percentagePanel.add(twoVaxSlider);
		
		percentagePanel.add(threeVaxLabel);
		percentagePanel.add(threeVaxSlider);
		
		percentagePanel.add(nuturalImmLabel);
		percentagePanel.add(naturalImmSlider);
	}
	
	public void buildPopulationPanel() {
		populationSizePanel = new JPanel();
		populationSizePanel.setLayout(new GridLayout(2, 1, 10, 50));
		JPanel panel = new JPanel(new GridLayout(2, 1, 10, 10));
		
		populationLabel = new JLabel("Population Size:");
		populationLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		submit = new JButton("Submit");
		
		populationBox = new JComboBox<Integer>(populationArray);
		Dimension dim = new Dimension(200,30);
		populationBox.setPreferredSize(dim);
		populationBox.setEditable(true);

		panel.add(populationLabel);
		panel.add(populationBox);	
		populationSizePanel.add(panel);
		populationSizePanel.add(submit);
	}
	
	public void buildSlidersAndLables() {
		noVaxSlider = new JSlider(JSlider.HORIZONTAL,0,100,0);
		noVaxSlider.setMajorTickSpacing(10);
		noVaxSlider.setMinorTickSpacing(5);
		noVaxSlider.setPaintTicks(true);
		noVaxSlider.setPaintLabels(true);
	
		oneVaxSlider = new JSlider(JSlider.HORIZONTAL,0,100,0);
		oneVaxSlider.setMajorTickSpacing(10);
		oneVaxSlider.setMinorTickSpacing(5);
		oneVaxSlider.setPaintTicks(true);
		oneVaxSlider.setPaintLabels(true);
		
		twoVaxSlider = new JSlider(JSlider.HORIZONTAL,0,100,0);
		twoVaxSlider.setMajorTickSpacing(10);
		twoVaxSlider.setMinorTickSpacing(5);
		twoVaxSlider.setPaintTicks(true);
		twoVaxSlider.setPaintLabels(true);
	
		threeVaxSlider = new JSlider(JSlider.HORIZONTAL,0,100,0);
		threeVaxSlider.setMajorTickSpacing(10);
		threeVaxSlider.setMinorTickSpacing(5);
		threeVaxSlider.setPaintTicks(true);
		threeVaxSlider.setPaintLabels(true);

		naturalImmSlider = new JSlider(JSlider.HORIZONTAL,0,100,0);
		naturalImmSlider.setMajorTickSpacing(10);
		naturalImmSlider.setMinorTickSpacing(5);	
		naturalImmSlider.setPaintTicks(true);
		naturalImmSlider.setPaintLabels(true);
		
		noVaxLabel = new JLabel("Percentage of non-vaccinated people: ");
		noVaxLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		oneVaxLabel = new JLabel("Percentage of people with one shot of the vaccine: ");
		oneVaxLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		twoVaxLabel = new JLabel("Percentage of people with two shots of the vaccine: ");
		twoVaxLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		threeVaxLabel = new JLabel("Percentage of people with three shots of the vaccine: ");
		threeVaxLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		nuturalImmLabel = new JLabel("Percentage of people who recovered and have natural immunity: ");
		nuturalImmLabel.setHorizontalAlignment(SwingConstants.CENTER);

	}
	
	public static void main(String[] args)
	{
		new Pandemic_Modeler();

	}
	//end main
}
//end class
