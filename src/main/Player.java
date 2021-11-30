package main;

public class Player {
	
	private int nivelAlcanzado =0;
	private String namePlayer;
	private  int lives =3;

	Player(String namePlayer){
		namePlayer = namePlayer.substring(0,1).toUpperCase() + namePlayer.substring(1);
		this.namePlayer = namePlayer;		
	}	
//Metodos
	protected String getNamePlayer() {
		return namePlayer;
	}
	
	protected int getLives() {
		return lives;
	}

	protected void setLives(int lives_) {
		lives = lives_;
	}

	protected int getNivelAlcanzado() {
		return nivelAlcanzado;
	}

	protected void setNivelAlcanzado(int nivelAlcanzado) {
		this.nivelAlcanzado = nivelAlcanzado;
	}
	
}