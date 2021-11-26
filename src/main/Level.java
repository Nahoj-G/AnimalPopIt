package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class Level  {
	
	

	Sound animalLevel = new Sound();
    public static final int WIDTH = 1514,  HEIGHT = 1080;
    private JFrame frame;
	private JLabel labelBackground, numberLevel;
    private Animals catButton,chickenButton,dogButton,donkeyButton,lyonButton,monkeyButton,pigButton,sheepButton,wolfButton,cowButton;
	private LBotton backToMenuBotton;
	private ImageIcon animalIcon;
	private static String[] listAnimals = {"dog","cat","cow","chicken","pig","donkey","lyon","monkey","sheep","wolf"};
	private String correctAnimals [];
	private String answerAnimals;
	static Sound click = new Sound();
	static Sound music = new Sound();

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
        
        
        music.setLocationSong("/src/sounds/song.wav");
        music.play();

        
        backToMenuBotton = new LBotton("backToMenu",1380,20,93,93);
        
		backToMenuBotton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Window();
				music.stop();
				frame.dispose();
				
			}
		});

		dogButton = new Animals("dog",185,285);
		dogButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				answerAnimals = answerAnimals + "dog";
			}
		});

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

		System.out.println(Arrays.toString(PlaySound(3)));

	}

	private String[] PlaySound(int count) {
		correctAnimals = new String[count];
		for (int i = 0 ; i <count; i++){
			correctAnimals[i] = listAnimals[(int)(Math.random()*10)];
		}

		Thread t1 = new Thread(new Runnable() {
			public void run(){
				for (int i = 0 ; i< correctAnimals.length ; i++) {
					switch (correctAnimals[i]) {
						case "dog":
							dogButton.changeIcon();
							break;
						case "cat":
							catButton.changeIcon();
							break;
						case "cow":
							cowButton.changeIcon();
							break;
						case "chicken":
							chickenButton.changeIcon();
							break;
						case "pig":
							pigButton.changeIcon();
							break;
						case "donkey":
							donkeyButton.changeIcon();
							break;
						case "lyon":
							lyonButton.changeIcon();
							break;
						case "monkey":
							monkeyButton.changeIcon();
							break;
						case "sheep":
							sheepButton.changeIcon();
							break;
						case "wolf":
							wolfButton.changeIcon();
							break;
					}
					System.out.println(correctAnimals[i]);
				}
			}});
		t1.start();

		return correctAnimals;
	}
	
}