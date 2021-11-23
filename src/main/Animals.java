package main;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Animals extends JButton {
		Sound click = new Sound();
		
		private ImageIcon icon, iconShade;
		private JButton animalButton; 
		private String sound;
		private String name;
		
		public Animals(String name, String iconLocation, String iconShadeLocation) {
			
			icon = new ImageIcon(this.getClass().getResource(iconLocation));			
			iconShade = new ImageIcon(this.getClass().getResource(iconShadeLocation));
			this.name= name;

			animalButton = new JButton(name);
			animalButton.setIcon(iconShade);
			animalButton.setBounds(750,450,200,200);
			//animalButton.setContentAreaFilled(false);
			animalButton.setBorder(null);
			
			animalButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	 
	            }
	        });
			animalButton.addMouseListener (new MouseListener () {
	    		@Override
	    		public void mouseClicked(MouseEvent e) {    			
	    		}
	    		@Override
	    		public void mousePressed(MouseEvent e) {    			
	    		}
	    		@Override
	    		public void mouseReleased(MouseEvent e) {    			
	    		}
	    		@Override
	    		public void mouseEntered(MouseEvent e) {    			
	    			animalButton.setRolloverIcon(icon);
	    			click.setLocationSong(sound);
	              	click.play();
	    		}
	    		@Override
	    		public void mouseExited(MouseEvent e) {    			
	    		}
	         });
		}
		
		public void sound(String text) {
			sound=text;
		}
}