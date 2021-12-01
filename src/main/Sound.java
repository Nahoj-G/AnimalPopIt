package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystems;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;

class Sound extends JButton {
   
   /**
	 * Clase de reproducción de sonidos
	 */
	private static final long serialVersionUID = 1L;
	private File archivowav;
   private Clip clip;
   private AudioInputStream audioInputStream;

    /**
     * Crea un sonido
     */
      protected Sound() {
      
      archivowav = new File(FileSystems.getDefault().getPath("").toAbsolutePath() + "");
       
      Sound.this.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {                
                play();           }
       });
   }
   
   /**
    * Metodo para reproducir un archivo de audio 
    */
   public void play(){
       try {
           //audioInputStream = AudioSystem.getAudioInputStream(archivowav);            
           clip = AudioSystem.getClip();
           clip.open(audioInputStream);            
           clip.start();

       } catch (LineUnavailableException | IOException e) {
           System.err.println(e.getMessage());
       }
   }

    /**
     * Metodo para asignar el sonido
     * @param resource localización del sonido
     */
   public void setLocationSong(String resource) {
	   InputStream inputStream = this.getClass().getResourceAsStream(resource);
	   try {
		   audioInputStream = AudioSystem.getAudioInputStream(new BufferedInputStream(inputStream));
	   } catch (IOException | UnsupportedAudioFileException e) {
		   System.err.println("ERROR: Playing sound has failed");
		   e.printStackTrace();
	   }
   }

    /**
     * detiene la reproducción
     */
   public void stop() {
		   clip.stop();
   }

    /**
     * Realiza la reproducción en bucle
     * @param x cantidad de reproducciones para un sonido
     */
   public void loop(int x) {
	   clip.loop(x);
   }
}