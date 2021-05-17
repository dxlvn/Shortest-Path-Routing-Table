import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
/**
 * Classe de création d'un graphe
 * @author Andy Andrianina Dylan
 *
 */
public class Graphe {
		private List<Sommet> graphe;

		/**
		 * 
		 * Constructors
		 * 
		 */
		public Graphe() {
			graphe = new LinkedList<Sommet>();
		}
		
		public Graphe(int number) {
			graphe = new LinkedList<Sommet>();
			for(int i = 0; i<number ; ++i) {
				Sommet s = new Sommet("S" + i);
				graphe.add(s);
				
				
			}
			
			
		}
		/**
		 * Create n number of nodes withe three types of tier set Edges randomly with special conditions
		 * 
		 * 
		 * 
		 */
		public Graphe(int probability,int z) {
			List<Sommet> C = new LinkedList<Sommet>();
			graphe = new LinkedList<Sommet>();
			Sommet s = null;
			
			int r,g,l,m,r1,r2,p,r3,r4,r5,q,r6,r7;
			
			Random rand = new Random();
			
			
			for(int i = 0; i<100; i++)
			{
				
				if(i >= 0 && i<8)
				{
					s = new Sommet("" + i,1);	
				
				}
				else if(i>= 8 && i < 28) 
				{
					 s = new Sommet("" + i,2);
					
				}
				else
				{
					 s = new Sommet("" + i,3);
					
				}
				
				graphe.add(s);
			}
			
			for(int i = 0; i<100; i++) {
				//les poids sont générés aléatoirement avec l'objet random
				r1 = 10 + rand.nextInt(11);
				r2 = 10 + rand.nextInt(11);
				r3 = 10 + rand.nextInt(11);
				r4 = 10 + rand.nextInt(11);
				r5 = 10 + rand.nextInt(11);
				r6 = 15 + rand.nextInt(35);
				r7 = 15 + rand.nextInt(35);
				
				if(graphe.get(i).getName().contains("A")) 
				{//tier 1 setup
						for(int j = i+1 ; j< 8; j++) 
						{
							
							if( rand.nextInt(100) <= probability)
							{//link between tier 1 node
								r= 5 + rand.nextInt(6);
								if(!graphe.get(i).getNeighbourgh().containsKey(graphe.get(j)) )
								{
								graphe.get(i).addNeighbourgh(graphe.get(j),r);
								graphe.get(j).addNeighbourgh(graphe.get(i), r);
								}
								
							}
						}
						
				}
				
				else if(graphe.get(i).getName().contains("B")) 
				{//tier 2 setup
					
					//random
					g = rand.nextInt(2);
					p= rand.nextInt(2);
				
					
					//evalutation de l'ajout d'arrete au tier 1
					if(g == 1)
					{//on ajoute deux arrete avec des Tier 1
						l=  rand.nextInt(8);
						m = rand.nextInt(8);
						if(l == m ) 
						{//Si random marche pas
							if(l==7) 
							{
								m = m - rand.nextInt(7);
							}
							else if(l == 0) 
							{
								m = m + rand.nextInt(7);
							}
							else 
							{
								m = 0;
								do 
								{
								m = rand.nextInt(8);
								}while(l == m);
							}
							if(!graphe.get(i).getNeighbourgh().containsKey(graphe.get(l))) {
							graphe.get(i).addNeighbourgh(graphe.get(l), r1);
							graphe.get(l).addNeighbourgh(graphe.get(i), r1);
							}
							if(!graphe.get(i).getNeighbourgh().containsKey(graphe.get(m))) {
							graphe.get(i).addNeighbourgh(graphe.get(m), r2);
							graphe.get(m).addNeighbourgh(graphe.get(i), r2);
							}
							
							
						}
						
						else 
						{//random has worked
							if(!graphe.get(i).getNeighbourgh().containsKey(graphe.get(l)))
							{
							graphe.get(i).addNeighbourgh(graphe.get(l), r1);
							graphe.get(l).addNeighbourgh(graphe.get(i), r1);
							}
							if(!graphe.get(i).getNeighbourgh().containsKey(graphe.get(m))) 
							{
							graphe.get(i).addNeighbourgh(graphe.get(m), r2);
							graphe.get(m).addNeighbourgh(graphe.get(i), r2);
							}
							 	
							
						}
						
						
					}
					else 
					{//on ajoute une arrete avec des Tier 1
						l = rand.nextInt(8);
						if(!graphe.get(i).getNeighbourgh().containsKey(graphe.get(l))) 
						{
						graphe.get(i).addNeighbourgh(graphe.get(l), r1=10 + rand.nextInt(11));
						graphe.get(l).addNeighbourgh(graphe.get(i), r1);
						}
					}
				
					//evaluation de l'ajout d'arrete entre tier 2
					
					g = rand.nextInt(2);
					p= rand.nextInt(2);
					
					if(p == 1) 
					{//on ajoute trois lien entre tier 2
						l=  8+rand.nextInt(20);
						m = 8+rand.nextInt(20);
						q = 8+rand.nextInt(20);
						
						if(l == m ) 
						{//Si random marche pas
							if(l==27)
							{
								m = m - rand.nextInt(20);
							}
							else if(l == 8)
							{
								m = m + rand.nextInt(20);
							}
							else 
							{
								m = 0;
								do 
								{
								m = 8+rand.nextInt(20);
								}while(l == m);
							}
							if(l == q ) 
							{//Si random marche pas
								if(l==27)
								{
									q = q - rand.nextInt(20);
								}
								else if(l == 8) 
								{
									q = q + rand.nextInt(20);
								}
								else 
								{
									q = 0;
									do 
									{
									q = 8+rand.nextInt(20);
									}while(l == q);
								}
						
						
							}
							
							if(!graphe.get(i).getNeighbourgh().containsKey(graphe.get(l)))
							{
							graphe.get(i).addNeighbourgh(graphe.get(l), r3);
							graphe.get(l).addNeighbourgh(graphe.get(i), r3);
							}
							if(!graphe.get(i).getNeighbourgh().containsKey(graphe.get(m)))
							{
							graphe.get(i).addNeighbourgh(graphe.get(m), r4);
							graphe.get(m).addNeighbourgh(graphe.get(i), r4);
							}
							if(!graphe.get(i).getNeighbourgh().containsKey(graphe.get(q)))
							{
							graphe.get(i).addNeighbourgh(graphe.get(q), r5);
							graphe.get(q).addNeighbourgh(graphe.get(i), r5);
							}
					
					
				}		
				else 
				{//random has worked
					if(!graphe.get(i).getNeighbourgh().containsKey(graphe.get(l))) 
					{
					graphe.get(i).addNeighbourgh(graphe.get(l), r3);
					graphe.get(l).addNeighbourgh(graphe.get(i), r3);
					}
					if(!graphe.get(i).getNeighbourgh().containsKey(graphe.get(m)))
					{
					graphe.get(i).addNeighbourgh(graphe.get(m), r4);
					graphe.get(m).addNeighbourgh(graphe.get(i), r4);
					}
					if(!graphe.get(i).getNeighbourgh().containsKey(graphe.get(q))) 
					{
					graphe.get(i).addNeighbourgh(graphe.get(q), r5);
					graphe.get(q).addNeighbourgh(graphe.get(i), r5);
					}
				}
					
					
					
				}
					
				else 
				{//deux arrete entre tier 2
					l=  8+rand.nextInt(20);
					m = 8+rand.nextInt(20);
					
					if(l == m ) 
					{//Si random marche pas
						if(l==27) 
						{
							m = m - rand.nextInt(20);
						}
						else if(l == 8)
						{
							m = m + rand.nextInt(20);
						}
						else 
						{
							m = 0;
							do 
							{
							m = 8+rand.nextInt(20);
							}while(l == m);
						}
						
						if(!graphe.get(i).getNeighbourgh().containsKey(graphe.get(l)))
						{
						graphe.get(i).addNeighbourgh(graphe.get(l), r3);
						graphe.get(l).addNeighbourgh(graphe.get(i), r3);
						}
						if(!graphe.get(i).getNeighbourgh().containsKey(graphe.get(m)))
						{
						graphe.get(i).addNeighbourgh(graphe.get(m), r4);
						graphe.get(m).addNeighbourgh(graphe.get(i), r4);
						}
						
				}
					else 
					{
					if(!graphe.get(i).getNeighbourgh().containsKey(graphe.get(l))) 
					{
					graphe.get(i).addNeighbourgh(graphe.get(l), r1);
					graphe.get(l).addNeighbourgh(graphe.get(i), r1);
					}
					if(!graphe.get(i).getNeighbourgh().containsKey(graphe.get(m)))
					{
					graphe.get(i).addNeighbourgh(graphe.get(m), r2);
					graphe.get(m).addNeighbourgh(graphe.get(i), r2);
					}
					
				}
				
				}
			}
				else 
				{//tier 3 setup
					l=  8+rand.nextInt(20);
					m = 8+rand.nextInt(20);
					//deux lien avec tier 2
					if(l == m )
					{//Si random marche pas
						if(l==27) 
						{
							m = m - (1+rand.nextInt(19));
						}
						else if(l == 0) 
						{
							m = m + (1+rand.nextInt(19));
						}
						else 
						{
							m = 0;
							do 
							{
							m = 8+rand.nextInt(20);
							}while(l == m);
						}
						if(!graphe.get(i).getNeighbourgh().containsKey(graphe.get(l))) 
						{
							graphe.get(i).addNeighbourgh(graphe.get(l), r6);
							graphe.get(l).addNeighbourgh(graphe.get(i), r6);
						}
						if(!graphe.get(i).getNeighbourgh().containsKey(graphe.get(m))) 
						{
							graphe.get(i).addNeighbourgh(graphe.get(m), r7);
							graphe.get(m).addNeighbourgh(graphe.get(i), r7);
						}
				   }
				else 
				   {
					   if(!graphe.get(i).getNeighbourgh().containsKey(graphe.get(l)))
					   {
						   graphe.get(i).addNeighbourgh(graphe.get(l), r6);
						   graphe.get(l).addNeighbourgh(graphe.get(i), r6);
					   }
					   if(!graphe.get(i).getNeighbourgh().containsKey(graphe.get(m)))
					   {
						   graphe.get(i).addNeighbourgh(graphe.get(m), r7);
						   graphe.get(m).addNeighbourgh(graphe.get(i), r7);
					   }
					
				   }
				
					//un lien entre tier 3
					
					
				do 
				{
				l = 28 + rand.nextInt(44);
				}while(l == i);
						
						
					if(!graphe.get(i).getNeighbourgh().containsKey(graphe.get(l))) 
					{
						graphe.get(i).addNeighbourgh(graphe.get(l), r6);
						graphe.get(l).addNeighbourgh(graphe.get(i), r6);
					
					}
						
					
				}	
					
			}
				
}
	
		
		
			
			
