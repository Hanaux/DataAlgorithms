package week12;

import java.util.ArrayList;
import java.util.Arrays;

class BellmanFord {
		final int INF = 9999;
		int N;
		int[] distance;
		ArrayList<Edge> edgeList;
		
		class Edge{
			int from, to, weight;
			
			public Edge(int from, int to, int weight) {
				this.from = from;
				this.to = to;
				this.weight = weight;
			}
		}
		
		public BellmanFord(int N) {
			this.N = N;
			edgeList = new ArrayList<>();
		}
		public void makeDirectEdge(int from, int to, int weight) {
			edgeList.add(new Edge(from, to, weight));
		}
		public void Bellman_Ford_Al(int v) {
			distance = new int[N+1];
			Arrays.fill(distance, INF);
			distance[v] = 0;
			
			for(int i=1;i<=N;i++) {
				for(int j=0;j<edgeList.size();j++) {
					int from = edgeList.get(j).from;
					int to = edgeList.get(j).to;
					int weight = edgeList.get(j).weight;
					
					if(distance[from]==INF) continue;
					if(distance[to]>distance[from]+weight) {
						if(i==N) {
							System.out.println("Has negative Cycle");
							break;
						}
						distance[to] = distance[from]+weight;
					}
				}
//				System.out.print(distance[i]==9999?"INF ":distance[i]+" ");
			}
			for(int i=1;i<=N;i++) {
				System.out.print(distance[i]==9999?"INF ":distance[i]+" ");
			}
		}


	public static void main(String[] args) {
		 BellmanFord graph = new BellmanFord(5);
		 graph.makeDirectEdge(1, 2, 7);
		 graph.makeDirectEdge(1, 3, 5);
		 graph.makeDirectEdge(1, 4, 3);
		 graph.makeDirectEdge(3, 4, 3);
		 graph.makeDirectEdge(3, 5, 3);
		 graph.makeDirectEdge(4, 2, 3);
		 graph.makeDirectEdge(4, 5, -6);
		 graph.makeDirectEdge(5, 3, 2);
		 
		 graph.Bellman_Ford_Al(1);

	}

}
