package main;

public class Player {
	
	private int levelReached =0;
	private String name;
	private  int lives =3;

	Player(String name){
		name = name.substring(0,1).toUpperCase() + name.substring(1);
		this.name = name;		
	}	
//Metodos
	protected String getName() {
		return name;
	}
	
	protected int getLives() {
		return lives;
	}

	protected void setVidas(int lives_) {
		lives = lives_;
	}

	protected int getLevelReached() {
		return levelReached;
	}

	protected void setLevelReached(int levelReached) {
		this.levelReached = levelReached;
	}	
}