package univers2;

import java.util.Scanner;
import java.util.Random;

import representation.DecisionNode;
import representation.InnerNode;
import representation.TerminalNode;
import univers.Singleton;

//Classe qui correspond à l'evenement 1, on y retrouvera toutes les méthodes nécessaires.
public class Evenements_1 {
	
	static int score;
	static boolean etape_suivante;
	String decision;
	static boolean etape_suivante_2;
	
	static Singleton fee=new Singleton();
	static TerminalNode tn= new TerminalNode();
	
	//Méthode grâce à laquelle l'utilisateur va faire le choix entre les deux options 
	//qui s'offrent à lui pour se faire remarquer par cléopatre.
	//Pour cela, on va utiliser la méthode disponible dans la classe DecisionNode
	public String choix(String s1, String s2) {
		DecisionNode decision1= new DecisionNode();
		decision=decision1.choix_2_string(s1,s2); //on fait appel à la méthode dans decision node qui choisi entre 2 string.
		return decision; //on retourne la decision prise (NB: la méthdoe retourne le choix sous forme de string, donc decision est un string)
	}
	
	public Evenements_1(){
		
	}
	 
	//Méthode qui va permettre que le combat se déroule.
    public static boolean combat() {
    	//On commence par instancier ce dont on va avoir besoin
    	Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // On intilise les points de marc antoine, notre personnage et son adversaire.
        int pointsDeViePersonnage = 100;
        int pointsDeVieAdversaire = 100;

        System.out.println("Vous entrez dans l'arène. Le combat commence!");

        // Boucle de combat        
        while (pointsDeViePersonnage > 0 && pointsDeVieAdversaire > 0) {
        	// Le personnage attaque l'adversaire
            int coupPersonnage = random.nextInt(20) + 1; // Un nombre aléatoire entre 1 et 20
            System.out.println("Vous portez un coup à l'adversaire, il perd:  " + coupPersonnage + " points.");
            pointsDeVieAdversaire -= coupPersonnage;

            // Vérification si l'adversaire est vaincu
            if (pointsDeVieAdversaire <= 0) {
                 System.out.println("Vous avez vaincu l'adversaire!");
                 return true; // Le personnage a gagné le combat
            }

            // L'adversaire contre-attaque
            int coupAdversaire = random.nextInt(15) + 1; // Un nombre aléatoire entre 1 et 15
            System.out.println("L'adversaire riposte, tu perds: " + coupAdversaire + " points.");
            pointsDeViePersonnage -= coupAdversaire;

            // Vérification si le personnage est vaincu
            if (pointsDeViePersonnage <= 0) {
                 System.out.println("Vous avez été vaincu par l'adversaire.");
                 return false; // Le personnage a perdu le combat
            }

            // Affichage des points de vie restants
            System.out.println("Points de vie restants - Marc Anotine: " + pointsDeViePersonnage + ", Adversaire: " + pointsDeVieAdversaire);

            // Pause pour la lisibilité
            try {
                 Thread.sleep(1000); // Pause d'une seconde entre chaque action
            } catch (InterruptedException e) {
                  e.printStackTrace();
             }

             // Demande au joueur d'appuyer sur Entrée pour passer à la prochaine action
             System.out.println("Appuyez sur Entrée pour continuer...");
             scanner.nextLine();
       }

     // La boucle se termine si l'un des combattants n'a plus de points de vie
     return false;
        
    }

