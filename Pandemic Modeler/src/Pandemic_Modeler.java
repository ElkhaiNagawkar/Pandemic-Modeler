/**
 * Program Name: Pandemic_Modeler.java
 * Purpose: This Is the main program of the Pandemic Modeler. This program will imitate the spread of an infection over a 3 week period.
 * Coder: Elkhai Nagawkar (1115993) for Sec 04, /////////ADD YOUR STUFF HERE BRUH
 * Date: Jul 24, 2024
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Pandemic_Modeler extends JFrame
{
	private JPanel percentagePanel, populationSizePanel;
	private JSlider noVaxSlider, oneVaxSlider, twoVaxSlider, threeVaxSlider, naturalImmSlider;
	private JLabel noVaxLabel, oneVaxLabel, twoVaxLabel, threeVaxLabel, nuturalImmLabel, populationLabel;
	private JButton submitButton;
	private JButton start, stop;
	private JComboBox<String> populationBox;
	String[]populationArray = {
      "100", "200", "300", "400", "500", "1000", "2000", "3000", "4000", "5000"
		};
	private int perNoVax, perOneVax, perTwoVax, perThreeVax, perNatural, perPop;
	Container errorPane;
	
	public Pandemic_Modeler(){
		super("Starting Input"); //Passing title bar text up to super class constructor
		
		//BOILER PLATE CODE for positioning and sizing of the frame
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(900, 600); //width and height in pixels
		this.setLocationRelativeTo(null); //Centers the JFrame on the desktop
		this.setLayout(new GridLayout(1, 2, 50, 10)); //Anonymous object... NOTE: Default layout for JFrame is borderlayout
		
		buildPercentagePanel();
		buildPopulationPanel();
		
		this.add(percentagePanel);
		this.add(populationSizePanel);
		//The last line
		this.setVisible(true);
	}
	
	private class ButtonListner implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource().equals(submitButton)) {
				String boxValue = (String)populationBox.getSelectedItem();				
				//Try checking if the box value is a number
				try {
					perPop = Integer.parseInt(boxValue);
					
					int checkPercentage = perNoVax + perOneVax + perTwoVax + perThreeVax + perNatural;
					//Check if percentage does not equal 100. If it does not equal 100 it means more percent needs to be added
					if(checkPercentage != 100) {
						JOptionPane.showMessageDialog(errorPane, "Percentage either exceedes or is lower than 100%\nCurrent Percentage:" + checkPercentage + "%");
						return;
					}
					
					//This will open a new frame where the simulation will happen and takes in values from the frame
					//Simulation_Frame simFrame = new Simulation_Frame(perNoVax, perOneVax, perTwoVax, perThreeVax, perNatural, perPop);
					JFrame sim_frame = new JFrame("Simulation Frame");
					
					sim_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					sim_frame.setLayout(new BorderLayout() );//ANONYMOUS object
					sim_frame.setSize(1200,1000);
					sim_frame.setLocationRelativeTo(null);
					
					//set background color of contentPane
					sim_frame.getContentPane().setBackground(Color.BLUE);
					
					//create an ANONYMOUS object of the class and add the JPanel to the JFrame
					sim_frame.add(new Simulation_Frame(perNoVax, perOneVax, perTwoVax, perThreeVax, perNatural, perPop), BorderLayout.CENTER);
					
//					start = new JButton("Start");
//					start.addActionListener(new test());
//					stop = new JButton("Stop");
//					sim_frame.add(start, BorderLayout.SOUTH);

					sim_frame.pack();//shrinks the JFrame to the smallest size possible to conserve
					             //screen real estate. Comment it out to see its effect
					sim_frame.setVisible(true);	
					setVisible(false);
					//Catch if box value is not a number
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(errorPane, "Please enter a number!");
				}
			}			
		}	
	}
	
	private class SliderListener implements ChangeListener{

		@Override
		public void stateChanged(ChangeEvent e)
		{
			perNoVax = noVaxSlider.getValue();
			perOneVax = oneVaxSlider.getValue();
			perTwoVax = twoVaxSlider.getValue();
			perThreeVax = threeVaxSlider.getValue();
			perNatural = naturalImmSlider.getValue();
						
			noVaxLabel.setText("Percentage of non-vaccinated people: " + perNoVax + "%");
			oneVaxLabel.setText("Percentage of people with one shot of the vaccine: " + perOneVax + "%");
			twoVaxLabel.setText("Percentage of people with two shots of the vaccine: " + perTwoVax + "%");
			threeVaxLabel.setText("Percentage of people with three shots of the vaccine: " + perThreeVax + "%");
			nuturalImmLabel.setText("Percentage of people who recovered and have natural immunity: " + perNatural + "%");
		}
		
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
		populationSizePanel.setLayout(new GridLayout(3, 1, 10, 50));

		
		populationLabel = new JLabel("Population Size:");
		populationLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		submitButton = new JButton("Submit");
		submitButton.addActionListener(new ButtonListner());
		
		populationBox = new JComboBox<String>(populationArray);
		Dimension dim = new Dimension(200,30);
		populationBox.setPreferredSize(dim);
		populationBox.setEditable(true);

		populationSizePanel.add(populationLabel);
		populationSizePanel.add(populationBox);
		populationSizePanel.add(submitButton);
	}
	
	public void buildSlidersAndLables() {
		noVaxSlider = new JSlider(JSlider.HORIZONTAL,0,100,0);
		noVaxSlider.setMajorTickSpacing(10);
		noVaxSlider.setMinorTickSpacing(5);
		noVaxSlider.setPaintTicks(true);
		noVaxSlider.setPaintLabels(true);
		noVaxSlider.addChangeListener(new SliderListener());
	
		oneVaxSlider = new JSlider(JSlider.HORIZONTAL,0,100,0);
		oneVaxSlider.setMajorTickSpacing(10);
		oneVaxSlider.setMinorTickSpacing(5);
		oneVaxSlider.setPaintTicks(true);
		oneVaxSlider.setPaintLabels(true);
		oneVaxSlider.addChangeListener(new SliderListener());
		
		twoVaxSlider = new JSlider(JSlider.HORIZONTAL,0,100,0);
		twoVaxSlider.setMajorTickSpacing(10);
		twoVaxSlider.setMinorTickSpacing(5);
		twoVaxSlider.setPaintTicks(true);
		twoVaxSlider.setPaintLabels(true);
		twoVaxSlider.addChangeListener(new SliderListener());
		
		threeVaxSlider = new JSlider(JSlider.HORIZONTAL,0,100,0);
		threeVaxSlider.setMajorTickSpacing(10);
		threeVaxSlider.setMinorTickSpacing(5);
		threeVaxSlider.setPaintTicks(true);
		threeVaxSlider.setPaintLabels(true);
		threeVaxSlider.addChangeListener(new SliderListener());
		
		naturalImmSlider = new JSlider(JSlider.HORIZONTAL,0,100,0);
		naturalImmSlider.setMajorTickSpacing(10);
		naturalImmSlider.setMinorTickSpacing(5);	
		naturalImmSlider.setPaintTicks(true);
		naturalImmSlider.setPaintLabels(true);
		naturalImmSlider.addChangeListener(new SliderListener());
		
		noVaxLabel = new JLabel("Percentage of non-vaccinated people: 0%");
		noVaxLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		oneVaxLabel = new JLabel("Percentage of people with one shot of the vaccine: 0%");
		oneVaxLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		twoVaxLabel = new JLabel("Percentage of people with two shots of the vaccine: 0%");
		twoVaxLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		threeVaxLabel = new JLabel("Percentage of people with three shots of the vaccine: 0%");
		threeVaxLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		nuturalImmLabel = new JLabel("Percentage of people who recovered and have natural immunity: 0%");
		nuturalImmLabel.setHorizontalAlignment(SwingConstants.CENTER);

	}
	
	public static void main(String[] args)
	{
		new Pandemic_Modeler();

	}
	//end main
}
//end class
