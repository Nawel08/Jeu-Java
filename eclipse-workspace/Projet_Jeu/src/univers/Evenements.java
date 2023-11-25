package univers;

public abstract class Evenements {
	//On initialise les passages possibles aux niveaux.
	/* 
	 * Au debut, on a accès que au niveau 1, donc c'est le seul qui est true.
	 */
	public boolean p_1=true; //p_1 signifie passage au niveau 1.
	public boolean p_2=false;
	public boolean p_3=false;
	public boolean p_4=false;
	
	/*
	Dans cette classe on va mettre le code qu'on retrouve dans toutes les classes dérivées.
	On utilise une classe abstraite car nous avons au moins une classe abstraite qui est la méthode "Issue"
	Dans cette méthode on va retrouver ce qui se passera à la suite de cet evenement pour le joueur.
	Elle est abstraite, car chaque evenement dispose de sa facon de procéder.
	*/
	
	
	
	protected int score;
    
    protected boolean mission;

    
   
    //On met la méthode pour afficher l'enumration en abstraite
    //Afin que chaque classe fille la redefinisse et puisse acceder à son element car il n'est pas possible d'effectuer etape_id avec un id variable.
    public abstract void afficherEtapes();
    
    
    
    //La méthode etant asbtraite, donc sans corps, on va être obligé de redefinir la méthode.
    public abstract void Issue();
    
    
}
