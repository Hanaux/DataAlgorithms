package week6;

public class MatrixChain {

	int nOfMatrix;
	int [] p;
	int count;
	int [][] memo;
	
	public MatrixChain(int[] dimension) {
		p = dimension;
		nOfMatrix=p.length-1;
		memo=new int[nOfMatrix+1][nOfMatrix+1];
	}
	
	void reset() {
		count =0;
		for(int i=0;i<nOfMatrix+1;i++)
			for(int j=0;j<nOfMatrix+1;j++)
				memo[i][j]=-1;
		for(int i=0;i<=nOfMatrix;i++)
			memo[i][i]=0;
	}
	
	int getCount() {
		return count;
	}
	
	int sequentialMult(int i, int j) {
		int retVal;
		if(i==j) return 0;
		else retVal =1;
		for(int k=0;k<=j;k++)
			retVal*=p[k];
		return retVal;
	}
	
	int matrixChain(int i, int j) {
		count++;
		if(i==j) return 0;
		int min=99999999;
		for(int k=i;k<j;k++) {
			int q = matrixChain(i,k)+matrixChain(k+1,j)+p[i-1]*p[k]*p[j];
			if(q<min) min = q;
		}
		return min;
	}
	int matrixChainDP(int i, int j) {
		count++;
		if(memo[i][j]>=0) return memo[i][j];
		int min=99999999;
		for(int k=i;k<j;k++) {
			if(memo[i][k]<0) memo[i][k]=matrixChainDP(i,k);
			if(memo[k+1][j]<0) memo[k+1][j]=matrixChainDP(k+1,j);
			min = Math.min(min, memo[i][k]+memo[k+1][j]+p[i-1]*p[k]*p[j]);
		}
		return min;
	}
	
	public static void main(String[] args) {
		int numOfMatrix=15;
		int[] dimension = {2,3,4,3,5,3,4,5,3,2,4,6,5,4,3,4}; //numOfMatrix+1
		
		MatrixChain mm = new MatrixChain(dimension);
		for(int i=1;i<=numOfMatrix;i++) {
			mm.reset();
			System.out.println("Seq : "+mm.sequentialMult(1, i));
			mm.reset();
			System.out.println("Recursion : "+mm.matrixChain(1, i)+"   Count="+mm.getCount());
			mm.reset();
			System.out.println(" ===> DP : "+mm.matrixChainDP(1, i)+"   Count="+mm.getCount());
		}

	}

}
