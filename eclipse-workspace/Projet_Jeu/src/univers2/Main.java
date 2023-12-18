package univers2;
import java.util.Scanner;

import representation.InnerNode;
import representation.TerminalNode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Main {

	    public static void main(String[] args) {
	    	
	    	TerminalNode tn= new TerminalNode();
	    		    	
/*__________________________________________________________
            	INTRODUCTION
____________________________________________________________*/
	    	
	    	Introduction introduction = new Introduction();
	        introduction.display();	  
	        
	        //Demander à l'utilisateur de commencer la partie
	        System.out.println("Appuyez sur Entrée pour commencer la partie...");
	        Scanner scanner = new Scanner(System.in);
	        scanner.nextLine();
	    	
/*__________________________________________________________
	    	      ETAPE 1 
____________________________________________________________*/
	    	
	        Evenements_1 e1= new Evenements_1();
	        
	        String choix=e1.choix("Combat", "Art");
	        
	        if (choix=="Combat") {
	        
	        // Simulation d'un combat, la méthode renvoi un boolean, on le nomme victoire.
	        boolean victoire = e1.combat();

	        // Vérification du résultat du combat
	        if (victoire) {
	            System.out.println("Félicitations! Vous avez remporté le combat. Passez à l'étape suivante.");
	        } 
	        else {
	            tn.display("Dommage! Vous avez perdu le combat. Fin de la partie.");
	            
	        }
	        }
	        
	        else if(choix=="Art") {
	        	
	            boolean volReussi = e1.volerStand();
	            if (volReussi) {
	                System.out.println("Vous avez réussi à voler le stand d'objets précieux.");
	                boolean r_c=e1.cleopatreRencontre(volReussi);
	                
	                if(r_c==false) { //Si marc antoine ne repond pas bien a l'une des question il peut appeler la fée
	                	//on peut imaginer que s'il veut appeler la file il n'a qua criee JENIWELLLL
	                	boolean etape2=e1.defi_fee();
	                	if (etape2) {
	                		System.out.println("Felicitation tu passes à l'étape 2 !");
	                	}
	                	else {
	                		tn.display("Malheuresement l'aventure s'arrête ici.");
	                	}
	  
	    	        }
	                
	            } 
	            else {
	            		System.out.println("Votre tentative de vol a échoué. Fin de la partie.");
	            }
	       } //du else if
	    		
/*__________________________________________________________
            	ETAPE 2 
____________________________________________________________*/
	    	
	        Evenements_2 e2= new Evenements_2();
		    
		    //Si l'utilisateur passe a l'étape suivante alors on affiche l'intro.
		    e2.intro();
		    
		    String choix_e2=e2.choix("Offrir un cadeau à Cléopatre grâce à la fée", "Résoudre un calcul pour impressioner Cléopatre.");
		    /*
		    //En fonction du choix de l'utilisateur on fait appel à la méthode en question, puis à la méthode de dessin.
		    if (choix_e2=="Offrir un cadeau à Cléopatre grâce à la fée") {
		    	e2.demanderCadeaux();  //On s'interesse pas a si elle est reussi ou non, on l'appel seulement car tout se passe dans la methode pour pas surcharger le main.
		    	
		    	//pour le dernier challenge
		    		SwingUtilities.invokeLater(() -> {
		            JFrame frame = new JFrame("Défi des Hiéroglyphes");
		            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		            frame.setSize(400, 400);

		            DefiPanel defiPanel = new DefiPanel();
		            frame.add(defiPanel, BorderLayout.CENTER);

		            JButton boutonValider = new JButton("Valider");
		            boutonValider.addActionListener(e -> {
		                boolean reussi = defiPanel.validerReponse(); //reussi correspond à l'issu du defi des hieroglyphes
		                int m = e2.afficherResultat(reussi);
		                e2.mariage(m);
		            });

		            frame.add(boutonValider, BorderLayout.SOUTH);

		            frame.setVisible(true);
		        });
		    
		    
		    }
		    
		    else if (choix_e2=="Résoudre un calcul pour impressioner Cléopatre.") {
		    	e2.Calcul();
		    	//pour le dernier challenge
	    		SwingUtilities.invokeLater(() -> {
	            JFrame frame = new JFrame("Défi des Hiéroglyphes");
	            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	            frame.setSize(400, 400);

	            DefiPanel defiPanel = new DefiPanel();
	            frame.add(defiPanel, BorderLayout.CENTER);

	            JButton boutonValider = new JButton("Valider");
	            boutonValider.addActionListener(e -> {
	                boolean reussi = defiPanel.validerReponse(); //reussi correspond à l'issu du defi des hieroglyphes
	                int m = e2.afficherResultat(reussi);
	                e2.mariage(m);
	            });

	            frame.add(boutonValider, BorderLayout.SOUTH);

	            frame.setVisible(true);
	        });
		    	
		    }//si c'est le calcul qui a été choisi
		    */
	    		
/*__________________________________________________________
            	ETAPE 3 
____________________________________________________________*/
	    		
		    Evenements_3 e3= new Evenements_3();
		    
		    boolean resultat_jeu;
		    
		    String choix_e3=e3.choix("Echec","Uno");
		    
		    if (choix=="Echec") {
		    	resultat_jeu=e3.playChessOnline("Marc_Antoine2023");
		    }
		    else if (choix=="Uno") {
		    	resultat_jeu;
		    	
		    }
		    
		    if (resultat_jeu) {
		    	e3.display("Fecilitation Octave est mort ...");
		    	//On affiche le mot de cette partie
		    	e3.mot_final("Idiot",3);
		    	e3.mot_final();
		    }
		    else {
		    	tn.display("la partie est fini.");
		    }

	        
 
	    
	   
} //methode pour tester
} //classe



