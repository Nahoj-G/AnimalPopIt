package main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Objects;

import static java.lang.Thread.sleep;

public class Hearts extends JButton{
    private final ImageIcon icon, iconShade;
    private final String name;
   

    public Hearts(String name,int x, int y) {
        this.name = name;
        icon = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/images/" + name + ".png")));
        iconShade = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/images/" + name + "Shade.png")));

        setIcon(icon);
        setBounds(x, y, 32, 32);
        setContentAreaFilled(false);
        setBorder(null);
        setFocusPainted(false);
    }

    public String getName() {
        return this.name;
    }
    public void changeIcon (){
        setIcon(iconShade);
        setContentAreaFilled(false);
        setBorder(null);
    
    }
}