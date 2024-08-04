/**
 * Program Name: About_Frame.java
 * Purpose: This is a JFrame that will show when the about button is clicked
 * Coder: Elkhai Nagawkar (1115993) for Sec 04, Bruno Magalhaes (1132360) section 3
 * Date: Aug 3, 2024
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class About_Frame extends JFrame
{
	JLabel title, firstMember, secondMember;
	
	public About_Frame(){
		super("About Frame"); //Passing title bar text up to super class constructor
	//BOILER PLATE CODE for positioning and sizing of the frame
			this.setDefaultCloseOperation(HIDE_ON_CLOSE);
			this.setSize(400,200); //width and height in pixels
			this.setLocationRelativeTo(null); //Centers the JFrame on the desktop
			this.setLayout(new GridLayout(3, 1, 50, 10)); //Anonymous object... NOTE: Default layout for JFrame is borderlayout
			
			title = new JLabel("Group Memebers");
			title.setHorizontalAlignment(SwingConstants.CENTER);
			title.setFont(new Font("Arial", Font.BOLD, 20));
			firstMember = new JLabel("Elkhai Nagawkar (1115993) section 4.");
			secondMember = new JLabel("Bruno Magalhaes (1132360) section 3.");
			
			this.add(title);
			this.add(firstMember);
			this.add(secondMember);
			
			//The last line
			this.setVisible(true);
	}
	
}
//end class
