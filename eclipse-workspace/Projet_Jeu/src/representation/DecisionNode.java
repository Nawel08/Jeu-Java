package representation;
import java.util.Scanner;

public abstract class DecisionNode extends Node {
	

	public DecisionNode(String description, int id )
	{
		super (description,id);

	}
	
	
    @Override
	public void display(String description)
	{
		System.out.println(description);

	}
	
	
	@Override
	public Node chooseNext() 
	{
		
		// Il doit y zvoir un system out pour que l'utilisateur entre sa reponse
			var reponse = System.console();
			if (reponse != null) 
			{
				Scanner choice = new Scanner (reponse.reader());
				System.out.println(description);
				String choix = choice.nextLine();
				System.out.println("vous avez rentrez: " +choix);
			}
			Node choix = null;
			//Ajouter des return en comparant la decision du joueur
			return choix;
			
		
		}


	public abstract String nextLine();


	}
	

