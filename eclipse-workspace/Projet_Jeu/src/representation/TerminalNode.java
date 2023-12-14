package representation;

public class TerminalNode extends Node {

	public TerminalNode(String description, int id) 
	{
		super(description,id);

	}

	public TerminalNode() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void display(String description)
	{
		System.out.println(description);

	}

	
	@Override
	public Node chooseNext() {
		System.out.println("Fin de Partie");
		//return super.chooseNext();
		//Comme j'ai redefinie la methode et que je veux qu'elle renvoie le noeud lui meme, je fais le return this
		return this;
		
		
	}

}