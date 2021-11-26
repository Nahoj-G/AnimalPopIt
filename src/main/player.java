package main;

import javax.swing.JFrame;

public class player{
	
	private int nivelAlcanzado;
	private final String nombre;
	private int vidas;

	player(String nombre, int vidas, int nivenAlcanzado){
		this.vidas = vidas;
		this.nombre = nombre;
		this.nivelAlcanzado= nivenAlcanzado;
		
	}

	
	//PUES NOSE, YA SE ME OLVIDO QUE IBA AQUI!	
	
	
	
	
	
	public int getVidas() {
		return vidas;
	}

	public void setVidas(int vidas) {
		this.vidas = vidas;
	}

	public int getNivelAlcanzado() {
		return nivelAlcanzado;
	}

	public void setNivelAlcanzado(int nivelAlcanzado) {
		this.nivelAlcanzado = nivelAlcanzado;
	};
	
	
	
	
	
	
	
}

