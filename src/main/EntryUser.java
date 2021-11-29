package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Objects;

public class EntryUser extends JFrame{

    private static final int WIDTH = 1514,  HEIGHT = 1080;
    private final JTextField popUser;
    private static Player player;
     
    public EntryUser(){

        ImageIcon animalIcon = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/images/entryUser.png")));
        ImageIcon windowIcon = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/images/icon.png")));
        JLabel labelBackground = new JLabel(animalIcon);
        labelBackground.setSize(WIDTH,HEIGHT);
        
        add(labelBackground);
        setSize(WIDTH,HEIGHT);
        setTitle("Animal Pop It");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setIconImage(windowIcon.getImage());
        
        //campo donde ignresar el texto
        popUser = new JTextField(5);
        popUser.setBounds(360,625,770,118);
        popUser.setFont(new Font("Consolas", Font.PLAIN,75));
        popUser.setBackground(new Color(240,236,231));        
        popUser.setBorder(null);      
        popUser.setHorizontalAlignment(JTextField.CENTER);
        //aqui configuere el limite y la tecla enter
        popUser.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            	// limit to 10 characters
                if (popUser.getText().length() >= 10 ) 
                    e.consume();
            }@Override public void keyPressed(KeyEvent e) {	
            	
            }
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					if (submitAction().equals("")){
		                JOptionPane.showMessageDialog(null, "No puede jugar sin asignar un nombre de jugador", "Error: " + "Ingresar nombre", JOptionPane.INFORMATION_MESSAGE);
		            }else {
		                //se crea nuevo usuario con el nombre dado en el textfield, vidas, y el nivel actual
		                player = new Player(submitAction(), 3,1);
		                //llama al contador del 3.2.1 etc	
		                new CountForm(true);
		                dispose();
		            }
					
				}
				
			}
        });
              
        //boton para regresar al menu principal
        LBotton menuBotton = new LBotton("menu", 600, 850, 126, 126);
		menuBotton.addActionListener(e -> {
			new MainMenu();
			dispose();

			});
		//boton para iniciar el juego.
        LBotton initBotton = new LBotton("initGameFromEntryUSer", 775, 850, 126, 126);
		initBotton.addActionListener(e -> {

            if (submitAction().equals("")){
                JOptionPane.showMessageDialog(null, "No puede jugar sin asignar un nombre de jugador", "Error: " + "Ingresar nombre", JOptionPane.INFORMATION_MESSAGE);
            }else {
                //se crea nuevo usuario con el nombre dado en el textfield, vidas, y el nivel actual, que no lo he configurado
                player = new Player(submitAction(), 3,1);
                //llama al contador del 3.2.1 etc

                new CountForm(true);
                dispose();
            }
        });
		
        labelBackground.add(menuBotton);
	    labelBackground.add(initBotton);
		labelBackground.add(popUser);            
       
        repaint();
      
     }
    //metodo para obtener el nombre del usuario dado por el text, tambien hay
    //uno en la clase player, pero no lo he usado aun
    private String submitAction() {        
        System.out.println(popUser.getText());
        return popUser.getText();
   } 

          
	public static Player getPlayer() {
		return player;
	}
	
      
 }