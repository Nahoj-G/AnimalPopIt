package main;

import javax.swing.*;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

class Lose extends JFrame{

    /**
	 * Clase que muestra un form cuando pierde el jugador
	 */
	private static final long serialVersionUID = 1L;
	private JLabel labelBackground,userPlayerInfo,userPlayer1,userPlayer2,userPlayer3,userPlayer4,userPlayer5;
	private JLabel levelPlayer1,levelPlayer2,levelPlayer3,levelPlayer4,levelPlayer5;
    private LBotton FinBotton,backToMenu2Botton,menuBotton;
    private ImageIcon animalIcon,windowIcon;
    private static Sound musicLose = new Sound();
	private String userPlayer [][];

	/**
	 * Crea el formulario donde puede volver a intentar o salir del juego
	 */
    protected Lose(){

        animalIcon = new ImageIcon(this.getClass().getResource("/images/perdiste.png"));
        windowIcon = new ImageIcon(this.getClass().getResource("/images/icon.png")); 
        
        setSize(options.WIDTH,1100);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setIconImage(windowIcon.getImage());
        setTitle("Animal Pop It");
        musicLose.setLocationSong("/sounds/gameOver.wav");
        musicLose.play();        
        
        labelBackground = new JLabel(animalIcon);
        labelBackground.setSize(options.WIDTH,1100);       
        
        add(labelBackground);   
        
        
		// boton para ir al menu principal
        menuBotton = new LBotton("menu",180,820,126,126);
		menuBotton.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {			
			new MainMenu();
			dispose();		
			}
		});

		// boton para salir del juego
        FinBotton = new LBotton("Fin",492,820,126,126);
		FinBotton.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {			
			System.exit(0);		
			}
		});		

		// boton para intentar de nuevo
		backToMenu2Botton = new LBotton("backToMenu2",340,820,126,126);
   		backToMenu2Botton.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			EntryUser.getPlayer().setLives(3);
			new CountForm(true);
			dispose();			
		}				
		
		});
   		
   		userPlayerInfo = new JLabel();
   		userPlayerInfo.setText("LLEGASTE AL NIVEL:  "+ EntryUser.getPlayer().getNivelAlcanzado());
   		userPlayerInfo.setBounds(165,627,1500,48);
   		userPlayerInfo.setFont(new Font("Jokerman", Font.PLAIN, 40));
   		
   		
		labelBackground.add(userPlayerInfo);
        labelBackground.add(menuBotton);
		labelBackground.add(FinBotton);
		labelBackground.add(backToMenu2Botton);
		add(labelBackground);


		saveData(EntryUser.getPlayer().getNamePlayer(),EntryUser.getPlayer().getNivelAlcanzado());
		userPlayer = getData();

		int y = 753;
		int factor = 53;
		int x = 850;

		userPlayer1 = new JLabel();
		userPlayer1.setText(userPlayer [0][0]);
		userPlayer1.setBounds(x,y + 0 * factor,300,28);
		userPlayer1.setFont(new Font("Jokerman", Font.PLAIN, 28));

		userPlayer2 = new JLabel();
		userPlayer2.setText(userPlayer [1][0]);
		userPlayer2.setBounds(x,y + 1 * factor,300,28);
		userPlayer2.setFont(new Font("Jokerman", Font.PLAIN, 28));

		userPlayer3 = new JLabel();
		userPlayer3.setText(userPlayer [2][0]);
		userPlayer3.setBounds(x,y + 2 * factor,300,28);
		userPlayer3.setFont(new Font("Jokerman", Font.PLAIN, 28));

		userPlayer4 = new JLabel();
		userPlayer4.setText(userPlayer [3][0]);
		userPlayer4.setBounds(x,y + 3 * factor,300,28);
		userPlayer4.setFont(new Font("Jokerman", Font.PLAIN, 28));

		userPlayer5 = new JLabel();
		userPlayer5.setText(userPlayer [4][0]);
		userPlayer5.setBounds(x,y + 4 * factor,300,28);
		userPlayer5.setFont(new Font("Jokerman", Font.PLAIN, 28));

		x = x + 480;
		levelPlayer1 = new JLabel();
		levelPlayer1.setText(userPlayer [0][1]);
		levelPlayer1.setBounds(x,y + 0 * factor,100,28);
		levelPlayer1.setFont(new Font("Jokerman", Font.PLAIN, 28));

		levelPlayer2 = new JLabel();
		levelPlayer2.setText(userPlayer [1][1]);
		levelPlayer2.setBounds(x,y + 1 * factor,100,28);
		levelPlayer2.setFont(new Font("Jokerman", Font.PLAIN, 28));

		levelPlayer3 = new JLabel();
		levelPlayer3.setText(userPlayer [2][1]);
		levelPlayer3.setBounds(x,y + 2 * factor,100,28);
		levelPlayer3.setFont(new Font("Jokerman", Font.PLAIN, 28));

		levelPlayer4 = new JLabel();
		levelPlayer4.setText(userPlayer [3][1]);
		levelPlayer4.setBounds(x,y + 3 * factor,100,28);
		levelPlayer4.setFont(new Font("Jokerman", Font.PLAIN, 28));

		levelPlayer5 = new JLabel();
		levelPlayer5.setText(userPlayer [4][1]);
		levelPlayer5.setBounds(x,y + 4 * factor,100,28);
		levelPlayer5.setFont(new Font("Jokerman", Font.PLAIN, 28));

		labelBackground.add(userPlayer1);
		labelBackground.add(userPlayer2);
		labelBackground.add(userPlayer3);
		labelBackground.add(userPlayer4);
		labelBackground.add(userPlayer5);
		labelBackground.add(levelPlayer1);
		labelBackground.add(levelPlayer2);
		labelBackground.add(levelPlayer3);
		labelBackground.add(levelPlayer4);
		labelBackground.add(levelPlayer5);

		repaint();

	}
	
	private void saveData (String name, int level){
		String url="jdbc:sqlite:db.db";

		try{
			Class.forName("org.sqlite.JDBC");
			Connection connection = DriverManager.getConnection(url.replace("%20"," ").replace("file:",""));
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);  // set timeout to 30 sec.
			statement.executeUpdate("create table IF NOT EXISTS players (id integer PRIMARY KEY AUTOINCREMENT, name string, level string)");
			statement.executeUpdate("INSERT INTO players (name,level) VALUES ('" + name + "'," + level + ");");

		}catch (Exception e){
			JOptionPane.showMessageDialog(null,e.getMessage());
		}


	}
	
	private String [][] getData (){
		String playerLevel [][] = new String[5][2];
		int i = 0;
		String url="jdbc:sqlite:db.db";

		try{
			Class.forName("org.sqlite.JDBC");
			Connection connection = DriverManager.getConnection(url.replace("%20"," ").replace("file:",""));
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);  // set timeout to 30 sec.
			ResultSet rs = statement.executeQuery("select * from players order by level DESC limit 5");
			while(rs.next())
			{
				playerLevel [i][0] = rs.getString("name");
				playerLevel [i][1] = rs.getString("level");
				System.out.println(playerLevel [i][0] + " " + playerLevel [i][1]);
				i++;
			}

		}catch (Exception e){
			JOptionPane.showMessageDialog(null,e.getMessage());
		}

		return playerLevel;
	}
}