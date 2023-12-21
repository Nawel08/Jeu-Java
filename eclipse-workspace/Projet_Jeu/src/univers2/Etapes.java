package univers2;

/**
 * Enumeration des étapes de cet univers. 
 * @author nawel
 *
 */
public enum Etapes {

		etape_1(1,"Tu dois attirer l'attention de Cléopatre."), 
		
		etape_2(2,"Maintenant que tu as réussi à te faire remarquer par Cléopatre, tu dois te marier avec elle. "
				+ "Durant cet étape tu vas devoir gagner le maximum de points pour qu'elle accepte de se marier avec toi."), 
		etape_3(3,"Octave ne t'apprécie pas, s'il parvient à te battre alors tu mourras et Cléopatre aussi."
				+ "Pour éviter cela, tu dois le battre."); 
		
		private int id;
		private String description;

		/**
		 * Constructeur de l'enumeration
		 * @param id: id de l'étape
		 * @param description
		 */
		Etapes(int id, String description) {
			this.id=id;
			this.description= description;
			
		}
		//Va nous permettre de recuprer l'id
		public int getId() {
	        return id;
	    }
		//Va nous permettre de recuperer la description.
	    public String getDescription() {
	        return description;
	    }
	    
	    public void display() {
	    	System.out.println("Bienvenu à l'étape: "+getId());
	    	System.out.println(getDescription());
	    }
		

	

}