     //Méthode pour simuler le vol du stand
     public static boolean volerStand() {
    	 Scanner scanner = new Scanner(System.in);
        	
    	 System.out.println("Une exposition est prévue dans le palais. Vous trouvez un moyen de vous y introduire.");
        	
    	 // Simulation du vol du stand
         System.out.println("Vous volez le stand d'objets rares et précieux d'un commerçant.");
         System.out.println("Appuyez sur Entrée pour continuer...");
         scanner.nextLine();
        	
         // Simulation aléatoire du succès ou de l'échec du vol
         boolean volReussi = Math.random() < 0.7; // 70% de chance de réussite
        	
         // Affichage du résultat du vol
         if (volReussi) {
        	  System.out.println("Le vol est un succès!");
        	  etape_suivante=true; //Il peut donc passer à l'etape suivante.
         } else {
        	    System.out.println("Votre tentative de vol a échoué.");
        	    etape_suivante=false;
       }
        	
       return volReussi; //on renvoi l'issu de cette mission.
     }
       
        	
      // Méthode pour simuler la rencontre avec Cléopâtre
      public static boolean cleopatreRencontre(boolean etape_suivante) {
        	 InnerNode innerNode = new InnerNode();
        	 Scanner scanner = new Scanner(System.in);
        	
        	 //On affiche la description à l'aide de la méthode display dans innernode.
        	 innerNode.display("Cléopâtre vient vous voir.");
        	
        	 // Simulation de l'interaction avec Cléopâtre
        	 innerNode.display("Cléopâtre: Bonjour");
        	 innerNode.display("Tu as besoin de répondre correctement aux questions de Cléopâtre pour éviter les soupçons.");
        	
        	 
        	    
        	 //Ne se deroule que si le vol du stand a été une réussite.
        	 if(etape_suivante) {
        	    	
        		// Simulation de trois questions posées par Cléopâtre en faisant appel a la méthdoe definie un peu plus bas. 
        	    if (defiCleopatre("Qu'est-ce que cet objet?", "un scarabé")) { //on passe en argument la question et la bonne reponse
        	        if (defiCleopatre("A quoi sert cet objet (en un mot) ?", "Protéger")) {
        	            if (defiCleopatre("Sur cet eventail, ce sont des plumes de quel oiseau ?", "Autruche")){
        	            	innerNode.display("Fecilictation ! Tu passes à l'étape 2");
        			        innerNode.display("Appuie sur Entrée pour continuer...");
        			        scanner.nextLine(); 
        			        etape_suivante_2=true;
           			        return etape_suivante_2; //Si l'utilisateur est arrivé jusqu'ici c'est qu'il a reussi a repondre correctement aux trois questions
           			        //Donc on renvoie true.
           			        
        	           }        	        
        	        } 
        	    }
        	 //Si on a pas repondu correctement à toutes les questions.
           	 etape_suivante_2=false;
           	 return etape_suivante_2;
        	  
        	}
        	//Si le vol du stand a échoué, alors on indique au joueur que la partie est terminée et qu'il ne peut pas passer à l'étape suivante.
        	else{
        	    	tn.display("Malheuresement la partie est terminée pour toi.");
        	    	etape_suivante_2=false;
        	    	return etape_suivante_2;
        	}
        	 

       }

           
    // Méthode pour simuler les questions posées par Cléopâtre
    public static boolean defiCleopatre(String question, String reponseCorrecte) {
        InnerNode innerNode = new InnerNode();
        Scanner scanner = new Scanner(System.in);
        
        boolean reponseCorrecteObtenue = fee.defi1(question, reponseCorrecte);
		// Simulation de trois questions posées par Cléopâtre
        
        if (reponseCorrecteObtenue) {
            innerNode.display("Bonne réponse! Cléopâtre pose une nouvelle question.");
        } else {
            innerNode.display("Mauvaise réponse! Voulez-vous faire appel à la fée magique Jeniwell?");
            innerNode.display("Appuyez sur Entrée pour faire appel à Jeniwell...");
            scanner.nextLine();

            // Appel à la méthode defi1 de la classe Fee
            reponseCorrecteObtenue = fee.defi1("", "Réponse correcte de Jeniwell");
        }

        return reponseCorrecteObtenue;
    }
    
    //Méthode à laquelle on fait appel si le joueur n'a pas réussi toutes les questions
    public static boolean defi_fee() {
    	//On verifie que l'etape n'avait pas été reusi
    	if (etape_suivante_2==false) {
    		//On fait appel à la méthode dans Singleton qui permet de poser une question.
    		boolean challenge= fee.defi1("Quelle est la matiere de cet objet ?", "Or");
    		boolean etape2;
    		//Si le joueur a répondu correctement à la question
    		if (challenge) {
    			fee.display("Bonne réponse!");
    			fee.display("Tu peux donc passer à l'étape suivante :)");
    			etape2=true;
    			return etape2;
    		}
    		//Sinon, on fait appel à un terminal node.
    		else {
    			tn.display("La partie est terminée ...");
    			etape2=false;
    			return etape2;
    			
    		}
    	}
	    
	} //kk
}
