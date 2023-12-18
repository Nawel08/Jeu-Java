package univers;
import java.util.Scanner;

//Classe spécifique au personnage principal
public class Personnage_Joueur extends Personnage{

	public  int score_pj=0;
	public String prenom_pj;


		public Personnage_Joueur() {
			// TODO Auto-generated constructor stub
		}
    
    	public void Genre() {
    		
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
        
        // On affichera un avatar représentant Ulysse	
        }
        
		if(genre.equalsIgnoreCase("F")) {
			//On prend l'attribut prenom de la classe mère.
			prenom_pj="Penelope";
			
			System.out.println(
		"Tu es "+prenom_pj+", femme du digne roi Ulysse.\n"+
		"Jugée par tous car tu es une femme guerrière, tu devras durant cette partie te faire apprécier par tous pour tes capacités physiques et mentales. \n"
		+"Ton score est de "+score_pj+" points.");
			
			// On affichera un avatar représentant Penelope
		        }
    	}
    	
    	
    	
    	public int getscore() {
    		return score_pj;
    	}
      
        
    }

