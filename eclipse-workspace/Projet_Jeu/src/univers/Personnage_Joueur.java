package univers;
import java.util.Scanner;

//Classe spécifique au personnage principal
public class Personnage_Joueur extends Personnage{
	public final String introduction;
	public  int score_pj;
	public String prenom_pj;

	    public Personnage_Joueur(String prenom_pj, int score_pj, String introduction) {
			super(prenom_pj, score_pj);
			this.introduction="En se baladant dans un endroit mystérieux, votre personnage actionne sans le vouloir le Temporal Explorer, la machine permettant de voyager dans le temps.";
	        this.score_pj = score_pj;
	        this.prenom_pj = prenom_pj;
	    }
		
	    

		public String Intro(String introduction) {
	    	return introduction;
	    }
	    
    	public void Genre() {
    		
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Choisissez le genre de votre personnage (H/F) : ");
        String genre = scanner.nextLine();
        //On ne ferme pas le scanner pour eviter les bugs.
        
        // Pour vérifier le choix de l'utilisateur.
        if ((!genre.equalsIgnoreCase("H"))&&!(genre.equalsIgnoreCase("F"))) {
        	System.out.println("Veuillez entrer 'H' ou 'F'.");
        }
        
        if(genre.equalsIgnoreCase("H")) {
        	prenom_pj=super.prenom="Ulysse";
        	score_pj=super.score=60;
        	System.out.println(
        "Tu es "+ prenom_pj+" roi rusé d'Ithaque et mari de la celebre Penelope. \n " +
        "Tu es un homme courageux et digne. Ton peuple t'aime et te respecte. Tu devras durant la partie te faire apprécier davantage. \n" 
        + "Ton score est de "+score_pj+" points. ");
        
        // On affichera un avatar représentant Ulysse	
        }
        
		if(genre.equalsIgnoreCase("F")) {
			//On prend l'attribut prenom de la classe mère.
			prenom_pj=super.prenom="Penelope";
			score_pj=super.score=40;
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
    	
    	//On va afficher la presentation de la fée.
    	Singleton fee= new Singleton();
		public void Presentation_fee() {
			String desc_fee = fee.description;
			System.out.println(desc_fee);
		}
		// On affichera un avatar représentant la fée	
		
        
        
    }

