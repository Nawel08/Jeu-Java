package univers;

/**
 * Dans cette classe on retrouvera tous les personnages non principaux
 * @author nawel
 *
 */
public class Personnage_Non_Joueur extends Personnage {

	
	public int d_mission;
    public boolean mission;
    public int nouveau_score1;
    
    /**
     * Méthode de présentation pour l'armée d'Ulysse.
     * @return
     */
    public String Presentation() {
		
		return "Nous seront ton armée";
	}
    
    
    public Personnage_Non_Joueur(){
    	
    }
    /**
     * Constrcueur de la classe
     * @param nom: nom du personnage non joueur.
     * @param effectif, effectif (ex: armée..)
     */
    public Personnage_Non_Joueur(String nom, int effectif) {
        this.nom = nom;
        this.effectif = effectif;
    }
    
    public Personnage_Non_Joueur(String prenom, int score, int d_mission, boolean mission) {
        super(prenom, score);
        this.d_mission = d_mission;
        this.mission = mission;
        this.nouveau_score1 = Apprecier(d_mission);
    }

	
	
	
	private String nom;
    private int effectif;

    public void Armee(String nom, int effectif) {
        this.nom = nom;
        this.effectif = effectif;
    }

    public String getNom() {
        return nom;
    }
    
	/**
	 * Getter pour recuperer l'effectif
	 * @return: le nombre qui correspond à l'effectif
	 */
    public int getEffectif() {
        return effectif;
    }

    /**
     * Méthode qui permet de réduire l'effectif par une quantité donnée
     * @param quantite, quantité qu'on doit enlever à l'effectif.
     */
    public void diminuerEffectif(int quantite) {
        effectif -= quantite;
    }

    /**
     * Méthode qui permet d'augmenter l'effectif par une quantité donnée
     * @param quantite, quantité qu'on doit ajouter à l'effectif.
     */
    public void augmenterEffectif(int quantite) {
        effectif += quantite;
    }
}

