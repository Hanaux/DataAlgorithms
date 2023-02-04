
public class Hanoi_2 {
	int maxSize;
	String[][] poles;
	int [] curPlates = {0,0,0};
	
	public Hanoi_2(String[] plates) {
		maxSize = plates.length;
		poles = new String[3][maxSize]; // 2���� array
		poles[0]=plates; //ù��° column�� �� �־���
		curPlates[0]=maxSize; // �� ����� ���� ���
	}
	private void hanoi(int i, int j) {
		hanoi(maxSize, i-1, j-1); // overloading �Ű����� 3��¥�� �ٽ� �ҷ��ֱ�.
	}
	public void hanoi(int level, int from, int to) { //recursive routine
		if(level==1) {
			move(level, from, to);
		} else {
			int extra = (3-from-to)%3; //extra ����
			hanoi(level-1, from, extra); 
			showTower(); // �߰� �߰� Ÿ�� ���
			move(level, from, to); // �ű��
			showTower();
			hanoi(level-1, extra, to);
		}
	}
	public void showTower() { // �� Ÿ�� ���� ��Ÿ���ִ� �ż���
		System.out.println(); //���� ����
		for(int i=0; i<3 ; i++) {
			System.out.print("Pole"+(i+1)+": |");
			for(int j=0;j<curPlates[i];j++) {
				System.out.print(poles[i][j]+"|");
			} // for j end
			System.out.println();
		} // for i end
	}
	
	private void move(int level, int from, int to) {
		curPlates[from]--; //�ű� ���� ��������� �˰� �صδ� �Ķ����
		if(curPlates[from]<0) { // ������ ����
			System.out.println("Indexing Error..");
			return;
		}
		poles[to][curPlates[to]]=poles[from][curPlates[from]]; // move�� �����ϴ� ����
		curPlates[to]++;
	}
	
	public static void main(String[] args) {
		String [] plates = {"��û", "�ϴ�", "����", "����", "�ʷ�", "����", "��ȫ", "���"};
		 Hanoi_2 me = new Hanoi_2(plates); // ����
		 
		 me.showTower(); //���̺��� ���� �˷���
		 me.hanoi(1, 2); // pole 1,2,3 �� 1���� 2�� �̵�
		 me.showTower();
	}

}
