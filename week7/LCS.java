package week7;

public class LCS {
	
	public int recursion(String arrA, String arrB) {
		if(arrA.length()==0 || arrB.length()==0)
			return 0;
		else if(arrA.charAt(0)==arrB.charAt(0)) {
			return 1+recursion(arrA.substring(1, arrA.length()), arrB.substring(1, arrB.length()));
		}else {
			return Math.max(recursion(arrA.substring(1, arrA.length()), arrB.substring(0, arrB.length()))
					, recursion(arrA.substring(0, arrA.length()), arrB.substring(1, arrB.length())));
		}
	}
	
	public int dynamic(String arrA, String arrB) {
		int[][] dynTable = new int[arrA.length()+1][arrB.length()+1];
		for(int i=1;i<dynTable.length;i++)
			for(int j=1;j<dynTable[i].length;j++) {
				if(arrA.charAt(i-1)==arrB.charAt(j-1))
					dynTable[i][j] = dynTable[i-1][j-1]+1;
				else
					dynTable[i][j] = Math.max(dynTable[i-1][j], dynTable[i][j-1]);
			}
		return dynTable[arrA.length()][arrB.length()];
	}
	
	
	public static void main(String[] args) {
		String arrA = "abcdabcd";
		String arrB = "bdbdf";
		
		LCS lcs = new LCS();
		System.out.println(lcs.recursion(arrA, arrB));
		System.out.println(lcs.dynamic(arrA, arrB));
	}

}
