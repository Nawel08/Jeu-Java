package representation;
import java.util.Random;



public class ChanceNode extends Node
{
	
	public ChanceNode(String description, int id) {
		super(description, id);
	}
	
	@Override
	public void display(String description) {
		System.out.println(description);
	}
	
    @Override
	public Node chooseNext()
	{
		Random possibilite = new Random();
		System.out.println();
		/* par contre à la methode du Random
	    changera si on peut recuperer des chaines
	    de caractere ou des int, boolean,...
	    En gros ca depends du jeu aléatoire proposé
	    */
		boolean valeur = possibilite.nextBoolean();
		System.out.println(valeur);
		// Changer le return en fonction de la reponse
		return null;
		
		
	}

}
