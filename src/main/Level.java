package main;


import javax.swing.*;
import javax.swing.border.TitledBorder;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import static java.lang.Thread.sleep;

public class Level extends JFrame {

	private static final int WIDTH = 1514,  HEIGHT = 1080;
   	private JLabel labelBackground, numberLevel,userPlayer;
    private Animals catButton,chickenButton,dogButton,frogButton,lyonButton,monkeyButton,pigButton,sheepButton,wolfButton,cowButton;
	private LBotton backToMenuBotton;
	private ImageIcon animalIcon,windowIcon,dackgroundShade;
	private static String[] listAnimals = {"dog","cat","cow","chicken","pig","frog","lyon","monkey","sheep","wolf"};
	private String correctAnimals [],answerAnimals[];
	private int position, inicio,level;
	public static int outLevel;
	private Sound music = new Sound();
	private Sound wrongSound = new Sound();
	
	private boolean passLevel;
	private Hearts h1,h2,h3;
	private LLabel tryAgain,backgroundShade;
	

	
    public Level() {
		passLevel = false;
    	position = 0;
		inicio=3;
		level=1;
		outLevel=level;
		answerAnimals = new String[inicio];
		animalIcon = new ImageIcon(this.getClass().getResource("/images/level_background.png"));		
		windowIcon = new ImageIcon(this.getClass().getResource("/images/icon.png"));
		dackgroundShade = new ImageIcon(this.getClass().getResource("/images/level_background_shade.png"));
		labelBackground = new JLabel(animalIcon);
        labelBackground.setSize(WIDTH,HEIGHT);
		userPlayer = new LLabel(EntryUser.player.getNombre(),180,38,350,42,30);
		numberLevel = new LLabel("1",60,900,95,95,95);
		tryAgain = new LLabel("Intenta de nuevo",0,0,WIDTH,HEIGHT,75);
		backgroundShade = new LLabel("",0,0,WIDTH,HEIGHT,75);
		labelBackground.add(numberLevel);
		labelBackground.add(userPlayer);
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
        music.loop(10);
        
        backToMenuBotton = new LBotton("backToMenu",1380,20,93,93);
        		backToMenuBotton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new MainMenu();
				music.stop();
				dispose();						
			}
		});
        		
        		
        		
        		
        monkeyButton = new Animals("monkey",210,270,241,220);
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
        		
        	        		
        dogButton = new Animals("dog",570,265,198,242);
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
        		
        		
		 cowButton = new Animals("cow",842,264,316,263);
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
        		
			catButton = new Animals("cat",1215,270,145,284);
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
        		
			wolfButton = new Animals("wolf",40,535,251,307);
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
        	
			sheepButton = new Animals("sheep",361,655,201,266);
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
        		
        		        		
			frogButton = new Animals("frog",575,785,214,240);
			frogButton.addActionListener(new ActionListener() {			
				@Override
				public void actionPerformed(ActionEvent e) {				
					answerAnimals [position] =  "frog"; position++;
					System.out.println("vamos en la posicion :  "+position);
					System.out.println(frogButton.getName());
					if(position==inicio) {
						checkWin(correctAnimals,answerAnimals);
						}
				}
			});	
        		
			chickenButton = new Animals("chicken",675,505,195,254);
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
        		
			lyonButton = new Animals("lyon",900,612,281,296);
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

		pigButton = new Animals("pig",1195,795,291,211);
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

		

	

	

		

		

		
		
		h1 = new Hearts("heart",183,81);
		h2 = new Hearts("heart",220,81);
		h3 = new Hearts("heart",259,81);
		
		labelBackground.add(tryAgain);
		labelBackground.add(backgroundShade);
		tryAgain.setVisible(false);
		tryAgain.setForeground(Color.WHITE);
		tryAgain.setHorizontalAlignment(JTextField.CENTER);;
		backgroundShade.setIcon(dackgroundShade);
		backgroundShade.setVisible(false);

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
		labelBackground.add(frogButton);
		labelBackground.add(numberLevel);
		labelBackground.add(h1);
		labelBackground.add(h2);
		labelBackground.add(h3);
		
		
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
						case "frog":
							frogButton.changeIcon();
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
				System.out.println("El usuario perdio");
				if (EntryUser.player.getVidas()==1){
					music.stop();
					dispose();
					new Lose();
					Animals.stopMusic();
					
				}else {
					EntryUser.player.setVidas(EntryUser.player.getVidas()-1);
					passLevel = true;
					System.out.println();
					System.out.println("Repite el nivel");
					wrongSound.setLocationSong("/src/sounds/error.wav");
			        wrongSound.play();
					tryAgain.setVisible(true);
					backgroundShade.setVisible(true);
					
					Thread t1 = new Thread(new Runnable() {
						public void run(){

							try {
								sleep(2000);
								tryAgain.setVisible(false);
								backgroundShade.setVisible(false);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}});
					t1.start();



					position = 0;
					System.out.println("animales en juego: "+inicio);
					numberLevel.setText(String.valueOf(level));
					System.out.println("Nivel de juego actual ---> "+(numberLevel.getText()));

					switch (EntryUser.player.getVidas()) {
						case 2:
							h3.changeIcon();
							break;
						case 1:
							h2.changeIcon();
							break;
						case 0:
							h1.changeIcon();
							break;
					}
				}
			}		
	}
	private void increaseInicio() {
		inicio++;
		level++;
		answerAnimals = new String[inicio];		
	}
	
	
}