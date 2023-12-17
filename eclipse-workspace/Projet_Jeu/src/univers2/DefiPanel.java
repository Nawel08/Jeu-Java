package univers2;



import java.util.Random;
import java.util.Scanner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DefiPanel extends JPanel{


	    private List<String> hieroglyphes;
	    private List<String> significations;
	    private List<JButton> boutons;

	    DefiPanel() {
	        hieroglyphes = new ArrayList<>();
	        significations = new ArrayList<>();
	        boutons = new ArrayList<>();

	        // Ajouter des hiéroglyphes et leurs significations
	        hieroglyphes.add("𓀀"); significations.add("A");
	        hieroglyphes.add("𓀁"); significations.add("B");
	        hieroglyphes.add("𓀂"); significations.add("C");

	        // Mélanger les hiéroglyphes pour les rendre aléatoires
	        Collections.shuffle(hieroglyphes);

	        setLayout(new GridLayout(2, hieroglyphes.size()));

	        for (int i = 0; i < hieroglyphes.size(); i++) {
	            JButton bouton = new JButton(hieroglyphes.get(i));
	            bouton.addActionListener(new BoutonListener());
	            boutons.add(bouton);
	            add(bouton);
	        }
	    }

	    boolean validerReponse() {
	        StringBuilder reponse = new StringBuilder();
	        for (JButton bouton : boutons) {
	            reponse.append(bouton.getText());
	        }

	        return reponse.toString().equals("ABC"); // Vous pouvez ajuster la réponse attendue
	    }

	    private class BoutonListener implements ActionListener {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            JButton bouton = (JButton) e.getSource();
	            // Ajoutez ici la logique pour la sélection/désélection des hiéroglyphes
	        }
	    }
	
}
