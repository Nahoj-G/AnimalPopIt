package main;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Objects;

public class Animals extends JButton {
		Sound click = new Sound();
		
		private ImageIcon icon, iconShade;
		private JButton animalButton;

		public Animals(String name,int x, int y){
			
			icon = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/images/" + name + ".png")));
			iconShade = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/images/" + name + "Shade.png")));

			setIcon(iconShade);
			setBounds(x,y,192,289);
			setContentAreaFilled(false);
			setBorder(null);
			addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	 
	            }
	        });
			addMouseListener (new MouseListener () {
	    		@Override
	    		public void mouseClicked(MouseEvent e) {
					click.setLocationSong("/sounds/" + name + ".wav");
					click.play();
	    		}
	    		@Override
	    		public void mousePressed(MouseEvent e) {    			
	    		}
	    		@Override
	    		public void mouseReleased(MouseEvent e) {    			
	    		}
	    		@Override
	    		public void mouseEntered(MouseEvent e) {    			
	    			setRolloverIcon(icon);

	    		}
	    		@Override
	    		public void mouseExited(MouseEvent e) {    			
	    		}
	         });
		}
}