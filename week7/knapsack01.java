package week7;

public class knapsack01 {

	static int[] weight = { 4,2,6,4,2,10};
	static int[] value = {7,10,6,7,5,4};
	

	
	private static int recursion(int capacity, int index) {
		int result = 0;
		
		if(index==value.length)
			return 0;
		int unselected = recursion(capacity, index+1);
		int selected = 0;
		
		if(capacity>=weight[index]) {
			selected = recursion(capacity-weight[index], index+1) + value[index];
		}
		
		result = Math.max(unselected, selected);
		
		return result;
	}
	private static int dynamic(int capacity, int index) {
		int[][] dynTable = new int[value.length+1][capacity+1];
		
		for(int i=0;i<value.length+1;i++)
			for(int j=0;j<capacity+1;j++) {
				if(i==0 || j==0)
					dynTable[i][j]=0;
				else if(weight[i-1]<=j)
					dynTable[i][j] = Math.max(value[i-1]+dynTable[i-1][j-weight[i-1]], dynTable[i-1][j]);
				else
					dynTable[i][j] = dynTable[i-1][j];
			}
		
		return dynTable[value.length][capacity];
	}
	
	public static void main(String[] args) {
		int capacity = 10;
		int index = 0;
		System.out.println(recursion(capacity, index));
		System.out.println(dynamic(capacity, index));
	}
}
