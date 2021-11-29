package main;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

import static java.lang.Thread.sleep;

public class CountForm extends JFrame{

    private static final int WIDTH = 1514,  HEIGHT = 1080;
    private final JLabel countDown;
    Sound conteo = new Sound();    
    
    public CountForm(Boolean makeLevel){

        ImageIcon animalIcon;
        if(makeLevel) {
    		animalIcon = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/images/FirstLevel.png")));
    	}else {
    		animalIcon = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/images/nextLevelLoading.png")));
    	}
        ImageIcon windowIcon = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/images/icon.png")));
        JLabel labelBackground = new JLabel(animalIcon);
        labelBackground.setSize(WIDTH,HEIGHT);
        
        add(labelBackground);
        setSize(WIDTH,HEIGHT);
        setTitle("Animal Pop It");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setIconImage(windowIcon.getImage());
        countDown = new JLabel(String.valueOf(3));
        countDown.setBounds(1090, 330, 300, 300);
        countDown.setFont(new Font("Jokerman", Font.PLAIN, 260));
        countDown.setHorizontalAlignment(JLabel.CENTER);
        labelBackground.add(countDown);          
                    
        Thread t1 = new Thread(() -> {
              try {
                  sleep(300);
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
             for (int i = 3 ; i >= 0; i--) {

                 if(i==0) {
                     countDown.setText("Go");
                     conteo.setLocationSong("/sounds/start.wav");
                     conteo.play();
                 }else {
                     countDown.setText(String.valueOf(i));
                     conteo.setLocationSong("/sounds/conter.wav");
                     conteo.play();
                     try {
                     sleep(1000);
                     } catch (InterruptedException e) {
                     e.printStackTrace();
                     }
                }
             }

             if(makeLevel){
                    new Level();
                    dispose();
             }else {
                  dispose();
             }
         });
        t1.start();    
        
    }
}