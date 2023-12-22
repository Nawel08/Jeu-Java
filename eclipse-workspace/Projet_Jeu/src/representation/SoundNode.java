package representation;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;

public class SoundNode extends Decorator {
    
    private Clip clip;

    public SoundNode(Event decoratedEvent) {
        super(decoratedEvent);
    }

    public SoundNode() {
        
    }

    @Override
    public void display(String son) {
        try {
            // Utilisez la méthode avec la commande "play"
            manageSound(son, "play");
        } catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
        decoratedEvent.display(son);
    }

    // Nouvelle méthode pour gérer le son
    public void manageSound(String son, String command) throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        File audioFile = new File(son);

        if (!audioFile.exists()) {
            System.out.println("Error: File not found");
            return;
        }

        AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);

        clip = AudioSystem.getClip();
        clip.open(audioStream);

        if ("play".equalsIgnoreCase(command)) {
            clip.start();
        } else if ("stop".equalsIgnoreCase(command)) {
            stop();
        } 
    }

    public void stop() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
            System.out.println("Son arrêté.");
        }
    }
}
