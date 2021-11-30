package main;

public class Player {
	
	private int nivelAlcanzado =0;
	private String nombre;
	private  int vidas =3;

	Player(String nombre){
		nombre = nombre.substring(0,1).toUpperCase() + nombre.substring(1);
		this.nombre = nombre;		
	}	
//Metodos
	protected String getNombre() {
		return nombre;
	}
	
	protected int getVidas() {
		return vidas;
	}

	protected void setVidas(int vidas_) {
		vidas = vidas_;
	}

	protected int getNivelAlcanzado() {
		return nivelAlcanzado;
	}

	protected void setNivelAlcanzado(int nivelAlcanzado) {
		this.nivelAlcanzado = nivelAlcanzado;
	}
	
}