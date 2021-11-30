package main;

import javax.swing.*;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Lose extends JFrame{

  
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel labelBackground,userPlayerInfo;
    private LBotton FinBotton,backToMenu2Botton,menuBotton;
    private ImageIcon animalIcon,windowIcon;
    private static Sound musicLose = new Sound();
 
    protected Lose(){

        animalIcon = new ImageIcon(this.getClass().getResource("/images/perdiste.png"));        
        windowIcon = new ImageIcon(this.getClass().getResource("/images/icon.png")); 
        
        setSize(options.WIDTH,1100);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setIconImage(windowIcon.getImage());
        setTitle("Animal Pop It");
        musicLose.setLocationSong("/sounds/gameOver.wav");
        musicLose.play();        
        
        labelBackground = new JLabel(animalIcon);
        labelBackground.setSize(options.WIDTH,1100);       
        
        add(labelBackground);   
        
        

        menuBotton = new LBotton("menu",520,615,126,126);
		menuBotton.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {			
			new MainMenu();
			dispose();		
			}
		});
		
        FinBotton = new LBotton("Fin",865,615,126,126);
		FinBotton.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {			
			System.exit(0);		
			}
		});		
          
		backToMenu2Botton = new LBotton("backToMenu2",685,615,126,126);
   		backToMenu2Botton.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			EntryUser.getPlayer().setLives(3);
			new CountForm(true);
			dispose();			
		}				
		
	});
   		
   		userPlayerInfo = new JLabel();
   		userPlayerInfo.setText("LLEGASTE AL NIVEL:  "+ EntryUser.getPlayer().getNivelAlcanzado());
   		userPlayerInfo.setBounds(492,540,1500,48);
   		userPlayerInfo.setFont(new Font("Jokerman", Font.PLAIN, 45));
   		
   		
		labelBackground.add(userPlayerInfo);      
        labelBackground.add(menuBotton);
		labelBackground.add(FinBotton);
		labelBackground.add(backToMenu2Botton);
		add(labelBackground);
		repaint();
    }
    
}