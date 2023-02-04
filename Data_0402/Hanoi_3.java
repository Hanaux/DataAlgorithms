package Data_0402;

public class Hanoi_3 {
	int maxSize;
	MyStack[] poles; //MyStack�̶�� Ŭ���� array ����
	 
	
	public Hanoi_3(String[] plates) { //���� ������ list�� ����
		maxSize = plates.length; //maxSize�� �������ְ�, 
		poles = new MyStack[3]; // 3���� stack�� ����
		
		for (int i=0;i<3;i++) {
			poles[i] = new MyStack(); // �ٽ� �˷��ִ� ����
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
		String[] plates = {"����", "��Ȳ", "���", "�ʷ�", "�Ķ�", "��û", "����", "����"};
		Hanoi_3 me = new Hanoi_3(plates);
		
		me.showTower();
		me.hanoi(1, 2);
		me.showTower();
	}
	
	private class MyStack{
		String[] stack = new String[maxSize+1]; // array �ϳ� �����
		int stackPointer=0; //������ ���� �ִ���
		
		private void push(String s) { //stackPoint�� maxSize�� ���� �ʾҴٸ�, ...
			if(stackPointer==maxSize) {
				System.out.println("Stack Full...");
				return;
			}
			stack[stackPointer]=s; //...s�� �־���
			stackPointer++; // stackPointer�� �ϳ� ����
		}
		
		private String pop() {
			if(stackPointer==0) { //stackPointer�� 0�̸� �̹� ���°�
				System.out.println("Stack Empty...");
				return null;
			}
			stackPointer--;
			return stack[stackPointer]; //stackPointer ���� �ϳ� ���� �� return
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
