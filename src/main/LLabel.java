package main;

import javax.swing.*;
import java.awt.*;

public class LLabel extends JLabel {

    public LLabel(String text,int x, int y,int w,int h,int size){
        setText(text);
        setFont(new Font("Jokerman", Font.PLAIN, size));
        setBounds(x,y,w,h);
    }
}
