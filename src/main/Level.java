package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Level {
	Sound animalLevel = new Sound();
    public static final int WIDTH = 1514,  HEIGHT = 1080;
    private JFrame frame;
	private JLabel labelBackground, numberLevel;
    private Animals catButton,chickenButton,dogButton,donkeyButton,lyonButton,monkeyButton,pigButton,sheepButton,wolfButton,cowButton;
	private LBotton backToMenuBotton;
	private ImageIcon animalIcon;


    public Level() {

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


        backToMenuBotton = new LBotton("backToMenu",1380,20,93,93);
		backToMenuBotton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Window();
				frame.dispose();
			}
		});

		dogButton = new Animals("dog",185,285);
		catButton = new Animals("cat",435,700);
        cowButton = new Animals("cow",910,235);
		chickenButton = new Animals("chicken",660,215);
		pigButton = new Animals("pig",420,215);
		donkeyButton = new Animals("donkey",1180,215);
		lyonButton = new Animals("lyon",680,730);
		monkeyButton = new Animals("monkey",930,700);
		sheepButton = new Animals("sheep",1200,720);
		wolfButton = new Animals("wolf",180,600);

        labelBackground.add(cowButton);
        labelBackground.add(dogButton);
        labelBackground.add(backToMenuBotton);
        labelBackground.add(catButton);
		labelBackground.add(chickenButton);
		labelBackground.add(lyonButton);
		labelBackground.add(monkeyButton);
		labelBackground.add(pigButton);
		labelBackground.add(sheepButton);
		labelBackground.add(wolfButton);
		labelBackground.add(donkeyButton);
		labelBackground.add(numberLevel);
    }

    public static void main (String[] args){
    	new Level();
    }
}