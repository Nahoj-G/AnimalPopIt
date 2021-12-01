package main;

import javax.swing.*;
import java.awt.*;
import static java.lang.Thread.sleep;

class CountForm extends JFrame{

    /**
     * Clase que muestra un conteo regresivo al iniciar o cambiar de nivel
     */

	private static final long serialVersionUID = 1L;
    private JLabel labelBackground, countDown;
    private ImageIcon BackgroundImage,windowIcon;
    private Boolean chooseBackGround;
    private Sound conteo = new Sound();

    /**
     * Clase que muestra el conteo regresivo de 3 a 1 para iniciar el nivel, la pantalla
     * de fondo depende si es el primer nivel o no
     * @param chooseBackground define el fondo a mostrar segun si es primer nivel o no
     */
    protected CountForm(Boolean chooseBackground){    	
    	
    	this.chooseBackGround= chooseBackground;
    	windowIcon = new ImageIcon(this.getClass().getResource("/images/icon.png"));
    	BackgroundImage = new ImageIcon(this.getClass().getResource("/images/FirstLevel.png"));
    	setBackGround(chooseBackGround);
    	
        setSize(options.WIDTH,options.HEIGHT);
        setTitle("Animal Pop It");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setIconImage(windowIcon.getImage());    	
    	
    	setBackGround(chooseBackGround);
    	  	  
    	labelBackground = new JLabel(BackgroundImage);
        labelBackground.setSize(WIDTH,HEIGHT);
        add(labelBackground);       
                
        countDown = new JLabel(String.valueOf(3));
        countDown.setBounds(1090, 330, 300, 300);
        countDown.setFont(new Font("Jokerman", Font.PLAIN, 260));        
        countDown.setHorizontalAlignment(JLabel.CENTER);
                       
        labelBackground.add(countDown);    
                
        generateCountDown();                  
                
    }

    /**
     * Metodo que define el fondo dependiente si es primer nivel u otro
     * @param b si es verdadero define un fondo de lo contraio otro fondo
     */
    private void setBackGround(boolean b) {
    	if(b) {
    		BackgroundImage = new ImageIcon(this.getClass().getResource("/images/FirstLevel.png"));
    	}else {
    		BackgroundImage = new ImageIcon(this.getClass().getResource("/images/nextLevelLoading.png"));    		
    	}   
    }


    /**
     * Metodo que inicia el conteo regresivo de 3 a 1 para iniciar el nivel
     */
    private void generateCountDown() {
    	Thread t1 = new Thread(new Runnable() {        	
            public void run(){
             	 try {
                      sleep(300);
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }
                 for (int i = 3 ; i >= 0; i--) {
                 	
                 	if(i==0) {
                 		countDown.setText("Go");
                 		conteo.setLocationSong("/sounds/start.wav");
                     	conteo.play();
                 	}else {
                 		countDown.setText(String.valueOf(i));
                 		conteo.setLocationSong("/sounds/conter.wav");
                 		conteo.play();
                 		try {
                         sleep(1000);
                 		} catch (InterruptedException e) {
                         e.printStackTrace();
                 		}
                    }
                 }   
                 
                 if(chooseBackGround){
                 	   new Game();
                 	   dispose();
                 }else {
                 	 dispose();
                 }
             }
          });
         t1.start();    
    }
}