import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
/**
 * Classe du plus court chemin
 * @author Andrianina Andy Dylan
 *
 */
public class ShortestPath {//Dijkstra
	 
	

	
/**
 * Constructeur Vide
 * 
 */
	public ShortestPath() {
		
		
		
	}
	
	/**
	 * Determine la liste des plus courts chemin de la racine vers les autres sommet d'un graphe
	 * @param g graphe courant
	 * @param source sommet source a atteindre
	 * @return g le graphe courant
	 */
	public  Graphe ShortestPathFromSource(Graphe g,Sommet source) {//main programm
		Set<Sommet> sommetpris = new HashSet<>();
	 	Set<Sommet> sommetnonpris = new HashSet<>();
		source.setDistanceFromSource(0);
		sommetnonpris.add(source);
		
		while(sommetnonpris.size() > 0) 
		{
			Sommet CSommet =  getLowestDistanceSommet(sommetnonpris);
		
			sommetnonpris.remove(CSommet);
			sommetpris.add(CSommet);
			
			for(Entry<Sommet, Integer> neighbourgh : CSommet.getNeighbourgh().entrySet())//browse all neighbors of the Current nodes set
			{
				Sommet adjacent = neighbourgh.getKey();
				int weight = neighbourgh.getValue();
				
				if(!sommetpris.contains(adjacent)) 
				{
					
					MinDistance(adjacent,weight,CSommet,g);
					sommetnonpris.add(adjacent);
					
				}
				
			}
			
			
		}
		
		return g;
	}
	
	/**
	 * Recupere la plus petite distance entre les sommets non traités
	 * @param sommetnonpris liste de sommet non traité
	 * @return le sommet qui possède la plus petite distance de la racine
	 */
	public  Sommet getLowestDistanceSommet(Set <Sommet> sommetnonpris) 
	{//gathered the lowest distance between unsettled Sommet
		
		int lDistance = Integer.MAX_VALUE;
		Sommet lDSommet = null;
		
		for(Sommet s: sommetnonpris) 
		{
			int DSommet = s.getDistanceFromSource();
			
			if(DSommet <= lDistance)
			{
				lDistance = DSommet;
				 lDSommet = s;
			}
		}
		return lDSommet;
	}
	/**
	 * Determine la plus petite distance de la source entre la distance du voisins du sommet traité/la racine et le sommet traité/la racine 
	 * le sommet avec la plus petite distance est intégré dans la liste du chemin le plus court vers la racine
	 * @param neighbourgh Le voisins du sommmet en cours de traitement 
	 * @param weight poids de l'arrete entre le sommet courant et son voisin
	 * @param CSommet Le sommet courant
	 * @param g graphe courant
	 */
	public  void MinDistance(Sommet neighbourgh,int weight, Sommet CSommet,Graphe g)
	{//evaluate between two path which is the shortest on both to reach the specified node
		Integer DistFromSource = CSommet.getDistanceFromSource();
		
		if(DistFromSource + weight < neighbourgh.getDistanceFromSource()) 
		{
			neighbourgh.setDistanceFromSource(DistFromSource + weight);
			List<Sommet>shortestPath = new LinkedList<Sommet>(CSommet.getShortestPathList());
			shortestPath.add(CSommet);
			neighbourgh.setShortestPathList(shortestPath);
			
			
		}
		
		
	}
	
}
