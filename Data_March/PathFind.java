
	
	public class PathFind {
		int[][] matrix; //input data�� matrix�� ����
		int[][] memo;
		int numOfCalls; //ȣ�� �ݺ� üũ
		
		public PathFind(int[][] input) {
			matrix=input; //main���� �޴� matrix�� input���� �޾� matrix�� ����
			numOfCalls=0; //ȣ�� Ƚ�� 0 �ʱ��
		}
		
		public int maxPath(int row, int col) { //�θ� �� ���� �� ��ġ�� row�� col�� �ش�Ǵ� ���� �̹� ����Ǿ� �ִ��� üũ
			numOfCalls++;
			if(row==0&&col==0) {
				return matrix[row][col]; //matrix[0][0] (����� �Ǿ�������) return
			} else if (row==0) {
				return matrix[row][col]+maxPath(row, col-1); //����� �ȵǾ����� ��쿡�� ȣ��
			} else if (col==0) {
				return matrix[row][col]+maxPath(row-1, col);
			} else {
				return matrix[row][col]+Math.max(maxPath(row, col-1), maxPath(row-1, col));
			}
		}
		
		public int numCalls() { //ȣ�� Ƚ�� return
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
		
		public void initMemo() { // memoization�� ���� �ʱ�ȭ
			numOfCalls=0;
			int n=matrix.length;
			memo=new int[n][n];
		}
		
		public int maxPath2(int row, int col) {
			numOfCalls++;
			
			if(row==0 && col==0) {
				if(memo[row][col]==0) { // �ѹ��� ���� ���� ������,,,
					memo[row][col] = matrix[row][col];
				}return memo[row][col]; // 0�� �ƴϸ� memo�� �ִ� �� return
			}
			else if(row==0) {
				if(memo[row][col]==0) { //�ѹ��� ���� ���� ������,,,
					memo[row][col] = matrix[row][col]+maxPath2(row, col-1); //ȣ�� 
				} return memo[row][col]; //�׻� memo[row][col]�� return
			}
			else if (col==0) {
				if(memo[row][col]==0) {
					memo[row][col] = matrix[row][col]+maxPath2(row-1, col);
				} return memo[row][col];
			}
			else {
				if (memo[row][col]==0) { //matrix + �� Math.max�� ���� memo�� �־��ִµ�, ���� ������ �ѹ� ȣ��
					memo[row][col] = matrix[row][col]+Math.max(maxPath2(row, col-1), maxPath2(row-1, col));
				} return memo[row][col]; //�׷��� ������ ����� ���� return
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


