import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/**
 * Classe de sommets
 * @author Andrianina Dylan Andy
 *
 */
public class Sommet {
	private boolean mark;
	private String name; //A+number=backbone B+number=tier 2 C+number=tier 3
	private Map<Sommet,Integer> neighbourgh = new HashMap<>();
	
	private Integer distancefromSource = Integer.MAX_VALUE;
	private List<Sommet> ShortestPath = new LinkedList<Sommet>();
	private List<List<Sommet>> RoutList = new LinkedList<List<Sommet>>(); // la table de routage composé d'une liste de liste de chemin les plus court pour atteindre tous les sommets a partir du sommet dit
	/**
	 * constructeur vide
	 */
	public Sommet() {
		this.mark = false;
		this.name = "";
		
	}
/**
 * instancie un sommet avec un nom
 * @param nom
 */
	public Sommet(String nom) {
		this.mark = false;
		this.name = nom;
		
		
	}
	/**
	 * Instance un sommet avec un nom et son "tier" : 1, 2 ou 3
	 * @param nom
	 * @param tier
	 */
	public Sommet(String nom,int tier) 
	{
		this.mark = false;
		switch (tier) {
		case 1:
			this.name = "A" + nom;
			
		break;
		case 2:
			this.name = "B" + nom;
		break;
		case 3 :
			this.name = "C" + nom;
		break;
		default:
			this.name = nom;
			break;
		
		}
		
		
	}
	
	/**
	 * 
	 * Getters and setters
	 * 
	 */
	
	public List<Sommet> getShortestPathList(){
		return this.ShortestPath;
	}
	/**
	 * 
	 * @param l
	 */
	public void setShortestPathList(List<Sommet> l) {
		this.ShortestPath = l;
		
		
	}
	/**
	 * 
	 * Getters and setters
	 * 
	 */
	public Integer getDistanceFromSource() {
		return this.distancefromSource;
	}
	/**
	 * 
	 * Getters and setters
	 * 
	 */
	public void setDistanceFromSource(int i) {
		this.distancefromSource = i;
	}
	
	/**
	 * 
	 * Getters and setters
	 * 
	 */
	public void addNeighbourgh(Sommet j,int cout) {
		neighbourgh.put(j, cout);
		
		
	}
	/**
	 * 
	 * Getters and setters
	 * 
	 */
	public Map<Sommet,Integer> getNeighbourgh(){
		return this.neighbourgh;
	}
	/**
	 * 
	 * Getters and setters
	 * 
	 */
	public String getName() {
		return this.name;
	}
	/**
	 * 
	 * Getters and setters
	 * 
	 */
	public List<List<Sommet>> getRoutList(){
		return RoutList;
	}
	/**
	 * 
	 * Getters and setters
	 * 
	 */
	public void setRoutList(List<Sommet> l) {
		this.RoutList.add(l);
	}
	
	/**
	 * Marquer un sommet
	 */
	public void mark() {//mark a node
		this.mark = true;
		
		
	}
	/**
	 * enlever la marque d'un sommet
	 */
	public void unmark() {//unmark a node
		this.mark = false;
	}
	/**
	 * savoir si le sommet est marquer ou non 
	 * @return true si marqué false sinon
	 */
	public boolean getMark()
	{
		return this.mark;
		
	}
	
	
	
	
	

}