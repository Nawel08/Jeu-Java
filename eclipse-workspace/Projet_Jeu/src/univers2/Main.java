package univers2;
import java.util.Scanner;

import representation.InnerNode;
import representation.TerminalNode;

public class Main {

	    public static void main(String[] args) {
	    	Introduction introduction = new Introduction();
	        introduction.display();
	        
	        TerminalNode tn= new TerminalNode();

	        // Demander à l'utilisateur de commencer la partie
	        System.out.println("Appuyez sur Entrée pour commencer la partie...");
	        Scanner scanner = new Scanner(System.in);
	        scanner.nextLine();
	        
	        Evenements_1 e1= new Evenements_1();
	        String choix=e1.choix("Combat", "Art");
	        
	        if (choix=="Combat") {
	        	
	        
	        // Simulation d'un combat, la méthode renvoi un boolean, on le nomme victoire.
	        boolean victoire = e1.combat();

	        // Vérification du résultat du combat
	        if (victoire) {
	            System.out.println("Félicitations! Vous avez remporté le combat. Passez à l'étape suivante.");
	            // Mettez ici le code pour passer à l'étape suivante du jeu
	        } else {
	            tn.display("Dommage! Vous avez perdu le combat. Fin de la partie.");
	            
	            // Mettez ici le code pour gérer la fin du jeu
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
	       }
	        
	    }

}



