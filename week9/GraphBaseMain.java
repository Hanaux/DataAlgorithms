package week9;

public class GraphBaseMain {
	public static void main(String[] args) {
		int maxNoVertex = 10;
		String [] vertices = { "Seoul", "Busan", "Ulsan", "Jeju", "Incheon", "Daejeon", "Daegu", "Kwangju"};
//		int [][] graphEdges = { {1,2}, {1,3}, {1,4}, {2,3}, 
//				                {3,5}, {1,6}, {5,6}, {4,6} };
		GraphInMatrix myGM = new GraphInMatrix(maxNoVertex);

		myGM.createGraph("TestGraph in Matrix");
		myGM.showGraph();

//		for (int i = 0; i<graphEdges.length; i++)
//			myGM.insertEdge(vertices[graphEdges[i][0]-1],vertices[graphEdges[i][1]-1]);
//		myGM.showGraph();
		
//		myGM.deleteVertex("¿µÈñ");
//		myGM.showGraph();
		
		myGM.insertEdge("Seoul", "Busan");
		myGM.insertEdge("Seoul", "Jeju");
		myGM.insertEdge("Busan", "Jeju");
		myGM.insertEdge("Busan", "Daejeon");
		myGM.insertEdge("Ulsan", "Seoul");
		myGM.insertEdge("Incheon", "Busan");
		myGM.insertEdge("Incheon", "Ulsan");
		myGM.insertEdge("Incheon", "Daegu");
		myGM.insertEdge("Incheon", "Jeju");
		myGM.insertEdge("Daejeon", "Incheon");
		myGM.insertEdge("Daejeon", "Kwanju");
		myGM.insertEdge("Ulsan", "Daegu");
		myGM.showGraph();

		
		System.out.println("\nAdjacent Set of "+"Seoul");
		System.out.println(myGM.adjacent("Seoul"));
		
		myGM.BFS(vertices[0]);
		myGM.DFS(vertices[0]);	
		
	///////////////////////////////////////////////////////////////////
		System.out.println("\n++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

		GraphInList myGL = new GraphInList(maxNoVertex);

		myGL.createGraph("TestGraph in List");
		myGL.showGraph();
		
//		for (int i = 0; i<graphEdges.length; i++)
//			myGL.insertEdge(vertices[graphEdges[i][0]-1],vertices[graphEdges[i][1]-1]);
//		myGL.showGraph();
		
//		myGL.deleteVertex("¿µÈñ");
//		myGL.showGraph();
		
		myGL.insertEdge("Seoul", "Busan");
		myGL.insertEdge("Seoul", "Jeju");
		myGL.insertEdge("Busan", "Jeju");
		myGL.insertEdge("Busan", "Daejeon");
		myGL.insertEdge("Ulsan", "Seoul");
		myGL.insertEdge("Incheon", "Busan");
		myGL.insertEdge("Incheon", "Ulsan");
		myGL.insertEdge("Incheon", "Daegu");
		myGL.insertEdge("Incheon", "Jeju");
		myGL.insertEdge("Daejeon", "Incheon");
		myGL.insertEdge("Daejeon", "Kwanju");
		myGL.insertEdge("Ulsan", "Daegu");
		myGL.showGraph();

		
		System.out.println("\nAdjacent Set of "+"Seoul");
		System.out.println(myGL.adjacent("Seoul"));
		
		myGL.BFS(vertices[0]);
		myGL.DFS(vertices[0]);
		
		System.out.println("\n++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

		GraphInArray myGA = new GraphInArray(maxNoVertex);

		myGA.createGraph("TestGraph in Array");
		myGA.showGraph();
		
		myGA.insertEdge("Seoul", "Busan");
		myGA.insertEdge("Seoul", "Jeju");
		myGA.insertEdge("Busan", "Jeju");
		myGA.insertEdge("Busan", "Daejeon");
		myGA.insertEdge("Ulsan", "Seoul");
		myGA.insertEdge("Incheon", "Busan");
		myGA.insertEdge("Incheon", "Ulsan");
		myGA.insertEdge("Incheon", "Daegu");
		myGA.insertEdge("Incheon", "Jeju");
		myGA.insertEdge("Daejeon", "Incheon");
		myGA.insertEdge("Daejeon", "Kwanju");
		myGA.insertEdge("Ulsan", "Daegu");
		myGA.showGraph();

		
		System.out.println("\nAdjacent Set of "+"Seoul");
		System.out.println(myGA.adjacent("Seoul"));
		
		myGA.BFS(vertices[0]);
		myGA.DFS(vertices[0]);

	}
}
