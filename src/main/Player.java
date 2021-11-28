package main;

public class Player {
	
	private int nivelAlcanzado;
	private final String nombre;
	private int vidas;

	Player(String nombre, int vidas, int nivenAlcanzado){
		this.vidas = vidas;
		nombre = nombre.substring(0,1).toUpperCase() + nombre.substring(1);
		this.nombre = nombre;
		this.nivelAlcanzado= nivenAlcanzado;		
	}

	public String getNombre() {
		return nombre;
	}

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
	}
	
}