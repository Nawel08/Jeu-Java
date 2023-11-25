package representation;

public abstract class Node {
	protected String description;
	protected int identifiant;

	
	public Node(String description, int id) 
	{
		this.description = description;	
		this.identifiant = id;
	
	}
	
	// A completer
	// Permet de designer le prochain noeud à considérer (donc je crois que ca doit etre relier soit à decisionnODE soit InnerNode
	// Du coup je decide de la mettre en abstract car chaque classe aura sa propre implementation de cette methode
	public abstract Node chooseNext();
	
	
	
	
	// là j'affiche rien car la methode abstraite n'a pas de corps
	// Mais dans les autres classes je dois afficher la description
	public abstract void display(String description);

	public String getDescription(){return description;}
	public void setDescription(String description){this.description = description;}


	public int getIdentifiant(){return identifiant;}
	public void setIdentifiant(int identifiant){this.identifiant = identifiant;}

	
}
