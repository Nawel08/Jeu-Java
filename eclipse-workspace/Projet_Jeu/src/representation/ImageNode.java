package representation;

//Décorateur concret ImageNode
public class ImageNode extends Decorator {
 public ImageNode(Event decoratedEvent) {
     super(decoratedEvent);
 }

 @Override
 public void display() {
     // Ajouter le code d'affichage de l'image ici
     System.out.println("Affichage de l'image");
     decoratedEvent.display();
 }
}