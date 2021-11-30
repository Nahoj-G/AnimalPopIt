package main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MainMenu extends JFrame{

    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ImageIcon animalIcon,windowIcon;
    private JLabel labelBackground;  
    private LBotton startButton,exitButton;
    private Sound music = new Sound();   

    
    protected MainMenu() {
    	System.out.println("Animal Pop IT");
    	System.out.println("Inicializando juego");
    	
        animalIcon = new ImageIcon(this.getClass().getResource("/images/index.png"));     
        windowIcon = new ImageIcon(this.getClass().getResource("/images/icon.png")); 
        labelBackground = new JLabel(animalIcon);
        labelBackground.setSize(options.WIDTH,options.HEIGHT);        
        add(labelBackground);
        
        setSize(options.WIDTH,options.HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setIconImage(windowIcon.getImage()); 
        setTitle("Animal Pop It");
   
        startButton = new LBotton("start",622,618,270,100);        
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             //new CountForm(true);
               setVisible(false);
               new EntryUser();
               music.stop();
               dispose();
            }
        });
        
        exitButton = new LBotton("exit",622,736,270,100);   
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {             
               dispose();
               music.stop();
               System.exit(0);
            }
        });
               
       labelBackground.add(startButton);
       labelBackground.add(exitButton);       
       
       music.setLocationSong("/sounds/back.wav");
       music.play();
       music.loop(4);
       
      repaint();
    }
    
}