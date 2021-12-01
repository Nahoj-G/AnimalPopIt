package main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Objects;
import static java.lang.Thread.sleep;

/**
 * Clase del objeto animals que se agregará a la clase game cuando se instancie
 * @author Johan Granados, Kevin Camargo. Sebastián Velásquez
 */
class Animals extends JButton {
	private static final long serialVersionUID = 1L;
	private static Sound click = new Sound();
	private final ImageIcon icon, iconShade;
	private final String name;

	/**
	 * Crea una animal recibiendo como parametros  la posición en x de la imagen,
	 * la posición en y de la imagen (el animal)
	 * la altura de la imagen (el animal)
	 * el ancho de la imagen (el animal)
	 */
	protected Animals(String name,int x, int y, int h, int w ){

		this.name = name;
		icon = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/images/" + name + ".png")));
		iconShade = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/images/" + name + "Shade.png")));

		setIcon(iconShade);
		setBounds(x,y,h,w);
		setContentAreaFilled(false);
		setBorder(null);
		setFocusPainted(false);
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});

		addMouseListener (new MouseListener () {
			@Override
			public void mouseClicked(MouseEvent e) {

			}

			/**
			 * Reproduce el sonido asociado al animal creado
			 * @param e
			 */
			@Override
			public void mousePressed(MouseEvent e) {
				if(EntryUser.getPlayer().getNivelAlcanzado()!=1) {
				Animals.stopMusic();}
				click.setLocationSong("/sounds/" + name + ".wav");
				click.play();
			}
			@Override
			public void mouseReleased(MouseEvent e) {
			}

			/**
			 * Cambiar el color del animal al pasar el mouse por ensima de la mesa
			 * @param e
			 */
			@Override
			public void mouseEntered(MouseEvent e) {
				setRolloverIcon(icon);
			}
			@Override
			public void mouseExited(MouseEvent e) {
			}
		 });
	}

	/**
	 * Nombre del animal creado
	 * @return nombre del animal creado
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Cambia la imagen a color reproduce un sonido y finalmente cambia de nuevo a escala de grises
	 * el color
	 */
	public void changeIcon (){
		setIcon(icon);
		setContentAreaFilled(false);
		setBorder(null);
		click.setLocationSong("/sounds/" + name + ".wav");
		click.play();
		try {
			sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		setIcon(iconShade);
		setContentAreaFilled(false);
		setBorder(null);
	}

	/**
	 * Detiene la reproducción del sonido del animal
	 */
	public static void stopMusic()
	{
		click.stop();
	}
}