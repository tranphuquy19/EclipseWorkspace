package lythuyet;

import java.io.*;
import java.util.*;

class Graph2 {
	private int V;
	private LinkedList<Integer> adj[];

	Graph2(int v) {
		V = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; ++i)
			adj[i] = new LinkedList();
	}

	void addEdge(int v, int w) {
		adj[v].add(w);
	}

	void BFS(int s) {
	
	
		boolean visited[] = new boolean[V];


		LinkedList<Integer> queue = new LinkedList<Integer>();

		
		visited[s] = true;
		queue.add(s);

		while (queue.size() != 0) {
		
			s = queue.poll();
			System.out.print(s + " ");

			
			Iterator<Integer> i = adj[s].listIterator();
			while (i.hasNext()) {
				int n = i.next();
				if (!visited[n]) {
					visited[n] = true;
					queue.add(n);
				}
			}
		}
	}

	// Driver method to
	public static void main(String args[]) throws FileNotFoundException{

		File f = new File("a.txt");
		Scanner sc = new Scanner(f);
		int v, e;
		v = sc.nextInt();
		e = sc.nextInt();
		int a[] = new int[e];
		Graph2 g = new Graph2(v); 
//		Map<Integer, Integer> list = new HashMap<Integer, Integer>(); 
		for (int i = 0; i < e; i++) {
			//System.out.println(sc.nextInt() +":"+ sc.nextInt());
			//list.put(sc.nextInt(), sc.nextInt());
			g.addEdge(sc.nextInt(), sc.nextInt());
		}
		sc.close();
		
//		Set<Integer> set = list.keySet();
//		for(Integer key:set) {
//			//g.addEdge(key.intValue(), list.get(key).intValue());
//			//System.out.println(key.intValue() + ":"+ list.get(key).intValue());
//		}
		System.out.println("Following is Breadth First Traversal " + "(starting from vertex 2)");

		g.BFS(3);
	}
}