package representation;
import representation.Decorator;
import univers.Evenements_2_u1;
import univers.Introduction1;
import univers2.Introduction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Décorateur concret ImageNode
public class ImageNode extends Decorator {
    @SuppressWarnings("unused")
    private String imagePath;

    public ImageNode(Event decoratedEvent, String imagePath) {
        super(decoratedEvent);
        this.imagePath = imagePath;
    }
    
    Introduction1 introduction = new Introduction1();
    Introduction intro = new Introduction();
    
    public ImageNode(Introduction1 introduction, String imagePath) {
        
        this.imagePath = imagePath;
    }
    
    public ImageNode(Introduction intro, String imagePath) {
        
        this.imagePath = imagePath;
    }

    
    public void display_intro(String nom) {
        System.out.println("L'image de " + nom + " s'est affichée, jettes-y un coup d'oeil");
        displayImage();
        
    }
    
    @Override
    public void display(String nom) {
        System.out.println("L'image de " + nom + " s'est affichée, jettes-y un coup d'oeil");
        displayImage();
        decoratedEvent.display(nom);
    }

    @Override
    public Event chooseNext() {
        System.out.println("choix spécifique de ImageDecorator");
        return decoratedEvent.chooseNext();
    }

    public void displayImage() {
        JFrame f = new JFrame("ImageNode");
        //on définit la taille de la fenêtre.
        f.setSize(800, 800);
        f.setLayout(new FlowLayout());

        ImageIcon icon = new ImageIcon(imagePath);
        JLabel label = new JLabel(icon);
        f.getContentPane().add(label, BorderLayout.CENTER);
        
        //Création d'un bouton fermer
        JButton b = new JButton("Fermer");
        //On l'ajoute à la fenêtre.
        f.add(b);

        // On ajoute un écouteur d'evenement, pour que quand on clique dessus ca ferme la fenetre
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Fermeture de la fenetre quand on clique.
                f.dispose();
            }
        });

        // Définition de l'action par défaut.
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        f.setVisible(true);
    }
}
