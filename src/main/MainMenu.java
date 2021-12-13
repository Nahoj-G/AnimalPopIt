package main;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

class MainMenu extends JFrame{

    /**
	 * Clase del menu principal
	 */
	private static final long serialVersionUID = 1L;
	private ImageIcon animalIcon,windowIcon,creditsImage,howToPlayImage;
    private JLabel labelBackground,creditsLabel,howToPlayLabel;  
    private LBotton startButton,exitButton,creditsButton,backToMenuBotton,howToPlayBotton,backToMenu2Botton;
    private Sound music = new Sound();
 
    /**
     * Crea el menu principal del juego donde puede inicarlo o salir
     */
    protected MainMenu() {
    	System.out.println("Animal Pop IT");
    	System.out.println("Inicializando juego");
    	
        animalIcon = new ImageIcon(this.getClass().getResource("/images/index.png"));     
        windowIcon = new ImageIcon(this.getClass().getResource("/images/icon.png")); 
        creditsImage = new ImageIcon(this.getClass().getResource("/images/credits.png")); 
        howToPlayImage = new ImageIcon(this.getClass().getResource("/images/howToPlay.png"));
        
        labelBackground = new JLabel(animalIcon);
        labelBackground.setSize(options.WIDTH,options.HEIGHT);       
        
        
        creditsLabel = new JLabel();                            
        creditsLabel.setIcon(creditsImage);   
        creditsLabel.setSize(options.WIDTH,options.HEIGHT); 
        creditsLabel.setVisible(false);
        
        howToPlayLabel = new JLabel(); 
        howToPlayLabel.setIcon(howToPlayImage); 
        howToPlayLabel.setSize(options.WIDTH,options.HEIGHT); 
        howToPlayLabel.setVisible(false);        
      
        
        add(creditsLabel);
        add(howToPlayLabel);
        add(labelBackground);
        
        setSize(options.WIDTH,options.HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setIconImage(windowIcon.getImage()); 
        setTitle("Animal Pop It");
        
        
        // boton para cerrar las ventanas emergentes          	
    	backToMenuBotton = new LBotton("backToMenu", 1380, 20, 93, 93);   
    	backToMenuBotton.setVisible(false);   
    	backToMenuBotton.addMouseListener (new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				exitButton.setVisible(true);
	        	startButton.setVisible(true);    
	        	creditsButton.setVisible(true);
	        	howToPlayBotton.setVisible(true);  
	        	
	        	creditsLabel.setVisible(false);         	
	        	howToPlayLabel.setVisible(false);  				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				
			}
    		
    	});
    
    	// boton para cerrar las ventanas emergentes          	
    	backToMenu2Botton = new LBotton("backToMenu", 1380, 20, 93, 93);   
    	backToMenu2Botton.setVisible(false);     	
        
    	backToMenu2Botton.addMouseListener (new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				exitButton.setVisible(true);
	        	startButton.setVisible(true);    
	        	creditsButton.setVisible(true);
	        	howToPlayBotton.setVisible(true);  
	        	
	        	creditsLabel.setVisible(false);         	
	        	howToPlayLabel.setVisible(false);
			}
			@Override
			public void mousePressed(MouseEvent e) {
			}			
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			@Override
			public void mouseExited(MouseEvent e) {
			}
    		
    	});
    	

        // boton para iniciar el juego
        startButton = new LBotton("start",622,590,270,100);        
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             //new CountForm(true);
               setVisible(false);
               new EntryUser();
               music.stop();            
               dispose();   
            }
        });
       
        
     // boton para ver los creditos del juego
        creditsButton = new LBotton("credits",553,694,202,81);   
        creditsButton.addMouseListener (new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	backToMenu2Botton.setVisible(true); 
           
            	howToPlayBotton.setVisible(false);            	
            	exitButton.setVisible(false);
            	startButton.setVisible(false); 
            	creditsButton.setVisible(false);
            	
            	creditsLabel.setVisible(true);  
           	}            
            @Override
            public void mousePressed(MouseEvent e) {
                
            }
            @Override
            public void mouseReleased(MouseEvent e) {
            }
            @Override
            public void mouseEntered(MouseEvent e) {
            }
            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
     
     // boton para ver las instrucciones del juego
        howToPlayBotton = new LBotton("howToPlay",759,694,202,81);   
        howToPlayBotton.addMouseListener (new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	howToPlayLabel.setVisible(true);   
            	backToMenuBotton.setVisible(true);            	
            	
            	howToPlayBotton.setVisible(false);            	
            	exitButton.setVisible(false);
            	startButton.setVisible(false); 
            	creditsButton.setVisible(false); 
           	}            
            @Override
            public void mousePressed(MouseEvent e) {
            }
            @Override
            public void mouseReleased(MouseEvent e) {
            }
            @Override
            public void mouseEntered(MouseEvent e) {
            }
            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        
        // boton para salir del juego
        exitButton = new LBotton("exit",622,780,270,100);   
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {             
               dispose();
               music.stop();             
               System.exit(0);
            }
        });
       labelBackground.add(howToPlayBotton);    
       labelBackground.add(startButton);
       labelBackground.add(creditsButton);
       labelBackground.add(exitButton); 
       creditsLabel.add(backToMenu2Botton);       
       howToPlayLabel.add(backToMenuBotton);       
       music.setLocationSong("/sounds/back.wav");
       music.play();
       music.loop(4);
       
      repaint();
    }
    
}