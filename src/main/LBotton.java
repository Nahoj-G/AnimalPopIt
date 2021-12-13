package main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Objects;

class LBotton extends JButton {

	/**
	 * Clase para crear los botones personalizados
	 */
	private static final long serialVersionUID = 1L;
	private Sound click = new Sound();
    private ImageIcon bottonIcon,bottonHoverIcon;

    /**
     * Crea el boton personalizado con sus coordenadas y dimensiones
     * @param name nombre del boton
     * @param x posicion en x en el tablero del boton
     * @param y posicion en y en el tablero del boton
     * @param w Ancho del boton
     * @param h Alto del boton
     */
    protected LBotton (String name, int x, int y,int w, int h){
    	bottonIcon = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/images/" + name + "Botton.png")));
    	bottonHoverIcon = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/images/" + name + "BottonHover.png")));
        setIcon(bottonIcon);
        setBounds(x,y,w,h);
        setContentAreaFilled(false);
        setBorder(null);
        setFocusPainted(false);
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        addMouseListener (new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            /**
             * Reproduce el sonido asignado al boton.
             * @param e
             */
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