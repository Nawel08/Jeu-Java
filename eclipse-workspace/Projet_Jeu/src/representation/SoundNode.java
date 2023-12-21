package representation;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.sound.sampled.*;

public class SoundNode extends Decorator {

    public SoundNode(Event decoratedEvent) {
        super(decoratedEvent);
    }
    
    public SoundNode() {
           
    }

    @Override
    public void display(String son) {
        try {
			playMusic(son);
		} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        decoratedEvent.display(son);
    }

    public static void playMusic(String son) throws LineUnavailableException, IOException, UnsupportedAudioFileException {        
    	
            File audioFile = new File(son);

            if (!audioFile.exists()) {
                System.out.println("Error: File not found");
                return;
            }

            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);

            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);

            String response = "";

            clip.start();
                               
            //On peut utiliser le stop, close, etc mais non necessaire.
      
    }
  
}

