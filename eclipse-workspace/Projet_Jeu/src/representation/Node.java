package representation;

public class Node implements Event {
	protected String description;
	protected int identifiant;

	public Node() {
		
	}
	public Node(String description, int id) 
	{
		this.description = description;	
		this.identifiant = id;
	
	}
	
	// A completer
	// Permet de designer le prochain noeud à considérer (donc je crois que ca doit etre relier soit à decisionnODE soit InnerNode
	// Du coup je decide de la mettre en abstract car chaque classe aura sa propre implementation de cette methode
	//public abstract boolean chooseNext();
	
	
	
	
	// là j'affiche rien car la methode abstraite n'a pas de corps
	// Mais dans les autres classes je dois afficher la description
	//public abstract void display(String description);

	public String getDescription(){return description;}
	public void setDescription(String description){this.description = description;}


	public int getIdentifiant(){return identifiant;}
	public void setIdentifiant(int identifiant){this.identifiant = identifiant;}
	
	@Override
	
    public void display(String nom) {
    }

    @Override
    public Event chooseNext() {
        // Implémentation de la logique pour choisir le prochain événement
        return null;
    }
	
}
