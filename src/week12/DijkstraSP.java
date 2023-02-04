package week12;

import java.util.Arrays;
import java.util.HashSet;

public class DijkstraSP extends WGraphInList{
		int [] d;
		int r = -1;
		HashSet<String>S, V;
		
		String[] prev;
		
		public DijkstraSP(int max) {
			super(max);
		}
		public void init(String start) {
			d = new int[maxNumber];
			S = new HashSet<>();
			V = new HashSet<>();
			   
			prev = new String[maxNumber];
			
			for(String s : vertices)
				V.add(s);
			r = vertices.indexOf(start);
			Arrays.fill(d, 9999);
			d[r] = 0;
		}
		
		public void shortestPath() {
			while(S.size()<maxNumber) {
				String u = extractMin(diff(V,S));
				S.add(u);
				System.out.println(">>> "+u+" is selected.");
				for(String v : adjacent(u)) {
					HashSet<String>temp = diff(V,S);
					int wuv = getWeight(u, v);
					int dv = d[vertices.indexOf(v)];
					int du = d[vertices.indexOf(u)];
					
					if(temp.contains(v) && (du+wuv)<dv) {
						d[vertices.indexOf(v)] = du+wuv;
						prev[vertices.indexOf(v)] = u;
					}
				}
			}
			for(int i=0;i<maxNumber;i++)
				System.out.print(vertices.get(i)+"("+d[i]+")");
			System.out.println();
		}
		
		public void showShortestPath() {
			for(int i=0;i<maxNumber;i++) {
				System.out.println(prev[i]+" ==> "+vertices.get(i)+"("+d[i]+")");
			}
		}
		
		private int getWeight(String u, String v) {
			return getEdge(u, v).weight;
		}
		
		private HashSet<String> diff(HashSet<String> s1, HashSet<String> s2){
			HashSet<String> result = s1;
			for(String s : s2)
				result.remove(s);
			return result;
		}
		
		private String extractMin(HashSet<String> diff) {
			String minVertex = null;
			int min = 9999;;
			for(String s : diff) {
				if(d[vertices.indexOf(s)]<min) {
					minVertex = s;
					min = d[vertices.indexOf(s)];
				} 
			}
			return minVertex;
		}
		public static void main(String[] args) {
			String[] vertices = {"서울", "인천", "대전", "대구", "광주", "부산", "울산"	};
			int[][] graphEdges = {{0,1,11}, {0,2,8}, {0,3,9}, {1,3,13}, 
					{1,6,8}, {2,4,10}, {3,4,5}, {3,5,12}, {5,6,7}};
			
			DijkstraSP myG = new DijkstraSP(vertices.length);
			
			myG.createGraph("DijkstraSP - Test Graph");
			
			for(int i=0;i<graphEdges.length;i++)
				myG.insertEdge(vertices[graphEdges[i][0]], vertices[graphEdges[i][1]], graphEdges[i][2]);
			myG.showGraph();
			
			System.out.println("\nDijstraSP Algorithm starts from "+"서울");
			myG.init("서울");
			myG.shortestPath();
			myG.showShortestPath();
		}
	}
