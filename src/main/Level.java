package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Level {

    public static final int WIDTH = 1514,  HEIGHT = 1080;
    private JFrame frame;
    private ImageIcon animalIcon, catIcon,chickenIcon,dogIcon,donkeyIcon,lyonIcon,monkeyIcon,pigIcon,sheepIcon,wolfIcon,cowIcon ;
    private JLabel labelBackground;
    private JButton catButton,chickenButton,dogButton,donkeyButton,lyonButton,monkeyButton,pigButton,sheepButton,wolfButton,cowButton;


    public Level() {
        animalIcon = new ImageIcon(this.getClass().getResource("./images/level_background.png"));
        catIcon = new ImageIcon(this.getClass().getResource("./images/cat.png"));
        chickenIcon = new ImageIcon(this.getClass().getResource("./images/chicken.png"));
        dogIcon = new ImageIcon(this.getClass().getResource("./images/dog.png"));
        lyonIcon = new ImageIcon(this.getClass().getResource("./images/lyon.png"));
        monkeyIcon = new ImageIcon(this.getClass().getResource("./images/monkey.png"));
        pigIcon = new ImageIcon(this.getClass().getResource("./images/pig.png"));
        sheepIcon = new ImageIcon(this.getClass().getResource("./images/sheep.png"));
        wolfIcon = new ImageIcon(this.getClass().getResource("./images/wolf.png"));
        cowIcon = new ImageIcon(this.getClass().getResource("./images/cow.png"));
        donkeyIcon = new ImageIcon(this.getClass().getResource("./images/donkey.png"));

        labelBackground = new JLabel(animalIcon);
        labelBackground.setSize(WIDTH,HEIGHT);

        frame = new JFrame("Animal Pop It");
        frame.add(labelBackground);
        frame.setSize(WIDTH,HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        catButton = new JButton("");
        catButton.setIcon(catIcon);
        catButton.setBounds(114,418,125,200);
        catButton.setMargin(new Insets(0, 0, 0, 0));
        catButton.setBorder(null);
        catButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        labelBackground.add(catButton);


    }

    public static void main (String[] args){


    }

}
