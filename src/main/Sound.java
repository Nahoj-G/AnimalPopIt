package main;

import javax.sound.sampled.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;


public class Sound extends JButton {
   
   private File archivowav;
   private Clip clip;

    /**
    * Constructor de clase
    */
      public Sound() {
      
      archivowav = new File(FileSystems.getDefault().getPath("").toAbsolutePath() + "");
       
      Sound.this.addActionListener(e -> play());
   }
   
   /**
    * Metodo para reproducir un archivo de audio 
    */
   public void play(){
       try {
           AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(archivowav);
           clip = AudioSystem.getClip();
           clip.open(audioInputStream);            
           clip.start();

       } catch (LineUnavailableException | IOException| UnsupportedAudioFileException e) {
           System.err.println(e.getMessage());
       }
   }
   
   public void setLocationSong(String a) {
       String file = String.valueOf(this.getClass().getResource(a));
	   archivowav = new File(file.replace("%20"," ").replace("file:",""));
   }
   public void stop() {
	   clip.stop();
   }
   public void loop(int x) {
	   clip.loop(x);
   }
}