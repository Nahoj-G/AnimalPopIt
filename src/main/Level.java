package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class Level  {
	Sound animalLevel = new Sound();
    public static final int WIDTH = 1514,  HEIGHT = 1080;
    private JFrame frame;
	private JLabel labelBackground, numberLevel, countDown;
    private Animals catButton,chickenButton,dogButton,donkeyButton,lyonButton,monkeyButton,pigButton,sheepButton,wolfButton,cowButton;
	private LBotton backToMenuBotton;
	private ImageIcon animalIcon;
	private static String[] listAnimals = {"dog","cat","cow","chicken","pig","donkey","lyon","monkey","sheep","wolf"};
	private String correctAnimals [],answerAnimals[];
	private int position;
	static Sound music = new Sound();



    public Level() {
		position = 0;
		animalIcon = new ImageIcon(this.getClass().getResource("/images/level_background.png"));
		labelBackground = new JLabel(animalIcon);
        labelBackground.setSize(WIDTH,HEIGHT);
		numberLevel = new JLabel("1");
		Font font = new Font("Jokerman", Font.PLAIN, 40);
		numberLevel.setBounds(180,1008,40,40);
		numberLevel.setFont(font);
		labelBackground.add(numberLevel);

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
				answerAnimals [position] =  "dog"; position++;
				checkWin(correctAnimals,answerAnimals);
			}
		});

		catButton = new Animals("cat",435,700);
		catButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				answerAnimals [position] =  "cat"; position++;
				checkWin(correctAnimals,answerAnimals);
			}
		});

        cowButton = new Animals("cow",910,235);
		cowButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				answerAnimals [position] =  "cow"; position++;
				checkWin(correctAnimals,answerAnimals);
			}
		});

		chickenButton = new Animals("chicken",660,215);
		chickenButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				answerAnimals [position] =  "chicken"; position++;
				checkWin(correctAnimals,answerAnimals);
			}
		});

		pigButton = new Animals("pig",420,215);
		pigButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				answerAnimals [position] =  "pig"; position++;
				checkWin(correctAnimals,answerAnimals);
			}
		});

		donkeyButton = new Animals("donkey",1180,215);
		donkeyButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				answerAnimals [position] =  "donkey"; position++;
				checkWin(correctAnimals,answerAnimals);
			}
		});

		lyonButton = new Animals("lyon",680,730);
		lyonButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				answerAnimals [position] =  "lyon"; position++;
				checkWin(correctAnimals,answerAnimals);
			}
		});

		monkeyButton = new Animals("monkey",930,700);
		monkeyButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				answerAnimals [position] =  "monkey"; position++;
				checkWin(correctAnimals,answerAnimals);
			}
		});

		sheepButton = new Animals("sheep",1200,720);
		sheepButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				answerAnimals [position] =  "sheep"; position++;
				checkWin(correctAnimals,answerAnimals);
			}
		});

		wolfButton = new Animals("wolf",180,600);
		wolfButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				answerAnimals [position] =  "wolf"; position++;
				checkWin(correctAnimals,answerAnimals);
			}
		});

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

		correctAnimals = new String[9];
		correctAnimals = PlaySound(3);
	}

	private String[] PlaySound(int count) {
		correctAnimals = new String[9];
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

	public void checkWin(String [] correct, String [] answer){
		if (position == Integer.parseInt(numberLevel.getText())){
			if (correct == answer){
				if (position == 9){
					// form ganaste
				}else {
					// Siguiente nivel
				}
			}else{
				//form perdiste
			}
		}
	}
	
}