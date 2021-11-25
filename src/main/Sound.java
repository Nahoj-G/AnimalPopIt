

package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.JFrame;

import static java.lang.Thread.sleep;


public class Sound extends JButton {
   
   private File archivowav;
   private Clip clip;
   private AudioInputStream audioInputStream;

   /**
    * Constructor de clase
    */
      public Sound() {
      
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
           audioInputStream = AudioSystem.getAudioInputStream(archivowav);            
           clip = AudioSystem.getClip();
           clip.open(audioInputStream);            
           clip.start();

       } catch (LineUnavailableException | IOException| UnsupportedAudioFileException e) {
           System.err.println(e.getMessage());
       }
   }
   
   public void setLocationSong(String a) {
	  archivowav = new File(FileSystems.getDefault().getPath("").toAbsolutePath() + a);
   }
}