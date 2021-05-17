import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
/**
 * Classe main
 * @author Andrianina Dylan Andy
 *
 */
public class Test {

	private static Scanner sc;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		String c4,c1,c2,c3,c0,essai,c5;
		int result2,result;
		sc = new Scanner(System.in);
			
			List<String> w = new ArrayList<>(); //full path of connexity
			int i;
		
		
			
			Graphe g1= null;
			
		do 
		{//create a graph until connected component is fully checked	// Partie 2 du projet : Connexité + création du graphe de la part 1
			
		g1 = new Graphe(75,0);
		g1.unmarkAll();
		
			
		 w = g1.checkConnexity(g1.getGraphe().get(0).getNeighbourgh(),g1.getGraphe().get(0),0,w);
		 i=	g1.getSize();
		}while(w.size() != i); // si tout les elements sont présent dans le chemin w alors le graphe est connexe
		
		ShortestPath sp = new ShortestPath();
		g1.affiche();
		
		
	//Set the root table for all/ Creation de la table de routage pour tout les sommets Partie 3 Bis du projet 
		for(int e1 = 0 ; e1<100; e1++) 
		{
			g1.resetDistance(Integer.MAX_VALUE);
			sp.ShortestPathFromSource(g1, g1.getGraphe().get(e1));
			for(int v = 0; v<100; v++)
			{
				List<Sommet> l = new LinkedList<Sommet>(g1.getGraphe().get(v).getShortestPathList());
				g1.getGraphe().get(e1).setRoutList(l);
		
			}
			for(int z3 = 0 ; z3<100; z3++)
			{
				g1.getGraphe().get(z3).getShortestPathList().clear();
			}
		}
		  
		System.out.println();
		//
		do {
			
		//Part 4 
		do 
		{
			
		do 
		{
		System.out.println("Saisir l'emetteur");
		c1 = sc.nextLine();
		}while(c1.length() < 2 && c1.length() < 3);
		
		c0 = c1.substring(0,1);
		c4 = c1.substring(1);
		result2 = Integer.parseInt(c4);
		}while( result2 > 99 || ((!c0.equals("A") || result2 > 7) && (!c0.equals("B") || (result2 > 27 || result2 <= 7)) &&  (!c0.equals("C") || (result2 > 99 || result2 <= 27))) );
		
		Sommet s1 = g1.getGraphe().get(result2);
		do 
		{
		System.out.println("Saisir le destinataire");
		c2 = sc.nextLine();
		c5 = c2.substring(0,1);
		c3 = c2.substring(1);
		result = Integer.parseInt(c3);
		}while(result > 99 || ((!c5.equals("A") || result > 7) && (!c5.equals("B") || (result > 27 || result <= 7)) &&  (!c5.equals("C") || (result > 99 || result <= 27)))  );
	
		System.out.print("Chemin le plus court : ");
		
		for(int a1 = 0; a1<s1.getRoutList().get(result).size();a1++ ) 
		{	
		System.out.print(s1.getRoutList().get(result).get(a1).getName()+ "->");
		}
		
		System.out.print(c2);
		System.out.println("Recherchez un autre root? Y/N");
		essai = sc.nextLine();
		
		}while((essai.equals("Y") && essai.equals("y")) || (!essai.equals("N") && !essai.equals("n")) );
		

		
		
	}
	

	
	

}
