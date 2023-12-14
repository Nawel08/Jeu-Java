package representation;

//Importation des classes du package javax.sound.sampled
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import java.io.File;


public class SoundNode extends Decorator {
	
		//Constructeur de notre classe.
	    public SoundNode(Event decoratedEvent) {
	        super(decoratedEvent);
	    }

	    @Override
	    //On rédéfinit la méthode display de décorator
	    public void display(String son) {
	        
	        playMusic(son);

	        // Afficher le contenu du nœud
	        decoratedEvent.display(son);
	    }
	    
	   //Méthode qui va permettre de jouer la musique
	   //Choix de la visibilité: private car, on va l'utiliser uniquement dans cette classe.
	    private void playMusic(String filePath) {
	    	//On utilise un bloc try-catch pour gérer les exceptions liées aux différents problèmes qui peuvent survenir comme l'ouverture du fichier, la lecture etc..
	        try {
	        	//Crée un objet file a partir du lien fournit.
	            File soundFile = new File(filePath);
	            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
	            
	            //Création d'un clip pour utiliser le son.
	            Clip clip = AudioSystem.getClip();
	            clip.open(audioInputStream);

	            clip.addLineListener(event -> {
	                if (event.getType() == LineEvent.Type.STOP) {
	                    clip.close();
	                }
	            });

	            clip.start();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
}
