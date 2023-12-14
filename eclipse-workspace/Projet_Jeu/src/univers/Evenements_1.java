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
    
	
	@Override
	public void Issue() {
		// TODO Auto-generated method stub
		
	}
}

	

