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

/**
 * Dans cette classe on va retrouver plsuieurs mini-jeu durant lesquels notre joueur devra gagner le maximum de points possible.
 * Si a la fin il a un score >60 alors il pourra se marier avec la reine.
 * @author nawel
 *
 */
public class Evenements_2 {

	//On affiche le but de l'etape grace à une enumeration
	
	InnerNode in= new InnerNode();
	DecisionNode dn= new DecisionNode();
	static TerminalNode tn= new TerminalNode();
	
	/**
	 * Affichage de l'introduction
	 * @param score, score actuel
	 */
	public void intro(int score) {
	
		in.display("Dans cette partie ton score determinera le niveau auquel Cléopatre t'apprecie.");
		in.display("Ton but est de te marier avec elle, et il ne peut être possible que si ton score est >= à 60");
		in.display("A l'étape précédente tu as réussi à attirer son attention, donc ton score est de: "+score);
		in.display("Dans cette etape tu dois donc gagner le maximum de point pour pouvoir te marier avec elle.");
	}
	
	/**
	 * Si le joueur à choisit d'offrir un cadeau à Cléopatre. Il entre un numéro (0 ou 1) et un cadeau apparait,
	 * soit il est au goût de la reine, soit il ne lui convient pas.
	 * (Il ne peut pas savoir en avance)
	 * @param score, score actuel du joueur.
	 */
	public void demanderCadeaux(int score) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Cléôpatre aime qu'on lui offre des cadeaux.");
        System.out.println("Elle n'aime que les cadeaux de qualité, et elle deteste qu'on se moque d'elle en lui offrant des cadeaux sans valeur.");
        
        
        System.out.println("Parmi ces deux cadeaux, il y'en a un que Cléopatre veut absolument avoir, et un autre qu'elle deteste.");

        int cadeau=dn.choix_int();
        
     // Vérifier si le choix est 0 ou 1, sinon demander à nouveau
        while (cadeau != 0 && cadeau != 1) {
        	System.out.println("Choix invalide. Veuillez choisir entre 0 et 1 : ");
            cadeau = scanner.nextInt();
        }     
         // 0 pour le cadeau bien, 1 pour le cadeau nulmp
        //On rajoutera a cet endroit l'apparission de deux cadeaux.
	        if (cadeau==0) {
	        		score+=10;
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
	                
        
                
    } //Fin de la méthode pour demander un cadeau
	
	/**
	 * Si le joueur choisis d'impressionner Cléopatre en resolvant un calcul, 
	 * Le calcul apparait, il doit donner la bonne réponse.
	 * @param score, score du joueur.
	 */
	public void Calcul(int score) {
		System.out.println("Cléopatre est très intelligente, et elle aime les gens intelligent.");
		System.out.print("Tu dois répondre correctement à ce calcul:  ");
		System.out.println("24678-9879");
		
		System.out.println("Entre ta réponse:");
		Scanner scanner = new Scanner(System.in);
		int calcul = scanner.nextInt();
		
		if (calcul==14799) {
			score+=10;
			System.out.println("Felicitation c'est la bonne réponse !");
			System.out.println("Ton score augmente de 10 points");
			System.out.println("Score: "+score+" points.");
			
		}
		else {
			score-=10;
			System.out.println("Ce n'était pas la bonne réponse ...");
			System.out.println("Ton score perd 10 points");
			System.out.println("Score: "+score+" points.");
		}
	
	} //fermeture de la méthdoe calcul
	
	/**
	 * Affiche l'issue du défi.
	 * @param reussi, résultat de la méthode précédente.
	 * @param score, score actuel
	 * @return renvoie le nouveua score en fonction de si le défi a été réussi (bonus, malus)
	 */
	
	public int afficherResultat(boolean reussi, int score) {
	    int finalScore = score;  // Variable locale

	    if (reussi) {
	        finalScore += 20;
	        final int afficheScore = finalScore;  // Variable locale finale pour usage dans la lambda
	        SwingUtilities.invokeLater(() -> {
	            JOptionPane.showMessageDialog(null, "Félicitations ! Tu as réussi le Défi des Hiéroglyphes.");
	            JOptionPane.showMessageDialog(null, "Ton score est désormais de " + afficheScore + " points.");
	        });
	        return finalScore;
	    } else {
	        finalScore -= 20;
	        final int afficheScore = finalScore;  // Variable locale finale pour usage dans la lambda
	        SwingUtilities.invokeLater(() -> {
	            JOptionPane.showMessageDialog(null, "Dommage ! Tu n'as pas réussi le Défi des Hiéroglyphes.");
	            JOptionPane.showMessageDialog(null, "Ton score est désormais de " + afficheScore + " points.");
	        });
	        return finalScore;
	    }
	}

	/**
	 * Méthode qui annonce au joueur s'il peut se marier avec la reine ou non.
	 * @param score, score du joueur
	 * @return, true si le mariage a lieu, false sinon.
	 */
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
	} 
	
} //de la classe
