package week12;

public class FloydWarshall {
	final int INF = 9999;
	int vertexCnt;
	int[][] map;
	
	public FloydWarshall(int N) {
		vertexCnt = N;
		map = new int[N+1][N+1];
	}
	
	public void makeDirectedEdge(int from, int to, int weight) {
		map[from][to] = weight;
	}
	
	public void floyd_Warshall() {
		int[][] distance = new int[vertexCnt+1][vertexCnt+1];
		for(int i=1;i<vertexCnt;i++) {
			for(int j=1;j<=vertexCnt;j++) {
				if(i==j) continue;
				distance[i][j] = map[i][j] == 0?INF:map[i][j];
			}
		}
		for(int i=1;i<=vertexCnt;i++) {
			for(int j=1;j<=vertexCnt;j++) {
				for(int k=1;k<=vertexCnt;k++) {
					if(distance[j][k] > distance[j][i] + distance[i][k]) {
						distance[j][k] = distance[j][i]+distance[i][k];
					}
				}
			}
		}
		for(int i=1;i<=vertexCnt;i++) {
			for(int j=1;j<=vertexCnt;j++) {
				System.out.print(distance[i][j]==INF?"INF ":distance[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		FloydWarshall graph = new FloydWarshall(5);
		graph.makeDirectedEdge(1, 2, 3);
		graph.makeDirectedEdge(1, 3, 8);
		graph.makeDirectedEdge(2, 3, 2);
		graph.makeDirectedEdge(3, 4, 1);
		graph.makeDirectedEdge(3, 5, 3);
		graph.makeDirectedEdge(4, 1, 5);
		graph.makeDirectedEdge(4, 5, 2);
		graph.makeDirectedEdge(5, 3, 4);
		graph.floyd_Warshall();
		

	}

}
