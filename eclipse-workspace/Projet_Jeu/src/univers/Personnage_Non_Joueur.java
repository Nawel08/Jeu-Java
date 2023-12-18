package univers;

// Cette classe va représenter l'armée de notre personnage principal.
public class Personnage_Non_Joueur extends Personnage {
	//Armee ulysse
	//Armee de troie
	
	public int d_mission;
    public boolean mission;
    public int nouveau_score1;
    
    public String Presentation() {
		
		return "Nous seront ton armée";
	}
    
    
    public Personnage_Non_Joueur(){
    	
    }
    
    public Personnage_Non_Joueur(String nom, int effectif) {
        this.nom = nom;
        this.effectif = effectif;
    }
    
    public Personnage_Non_Joueur(String prenom, int score, int d_mission, boolean mission) {
        super(prenom, score);
        this.d_mission = d_mission;
        this.mission = mission;
        this.nouveau_score1 = Apprecier(mission, d_mission);
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

    public int getEffectif() {
        return effectif;
    }

    public void diminuerEffectif(int quantite) {
        effectif -= quantite;
    }

    public void augmenterEffectif(int quantite) {
        effectif += quantite;
    }
}