		/**
		 * 
		 * Getters and setters
		 * 
		 */
		
		public void addS(Sommet s)
		{
			graphe.add(s);
			
			
		}
		/**
		 * Taille du graphe
		 * @return size
		 */
		public int getSize()
		{
			return graphe.size();
		}
		/**
		 * getters
		 * @return graphe liste des sommets
		 */
		public List<Sommet> getGraphe()
		{
			return this.graphe;
		}
		
		public void setGraphe(List<Sommet> g) {
			this.graphe =  g;
					
					
				}
		
		
		/**
		 * 
		 * filling an empty Graph with random setup
		 * 
		 * 
		 */
		
		public void fillUpRandomly(Graphe g) 
		{
			Random r = new Random();
		
			for(int i = 0; i< r.nextInt(10000); i++)
			{
				Sommet s = new Sommet("S" + i);
				g.addS(s);
			}
			
			for(int j = 0; j<g.getSize(); j++) 
			{
				int d = r.nextInt(g.getSize());
				int m = 1+r.nextInt(20);
				if(!g.getGraphe().get(j).getNeighbourgh().containsKey(g.getGraphe().get(d))){
				g.getGraphe().get(j).addNeighbourgh(g.getGraphe().get(d), m);
				g.getGraphe().get(d).addNeighbourgh(g.getGraphe().get(j), m);
				}
				
			}
			
		}
		
