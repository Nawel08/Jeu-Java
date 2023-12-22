package univers;

/**
 * Enumération du contenu de chacune des étapes (=Evenements_i i=1,2,3,4)
 * @author nawel
 *
 */
public enum Etapes {

		etape_1(1,"Tu pars à la guerre avec ton armée Grecques"), 
		etape_2(2,"Tu tentes de percer la muraille de Troie en l'attaquant."), 
		etape_3(3,"Il faut absolument que tu entres dans Troie pour récupérer le chronomètre de la reine Cronos pour arreter le temps et sortir de cet univers. Tu découvres que le seul moyen qui te reste pour entrer dans Troie est de construire un cheval."), 
		etape_4(4,"Vous simulez que ce cadeau vient des Grecques, les troyiens n'y voit que du feu et font entrer le cheval dans Troie. Une fois la nuit tombée, vous sortez. Vous entrez dans le chateau. Vous devez trouver le chronomètre de Cronos. Un itinéraire vous guidera. Sur le chemin, vous ferez attention à ne pas tomber dans les trois pièges.");

		private int id;
		private String description;

		private Etapes(int id, String description) {
			this.id=id;
			this.description= description;
			
		}
		
		/**
		 * Getter qui nous permet de récupérer l'id
		 * @return l'id 
		 */
		
		public int getId() {
	        return id;
	    }
		
		/**
		 * Getter qui nous permet de récupérer la description.
		 * @return la descrption.
		 */

	    public String getDescription() {
	        return description;
	    }
	    
	    /**
	     * Affichage du numéro de l'étape, et de sa description.
	     */
	    public void display() {
	    	System.out.println("Bienvenu à l'étape: "+getId());
	    	System.out.println(getDescription());
	    }
	

}
