package main;
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Objects;

import static java.lang.Thread.sleep;

class Animals extends JButton {
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private static final Sound click = new Sound();
		private final ImageIcon icon, iconShade;
		private final String name;

		protected Animals(String name,int x, int y, int h, int w ){
			
			this.name = name;
			icon = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/images/" + name + ".png")));
			iconShade = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/images/" + name + "Shade.png")));
			
			setIcon(iconShade);
			setBounds(x,y,h,w);
			setContentAreaFilled(false);
			setBorder(null);
			setFocusPainted(false);
			addActionListener(e -> {

			});
			addMouseListener (new MouseListener () {
	    		@Override
	    		public void mouseClicked(MouseEvent e) {
					
	    		}
	    		@Override
	    		public void mousePressed(MouseEvent e) {  
	    			Animals.stopMusic();
	    			click.setLocationSong("/sounds/" + name + ".wav");
					click.play();
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
		
		public String getName() {
			return this.name;
		}
		
		public void changeIcon (){
			setIcon(icon);
			setContentAreaFilled(false);
			setBorder(null);
			click.setLocationSong("/sounds/" + name + ".wav");
			click.play();
			try {				
				sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			setIcon(iconShade);
			setContentAreaFilled(false);
			setBorder(null);
		}
		
		public static void stopMusic()
		{
			click.stop();
		}
}