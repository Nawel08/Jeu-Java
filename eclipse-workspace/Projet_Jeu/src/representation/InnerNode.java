package representation;

public class InnerNode extends Node {
	public Node Node1;
	public Node Node2;
	public Node Node3;
	public Node Node4;
	
	public InnerNode() {
		
	}
	
	
	public InnerNode(Node Node1, Node  Node2,Node Node3,Node Node4, String description, int id) 
	{
		super(description,id);
		this.Node1 = Node1;
		this.Node2 = Node2;
		this.Node3 = Node3;
		this.Node4 = Node4;
		
	}


	//public InnerNode(Evenements_1 level, Evenements_2 leve2, Evenements_3 leve3, Evenements_4 leve4) {
		// TODO Auto-generated constructor stub
	//}


	@Override
	public void display(String description) {
		System.out.println(description);
		
	}
	
	public void display_score(int score) {
		System.out.println("Ton score est de "+score+" points.");
		
	}


	@Override
	public Node chooseNext() {
		// TODO Auto-generated method stub
		return  Node1;
	}

}