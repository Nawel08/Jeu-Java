package univers;
import java.util.Scanner;

//Classe spécifique au personnage principal
public final class Personnage_Joueur extends Personnage{

	/**
	 * score du joueur qu'on initialise à 0.
	 */
	public  int score_pj=0;
	
	

		public Personnage_Joueur() {
			// TODO Auto-generated constructor stub
		}
    
		/**
		 * Méthode qui demande à l'utilisateur de choisir son genre, et affiche le texte associé.
		 */
    	public String Genre() {
    	
    	String prenom_pj;
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Choisi le genre de votre personnage (H/F) : ");
        String genre = scanner.nextLine();
        //On ne ferme pas le scanner pour eviter les bugs.
        
        // Pour vérifier le choix de l'utilisateur.
        if ((!genre.equalsIgnoreCase("H"))&&!(genre.equalsIgnoreCase("F"))) {
        	System.out.println("Entre 'H' ou 'F'.");
        }
        
        if(genre.equalsIgnoreCase("H")) {
        	
        	prenom_pj="Ulysse";
        	System.out.println(
        "Tu es "+ prenom_pj+" roi rusé d'Ithaque et mari de la celebre Penelope. \n " +
        "Tu es un homme courageux et digne. Ton peuple t'aime et te respecte. Tu devras durant la partie te faire apprécier davantage. \n" 
        + "Ton score est de "+score_pj+" points. ");
        	return prenom_pj="Ulysse";
        
        // On affichera un avatar représentant Ulysse	
        }
        
        else if(genre.equalsIgnoreCase("F")) {
			//On prend l'attribut prenom de la classe mère.
			
			prenom_pj="Penelope";
			System.out.println(
		"Tu es "+prenom_pj+", femme du digne roi Ulysse.\n"+
		"Jugée par tous car tu es une femme guerrière, tu devras durant cette partie te faire apprécier par tous pour tes capacités physiques et mentales. \n"
		+"Ton score est de "+score_pj+" points.");
			return prenom_pj="Penelope";
			// On affichera un avatar représentant Penelope
		        }
		return genre;
		
    	}
    	
    	
    	
    	public int getscore() {
    		return score_pj;
    	}
      
        
    }

