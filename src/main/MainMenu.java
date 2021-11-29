package main;

import javax.swing.*;
import java.util.Objects;

public class MainMenu {

    public static final int WIDTH = 1514,  HEIGHT = 1080;
    private final JFrame frame;
    Sound music = new Sound();
    
    public MainMenu() {
    	
    	System.out.println("Inicializando juego");
    	System.out.println("Animal Pop IT");
        ImageIcon animalIcon = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/images/index.png")));
        ImageIcon windowIcon = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/images/icon.png")));
        JLabel labelBackground = new JLabel(animalIcon);
        labelBackground.setSize(WIDTH,HEIGHT);

        frame = new JFrame("Animal Pop It");      
        frame.add(labelBackground);
        frame.setSize(WIDTH,HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setIconImage(windowIcon.getImage());

        LBotton startButton = new LBotton("start", 622, 618, 270, 100);
        startButton.addActionListener(e -> {
           frame.setVisible(false);
           new EntryUser();
           music.stop();
           frame.dispose();
        });

        LBotton exitButton = new LBotton("exit", 622, 736, 270, 100);
        exitButton.addActionListener(e -> {
           frame.dispose();
           music.stop();
           System.exit(0);
        });
               
       labelBackground.add(startButton);
       labelBackground.add(exitButton);       
       music.setLocationSong("/sounds/back.wav");
       music.play();
       music.loop(4);
       frame.repaint();
    }
    
}