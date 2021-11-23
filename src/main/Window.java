package main;


import javax.swing.*;
import javax.swing.JButton;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window {

    public static final int WIDTH = 1514,  HEIGHT = 1080;
    private JFrame frame;
    private ImageIcon animalIcon, startIcon, exitlIcon, startoIcon, exitolIcon,windowIcon;
    private JLabel labelBackground;
    private JButton startButton, exitButton;
    Sound click = new Sound();
    public Window() {
        animalIcon = new ImageIcon(this.getClass().getResource("/images/index.png"));
        startIcon = new ImageIcon(this.getClass().getResource("/images/start.png"));
        startoIcon = new ImageIcon(this.getClass().getResource("/images/starto.png"));
        exitlIcon = new ImageIcon(this.getClass().getResource("/images/exit.png"));
        exitolIcon = new ImageIcon(this.getClass().getResource("/images/exito.png"));
        windowIcon = new ImageIcon(this.getClass().getResource("/images/icon.png")); //create an ImageIcon

        labelBackground = new JLabel(animalIcon);
        labelBackground.setSize(WIDTH,HEIGHT);

        frame = new JFrame("Animal Pop It");
        frame.add(labelBackground);
        frame.setSize(WIDTH,HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setIconImage(windowIcon.getImage());

        startButton = new JButton("   Iniciar");
        startButton.setIcon(startIcon);
        startButton.setBounds(622,618,270,100);
        startButton.setBorder(null);
        startButton.setContentAreaFilled(false);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                click.setLocationSong("/src/sounds/button_sound.wav");
                click.play();
                new Level();
                frame.setVisible(false);
            }
        });
        startButton.addMouseListener (new MouseListener () {

            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub
                startButton.setRolloverIcon(startoIcon);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub

            }

        });




        exitButton = new JButton("Cerrar");
        exitButton.setIcon(exitlIcon);
        exitButton.setBounds(622,736,270,100);
        exitButton.setBorder(null);
        exitButton.setContentAreaFilled(false);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                click.setLocationSong("/sounds/close.wav");
                click.play();
                frame.dispose();


            }
        });
        exitButton.addMouseListener (new MouseListener () {

            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub
                exitButton.setRolloverIcon(exitolIcon);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub

            }

        });




        labelBackground.add(startButton);
        labelBackground.add(exitButton);















    }



    public static void main (String[] args){

        new Window();

    }


}

