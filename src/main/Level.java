package main;


import javax.swing.*;



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import static java.lang.Thread.sleep;

public class Level extends JFrame {
	Sound animalLevel = new Sound();
    public static final int WIDTH = 1514,  HEIGHT = 1080;
   	private JLabel labelBackground, numberLevel;
    private Animals catButton,chickenButton,dogButton,donkeyButton,lyonButton,monkeyButton,pigButton,sheepButton,wolfButton,cowButton;
	private LBotton backToMenuBotton;
	private ImageIcon animalIcon,windowIcon;
	private static String[] listAnimals = {"dog","cat","cow","chicken","pig","donkey","lyon","monkey","sheep","wolf"};
	private String correctAnimals [],answerAnimals[];
	private int position, inicio,level;
	public static int outLevel;
	private static Sound music = new Sound();
	private boolean passLevel;
	
    public Level() {
		passLevel = false;
    	position = 0;
		inicio=3;
		level=1;
		outLevel=level;
		answerAnimals = new String[inicio];
		animalIcon = new ImageIcon(this.getClass().getResource("/images/level_background.png"));
		windowIcon = new ImageIcon(this.getClass().getResource("/images/icon.png")); 
		labelBackground = new JLabel(animalIcon);
        labelBackground.setSize(WIDTH,HEIGHT);
		numberLevel = new JLabel();
		//toco asi, porque del 2 en adelante no los mostraba
		numberLevel.setText("1");
		//aqui podemos ahorrar codigo creando el objecto y dandolo como parametro
		numberLevel.setFont(new Font("Jokerman", Font.PLAIN, 95));
		numberLevel.setBounds(60,900,95,95);
		labelBackground.add(numberLevel);
		
		System.out.println("animales en juego: "+inicio);
		System.out.println("Nivel de juego actual ---> "+(String.valueOf(numberLevel.getText())));
     
        add(labelBackground);
        setSize(WIDTH,HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setIconImage(windowIcon.getImage());
        setTitle("Animal Pop It");
        music.setLocationSong("/src/sounds/song.wav");
        music.play();        
        
        backToMenuBotton = new LBotton("backToMenu",1380,20,93,93);
        		backToMenuBotton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new MainMenu();
				music.stop();
				dispose();						
			}
		});

		dogButton = new Animals("dog",185,285);
		dogButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {					
				answerAnimals [position] =  "dog"; position++;
				System.out.println("vamos en la posicion :  "+position);
				System.out.println(dogButton.getName());
				if(position==inicio) {
					checkWin(correctAnimals,answerAnimals);
					}						
			}
		});

		catButton = new Animals("cat",435,700);
		catButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {				
				answerAnimals [position] =  "cat"; position++;
				System.out.println("vamos en la posicion :  "+position);
				System.out.println(catButton.getName());
				if(position==inicio) {
					checkWin(correctAnimals,answerAnimals);
					}
			}
		});

        cowButton = new Animals("cow",910,235);
		cowButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {				
				answerAnimals [position] =  "cow"; position++;
				System.out.println("vamos en la posicion :  "+position);
				System.out.println(cowButton.getName());
				if(position==inicio) {
					checkWin(correctAnimals,answerAnimals);
					}
			}
		});

		chickenButton = new Animals("chicken",660,215);
		chickenButton.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {				
				answerAnimals [position] =  "chicken"; position++;
				System.out.println("vamos en la posicion :  "+position);
				System.out.println(chickenButton.getName());
				if(position==inicio) {
					checkWin(correctAnimals,answerAnimals);
					}
			}
		});

		pigButton = new Animals("pig",420,215);
		pigButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {				
				answerAnimals [position] =  "pig"; position++;
				System.out.println("vamos en la posicion :  "+position);
				System.out.println(pigButton.getName());
				if(position==inicio) {
					checkWin(correctAnimals,answerAnimals);
					}
			}
		});

		donkeyButton = new Animals("donkey",1180,215);
		donkeyButton.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {				
				answerAnimals [position] =  "donkey"; position++;
				System.out.println("vamos en la posicion :  "+position);
				System.out.println(donkeyButton.getName());
				if(position==inicio) {
					checkWin(correctAnimals,answerAnimals);
					}
			}
		});

		lyonButton = new Animals("lyon",680,730);
		lyonButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {				
				answerAnimals [position] =  "lyon"; position++;
				System.out.println("vamos en la posicion :  "+position);
				System.out.println(lyonButton.getName());				
				if(position==inicio) {
					checkWin(correctAnimals,answerAnimals);
					}
			}
		});

		monkeyButton = new Animals("monkey",930,700);
		monkeyButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {				
				answerAnimals [position] =  "monkey"; position++;
				System.out.println("vamos en la posicion :  "+position);
				System.out.println(monkeyButton.getName());
				if(position==inicio) {
					checkWin(correctAnimals,answerAnimals);
					}
			}
		});

		sheepButton = new Animals("sheep",1200,720);
		sheepButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {			
				answerAnimals [position] =  "sheep"; position++;				
				System.out.println("vamos en la posicion :  "+position);
				System.out.println(sheepButton.getName());				
				if(position==inicio) {
					checkWin(correctAnimals,answerAnimals);
					}
			}
		});

		wolfButton = new Animals("wolf",180,600);
		wolfButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {	
				answerAnimals [position] =  "wolf"; position++;
				System.out.println("vamos en la posicion :  "+position);
				System.out.println(wolfButton.getName());
				if(position==inicio) {
				checkWin(correctAnimals,answerAnimals);
				}
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
		labelBackground.add(numberLevel);
		 
		repaint();
		
		correctAnimals = new String[inicio];
		correctAnimals = PlaySound(inicio);
	}
    
    //metodo para obtener el nivel actual, y mandarlo  a la clase player(), pero no la he linkeado
    public int getLevel() {
    	return outLevel;
    }   
    
//metodo del juego    										
	private String[] PlaySound(int count) {
		correctAnimals = new String[count];
		for (int i = 0 ; i <count; i++){
			correctAnimals[i] = listAnimals[(int)(Math.random()*10)];
		}

		Thread t1 = new Thread(new Runnable() {
			public void run(){
				try {
					if (!passLevel){
						sleep(1000);
					}else{
						sleep(4000);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				for (int i = 0 ; i< count ; i++) {
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
					System.out.println((i+1)+"-"+correctAnimals[i]);
				}
				System.out.println("--------"+inicio);
			}});
		t1.start();
		return correctAnimals;
	}

	public void checkWin(String [] correct, String [] answer){		
			if (Arrays.equals(correct,answer)){			
				if (position ==10){
					// form ganaste
					System.out.println();
					System.out.println("GANASTE");
					System.exit(0);					
				}else {
					passLevel = true;
					System.out.println();
					System.out.println("Avanzaste de nivel");
					new CountForm(false);
					position = 0;
					increaseInicio();
					System.out.println("animales en juego: "+inicio);					
					correctAnimals = PlaySound(inicio);
					numberLevel.setText(String.valueOf(level));
					System.out.println("Nivel de juego actual ---> "+(numberLevel.getText()));
				}
			}else{
				//form perdiste
				System.out.println();
				System.out.println();
				System.out.println("YA VALISTE MADRE");
				new Lose();
				music.stop();			
			}		
	}
	private void increaseInicio() {
		inicio++;
		level++;
		answerAnimals = new String[inicio];		
	}	
}