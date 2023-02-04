
	
	public class PathFind {
		int[][] matrix; //input data를 matrix로 받음
		int[][] memo;
		int numOfCalls; //호출 반복 체크
		
		public PathFind(int[][] input) {
			matrix=input; //main에서 받는 matrix를 input으로 받아 matrix에 넣음
			numOfCalls=0; //호출 횟수 0 초기와
		}
		
		public int maxPath(int row, int col) { //부를 때 마다 그 위치의 row와 col에 해당되는 값이 이미 저장되어 있는지 체크
			numOfCalls++;
			if(row==0&&col==0) {
				return matrix[row][col]; //matrix[0][0] (계산이 되어있으면) return
			} else if (row==0) {
				return matrix[row][col]+maxPath(row, col-1); //계산이 안되어있을 경우에만 호출
			} else if (col==0) {
				return matrix[row][col]+maxPath(row-1, col);
			} else {
				return matrix[row][col]+Math.max(maxPath(row, col-1), maxPath(row-1, col));
			}
		}
		
		public int numCalls() { //호출 횟수 return
			return numOfCalls;
		}
		
		public void printMatrix(int[][] data, int row, int col) {
			for (int i=0;i<=row;i++) {
				System.out.println();
				for(int j=0;j<=col;j++) {
					System.out.print(data[i][j]+" ");
				}
			}
			System.out.println();
	
		}
		
		public void initMemo() { // memoization을 위한 초기화
			numOfCalls=0;
			int n=matrix.length;
			memo=new int[n][n];
		}
		
		public int maxPath2(int row, int col) {
			numOfCalls++;
			
			if(row==0 && col==0) {
				if(memo[row][col]==0) { // 한번도 계산된 적이 없으면,,,
					memo[row][col] = matrix[row][col];
				}return memo[row][col]; // 0이 아니면 memo에 있던 값 return
			}
			else if(row==0) {
				if(memo[row][col]==0) { //한번도 계산된 적이 없으면,,,
					memo[row][col] = matrix[row][col]+maxPath2(row, col-1); //호출 
				} return memo[row][col]; //항상 memo[row][col]을 return
			}
			else if (col==0) {
				if(memo[row][col]==0) {
					memo[row][col] = matrix[row][col]+maxPath2(row-1, col);
				} return memo[row][col];
			}
			else {
				if (memo[row][col]==0) { //matrix + 밑 Math.max의 값을 memo에 넣어주는데, 값이 없으면 한번 호출
					memo[row][col] = matrix[row][col]+Math.max(maxPath2(row, col-1), maxPath2(row-1, col));
				} return memo[row][col]; //그렇지 않으면 저장된 값을 return
			}
		}

	
	
	public static void main(String[] args) {
		int dim = 6;
		int [][] matrix = {	{ 6,-7,12,-5, 2, 8},
		   					{ 0,-3,11,18,-1, 6},
		   					{ 0, 0,17,-3, 5,-11},
		   					{ 0, 0, 0,-2,13,-4},
		   					{ 0, 0, 0, 0,-9,10},
		   					{ 0, 0, 0, 0, 0, 5}};
		
		PathFind pf = new PathFind(matrix);
		pf.maxPath(5, 5);
		//System.out.println(pf.maxPath(dim-1, dim-1)+"("+pf.numCalls()+")");
		//System.out.println(pf.pathIteration(dim-1, dim-1));
		//pf.initMemo();
//		System.out.println(pf.maxPath2(dim-1, dim-1)+"("+pf.numCalls()+")");
		}	
	}


