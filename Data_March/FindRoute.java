
public class FindRoute {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] map = {	{10,7,2,3},
				   		{8,3,1,18},
				   		{4,4,13,9},
				   		{8,1,4,7} }; 
	System.out.println(sum(map, 3, 3)); 
	
}
	public static int sum(int[][] map, int x, int y) {
	if (x == 0 && y == 0)
		return map[x][y];
	else if (x == 0)
		return sum(map, x, y - 1) + map[x][y];
	else if (y == 0) return sum(map, x - 1, y) + map[x][y];
	else
		return max(sum(map, x - 1, y), sum(map, x, y - 1)) + map[x][y]; 
	} 

	public static int max(int n1, int n2) {
		return (n1 > n2) ? n1 : n2; 
	}

}
