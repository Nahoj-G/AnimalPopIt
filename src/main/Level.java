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
		lyonShadeIcon = new ImageIcon(this.getClass().getResource("/images/lyon.png"));
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

        dogButton = new JButton("");
        dogButton.setIcon(dogShadeIcon);
        dogButton.setBounds(185,285,200,245);
        dogButton.setBorder(null);
        dogButton.setContentAreaFilled(false);
        dogButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


            }
        });
        dogButton.addMouseListener (new MouseListener () {
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
    			dogButton.setRolloverIcon(dogIcon);
    			click.setLocationSong("/src/sounds/dog.wav");
            	click.play();
    		}
    		@Override
    		public void mouseExited(MouseEvent e) {
    		}

         });

        catButton = new JButton("");
        catButton.setIcon(catShadeIcon);
        catButton.setBounds(435,695,178,288);

        catButton.setBorder(null);
        catButton.setContentAreaFilled(false);
        catButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	// click.setfile("/src/sounds/close.wav");
              	 //click.play();

            }
        });
        catButton.addMouseListener (new MouseListener () {
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
    			catButton.setRolloverIcon(catIcon);
    			click.setLocationSong("/src/sounds/cat.wav");
            	click.play();
    		}
    		@Override
    		public void mouseExited(MouseEvent e) {
    		}

         });

        cowButton = new JButton("");
        cowButton.setIcon( cowShadeIcon);
        cowButton.setBounds(910,235,192,289);

        cowButton.setBorder(null);
        cowButton.setContentAreaFilled(false);
        cowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	 //click.setfile("/src/sounds/close.wav");
              	 //click.play();

            }
        });
        cowButton.addMouseListener (new MouseListener () {
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
    			 cowButton.setRolloverIcon(cowIcon);
    			 click.setLocationSong("/src/sounds/cow.wav");
             	click.play();
    		}
    		@Override
    		public void mouseExited(MouseEvent e) {    			
    		}

         });

        labelBackground.add(cowButton);
        labelBackground.add(dogButton);
        labelBackground.add(backToMenuBotton);
        labelBackground.add(catButton);
    }

    public static void main (String[] args){
    	new Level();
    }
}