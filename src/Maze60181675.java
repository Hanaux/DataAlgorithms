
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;

public class Maze60181675 {
	
///////////////////////////////////////////////////////////////////
/// 0) 학번, 이름을 기입하시오.
	String numId ="60181675";   // 학번
	String name ="한승헌";    // 이름	
///////////////////////////////////////////////////////////////////

	public class Coordinate{
		int x, y;
		public Coordinate(int i, int j) {
			x=i; y=j;
		}
		public boolean equals(Coordinate other) {
			return (this.x==other.x)&&(this.y==other.y); 
		}
		public void copyFrom(Coordinate other) {
			this.x = other.x;
			this.y = other.y;
		}
		public String toString() {
			return "("+x+","+y+")";
		}		
	}
	int size ;
	Coordinate start, destin;
	
	public Maze60181675(int n) {
		size = n;
		start = new Coordinate(0,0);
		destin = new Coordinate(size-1,size-1);
		
		System.out.println("<< "+numId+" : "+name+" >>");
	}
	
	public int DFS(int [][] in) {
		int [][] m = deepCopy(in);
		show("Initial State", m);

		Coordinate p = new Coordinate(start.x,start.y);
		int seq = 1;
		int n = DFS(m, p, seq); // sequence-value starts from 1, ie.  [0,0]=1
		show("DFS result", m);
		return n;
	}
	
	public int DFS(int [][] m, Coordinate p, int seq) {
///////////////////////////////////////////////////////////////////
/// 1) 여기에 DFS 코드를 완성하시오.
//		int index = seq;
//		boolean visited[index] = true;
//		for (int i=0; i<vertices.size();i++) {
//			if (adjacentMatrix[index][i]==1 && !visited[i]) {
//				DFS(m, p, seq);
//			}
//		}




///////////////////////////////////////////////////////////////////
		return seq;
	}
	
	
	public void BFS(int [][] in) {
		int [][] m = deepCopy(in);
		Coordinate p = new Coordinate(start.x,start.y);
		boolean[][] isVisited = new boolean[size][size];
		Deque<Coordinate> Q = new ArrayDeque<>();
		Q.add(p);
		int seq = 1;

		while(Q.peek()!=null) {
///////////////////////////////////////////////////////////////////
/// 2) 여기에 BFS 코드를 완성하시오.
		m[start.x][start.y] = 1;
		isVisited[start.x][start.y] = true;
		if(seq==1) seq =2;
		p = Q.poll();
		
		HashSet<Coordinate> a = adjacent(p,m);
		for(Coordinate t : a) {
			if(isVisited[t.x][t.y]!=true) {
				m[t.x][t.y] = seq;
				Q.add(new Coordinate(t.x, t.y));
				isVisited[t.x][t.y] = true;
				seq++;
			}

		}	
///////////////////////////////////////////////////////////////////
		}
		show("BFS result", m);
	}

	public void Dijkstra(int [][] in) {
		int [][] m = deepCopy(in);
		Coordinate p = new Coordinate(start.x,start.y);
		boolean[][] isVisited = new boolean[size][size];
		Deque<Coordinate> Q = new ArrayDeque<>();
		int[] distance = new int[size*size];
		Arrays.fill(distance, 9999);
		Q.add(p);
		int seq = 1;
		int counter = 1;
///////////////////////////////////////////////////////////////////
/// 3) 여기에 Dijkstra 코드를 완성하시오.
		distance[1] = 1;
		while(Q.peek()!=null) {
			m[start.x][start.y] = 1;
			isVisited[start.x][start.y] = true;
			if(seq==1) seq =2;
			p = Q.poll();
			
			HashSet<Coordinate> a = adjacent(p,m);
			for(Coordinate t : a) {
				if(isVisited[t.x][t.y]!=true) {
					if(distance[counter]>(distance[seq]+m[t.x][t.y])) {
						distance[counter] = (distance[seq]+m[t.x][t.y]);
						m[t.x][t.y] = distance[counter];
					}
					m[t.x][t.y] = seq;
					Q.add(new Coordinate(t.x, t.y));
					isVisited[t.x][t.y] = true;
					seq++;
				}

			}	

		}
///////////////////////////////////////////////////////////////////
		
		show("Dijkstra result", m);
	}

