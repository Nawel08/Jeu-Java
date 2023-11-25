package univers;
import java.util.Scanner;

public class Evenements_4 extends Evenements {

	
	public boolean mission_2;
	public static String enigme;
	//On fait appel aux caractéristiques de notre etape 4 dans notre enumeration.
		Etapes etape = Etapes.etape_4;
		int id = etape.getId();
	    String description = etape.getDescription();
	    
	// On récupère le score de la méthode 3.
	    Evenements_3 e3= new Evenements_3();
	    protected int score_4= e3.score_3;
//On va récupérer les méthodes de la fonction de la méthode Personnage
	    Personnage p = new Personnage(description, id, description);
	    
	    
		@Override
		public void afficherEtapes() {
			// Accès à l'énumération Etapes
	        
	        System.out.println("Bienvenu à l'étape: "+id+" \n"+
	        "Voici sa description: "+description);
			
		}
		//Méthode qui correspond à la mission 2, où le joueur doit répondre à une énigme.
		public static String mission_2() {
			enigme="Je suis le début de la fin et la fin du début, Dans l'éternité, je suis toujours dissimulé. Qui suis-je ?";
			System.out.println(enigme);
			Scanner scanner = new Scanner(System.in);
		    System.out.print("Entrez votre réponse : ");
		return scanner.nextLine().toLowerCase();  // Convertir en minuscules pour être insensible à la casse
		 }

		    // Méthode pour vérifier si la réponse de l'utilisateur est correcte
		    public static boolean verifierReponse(String reponseAttendue, String reponseUtilisateur) {
		        return reponseAttendue.toLowerCase().equals(reponseUtilisateur);
		    }
		    
		
		@Override
		public void Issue() {
			if(mission) {
				score_4+=20;
				System.out.println("Félicitation, vous avez réussi à arriver devant la salle sans tomber dans les trois pièges.");
				System.out.println("Toutefois, il vous reste à entrer dans la pièce. Pour cela, vous devez répondre à une énigme pour déverouiller les portes.");
				String reponseAttendue = "le temps";
		        String reponseUtilisateur = mission_2();

		        if (verifierReponse(reponseAttendue, reponseUtilisateur)) {
		            System.out.println("Bravo, la réponse est correcte ! Vous entrez donc dans la salle du Temps.");
		            System.out.println("Vous réussissez à trouver le chronolètre et vous arretez le temps.");
		            //Va afficher si le joueur peut aller dans le prochain univers
		            if(p.Issue_finale(score_4)) {
		            	System.out.println("VOUS AVEZ GAGNE");
		            }
		            else {
		            	System.out.println("La partie est terminée");
		            }
		            
		        } else {
		            System.out.println("Dommage, la réponse est incorrecte. La partie est terminée");
		        }
		    }
			//Si la mission n'est pas réussie, vous êtes tombé danns au moins l'un des trois pièges.
			else {
				score_4 -=10;
				if(p.Issue_finale(score_4)) {
	            	System.out.println("Votre score vous permet de ne pas mourrir, si vous accepter de perdre 20 points.");
	            	score_4 -=20;
	            	System.out.println("Vous avez maintenant un score de: " + score_4 +"Vous pouvez donc retenter l'itinéraire pour aller vers la salle du temps.");
	            	//S'il a réussi les trois pieges
	            	if(mission) {
	            		score_4+=10;
	            		String reponseAttendue = "le temps";
	    		        String reponseUtilisateur = mission_2();
	    		        //Il doit ensuite trouver la réponse à l'énigme. Attention on veillera à ce que l'énigme ne soit pas la même que precedemment, mais soit plus dure.
	    		        if (verifierReponse(reponseAttendue, reponseUtilisateur)) {
	    		            System.out.println("Bravo, la réponse est correcte ! Vous entrez donc dans la salle du Temps.");
	    		            System.out.println("Vous réussissez à trouver le chronolètre et vous arretez le temps.");
	    		            //Va afficher si le joueur peut aller dans le prochain univers
	    		            if(p.Issue_finale(score_4)) {
	    		            	System.out.println("VOUS AVEZ GAGNE");
	    		            }
	    		            else {
	    		            	System.out.println("La partie est terminée");
	    		            }
	    		            
	    		        } else {
	    		            System.out.println("Dommage, la réponse est incorrecte. La partie est terminée");
	    		        }
	            		
	            	}
	            }
	            else {
	            	System.out.println("La partie est terminée");
	            	
	            }
				
			}
			}
			
			
			
		
	

}
