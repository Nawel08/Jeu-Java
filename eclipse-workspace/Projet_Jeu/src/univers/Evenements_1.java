package univers;
import java.util.Random;
import java.util.Scanner;

public class Evenements_1 extends Evenements{
	private boolean mission2;
	
	//On fait appel aux caractéristiques de notre etape 1 dans notre enumeration.
	Etapes etape = Etapes.etape_1;
	int id = etape.getId();
    String description = etape.getDescription();
    
    //Pour le score de l'étape 1, on récupere le score atttribué à chaque personnnage.
    
  //Pour acceder aux attributs de la classe personnage_joueur.
    
   
    
    
    public Evenements_1() {
    	this.score_1=score_1;
    }
    Personnage_Joueur pj = new Personnage_Joueur(description, id, description);
    int score_1=pj.score_pj;
    public String prenom=pj.prenom;
    
	@Override
	public void afficherEtapes() {
		// Accès à l'énumération Etapes
        System.out.println("Bienvenu à l'etape: "+id+ "\n"+"Voici sa descrption: \n"+description);
		
		}
	
	//Attributs issu de la classe mère.
	public boolean mission= super.mission; //Si la mission est réussi
	public boolean p_2=super.p_2; //Booleen qui conditionne le passage au niveau 2.
	
	
	public void Combat(){
		//Méthode où se déroulera le combat.
		System.out.println("COMBAT");
	}
	
	//Defi que la fee feniwell va donner au joueur.
	//Idealement on va rajouter qu'il a 3 chances 
    public static boolean Defi() {
    	//Generation d'un nombre aléatoire entre 1 et 5.
        Random random = new Random();
        int nombreMagique = random.nextInt(5) + 1;
        
        System.out.println("La fée Jeniwell vous propose un défi amusant : deviner le nombre magique (entre 1 et 5) !");
        //On stocke le resultat de la méthode demanderTentatives() dans "tentative".
        int tentative = demanderTentative();
        // S'il a trouvé le bon chiffre.
        if(tentative == nombreMagique){
        	boolean mission2=true; // il a reussi la mission
        	boolean p_2=true; //Il peut passer au niveau superieur.
        	return (p_2);
    }
    else{
    	//S'il n'a pas trouvé le bon chiffre, il a échoué sa mission et ne peut pas passer au niveau superieur.
    	boolean mission2=false;
    	boolean p_2=false;
    	return (p_2);
    }
  }
    //Méthode pour récuperer la réponse du joueur. 
    public static int demanderTentative() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez votre tentative : ");
        return scanner.nextInt();
        
    }
    
    
    
	
	//Cette méthode permet de définir la suite de l'aventure pour le joueur.	
	public void Issue(boolean mission) {
		//On va dans personnage_non joueur et on va appeler la fonction qui va implementer son score
		//Comme on est sur une méthode d'instance, on doit procéder comme suit:
		//Impossible car apprecier renvoie un int est issue est string.
		//Si le joueur réussi sa mission.
		if(mission) {
			
			
			System.out.println("Felicitation tu as réussi à survivre.");
			//Il peut passer à l'etape suivante.
			//on met à jour la valeur qui permet de passer à l'étape 2.
			p_2=true;
		}
		
		if(mission==false) {
			// !On va dans personnage_non joueur et on va appeler la fonction qui va implementer son score
			
			System.out.println("Tu n'as malheuresement pas réussi à survivre lors de cette guere. "
					+ "Mais heuresement la fée Jeniwell est là."
					+ "Elle te propose de relever un defi pour te redonner la vie.");
			boolean defi =Defi(); //renvoie p_2 qui qui conditionne le passage au niveau 2.
			//Je crois que quand c'est true on a pas besoin de spécifier (defie==true)
			if(defi) { 
				System.out.println("Fecilitation, tu as réussi le defi et tu peux passer à l'étape suivante.");
			}
			else {
				System.out.println("Malheuresement, l'aventure s'arrête ici pour toi.");
				
			}	
	}	
		
}
	
	@Override
	public void Issue() {
		// TODO Auto-generated method stub
		
	}
}

	

