package week10;

import java.util.PriorityQueue;
import java.util.Queue;

public class Kruskal {
	public static class Edge implements Comparable<Edge> {
		public int to, from, weight;
		
		public Edge(int to,int from, int weight) {
			this.to = to;
			this.from = from;
			this.weight = weight;
		}
		
		public int compareTo(Edge o) {
			return this.weight-o.weight;
		}
	}
	
	private static int n;
	private static int[] parents;
	public static void main(String[] args) {
		n = 7;
		int[][] graph = {
				{1,3,25}, {1,3,35}, {4,7,15}, {1,6,24}, {3,5,17}, {6,4,33}, {2,5,13}, {3,7,33}, {3,6,15}
		};
		parents = new int[n+1];
		
		for(int i=1;i<n+1;i++) {
			parents[i] = i;
		}
		
		Queue<Edge> pq = new PriorityQueue<>();
		for(int i=0;i<graph.length;i++) {
			int to = graph[i][0];
			int from = graph[i][1];
			int weight = graph[i][2];
			pq.add(new Edge(to, from, weight));
		}
		
		int size = pq.size();
		int total = 0;
		for(int i=0;i<size;i++) {
			Edge edge = pq.poll();
			int rx = find(edge.to);
			int ry = find(edge.from);
			
			if(!isSameParent(rx, ry)) {
				total += edge.weight;
				union(edge.to, edge.from);
			}
		}
		System.out.println(total);
	}
	
	static int find(int r) {
		if(parents[r] == r) {
			return r;
		}
		return parents[r] = find(parents[r]);
	}
	
	static void union(int to, int from) {
		to = find(to);
		from = find(from);
		if(to<from) parents[from] = to;
		else parents[to] = from;
	}
	
	static boolean isSameParent(int x, int y) {
		if(x == y) return true;
		return false;
	}
	
}
