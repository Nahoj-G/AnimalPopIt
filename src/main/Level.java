package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Level {
	Sound click = new Sound();
    public static final int WIDTH = 1514,  HEIGHT = 1080;
    private JFrame frame;
	private JLabel labelBackground;
    private JButton backToMenuBotton, catButton,chickenButton,dogButton,donkeyButton,lyonButton,monkeyButton,pigButton,sheepButton,wolfButton,cowButton;
	private ImageIcon animalIcon, catIcon,chickenIcon,dogIcon,donkeyIcon,lyonIcon,monkeyIcon,pigIcon,
			sheepIcon,wolfIcon,cowIcon,backToMenuBottonIcon,backToMenuBottonHoverIcon,catShadeIcon,
			chickenShadeIcon,dogShadeIcon,donkeyShadeIcon,lyonShadeIcon,monkeyShadeIcon,pigShadeIcon,
			sheepShadeIcon,wolfShadeIcon,cowShadeIcon;

    public Level() {
		//iconos con color
		animalIcon = new ImageIcon(this.getClass().getResource("/images/level_background.png"));
		catIcon = new ImageIcon(this.getClass().getResource("/images/cat.png"));
        chickenIcon = new ImageIcon(this.getClass().getResource("/images/chicken.png"));
		dogIcon = new ImageIcon(this.getClass().getResource("/images/dog.png"));
		lyonIcon = new ImageIcon(this.getClass().getResource("/images/lyon.png"));
		monkeyIcon = new ImageIcon(this.getClass().getResource("/images/monkey.png"));
		pigIcon = new ImageIcon(this.getClass().getResource("/images/pig.png"));
		sheepIcon = new ImageIcon(this.getClass().getResource("/images/sheep.png"));
		wolfIcon = new ImageIcon(this.getClass().getResource("/images/wolf.png"));
		cowIcon = new ImageIcon(this.getClass().getResource("/images/cow.png"));
		donkeyIcon = new ImageIcon(this.getClass().getResource("/images/donkey.png"));
		backToMenuBottonIcon = new ImageIcon(this.getClass().getResource("/images/backToMenuBotton.png"));

   		//iconos sombreados
		backToMenuBottonHoverIcon = new ImageIcon(this.getClass().getResource("/images/backToMenuBottonHover.png"));
		catShadeIcon = new ImageIcon(this.getClass().getResource("/images/catShade.png"));
		chickenShadeIcon = new ImageIcon(this.getClass().getResource("/images/chickenShade.png"));
		dogShadeIcon = new ImageIcon(this.getClass().getResource("/images/dogShade.png"));
		lyonShadeIcon = new ImageIcon(this.getClass().getResource("/images/lyonShade.png"));
		monkeyShadeIcon = new ImageIcon(this.getClass().getResource("/images/monkeyShade.png"));
		pigShadeIcon = new ImageIcon(this.getClass().getResource("/images/pigShade.png"));
		sheepShadeIcon = new ImageIcon(this.getClass().getResource("/images/sheepShade.png"));
		wolfShadeIcon = new ImageIcon(this.getClass().getResource("/images/wolfShade.png"));
		cowShadeIcon = new ImageIcon(this.getClass().getResource("/images/cowShade.png"));
		donkeyShadeIcon = new ImageIcon(this.getClass().getResource("/images/donkeyShade.png"));
		labelBackground = new JLabel(animalIcon);
        labelBackground.setSize(WIDTH,HEIGHT);

        frame = new JFrame("Animal Pop It");
        frame.add(labelBackground);
        frame.setSize(WIDTH,HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        backToMenuBotton = new JButton("");
        backToMenuBotton.setIcon(backToMenuBottonIcon);
        backToMenuBotton.setBounds(1380,20,93,93);
        backToMenuBotton.setContentAreaFilled(false);
        backToMenuBotton.setBorder(null);
        backToMenuBotton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	 new Window();
            	 click.setLocationSong("/src/sounds/close.wav");
              	 click.play();
            	 frame.dispose();
            }
        });
        backToMenuBotton.addMouseListener (new MouseListener () {
    		@Override
    		public void mouseClicked(MouseEvent e) {
    		}
    		@Override
    		public void mousePressed(MouseEvent e) {
    		}
    		@Override
    		public void mouseReleased(MouseEvent e) {
    		}
    		@Override
    		public void mouseEntered(MouseEvent e) {
    			backToMenuBotton.setRolloverIcon(backToMenuBottonHoverIcon);
    		}
    		@Override
    		public void mouseExited(MouseEvent e) {
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
    }

    public static void main (String[] args){
    	new Level();
    }
}