package week11;

public class Dijkstra {
	private int n;
	private int maps[][];
	int distance[];
	boolean check[];
	
	public Dijkstra(int n) {
		this.n = n;
		this.maps = new int[n+1][n+1];
		distance = new int[this.n+1];
		check = new boolean[this.n+1];
	}
	
	public void input(int i, int j, int w) {
		maps[i][j] = w;
		maps[j][i] = w;
	}
	
	public void dijkstra(int v) {
		reset(v);
		execute();
		printGraph();
	}

	private void reset(int v) {
		for(int i=1;i<n+1;i++) {
			distance[i] = Integer.MAX_VALUE;
		}
		distance[v] = 0;
		check[v] = true;
		
		for(int i=1;i<n+1;i++) {
			if(!check[i] && maps[v][i]!=0)
				distance[i] = maps[v][i];
		}
	}

	private void execute() {
		for(int i=0;i<n-1;i++) {
			int min = Integer.MAX_VALUE;
			int min_index=-1;

			min_index = findMin(min, min_index);
			check[min_index] = true;
			distanceSet(min_index);
		}
	}

	private void distanceSet(int min_index) {
		for(int j=1;j<n+1;j++) {
			if(!check[j] && maps[min_index][j]!=0) {
				if(distance[j]>distance[min_index]+maps[min_index][j]) {
					distance[j] = distance[min_index]+maps[min_index][j];
				}
			}
		}
	}
	private int findMin(int min, int min_index) {
		for(int j=1;j<n+1;j++) {
			if(!check[j] && distance[j]!=Integer.MAX_VALUE) {
				if(distance[j]<min) {
					min=distance[j];
					min_index = j;
					return min_index;
				}
			}
		}
		return 0;
	}
	private void printGraph() {
		for(int i=1;i<n+1;i++) {
			System.out.print(distance[i]+" ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int size = 8;
		Dijkstra d = new Dijkstra(size);
		d.input(1, 2, 3);
		d.input(1, 5, 4);
		d.input(1, 4, 4);
		d.input(2, 3, 2);
		d.input(3, 4, 1);
		d.input(4, 5, 2);
		d.input(5, 6, 4);
		d.input(4, 7, 6);
		d.input(7, 6, 3);
		d.input(3, 8, 3);
		d.input(6, 8, 2);
		d.dijkstra(1);
		
	}
	
}
