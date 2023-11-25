package univers;

public class Evenements_3 extends Evenements{

	//On fait appel aux caractéristiques de notre etape 3 dans notre enumeration.
		Etapes etape = Etapes.etape_3;
		int id = etape.getId();
	    String description = etape.getDescription();
	    
	    //On fait appel au score de l'évenement précédent.
	    Evenements_2 e_2= new Evenements_2();
	    int score_3= e_2.score_2;
	    
	    private boolean mission_fee;
	    boolean p_4=super.p_4;
	    
		@Override
		public void afficherEtapes() {
			// Accès à l'énumération Etapes
	        
	        System.out.println("Bienvenu à l'étape: "+id+"\n"+
	        "Voici sa description: "+description);
			
		}
		public boolean ConstructionCheval() {
			//Si tu réussi la mission
			if(mission) {
				score_3+=20;
				p_4=true;
				System.out.println("Felicitation tu as réussi à construire le cheval de Troie. Cela t'as permit de gagner le respect de ton équipe donc la fée Jeniwell t'offre une vie en bonus !");
				return true;
			}
			else {
				score_3-=10;
				p_4=false;
				System.out.println("Tu as échoué dans la construction du cheval, ton équipe s'est donc rendue compte que tu étais un imposteur. Mais heuresement, la fée Jeniwell est là. Elle te permet de rententer la construction du cheval de Troie en 45 secondes.");
				if(mission_fee) {
					score_3 +=10;
					System.out.println("Felicitation, tu as réussi la mission.");
					return true;
					
				}
				p_4=false;
				System.out.println("C'est la fin de la partie.");
				return false;
			}
			
		}
		@Override
		public void Issue() {
			if (p_4) {
				System.out.println("Felictation, tu passes au niveau 4 !");
			}
			else {
				System.out.println("Malheuresement, l'aventure s'arrête ici pour toi.");
			}
			// TODO Auto-generated method stub
			
		}
		
		
		
}
