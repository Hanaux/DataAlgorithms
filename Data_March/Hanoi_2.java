
public class Hanoi_2 {
	int maxSize;
	String[][] poles;
	int [] curPlates = {0,0,0};
	
	public Hanoi_2(String[] plates) {
		maxSize = plates.length;
		poles = new String[3][maxSize]; // 2차원 array
		poles[0]=plates; //첫번째 column에 다 넣어줌
		curPlates[0]=maxSize; // 위 결과에 따른 결과
	}
	private void hanoi(int i, int j) {
		hanoi(maxSize, i-1, j-1); // overloading 매개변수 3개짜리 다시 불러주기.
	}
	public void hanoi(int level, int from, int to) { //recursive routine
		if(level==1) {
			move(level, from, to);
		} else {
			int extra = (3-from-to)%3; //extra 산출
			hanoi(level-1, from, extra); 
			showTower(); // 중간 중간 타워 모습
			move(level, from, to); // 옮기기
			showTower();
			hanoi(level-1, extra, to);
		}
	}
	public void showTower() { // 현 타워 상태 나타내주는 매서드
		System.out.println(); //한줄 띄우기
		for(int i=0; i<3 ; i++) {
			System.out.print("Pole"+(i+1)+": |");
			for(int j=0;j<curPlates[i];j++) {
				System.out.print(poles[i][j]+"|");
			} // for j end
			System.out.println();
		} // for i end
	}
	
	private void move(int level, int from, int to) {
		curPlates[from]--; //옮길 값이 어딨는지를 알게 해두는 파라메터
		if(curPlates[from]<0) { // 에러문 산출
			System.out.println("Indexing Error..");
			return;
		}
		poles[to][curPlates[to]]=poles[from][curPlates[from]]; // move를 실행하는 문장
		curPlates[to]++;
	}
	
	public static void main(String[] args) {
		String [] plates = {"군청", "하늘", "연두", "보라", "초록", "빨강", "주홍", "노랑"};
		 Hanoi_2 me = new Hanoi_2(plates); // 생성
		 
		 me.showTower(); //테이블의 상태 알려줌
		 me.hanoi(1, 2); // pole 1,2,3 중 1에서 2로 이동
		 me.showTower();
	}

}
