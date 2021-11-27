package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EntryUser extends JFrame{

    public static final int WIDTH = 1514,  HEIGHT = 1080;
    private JLabel labelBackground;
    private LBotton initBotton,menuBotton;
    private ImageIcon animalIcon,windowIcon;
    private JTextField popUser;
    static public  Player player;
     
    public EntryUser(){
    	
    	animalIcon = new ImageIcon(this.getClass().getResource("/images/entryUser.png"));    	
        windowIcon = new ImageIcon(this.getClass().getResource("/images/icon.png")); 
        labelBackground = new JLabel(animalIcon);
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
        popUser = new JTextField();
        popUser.setBounds(360,625,770,118);
        popUser.setFont(new Font("Consolas", Font.PLAIN,75));
        popUser.setBackground(new Color(240,236,231));        
        popUser.setBorder(null);      
        popUser.setHorizontalAlignment(JTextField.CENTER);
        
              
        //boton para regresar al menu principal
        menuBotton = new LBotton("menu",600,850,126,126);
		menuBotton.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {			
			new MainMenu();
			dispose();
		
			}
		});
		//boton para iniciar el juego.
        initBotton = new LBotton("initGameFromEntryUSer",775,850,126,126);
		initBotton.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {

            if (submitAction().equals("")){
                JOptionPane.showMessageDialog(null, "No puede jugar sin asignar un nombre de jugador", "Error: " + "Ingresar nombre", JOptionPane.INFORMATION_MESSAGE);
            }else {
                //se crea nuevo usuario con el nombre dado en el textfield, vidas, y el nivel actual, que no lo he configurado
                player = new Player(submitAction(), 3, Level.outLevel);
                //llama al contador del 3.2.1 etc
                new CountForm(true);
            }
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
      
 }
        
  
 
