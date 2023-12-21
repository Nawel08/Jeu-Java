package univers2;
import java.util.Scanner;

import representation.InnerNode;
import representation.TerminalNode;
import representation.DecisionNode;
import representation.SoundNode;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Main {

	    public static void main(String[] args) throws LineUnavailableException, IOException, UnsupportedAudioFileException{
	    	
	    	InnerNode in = new InnerNode();
	    	DecisionNode dn = new DecisionNode();
	    	TerminalNode tn= new TerminalNode();
	    	SoundNode son = new SoundNode();
	    	
	    	int score=0;
/*__________________________________________________________
            	INTRODUCTION
____________________________________________________________*/
	    	
	    	 	
	    		Scanner scanner = new Scanner(System.in);
	    	
	    	    // Play music
	    	    
	    	    

	    	    // Introduction
	    	    Introduction introduction = new Introduction();
	    	    introduction.display();  

	    	    // Ask the user to start the game
	    	    System.out.println("Appuyez sur Entrée pour commencer la partie...");
	    	    scanner.nextLine();
/*__________________________________________________________
	    	      ETAPE 1 
____________________________________________________________*/
	    	
	        Evenements_1 e1= new Evenements_1();
	        
	        
	        String choix=dn.choix_2_string("Combat", "Art");
	        
	        if (choix=="Combat") {
	        	son.playMusic("C:/Users/nawel/Downloads/10803.wav");
	        // Simulation d'un combat, la méthode renvoi un boolean, on le nomme victoire.
	        boolean victoire = e1.combat(score);
	        boolean conditions=true;
	        while (conditions) {
	        // Vérification du résultat du combat
	        if (victoire) {
	            System.out.println("Félicitations! Vous avez remporté le combat. Passez à l'étape suivante.");
	            conditions=false;
	        } 
	        else {
	            tn.display("Dommage! Vous avez perdu le combat. Fin de la partie.");
	            break;
	            
	        }}
	        }
	        
	        else if(choix=="Art") {
	        	son.playMusic("C:/Users/nawel/Downloads/Brouhaha.wav");
	            boolean volReussi = e1.volerStand(score);
	            if (volReussi) {
	            	son.playMusic("C:/Users/nawel/Downloads/Bonjour_femme.wav");
	                boolean r_c=e1.cleopatreRencontre(volReussi,score);
	                
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
	            		
	            		return;
	            }
	       } //du else if
	    		
/*__________________________________________________________
            	ETAPE 2 
____________________________________________________________*/
	    	
	        Evenements_2 e2= new Evenements_2();
		    
		    //Si l'utilisateur passe a l'étape suivante alors on affiche l'intro.
		    e2.intro(score);
		    
		    String choix_e2=dn.choix_2_string("Offrir un cadeau à Cléopatre grâce à la fée", "Résoudre un calcul pour impressioner Cléopatre.");
		    
		    //En fonction du choix de l'utilisateur on fait appel à la méthode en question, puis à la méthode de dessin.
		    if (choix_e2=="Offrir un cadeau à Cléopatre grâce à la fée") {
		    	
		    	e2.demanderCadeaux(score);  //On s'interesse pas a si elle est reussi ou non, on l'appel seulement car tout se passe dans la methode pour pas surcharger le main.
		    	
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
		                int m = e2.afficherResultat(reussi, score);
		                e2.mariage(m);
		            });

		            frame.add(boutonValider, BorderLayout.SOUTH);

		            frame.setVisible(true);
		        });
		    
		    
		    }
		    
		    else if (choix_e2=="Résoudre un calcul pour impressioner Cléopatre.") {
		    	e2.Calcul(score);
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
	                int m = e2.afficherResultat(reussi,score);
	                e2.mariage(score);
	            });

	            frame.add(boutonValider, BorderLayout.SOUTH);

	            frame.setVisible(true);
	        });
		    	
		    }//si c'est le calcul qui a été choisi
		    
	    		
/*__________________________________________________________
            	ETAPE 3 
____________________________________________________________*/
	    		
		    Evenements_3 e3= new Evenements_3();
		    
		    boolean resultat_jeu;
		    
		    int choix_e3=e3.choix("Echec","Pierre-Feuille-Ciseau");
		    
		    if (choix_e3==1) {
		    	resultat_jeu=e3.playChessOnline("Marc_Antoine2023");
		    	if (resultat_jeu) {
		    		son.playMusic("C:/Users/nawel/Downloads/Fanfare.wav");
			    	in.display("Fecilitation Octave est mort ...");
			    	//On affiche le mot de cette partie
			    	e3.mot_univers2("Etre");
			    	
			    }
			    else {
			    	tn.display("la partie est fini.");
			    }
		    }
		    else if (choix_e3==2) {
		    	resultat_jeu=e3.jouerPierreFeuilleCiseaux();
		    	if (resultat_jeu) {
		    		son.playMusic("C:/Users/nawel/Downloads/Fanfare.wav");
			    	in.display("Fecilitation Octave est mort ...");
			    	//On affiche le mot de cette partie
			    	e3.mot_univers2("Etre");
			    	
			    }
			    else {
			    	tn.display("la partie est fini.");
			    }
		    	
		    	
		    }
		    
		    

	    
	   
} //methode pour tester
} //classe



