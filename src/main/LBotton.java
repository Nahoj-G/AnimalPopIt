package main;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Objects;

public class LBotton extends JButton {
    Sound click = new Sound();
    private final ImageIcon bottonHoverIcon;

    public LBotton (String name, int x, int y,int w, int h){
        ImageIcon bottonIcon = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/images/" + name + "Botton.png")));
    	bottonHoverIcon = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/images/" + name + "BottonHover.png")));
        setIcon(bottonIcon);
        setBounds(x,y,w,h);
        setContentAreaFilled(false);
        setBorder(null);
        setFocusPainted(false);
        addActionListener(e -> {
        });
        addMouseListener (new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }
            @Override
            public void mousePressed(MouseEvent e) {
                    click.setLocationSong("/sounds/" + name + ".wav");
                    click.play();
            }
            @Override
            public void mouseReleased(MouseEvent e) {
            }
            @Override
            public void mouseEntered(MouseEvent e) {
               setRolloverIcon(bottonHoverIcon);
            }
            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
    }
}