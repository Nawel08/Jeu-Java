package univers2;

import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import representation.InnerNode;
import representation.DecisionNode;
import representation.TerminalNode;

public class Evenements_2 {

	//On affiche le but de l'etape grace à une enumeration
	
	InnerNode in= new InnerNode();
	DecisionNode dn= new DecisionNode();
	static TerminalNode tn= new TerminalNode();
	
	//On initialise le score du personnage à 40 pour cette étape.
	static int score=40;
	public void intro() {
	
		in.display("Dans cette partie ton score determinera le niveau auquel Cléopatre t'apprecie.");
		in.display("Ton but est de te marier avec elle, et il ne peut être possible que si ton score est >= à 80");
		in.display("A l'étape précédente tu as réussi à attirer son attention, donc ton score est de: "+score);
		in.display("Dans cette etape tu dois donc gagner le maximum de point pour pouvoir te marier avec elle.");
	}
	
	public String choix(String s1, String s2) {
		String choix= dn.choix_2_string(s1,s2);
		return choix;
	}
	
	public static void demanderCadeaux() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Cléôpatre aime qu'on lui offre des cadeaux.");
        System.out.println("Elle n'aime  que les cadeaux de qualité, et elle deteste qu'on se moque d'elle en lui offrant des cadeaux sans valeur.");
        System.out.println("Appuie sur entrée pour que la fée te ramène deux cadeaux.");
        
        System.out.println("Parmi ces deux cadeaux, il y'en a un que Cléopatre veut absolument avoir, et un autre qu'elle deteste.");

        // Générer aléatoirement les cadeaux génial et nul
        String cadeauGenial = "B";
        String cadeauNul = "N";

        int choixCadeau = random.nextInt(2); // 0 pour le cadeau bien, 1 pour le cadeau nul
        //METTRE UN DECISION NODE ET CREE UNE NOUVELLE METHODE !!!!
        System.out.println("Choisissez entre 0 et 1 : ");
        int cadeau = scanner.nextInt();
     // Vérifier si le choix est 0 ou 1, sinon demander à nouveau
        while (cadeau != 0 && cadeau != 1) {
            System.out.println("Choix invalide. Veuillez choisir entre 0 et 1 : ");
            cadeau = scanner.nextInt();
        
        //On rajoutera a cet endroit l'apparission de deux cadeaux.
	        if (choixCadeau == 0) {
	        	if (choixCadeau==cadeau) {
	        		score+=10;
	        		System.out.println("Les deux cadeaux apparraissent.");
	        		System.out.println("Felicitation tu as obtenu le bon cadeau, tu gagnes 10 points !");
	        		System.out.println("Ton score est de "+ score+ " points");
	        	}
	        	//Il a choisi le cadeau nul
	        	else {
	        		System.out.println("Les deux cadeaux apparraissent.");
	        		score-=10;
	        		System.out.println("Malheuresement tu n'as pas obtenu le bon cadeau, tu perds 10 points ...");
	        		System.out.println("Ton score est de "+ score+ " points");
	        	}	            
	        }        
        }
                
    } //Fin de la méthode pour demander un cadeau
	
	public void Calcul() {
		System.out.println("Cléopatre est très intelligente, et elle aime les gens intelligent.");
		System.out.print("Tu dois répondre correctement à ce calcul:  ");
		System.out.println("2x+K");
		
		System.out.println("Entre ta réponse:");
		Scanner scanner = new Scanner(System.in);
		int calcul = scanner.nextInt();
		
		if (calcul==2) {
			score+=10;
			System.out.println("Felicitation c'est la bonne réponse !");
			System.out.println("Ton score augmente de 10 points");
			System.out.println("Score: "+score+" points.");
			
		}
			score-=10;
			System.out.println("Ce n'était pas la bonne réponse ...");
			System.out.println("Ton score perd 10 points");
			System.out.println("Score: "+score+" points.");
	
	} //fermeture de la méthdoe calcul
	/*
	public static int afficherResultat(boolean reussi) {
		if (reussi) {
	        score += 20;
	        SwingUtilities.invokeLater(() -> {
	            JOptionPane.showMessageDialog(null, "Félicitations ! Tu as réussi le Défi des Hiéroglyphes.");
	            JOptionPane.showMessageDialog(null, "Ton score est désormais de " + score + " points.");
	        });
	        return score;
	    } else {
	        score -= 20;
	        SwingUtilities.invokeLater(() -> {
	            JOptionPane.showMessageDialog(null, "Dommage ! Tu n'as pas réussi le Défi des Hiéroglyphes.");
	            JOptionPane.showMessageDialog(null, "Ton score est désormais de " + score + " points.");
	        });
	        return score;
	    }
    }
	
	public boolean mariage(int score) {
		boolean mariage;
	    
	    
	    if (score<60) {
	    	System.out.println("Malheuresement ton score ne te permet pas de te marier avec Cléopatre.");
	    	tn.display("L'aventure s'arrête ici pour toi.");
	    	mariage=false;
	    	return mariage;
	    }
	    else {
	    	System.out.println("Felicitation ton score te permet d'être assez apprécié par Cléopatre pour te marier avec elle !");
	    	in.display("Tu te marie avec elle <3");
	    	mariage=true;
	    	return mariage;
	    }
	} */
	
} //de la classe
