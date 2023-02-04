import java.util.Arrays;

public class Permutation {

	char[] data; //�Ͻ��� �Ű�����
	int numberOfPatterns=0; // �Ͻ��� �Ű�����
	
	public Permutation(char [] input) {
		data=input;
	}
	
	public void permIteration() {
		int size = data.length;
		numberOfPatterns=0;
		for (int i0=0;i0<size;i0++) {
			swapData(0,i0);
			for (int i1=1;i1<size;i1++) {
				swapData(1,i1);
				for (int i2=2;i2<size;i2++) {
					swapData(2,i2);
					
					numberOfPatterns++; //�۷ι� ���� ����
					System.out.println(numberOfPatterns+" : "+toString()); // toString method�� ���� String ������ res�� �迭�� ���� ���
					swapData(3,4);
					numberOfPatterns++;
					System.out.println(numberOfPatterns+" : "+toString());
					
					swapData(3,4); // �ٲۻ��¿��� �ٽ� ���� for���� ���� �ߺ� �߻� ���ڸ��� ��ġ���Ѿ��� �� �ڿ� �����ϴ�
					swapData(2,i2); // method �� swapData�� ��� ���� ���� ����
				}
				swapData(1,i1); //�ٲ۰� ����Ʈ �ѵڿ��� ����ġ
			}
			swapData(0,i0); // swapData�� �̿��� ������� ��ġ�ϰ� ��
		}
	}

	public void permRecursion(char[] input, String res) {
		if(input.length==1) { //���� copyOfRange���� ������ �迭�� 1�� ���� ��, ��, �ε��� 1�� ���� array�� ����Ǿ��� ��
			System.out.println(numberOfPatterns+" "+res+input[0]); //res�� input[0] �߰�
			numberOfPatterns++;
		}
		for (int i=0;i<input.length;i++) {
			swapData(input,0,i);
			res+=input[0]; //ù �� ����
			permRecursion(Arrays.copyOfRange(input, 1, input.length), res); //input array���� index 1���� input length �������� �迭 ���� 
			res = res.substring(0,res.length()-1); //index 1���� res length-1�� �������� res�� ����
		}
	}
	public void permRecursion() {
		permRecursion(this.data,"");
	}
	private void swapData(int level, int index) { //�� �� Int �ٲٴ� method
		if(level!=index) { //data array�� �Ͻ���, level, index�� �������
			char temp = data[level];
			data[level]=data[index];
			data[index]=temp;
		}
	}
	private void swapData(char[] data, int level, int index) { //�ΰ��� int ���� �޾� �ش� index ������ ��ȯ
		if(level!=index) {
			char temp = data[level];
			data[level]=data[index];
			data[index]=temp;
		}
	}
	public String toString() {
		String res="";
		for (int i=0;i<data.length;i++) //data array�� String res�� ����
			res+=data[i];
		return res;
	} 
	public static void main(String[] args) {
		char data[] = {'a','b','c'};
		Permutation p = new Permutation(data);

//		p.permIteration();
		p.permRecursion();
	}
}
