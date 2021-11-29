package main;

import javax.swing.*;
import java.util.Objects;

public class Lose extends JFrame{

    public static final int WIDTH = 1520,  HEIGHT = 1100;
	private static final Sound musicLose = new Sound();
 
    public Lose(){

		ImageIcon animalIcon = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/images/perdiste.png")));
		ImageIcon windowIcon = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/images/icon.png")));
		JLabel labelBackground = new JLabel(animalIcon);
        labelBackground.setSize(WIDTH,HEIGHT);       
        
        add(labelBackground);
        setSize(WIDTH,HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setIconImage(windowIcon.getImage());
        setTitle("Animal Pop It");
        musicLose.setLocationSong("/sounds/gameOver.wav");
        musicLose.play();


		LBotton menuBotton = new LBotton("menu", 520, 615, 126, 126);
		menuBotton.addActionListener(e -> {
			new MainMenu();
			dispose();
			});

		LBotton finBotton = new LBotton("Fin", 865, 615, 126, 126);
		finBotton.addActionListener(e -> System.exit(0));

		LBotton backToMenu2Botton = new LBotton("backToMenu2", 685, 615, 126, 126);
   		backToMenu2Botton.addActionListener(e -> {
			   EntryUser.getPlayer().setVidas(3);
			   new CountForm(true);
			   dispose();
		   });

		JLabel userPlayer = new LLabel("LLEGASTE AL NIVEL:  " + EntryUser.getPlayer().getNivelAlcanzado(), 492, 540, 1500, 48, 45);
		labelBackground.add(userPlayer);      
        labelBackground.add(menuBotton);
		labelBackground.add(finBotton);
		labelBackground.add(backToMenu2Botton);
		add(labelBackground);
		repaint();
    }
    
}