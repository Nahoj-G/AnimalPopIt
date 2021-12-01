package main;

import javax.swing.*;
import java.util.Objects;

class Hearts extends JButton{
    /**
	 * Clase que muestra las vidas que tiene el jugador
	 */
	private static final long serialVersionUID = 1L;
	private final ImageIcon icon, iconShade;
    private final String name;

    /**
     * Crea el objetivo vidas
     * @param name nombre del objeto creado (vidas)
     * @param x posicion de x de la imagen en el tablero
     * @param y posicion de y de la imagen en el tablero
     */
    protected Hearts(String name,int x, int y) {
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

    /**
     * Cambia el color del corazon de rojo a gris.
     */
    protected void changeIcon (){
        setIcon(iconShade);
        setContentAreaFilled(false);
        setBorder(null);
    }
}