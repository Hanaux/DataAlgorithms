package week10;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Prim {
	public static class Edge implements Comparable<Edge> {
		public int to, weight;
		
		public Edge(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
		
		public int compareTo(Edge o) {
			return this.weight-o.weight;
		}
	}
	
	static int total;
	static List<Edge>[] list;
	static boolean[] visited;
	
	public static void main(String[] args) {
		int w = 7;
		int[][] graph = {
				{1,3,25}, {1,3,35}, {4,7,15}, {1,6,24}, {3,5,17}, {6,4,33}, {2,5,13}, {3,7,33}, {3,6,15}
		};
		
		list = new ArrayList[w+1];
		visited = new boolean[w+1];
		for(int i=1;i<w+1;i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0;i<graph.length;i++) {
			int a = graph[i][0];
			int b = graph[i][1];
			int c = graph[i][2];
			
			list[a].add(new Edge(b,c));
			list[b].add(new Edge(a,c));
		}
		
		prim(1);
		System.out.println(total);
	}
	
	public static void prim(int start) {
		Queue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(start,0));
		
		while(!pq.isEmpty()) {
			Edge e = pq.poll();
			int edge = e.to;
			int weight = e.weight;
			
			if(visited[edge]) continue;
			visited[edge] = true;
			total += weight;
			
			for(Edge next : list[edge]) {
				if(!visited[next.to]) {
					pq.add(next);
				}
			}
		}
	}
}
