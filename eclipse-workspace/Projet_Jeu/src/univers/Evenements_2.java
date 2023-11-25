package univers;

public class Evenements_2 extends Evenements{
	
	//On fait appel aux caractéristiques de notre etape 2 dans notre enumeration.
		Etapes etape = Etapes.etape_2;
		int id = etape.getId();
	    String description = etape.getDescription();
	    protected static boolean mission_2;
	    static boolean p_3;
	    
	    //On va affecter à notre score de l'evenement 2, le score de l'evenement 1.
	    
	    Evenements_1 e1= new Evenements_1();
	    int score_2=e1.score_1;
	    
	    public Evenements_2() {
	    	this.score_2=score_2;
	    }
	    
		@Override
		public void afficherEtapes() {
			// Accès à l'énumération Etapes
	        
	        System.out.println("Bienvenu à l'étape: "+id+" \n"+
	        "Voici sa description: "+description);
			
		}
		//Méthode où le personnage et son armée attaquent Troie.
		/*
		 * Pour l'instant je l'ai mit en void, mais elle renverra un boolean qui sera mission, et qui indiquera si le joueur à réussi ou non.
		 */
		public void Attaque() {
			
		}
		public static boolean mission() {
			//Très difficile
			if(mission_2) {
				return (p_3=true);
			}
			else {
				return (p_3=false);
			}
			
		}
		@Override
		public void Issue() {
			// TODO Auto-generated method stub
			
		}
		

	

}