	public void AStar(int [][] in) {
		int [][] m = deepCopy(in);
		Coordinate p = new Coordinate(start.x,start.y);
		int[] distance = new int[size*size];
		boolean[][] isVisited = new boolean[size][size];
		Arrays.fill(distance, 9999);
		Deque<Coordinate> Q = new ArrayDeque<>();
		distance[1] = 1;
		int seq = 1;
		int counter = 1;
///////////////////////////////////////////////////////////////////
/// 4) 여기에 A* 코드를 완성하시오.
		distance[1] = 1;
		while(Q.peek()!=null) {
			m[start.x][start.y] = 1;
			isVisited[start.x][start.y] = true;
			if(seq==1) seq =2;
			p = Q.poll();
			
			HashSet<Coordinate> a = adjacent(p,m);
			for(Coordinate t : a) {
				if(isVisited[t.x][t.y]!=true) {
					if(distance[counter]>(distance[seq]+m[t.x][t.y])) {
						distance[counter] = (distance[seq]+m[t.x][t.y]);
						m[t.x][t.y] = distance[counter];
					}
					m[t.x][t.y] = seq;
					Q.add(new Coordinate(t.x, t.y));
					isVisited[t.x][t.y] = true;
					seq++;
				}

			}	

		}




///////////////////////////////////////////////////////////////////

		show("Dijkstra + A* result", m);
	}


	private HashSet<Coordinate> adjacent(Coordinate u, int [][] maze) {  // can filter 1-boundary condition, 2-not the wall(-1)
		HashSet<Coordinate> retSet = new HashSet<>();
		if (u.x-1>=0 && maze[u.x-1][u.y]!=-1) retSet.add(new Coordinate(u.x-1, u.y));
		if (u.x+1<size && maze[u.x+1][u.y]!=-1) retSet.add(new Coordinate(u.x+1, u.y));
		if (u.y-1>=0 && maze[u.x][u.y-1]!=-1) retSet.add(new Coordinate(u.x, u.y-1));
		if (u.y+1<size && maze[u.x][u.y+1]!=-1) retSet.add(new Coordinate(u.x, u.y+1));		
		return retSet;
	}
	
	private int calcHVal(Coordinate c) {
		double temp = Math.sqrt((destin.x-c.x)*(destin.x-c.x)+(destin.y-c.y)*(destin.y-c.y));
		return (int)temp;
	}
	
	private void show(String s, int [][] m) {
		System.out.println("\n [ "+s+" ]");
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				System.out.printf("%3d",m[i][j]);
			}
			System.out.println();
		}
	}

	private int[][] deepCopy(int[][] m) {
		int [][] ret = new int[size][size];
		for (int i=0;i<size;i++)
			for (int j=0;j<size;j++)
				ret[i][j]=m[i][j];
		return ret;
	}

	public static void main(String[] args) {
		int [][] input = { {0,-1,0,0,0,0,0,-1,0,-1},
		           		   {0,-1,0,-1,-1,-1,0,-1,0,0},
		                   {0,0,0,0,0,0,0,0,0,-1},
		                   {-1,0,-1,0,-1,0,-1,-1,0,0},
		                   {-1,0,-1,0,-1,0,0,-1,-1,0},
		                   {-1,0,0,0,0,0,0,0,0,0},
		                   {0,0,-1,0,0,-1,-1,0,-1,-1},
		                   {0,-1,-1,0,0,0,0,0,0,-1},
		                   {0,-1,0,0,-1,0,0,-1,0,0},
		                   {0,0,-1,0,0,0,-1,-1,0,0} };
		
		int size  = input.length;
	
		Maze60181675  me = new Maze60181675(size);
//		me.DFS(input);
		me.BFS(input);
		me.Dijkstra(input);
//		me.AStar(input);

	}

}