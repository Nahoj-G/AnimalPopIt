package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import static java.lang.Thread.sleep;

public class CountForm {

    public static final int WIDTH = 1514,  HEIGHT = 1080;
    private JFrame frame;
    private JLabel labelBackground, numberLevel, countDown;
    private ImageIcon animalIcon;

    public CountForm(){

        animalIcon = new ImageIcon(this.getClass().getResource("/images/level_background.png"));
        labelBackground = new JLabel(animalIcon);
        labelBackground.setSize(WIDTH,HEIGHT);
        numberLevel = new JLabel("1");
        Font font = new Font("Jokerman", Font.PLAIN, 40);
        numberLevel.setBounds(180,1008,40,40);
        numberLevel.setFont(font);

        frame = new JFrame("Animal Pop It");
        frame.add(labelBackground);
        frame.setSize(WIDTH,HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        labelBackground.add(numberLevel);
        countDown = new JLabel(String.valueOf(3));
        Font font2 = new Font("Jokerman", Font.PLAIN, 300);
        countDown.setBounds(630, 390, 300, 300);
        countDown.setFont(font2);
        labelBackground.add(countDown);

        Thread t1 = new Thread(new Runnable() {
            public void run(){
                for (int i = 3 ; i >= 0; i--) {
                    countDown.setText(String.valueOf(i));
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                frame.dispose();
                new Level();
            }});
        t1.start();


    }
}
