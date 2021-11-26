package main;

import javax.swing.*;
import javax.swing.JButton;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mainMenu {

    public static final int WIDTH = 1514,  HEIGHT = 1080;
    private JFrame frame;
    private ImageIcon animalIcon,windowIcon;
    private JLabel labelBackground;  
    private LBotton startButton,exitButton;
    Sound music = new Sound();   
    
    public mainMenu() {
    	
    	System.out.println("Inicializando juego");
    	System.out.println("Animal Pop IT");
        animalIcon = new ImageIcon(this.getClass().getResource("/images/index.png"));     
        windowIcon = new ImageIcon(this.getClass().getResource("/images/icon.png")); 
        labelBackground = new JLabel(animalIcon);
        labelBackground.setSize(WIDTH,HEIGHT);

        frame = new JFrame("Animal Pop It");      
        frame.add(labelBackground);
        frame.setSize(WIDTH,HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setIconImage(windowIcon.getImage());        
   
        startButton = new LBotton("start",622,618,270,100);        
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             //new CountForm(true);
               frame.setVisible(false);
               new entryUser();
               music.stop();
               frame.dispose();
            }
        });
        
        exitButton = new LBotton("exit",622,736,270,100);   
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {             
               frame.dispose();
               music.stop();
               System.exit(0);
            }
        });
               
       labelBackground.add(startButton);
       labelBackground.add(exitButton);       
       music.setLocationSong("/src/sounds/back.wav");
       music.play();
       music.loop();;
       frame.repaint();
    }
    
}