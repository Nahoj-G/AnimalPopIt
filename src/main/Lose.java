package main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lose extends JFrame{

    public static final int WIDTH = 1520,  HEIGHT = 1100;
    private JLabel labelBackground;
    private LBotton FinBotton,backToMenu2Botton,menuBotton;
    private ImageIcon animalIcon,windowIcon;
    private static Sound musicLose = new Sound();
 
    public Lose(){

        animalIcon = new ImageIcon(this.getClass().getResource("/images/perdiste.png"));        
        windowIcon = new ImageIcon(this.getClass().getResource("/images/icon.png")); 
        labelBackground = new JLabel(animalIcon);
        labelBackground.setSize(WIDTH,HEIGHT);       
        
        add(labelBackground);
        setSize(WIDTH,HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setIconImage(windowIcon.getImage());
        setTitle("Animal Pop It");
        musicLose.setLocationSong("/sounds/gameOver.wav");
        musicLose.play();
        

        menuBotton = new LBotton("menu",520,523,126,126);
		menuBotton.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {			
			new MainMenu();
			dispose();		
			}
		});
		
        FinBotton = new LBotton("Fin",865,523,126,126);
		FinBotton.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {			
			System.exit(0);		
			}
		});		
          
		backToMenu2Botton = new LBotton("backToMenu2",685,523,126,126);
   		backToMenu2Botton.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			EntryUser.player.setVidas(3);
			new CountForm(true);
			dispose();			
		}
	});
        labelBackground.add(menuBotton);
		labelBackground.add(FinBotton);
		labelBackground.add(backToMenu2Botton);
		add(labelBackground);
		repaint();
    }
}