		/**
		 * 
		 * find a node with his name
		 * 
		 */
		public Sommet getSommetByItName(String name)
		{
			for(int i = 0; i<graphe.size();++i) 
			{
				if(name == graphe.get(i).getName())
				{
					return graphe.get(i);
				}
			}
			return null;
		}
		
		/**
		 * retourne le poids d'une arrete entre deux sommet
		 * @param s1 
		 * @param s2
		 * @return poids
		 */
		
		public int getCostBetween2Components(Sommet s1, Sommet s2)
		{
			return s1.getNeighbourgh().get(s2);
		}
		
		/**
		 * CHeck if all the component are connected and returns a List of the tree DepthFirstSearch
		 * 
		 * 
		 * 
		 */
		public List<String> checkConnexity(Map<Sommet,Integer> a,Sommet v,int i,List<String> q) {
			//System.out.println(a.get(i).getName());
			
			v.mark();
		
			q.add(v.getName());
			 a  = v.getNeighbourgh();	
			
			 for(Sommet x : a.keySet())
			if(x.getMark() == false) {
				
				
				checkConnexity(a,x,i+1,q);
				
			}
			return q;
		}
		/**
		 * 
		 * print the all the connection between nodes and weight 
		 * 
		 * 
		 */
		public void affiche() {
			int i = this.getSize();
			
			for(int o = 0; o<i;o++) {
				System.out.println();
				System.out.print(this.getGraphe().get(o).getName() + ": ");
				
			
			for(Entry<Sommet, Integer > x : this.graphe.get(o).getNeighbourgh().entrySet()) {
					System.out.print(x.getKey().getName() + " (" + x.getValue() + ") ");
					
			
				}
			
			}
		}
		/**
		 * unmark ALl the node
		 * 
		 * 
		 */
		
		
		
		public void unmarkAll() {
			for(int i = 0; i<this.graphe.size();  i++) { 
					this.graphe.get(1).unmark();
			}
		}
		/**
		 * reinitialise les distance vers une racine 
		 * @param i distance reinitialisé
		 */
		public void resetDistance(int i) {
			for(int a = 0; a<100; a++) {
			this.graphe.get(a).setDistanceFromSource(i);
			}
			
		}
		
		
}
