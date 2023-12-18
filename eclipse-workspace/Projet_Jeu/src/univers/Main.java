package univers;

import representation.SoundNode;
import representation.Event;
import representation.Node;
import representation.TerminalNode;
import representation.InnerNode;
import representation.DecisionNode;

import java.util.Scanner;
import java.util.Random;

public class Main {
	
	public static void main (String[] args) {

		Singleton fee=new Singleton();
		TerminalNode tn= new TerminalNode();
		InnerNode in= new InnerNode();
		Evenements e = new Evenements();
		DecisionNode dn = new DecisionNode();
/*__________________________________________________________
			INTRODUCTION
____________________________________________________________*/	
		
		Introduction intro=new Introduction();
		
		intro.display_intro();
		intro.display_but();
		
		Personnage_Joueur pj = new Personnage_Joueur();
		pj.Genre(); 

		
		
/*__________________________________________________________
        		ETAPE 1
____________________________________________________________*/
		
		Etapes etape1 = Etapes.etape_1;
        etape1.display();
        
        Evenements_1 e1= new Evenements_1();
        
        int score = e1.score;
        
        in.display("Ulysse part à la guerre avec son armée!");
        
        Guerre[] etapes = Guerre.values();
        Scanner scanner = new Scanner(System.in);

        Random random = new Random();

        boolean ulysseBlesse = false;
        boolean etape_s=false;
        for (Guerre etape : etapes) {
            etape.display();

            if (ulysseBlesse) {
                System.out.println("Ulysse est blessé.");
                //On propose au joueur d'appeler la fée pour le guérir. 
                boolean decision= dn.appel_fee2();
                if (decision) {
                boolean fee_defi=fee.defi_e1(); //on fait appel a la fée
                
                if(fee_defi) {
                	System.out.println("Tu as réussi le défi !");
                	etape_s=e.Passage(fee_defi);
                }
                else {
                	etape_s=e.Passage(fee_defi);
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
        	
        	boolean combat_reussi=true;
        	e.Passage(combat_reussi);
        	
        	score+=20;
        	e.display_score(score);
        


/*__________________________________________________________
        		ETAPE 2
____________________________________________________________*/
        
        Etapes etape2 = Etapes.etape_2;
        etape2.display();
        
        Evenements_2 e2= new Evenements_2();
        
        boolean passage_3=e2.etape2(score);
        boolean passage_suivant=e.Passage(passage_3);
		
/*__________________________________________________________
        		ETAPE 3 
____________________________________________________________*/
        
        if(passage_suivant) {
        Etapes etape3 = Etapes.etape_3;
        etape3.display();
		
        Evenements_3 e3= new Evenements_3();       

        boolean e0=e3.executerEtape0(score);
        
        boolean passage=e3.executerEtape(score);
        e.Passage(passage);
        
        
        
        
/*__________________________________________________________
        		ETAPE 4 
____________________________________________________________*/
        
        Etapes etape4 = Etapes.etape_4;
        etape4.display();
        
        Evenements_4 e4= new Evenements_4();
		
        boolean pieges;
        boolean passage_enigme = false; // Initialisez-la à false ici pour éviter des problèmes potentiels

        boolean reussi_1 = e4.labyrintheTemporel(score);
        
        while(reussi_1) {
        
            System.out.println("Tu as traversé le Labyrinthe Temporel avec succès !");
            boolean reussi_2 = e4.miroirsDuTemps(score);
            if (reussi_2) {
                System.out.println("Félicitations, tu as emprunté le bon miroir !");
                boolean reussi_3 = e4.portesTemporelles(score);
                if (reussi_3) {
                    System.out.println("Tu as réussi à trouver la bonne porte !");
                    System.out.println("Tu n'es tombé dans aucun piège");
                    score += 20;
                    
                    passage_enigme = e4.Pieges(reussi_3,score);
                } else {
                    tn.display("Tu n'as pas réussi à trouver la bonne porte.");
                    // Tu es tombé dans le piège
                    passage_enigme = e4.Pieges(reussi_3,score);
                    break;
                }
            } else {
                tn.display("Échec ! Ulysse est piégé dans le passé et doit recommencer son chemin.");
                passage_enigme = e4.Pieges(reussi_2,score);
                break;
            }
         
        }
        
        boolean passage_univers2 = e4.Enigme(score, passage_enigme);
        if (passage_univers2) {
        	
        }
        } // etape 2 réussie
        /*
		//POUR LE SON
		Event baseNode = new Node(introduction, 0);

        // Ajoutez la fonctionnalité de lecture de son au nœud de base
        Event soundNode = new SoundNode(baseNode);

        // Affichez le nœud avec la fonctionnalité de son
        soundNode.display("Data/son.wav");
        
        */
        }
         //Fermetures des passages.
     } //fermeture classe test.

}
