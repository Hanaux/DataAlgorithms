package Data_0402;

public class Hanoi_3 {
	int maxSize;
	MyStack[] poles; //MyStack이라는 클래스 array 생성
	 
	
	public Hanoi_3(String[] plates) { //색이 적혀진 list를 받음
		maxSize = plates.length; //maxSize를 지정해주고, 
		poles = new MyStack[3]; // 3개의 stack을 생성
		
		for (int i=0;i<3;i++) {
			poles[i] = new MyStack(); // 다시 알려주는 거임
		}
		for (int i=0;i<maxSize;i++) {
			poles[0].push(plates[i]);
		}
	}
	
	private void hanoi(int i, int j) {
		hanoi(maxSize, i-1, j-1);
	}
	
	public void hanoi(int level, int from, int to) {
		if(level ==1) {
			move(level, from, to);
		} else {
			int extra = (3-from-to)%3;
			hanoi(level-1, from, extra);
			showTower();
			move(level, from, to);
			showTower();
			hanoi(level-1, extra, to);
		}
	}
	
	public void showTower() {
		System.out.println();
		for(int i=0;i<3;i++) {
			System.out.println("Pole "+(i+1)+": "+poles[i].toString());
		}
	}
	
	private void move(int level, int from, int to) {
		poles[to].push(poles[from].pop());
	}
	
	public static void main(String[] args) {
		String[] plates = {"빨강", "주황", "노랑", "초록", "파랑", "군청", "보라", "검정"};
		Hanoi_3 me = new Hanoi_3(plates);
		
		me.showTower();
		me.hanoi(1, 2);
		me.showTower();
	}
	
	private class MyStack{
		String[] stack = new String[maxSize+1]; // array 하나 만들기
		int stackPointer=0; //어디까지 들어와 있는지
		
		private void push(String s) { //stackPoint가 maxSize를 넘지 않았다면, ...
			if(stackPointer==maxSize) {
				System.out.println("Stack Full...");
				return;
			}
			stack[stackPointer]=s; //...s를 넣어줌
			stackPointer++; // stackPointer를 하나 증가
		}
		
		private String pop() {
			if(stackPointer==0) { //stackPointer가 0이면 이미 없는거
				System.out.println("Stack Empty...");
				return null;
			}
			stackPointer--;
			return stack[stackPointer]; //stackPointer 값을 하나 감소 후 return
		}
		
		public String toString() {
			String ret = "|";
			for(int i=0; i<stackPointer; i++) {
				ret += stack[i];
			}
			return ret;
		}
	}
	

}
