package main;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Objects;

import static java.lang.Thread.sleep;

public class Game extends JFrame {

	/**
	 * Clase que contiene el tablero del juego donde se ubicaran los animales
	 */
	private static final long serialVersionUID = 1L;
	private ImageIcon animalIcon,windowIcon,dackgroundShade;
	private final JLabel numberLevel;
	private final Animals catButton;
	private final Animals chickenButton;
	private final Animals dogButton;
	private final Animals frogButton;
	private final Animals lyonButton;
	private final Animals monkeyButton;
	private final Animals pigButton;
	private final Animals sheepButton;
	private final Animals wolfButton;
	private final Animals cowButton;
	private static final String[] listAnimals = {"dog","cat","cow","chicken","pig","frog","lyon","monkey","sheep","wolf"};
	private String[] correctAnimals,answerAnimals;
	private int position =0, starts =1,level =1;
	private final Sound music = new Sound();
	private final Sound wrongSound = new Sound();
	private boolean passLevel;
	private final Hearts h1;
	private final Hearts h2;
	private final Hearts h3;
	private final JLabel tryAgain;
	private final JLabel UserPlayer;
	private final JLabel backgroundShade;

	/**
	 * Metodo constructor crea 10 objetos animals que son con los cuales se jugará
	 * adicionalmente crea 3 objetos Hears que son las vidas del jugador
	 */
    protected Game() {
		passLevel = false;
		starts=1;
		level=1;
		answerAnimals = new String[starts];
		animalIcon = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/images/level_background.png")));
		windowIcon = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/images/icon.png")));
		dackgroundShade = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/images/level_background_shade.png")));
		JLabel labelBackground = new JLabel(animalIcon);
        labelBackground.setSize(options.WIDTH,options.HEIGHT);
        
        
        UserPlayer = new JLabel();
		UserPlayer.setText(EntryUser.getPlayer().getNamePlayer());
		UserPlayer.setFont(new Font("Jokerman", Font.PLAIN, 30));
		UserPlayer.setBounds(180, 38, 350, 42);
		
		numberLevel = new JLabel();
		numberLevel.setText("1");
		numberLevel.setFont(new Font("Jokerman", Font.PLAIN,95));
		numberLevel.setBounds(60,900,95,95);
		
		tryAgain = new JLabel();
		tryAgain.setText("Intenta de nuevo");
		tryAgain.setFont(new Font("Jokerman", Font.PLAIN,75));
        tryAgain.setBounds(0,0,options.WIDTH,options.HEIGHT);
		
		
		backgroundShade = new JLabel();
		backgroundShade.setText("");
		backgroundShade.setFont(new Font("Jokerman", Font.PLAIN, 75));
		backgroundShade.setBounds(0,0,options.WIDTH,options.HEIGHT);
		
		
		System.out.println("animales en juego: "+starts);
		System.out.println("Nivel de juego actual ---> "+(numberLevel.getText()));
     
        add(labelBackground);
        setSize(options.WIDTH,options.HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setIconImage(windowIcon.getImage());
        setTitle("Animal Pop It");
        music.setLocationSong("/sounds/song.wav");
        music.play();
        music.loop(10);

		LBotton backToMenuBotton = new LBotton("backToMenu", 1380, 20, 93, 93);
        		backToMenuBotton.addActionListener(e -> {
					new MainMenu();
					music.stop();
					dispose();
				});
        		
 		       		
        		
        //ANIMALES		
        monkeyButton = new Animals("monkey",210,270,241,220);
        monkeyButton.addActionListener(e -> {
			answerAnimals [position] =  "monkey"; position++;
			System.out.println("vamos en la posicion :  "+position);
			System.out.println(monkeyButton.getName());
			if(position==starts) {
				checkWin(correctAnimals,answerAnimals);
			}
		});        		
        	        		
        dogButton = new Animals("dog",570,265,198,242);
		dogButton.addActionListener(e -> {
			answerAnimals [position] =  "dog"; position++;
			System.out.println("vamos en la posicion :  "+position);
			System.out.println(dogButton.getName());
			if(position==starts) {
				checkWin(correctAnimals,answerAnimals);
				}
		});        		
        		
		cowButton = new Animals("cow",842,264,316,263);
		cowButton.addActionListener(e -> {
			answerAnimals [position] =  "cow"; position++;
			System.out.println("vamos en la posicion :  "+position);
			System.out.println(cowButton.getName());
			if(position==starts) {
				checkWin(correctAnimals,answerAnimals);
			}
		});
        		
		catButton = new Animals("cat",1215,270,145,284);
		catButton.addActionListener(e -> {
			answerAnimals [position] =  "cat"; position++;
			System.out.println("vamos en la posicion :  "+position);
			System.out.println(catButton.getName());
			if(position==starts) {
				checkWin(correctAnimals,answerAnimals);
			}
		});
        		
		wolfButton = new Animals("wolf",40,535,251,307);
		wolfButton.addActionListener(e -> {
			answerAnimals [position] =  "wolf"; position++;
			System.out.println("vamos en la posicion :  "+position);
			System.out.println(wolfButton.getName());
			if(position==starts) {
			checkWin(correctAnimals,answerAnimals);
			}
		});
        
		sheepButton = new Animals("sheep",361,655,201,266);
		sheepButton.addActionListener(e -> {
			answerAnimals [position] =  "sheep"; position++;
			System.out.println("vamos en la posicion :  "+position);
			System.out.println(sheepButton.getName());
			if(position==starts) {
				checkWin(correctAnimals,answerAnimals);
			}
		});
             		
		frogButton = new Animals("frog",575,785,214,240);
		frogButton.addActionListener(e -> {
			answerAnimals [position] =  "frog"; position++;
			System.out.println("vamos en la posicion :  "+position);
			System.out.println(frogButton.getName());
			if(position==starts) {
				checkWin(correctAnimals,answerAnimals);
			}
		});
        		
		chickenButton = new Animals("chicken",675,505,195,254);
		chickenButton.addActionListener(e -> {
			answerAnimals [position] =  "chicken"; position++;
			System.out.println("vamos en la posicion :  "+position);
			System.out.println(chickenButton.getName());
			if(position==starts) {
				checkWin(correctAnimals,answerAnimals);
			}
		});
        		
		lyonButton = new Animals("lyon",900,612,281,296);
		lyonButton.addActionListener(e -> {
			answerAnimals [position] =  "lyon"; position++;
			System.out.println("vamos en la posicion :  "+position);
			System.out.println(lyonButton.getName());
			if(position==starts) {
				checkWin(correctAnimals,answerAnimals);
			}
		});

		pigButton = new Animals("pig",1195,795,291,211);
		pigButton.addActionListener(e -> {
			answerAnimals [position] =  "pig"; position++;
			System.out.println("vamos en la posicion :  "+position);
			System.out.println(pigButton.getName());
			if(position==starts) {
				checkWin(correctAnimals,answerAnimals);
			}
		});

		tryAgain.setVisible(false);
		tryAgain.setForeground(Color.WHITE);
		tryAgain.setHorizontalAlignment(JTextField.CENTER);
		backgroundShade.setIcon(dackgroundShade);
		backgroundShade.setVisible(false);


		/*
		 En mac y en windows existe una pequeña diferencia en las posiciones que se notan solo en la ubicación de los corazones
		 motivo por el cual se verifica el sistema operativo y se asignan posiciones según este
		 */
		String os = System.getProperty("os.name").toLowerCase();

		if(os.contains("mac")){
			h1 = new Hearts("heart",188,87);
			h2 = new Hearts("heart",227,87);
			h3 = new Hearts("heart",265,87);
		} else {
			h1 = new Hearts("heart",183,81);
			h2 = new Hearts("heart",220,81);
			h3 = new Hearts("heart",260,81);
		}

		
		labelBackground.add(numberLevel);
		labelBackground.add(UserPlayer);
		labelBackground.add(tryAgain);
		labelBackground.add(backgroundShade);
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
		
		correctAnimals = new String[starts];
		correctAnimals = PlaySound(starts);
	}


	/**
	 * Metodo que inicia el nivel asigna los animales los muestra al jugador llamando al método changeIcon
	 * de la clase Animals y reproduce el sonido del animal
	 * @param count parametro que indica el nivel
	 * @return el orden correcto de los animales
	 */
	private String[] PlaySound(int count) {
		correctAnimals = new String[count];
		for (int i = 0 ; i <count; i++){
			correctAnimals[i] = listAnimals[(int)(Math.random()*10)];
		}

		Thread t1 = new Thread(() -> {
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
			System.out.println("--------"+starts);
		});
		t1.start();
		return correctAnimals;
	}

	/**
	 * Metodo que verifica la respuesta del jugador si esta es correcta llama al metodo playSound para
	 * pasar al siguiente nivel
	 * @param correct Array con el orden correcto de animales
	 * @param answer Array con el orden que establece el jugador
	 */
	public void checkWin(String [] correct, String [] answer){		
			if (Arrays.equals(correct,answer)){			
				if (position ==15){
					// form ganaste
					Animals.stopMusic();
					System.out.println();
					System.out.println("GANASTE");
					System.exit(0);					
				}else {
					passLevel = true;
					Animals.stopMusic();
					System.out.println();
					System.out.println("Avanzaste de nivel");
					new CountForm(false);
					position = 0;
					increaseStarts();
					System.out.println("animales en juego: "+starts);					
					correctAnimals = PlaySound(starts);
					numberLevel.setText(String.valueOf(level));
					System.out.println("Nivel de juego actual ---> "+(numberLevel.getText()));
					EntryUser.getPlayer().setNivelAlcanzado(Integer.parseInt((numberLevel.getText())));
				}
			}else{
				//form perdiste
				System.out.println();
				System.out.println();
				System.out.println("El usuario perdio");
				if (EntryUser.getPlayer().getLives()==1){
					music.stop();
					dispose();
					new Lose();
					Animals.stopMusic();
					
				}else {
					EntryUser.getPlayer().setLives(EntryUser.getPlayer().getLives()-1);
					passLevel = true;
					System.out.println();
					System.out.println("Repite el nivel");
					wrongSound.setLocationSong("/sounds/error.wav");
			        wrongSound.play();
					tryAgain.setVisible(true);
					backgroundShade.setVisible(true);
					
					Thread t1 = new Thread(() -> {

						try {
							sleep(2000);
							tryAgain.setVisible(false);
							backgroundShade.setVisible(false);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					});
					t1.start();


					position = 0;
					System.out.println("animales en juego: "+starts);
					numberLevel.setText(String.valueOf(level));
					System.out.println("Nivel de juego actual ---> "+(numberLevel.getText()));

					switch (EntryUser.getPlayer().getLives()) {
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

	/**
	 * Metodo que incrementa el nivel
	 */
	private void increaseStarts() {
		starts++;
		level++;
		answerAnimals = new String[starts];		
	}
}