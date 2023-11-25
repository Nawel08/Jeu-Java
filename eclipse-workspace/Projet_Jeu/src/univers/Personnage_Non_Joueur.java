package univers;

// Cette classe va représenter l'armée de notre personnage principal.
public class Personnage_Non_Joueur extends Personnage {
	
	
	public int d_mission;
    public boolean mission;
    public int nouveau_score1;
    
    public String Presentation() {
		
		return "Nous seront ton armée";
	}
    
    
    public Personnage_Non_Joueur(String prenom, int score, int d_mission, boolean mission) {
        super(prenom, score);
        this.d_mission = d_mission;
        this.mission = mission;
        this.nouveau_score1 = Apprecier(mission, d_mission);
    }
    
	@Override
	public int Apprecier(boolean mission,int score) {
		//Deja il faut borner notre score
		if(mission=true) {
			System.out.println("Felicitation vous avez réussi la mission");
			if(d_mission==1) {
				return (score+=20);
			}
			else {
				return (score+=10);
			}
		}
		else{
			System.out.println("Vous avez échouer votre mission.");
			if(d_mission==1) {
				return (score-=10);
			}
			else {
				return (score= score - score);
			}
		}
			
		
		
		
		
	}
	public int nouveau_score= Apprecier(mission, score);
}

