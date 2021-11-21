package main;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window {

    public static final int WIDTH = 1280,  HEIGHT = 720;
    private JFrame frame;
    private ImageIcon animalIcon;
    private JLabel labelBackground;
    private JButton startButton, exitButton;


    public Window() {
        animalIcon = new ImageIcon(this.getClass().getResource("./images/index.png"));

        labelBackground = new JLabel(animalIcon);
        labelBackground.setSize(WIDTH,HEIGHT);

        frame = new JFrame("Animal Pop It");
        frame.add(labelBackground);
        frame.setSize(WIDTH,HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        startButton = new JButton("Iniciar");
        startButton.setBounds(514,418,252,100);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        labelBackground.add(startButton);

        exitButton = new JButton("Cerrar");
        exitButton.setBounds(514,536,252,100);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        labelBackground.add(exitButton);

    }

    public static void main (String[] args){

        new Window();
    }


}
