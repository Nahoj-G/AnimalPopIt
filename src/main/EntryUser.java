package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class EntryUser extends JFrame{

    /**
	 * Clase donde se obtiene el nombre del jugador
	 */
	private static final long serialVersionUID = 1L;
	private JLabel labelBackground;
    private LBotton initBotton,menuBotton;
    private ImageIcon BackgroundImage,windowIcon;
    private JTextField userTextEntry;
    protected static Player player;

    /**
     * Crea el formulario para registrar el jugador
     */
    protected EntryUser(){
    	
    	setSize(options.WIDTH,options.HEIGHT);
        setTitle("Animal Pop It");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);        
    	
    	windowIcon = new ImageIcon(this.getClass().getResource("/images/icon.png"));
    	setIconImage(windowIcon.getImage());
    	BackgroundImage = new ImageIcon(this.getClass().getResource("/images/entryUser.png"));  
    	
        labelBackground = new JLabel(BackgroundImage);
        labelBackground.setSize(options.WIDTH, options.HEIGHT);
        add(labelBackground);      
        
        
        //campo donde ignresar el texto
        userTextEntry = new JTextField(5);
        userTextEntry.setBounds(360,625,770,118);
        userTextEntry.setFont(new Font("Consolas", Font.PLAIN,75));
        userTextEntry.setBackground(new Color(240,236,231));        
        userTextEntry.setBorder(null);      
        userTextEntry.setHorizontalAlignment(JTextField.CENTER);
        //aqui configuere el limite y la tecla enter
        userTextEntry.addKeyListener(new KeyListener() {
            /**
             * Metodo que limita el # de caracteres a 10
             * @param e
             */
            @Override
            public void keyTyped(KeyEvent e) {
            	// limit to 10 characters
                if (userTextEntry.getText().length() >= 10 ) 
                    e.consume();
            }@Override public void keyPressed(KeyEvent e) {	
            	
            }

            /**
             * Metodo que impide continuar si no se definió un nombre al jugador
             * @param e
             */
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					if (submitAction().equals("")){
		                JOptionPane.showMessageDialog(null,
                                "No puede jugar sin asignar un nombre de jugador", "Error: " + "Ingresar nombre",
                                JOptionPane.INFORMATION_MESSAGE);
		            }else {
		                //se le cambia el nombre al usuario con el nombre dado en el textfield		                
		            	player = new Player(submitAction());
		            	System.out.println("El nombre del jugador es: "+player.getNamePlayer());
		            	
		            	
		                //llama al contador del 3.2.1 etc	
		                new CountForm(true);
		                dispose();
		            }					
				}
			}
        });     
                           
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

        /**
         * Metodo que impide continuar si no se definió un nombre al jugador
         * @param e
         */
		@Override
		public void actionPerformed(ActionEvent e) {
            if (submitAction().equals("")){
                JOptionPane.showMessageDialog(null,
                        "No puede jugar sin asignar un nombre de jugador", "Error: " + "Ingresar nombre",
                        JOptionPane.INFORMATION_MESSAGE);
            }else {
            	 //se le cambia el nombre al usuario con el nombre dado en el textfield            	
            	player = new Player(submitAction());
            	System.out.println("El nombre del jugador es: "+player.getNamePlayer());
                //llama al contador del 3.2.1 etc                
                new CountForm(true);
                dispose();
            }
        }
		});				
		
		labelBackground.add(userTextEntry);  				
        labelBackground.add(menuBotton);
	    labelBackground.add(initBotton);
		                 
        repaint();      
       
    }

    /**
     * metodo para obtener el nombre del usuario dado por el text
     * @return el nombre del jugador
     */
    private String submitAction() {  
        return userTextEntry.getText();
   }

    public static Player getPlayer() {
		return player;
	}
   
     
	
}