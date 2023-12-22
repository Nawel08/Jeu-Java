package univers2;

import java.awt.BorderLayout;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import representation.DecisionNode;
import representation.InnerNode;
import representation.SoundNode;
import representation.TerminalNode;
import representation.ImageNode;

import univers.Introduction1;
import univers.Etapes;
import univers.Evenements_u1;
import univers.Evenements_2_u1;
import univers.Evenements_3_u1;
import univers.Evenements_4_u1;
import univers.Guerre;
import univers.Personnage_Joueur;
import univers.Singleton;




public class Main {

	    public static void main(String[] args) throws LineUnavailableException, IOException, UnsupportedAudioFileException{
	    	
	    	InnerNode in = new InnerNode();
	    	DecisionNode dn = new DecisionNode();
	    	TerminalNode tn= new TerminalNode();
	    	SoundNode son = new SoundNode();
	    	Singleton fee=new Singleton();
	    	
	    	Introduction1 intro1 = new Introduction1();	
	    	Evenements_u1 e_u1 = new Evenements_u1();
	    	Evenements_2_u1 e2_u1 = new Evenements_2_u1();
	    	Evenements_3_u1 e3_u1 = new Evenements_3_u1();
	    	Evenements_4_u1 e4_u1 = new Evenements_4_u1();
	    	
	    	Introduction intro = new Introduction();
	    	Evenements e = new Evenements();
	    	Evenements_1 e1 = new Evenements_1();
	    	Evenements_2 e2 = new Evenements_2();
	    	Evenements_3 e3 = new Evenements_3();

  	
	    	int score=0;

	   /*__________________________________________________________
        		UNIVERS 1 : ULYSSE ET LE CHEVAL DE TROIE
		____________________________________________________________*/
	    	



	    	/*__________________________________________________________
	    				INTRODUCTION
	    	____________________________________________________________*/	
	    			
	    			
	    			//Introduction au jeu
	    			intro1.display_intro();
	    			intro1.display_but();
	    			
	    			//Présentation des personnages
	    			fee.display();
	    	 	   ImageNode imageNode = new ImageNode(intro1, "C:/Users/nawel/Downloads/jeniwell.png");
	    	 	   imageNode.display_intro("Avatar de la fée Jeniwell");
	    	 	    
	    	 	   //Présentation du perosnnage joueur
	    	 	   Personnage_Joueur pj = new Personnage_Joueur();
	    	 	   String prenom_joueur=pj.Genre(); 
	    			
	    	 	   if (prenom_joueur=="Ulysse") {
	    	 		  Personnage_Joueur ulysse = new Personnage_Joueur();
		    	 	   ImageNode imageNode6 = new ImageNode(intro1, "C:/Users/nawel/Downloads/jeniwell.jpeg");
		    	 	   imageNode6.display_intro("Avatar de la fée Ulysse");
	    	 	   }
	    	 	   else if (prenom_joueur=="Penelope") {
	    	 		  Personnage_Joueur penelope = new Personnage_Joueur();
		    	 	   ImageNode imageNode7 = new ImageNode(intro1, "C:/Users/nawel/Downloads/jeniwell.jpeg");
		    	 	   imageNode7.display_intro("Avatar de la fée Penelope");
	    	 	   }
	    	 	    
	    	 	   
	    	 	    
	    			

	    			
	    			
	    	/*__________________________________________________________
	    	        		ETAPE 1
	    	____________________________________________________________*/
	    			
	    			Etapes etape1 = Etapes.etape_1;
	    	        etape1.display();
	    	        
	    	        
	    	        Guerre[] etapes = Guerre.values();
	    	        Scanner scanner = new Scanner(System.in);

	    	        Random random = new Random();

	    	        boolean ulysseBlesse = false;
	    	        boolean etape_s=false;
	    	        
	    	        ImageNode imageNode8 = new ImageNode(e1, "C:/Users/nawel/Downloads/guerre_e1.jpeg");
		    	 	imageNode8.display_intro("Guerre entre l'armée d'Ulysse et l'armée de Troie");
	    	        for (Guerre etape : etapes) {
	    	        	son.manageSound("C:/Users/nawel/Downloads/Combat_epee.wav", "play");
	    	            etape.display(prenom_joueur);

	    	            if (ulysseBlesse) {
	    	            	
	    	                System.out.println("Ulysse est blessé.");
	    	                son.manageSound("C:/Users/nawel/Downloads/Combat_epee.wav", "stop");
	    	                //On propose au joueur d'appeler la fée pour le guérir. 
	    	                boolean decision= dn.appel_fee2();
	    	                if (decision) {
	    	                	son.stop();
	    	                	boolean fee_defi=fee.defi_e1(); //on fait appel a la fée
	    	                
	    	                if(fee_defi) {
	    	                	System.out.println("Tu as réussi le défi !");
	    	                	son.manageSound("C:/Users/nawel/Downloads/Combat_epee.wav", "stop");
	    	                	son.manageSound("C:/Users/nawel/Downloads/baguette-magique-01.wav","play");
	    	                	etape_s=e_u1.Passage(fee_defi);
	    	                }
	    	                else {
	    	                	son.stop();
	    	                	etape_s=e_u1.Passage(fee_defi);
	    	                }
	    	                break; // Sortir de la boucle si Ulysse est blessé
	    	            }
	    	                else {
	    	                	tn.chooseNext();
	    	                	break;
	    	                }
	    	                
	    	            }
	    	            

	    	            System.out.println("Appuie sur Entrée pour continuer...");
	    	            scanner.nextLine(); // Attendre l'entrée de l'utilisateur

	    	            // Générer un nombre aléatoire entre 0 et 1 pour la probabilité de blessure
	    	            double probaBlessure = random.nextDouble();

	    	            // Si la probabilité est inférieure ou égale à 0.5, Ulysse est blessé
	    	            ulysseBlesse = probaBlessure <= 0.5;
	    	        }
	    	        
	    	        //Si Ulysse n'a pas été blessé lors du combat.
	    	        if (!(ulysseBlesse) || etape_s==true) {
	    	        	son.stop();
	    	        	boolean combat_reussi=true;
	    	        	e_u1.Passage(combat_reussi);
	    	        	
	    	        	score+=20;
	    	        	e_u1.display_score(score);
	    	        


	    	/*__________________________________________________________
	    	        		ETAPE 2
	    	____________________________________________________________*/
	    	        
	    	        son.stop();
	    	        Etapes etape2 = Etapes.etape_2;
	    	        etape2.display();
	    	          
	    	        boolean passage_3=e2_u1.etape2(score);
	    	        boolean passage_suivant=e_u1.Passage(passage_3);
	    			
	    	/*__________________________________________________________
	    	        		ETAPE 3 
	    	____________________________________________________________*/
	    	        
	    	        if(passage_suivant) {
	    	        Etapes etape3 = Etapes.etape_3;
	    	        etape3.display();

	    	        boolean e0=e3_u1.executerEtape0(score);
	    	        ImageNode imageNode10 = new ImageNode(e3_u1,"C:/Users/nawel/Downloads/materiaux.jpeg");
		    	 	imageNode10.display_intro("image des matériaux disponible");
		    	 	   
	    	        boolean passage=e3_u1.executerEtape(score);
	    	        if(passage) {
	    	        	ImageNode imageNode11 = new ImageNode(e3_u1,"C:/Users/nawel/Downloads/cheval.jpeg");
			    	 	imageNode11.display_intro("cheval de troie");
	    	        }
	    	        e_u1.Passage(passage);
	    	                
	    	        
	    	        
	    	/*__________________________________________________________
	    	        		ETAPE 4 
	    	____________________________________________________________*/
	    	        
	    	        Etapes etape4 = Etapes.etape_4;
	    	        etape4.display();
	    	        
	     	        boolean pieges;
	    	        boolean passage_enigme = false; 
	    	        
	    	        son.manageSound("C:/Users/nawel/Downloads/rise-above-178316.wav","play");
	    	        boolean reussi_1 = e4_u1.labyrintheTemporel(score);
	    	        son.manageSound("C:/Users/nawel/Downloads/stress.wav", "play");
	    	        int count =0;
	    	        while(reussi_1) {
	    	        	
	    	        	if (reussi_1 && count==0) {
	    	        	ImageNode imageNode12 = new ImageNode(e3_u1,"C:/Users/nawel/Downloads/lab.jpeg");
			    	 	imageNode12.display_intro("Ulysse fasse aux deux couloirs");
			    	 	count++;
	    	        	}
	    	            System.out.println("Tu as traversé le Labyrinthe Temporel avec succès !");
	    	            boolean reussi_2 = e4_u1.miroirsDuTemps(score);
	    	            if (reussi_2) {
	    	            	ImageNode imageNode13 = new ImageNode(e3_u1,"C:/Users/nawel/Downloads/miroir.jpeg");
	    		    	 	imageNode13.display_intro("les deux miroirs temporels");
	    	                System.out.println("Félicitations, tu as emprunté le bon miroir !");
	    	                boolean reussi_3 = e4_u1.portesTemporelles(score);
	    	                if (reussi_3) {
	    	                	ImageNode imageNode14 = new ImageNode(e3_u1,"C:/Users/nawel/Downloads/portes.jpeg");
	    			    	 	imageNode14.display_intro("les portes du temps");
	    	                    System.out.println("Tu as réussi à trouver la bonne porte !");
	    	                    System.out.println("Tu n'es tombé dans aucun piège");
	    	                    score += 20;
	    	                    
	    	                    passage_enigme = e4_u1.Pieges(reussi_3,score);
	    	                } else {
	    	                	ImageNode imageNode15 = new ImageNode(e3_u1,"C:/Users/nawel/Downloads/erreur.jpeg");
	    			    	 	imageNode15.display_intro("mauvaise porte");
	    	                    tn.display("Tu n'as pas réussi à trouver la bonne porte.");
	    	                    // Tu es tombé dans le piège
	    	                    passage_enigme = e4_u1.Pieges(reussi_3,score);
	    	                    break;
	    	                }
	    	            } else {
	    	                tn.display("Échec ! Ulysse est piégé dans le passé et doit recommencer son chemin.");
	    	                passage_enigme = e4_u1.Pieges(reussi_2,score);
	    	                break;
	    	            }
	    	         
	    	        }
	    	        
	    	        boolean passage_univers2 = e4_u1.Enigme(score, passage_enigme);
	    	        if (passage_univers2) {
	    	        	
	    	        }
	    	        } // etape 2 réussie
	    	  
	    	        }
	    	
	   /*__________________________________________________________
				UNIVERS 2 : MARC ANTOINE ET CLEOPATRE
		____________________________________________________________*/

/*__________________________________________________________
            	INTRODUCTION
____________________________________________________________*/
	    	
	    	 	
	    		Scanner scanner1 = new Scanner(System.in);


	    	    // Introduction
	    	    Introduction introduction = new Introduction();
	    	    Introduction introduction1 = new Introduction();
	    	    introduction.display();  
	    	    
    	 	    ImageNode imageNode3 = new ImageNode(introduction, "C:/Users/nawel/Downloads/Lucius.png");
    	 	    imageNode3.display_intro("Avatar de Marc Antoine");
    	 	   
    	 	    
   	 	    	ImageNode imageNode4 = new ImageNode(introduction1, "C:/Users/nawel/Downloads/Cleopatre.png");
   	 	    	imageNode4.display_intro("Avatar de Cléopatre");
    	 	    

	    	    // Ask the user to start the game
	    	    System.out.println("Appuyez sur Entrée pour commencer la partie...");
	    	    scanner1.nextLine();
/*__________________________________________________________
	    	      ETAPE 1 
____________________________________________________________*/
	    	
	        
	        
	        
	        String choix=dn.choix_2_string("Combat", "Art");
	        
	        if (choix=="Combat") {
	        	ImageNode imageNode16 = new ImageNode(e1,"C:/Users/nawel/Downloads/comabt.png");
	    	 	imageNode16.display_intro("combat de Marc Antoine");
	        	son.manageSound("C:/Users/nawel/Downloads/10803.wav","play");
	        // Simulation d'un combat, la méthode renvoi un boolean, on le nomme victoire.
	        boolean victoire = e1.combat(score);
	        boolean conditions=true;
	        while (conditions) {
	        // Vérification du résultat du combat
	        if (victoire) {
	        	ImageNode imageNode10 = new ImageNode(e3_u1,"C:/Users/nawel/Downloads/victoire.jpeg");
	    	 	imageNode10.display_intro("victoire de Marc Antoine");
	            System.out.println("Félicitations! Vous avez remporté le combat. Passez à l'étape suivante.");
	            conditions=false;
	        } 
	        else {
	            tn.display("Dommage! Vous avez perdu le combat. Fin de la partie.");
	            break;
	            
	        }}
	        }
	        
	        else if(choix=="Art") {
	        	son.manageSound("C:/Users/nawel/Downloads/Brouhaha.wav","play");
	            boolean volReussi = e1.volerStand(score);
	            if (volReussi) {
	            	
	            	ImageNode imageNode5 = new ImageNode(e1, "C:/Users/nawel/Downloads/e_1.png");
	    	 	    imageNode5.display("stand de Marc Antoine");
	    	 	    
	            	son.manageSound("C:/Users/nawel/Downloads/Brouhaha.wav","stop");
	            	son.manageSound("C:/Users/nawel/Downloads/Bonjour_femme.wav","play");
	                boolean r_c=e1.cleopatreRencontre(volReussi,score);
	                
	                if(r_c==false) { //Si marc antoine ne repond pas bien a l'une des question il peut appeler la fée
	                	//on peut imaginer que s'il veut appeler la file il n'a qua criee JENIWELLLL
	                	
	                	son.manageSound("C:/Users/nawel/Downloads/baguette-magique-01.wav","play");
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
	    	
	        
		    
		    //Si l'utilisateur passe a l'étape suivante alors on affiche l'intro.
		    e2.intro(score);
		    
		    
		    String choix_e2=dn.choix_2_string("Offrir un cadeau à Cléopatre grâce à la fée", "Résoudre un calcul pour impressioner Cléopatre.");
		    
		    //En fonction du choix de l'utilisateur on fait appel à la méthode en question, puis à la méthode de dessin.
		    if (choix_e2=="Offrir un cadeau à Cléopatre grâce à la fée") {
		    	son.manageSound("C:/Users/nawel/Downloads/baguette-magique-01.wav","play");
		    	ImageNode imageNode10 = new ImageNode(e3_u1,"C:/Users/nawel/Downloads/cadeaux.jpeg");
	    	 	imageNode10.display_intro("2 cadeaux proposés par Jeniwell");
		    	boolean choix_cadeau=e2.demanderCadeaux(score);  //On s'interesse pas a si elle est reussi ou non, on l'appel seulement car tout se passe dans la methode pour pas surcharger le main.
		    	int score_mariage= e2.afficherResultat(choix_cadeau, score);
		    	e2.mariage(score_mariage);
		    	
		    
		    
		    }
		    
		    else if (choix_e2=="Résoudre un calcul pour impressioner Cléopatre.") {
		    	boolean choix_calcul = e2.Calcul(score);
		    	int score_mariage=e2.afficherResultat(choix_calcul, score);
		    	e2.mariage(score_mariage);
		    	
	    		
		    	
		    }//si c'est le calcul qui a été choisi
		    
	    		
/*__________________________________________________________
            	ETAPE 3 
____________________________________________________________*/
	    		
		   
		    
		    boolean resultat_jeu;
		    
		    int choix_e3=e3.choix("Echec","Pierre-Feuille-Ciseau");
		    son.manageSound("C:/Users/nawel/Downloads/stress.wav", "play");
		    if (choix_e3==1) {
		    	resultat_jeu=e3.playChessOnline("Marc_Antoine2023");
		    	if (resultat_jeu) {
		    		son.manageSound("C:/Users/nawel/Downloads/Fanfare.wav","play");
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
		    		son.manageSound("C:/Users/nawel/Downloads/Fanfare.wav","play");
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



