
public class RecursionSample {
	
	int [] data;
	public RecursionSample(int[] input) {
		data = input;
	}
	
	public String toString() { // object�� toString�� override
		String res="";
		for(int i=0;i<data.length;i++) {
			res +=(data[i]+", ");
		}
		return res;
	}
	
	public int maxIndexIter() {
		if(data.length<1) { //������ ã�� �ʿ� ��� -1 ����
			return -1;
		}
		int index = 0;
		int max = data[0]; //data[0]�� max�� ����
		int i = 1;
		while(i<data.length) {
			if(data[i]>max) { //data[i] ���� max�� ����  data[i]�� �� ũ�� �� ���� max�� ���� 
			max=data[i];
			index=i;
		}
		i++; //i�� ���� +1
		}
		return index; //array�߿��� ���� ū ���� ���� index�� ��ȯ
	}
	
	public int maxIndexRec(int startIndex) { //index ���� ����
		
		if(startIndex==(data.length-1)) { //data array�� ������ ���� data.length-1 �̰� startIndex�� ������
			return startIndex; //startIndex�� ��ȯ �ϰ� ����
		}
		int tempIndex = maxIndexRec(startIndex+1); //�� start index�� startIndex�� 1�� ���� ���� �־��� ���� return��
		if(data[startIndex]>data[tempIndex]) { //�� index�� data index�� �ְ� ��
			return startIndex; //���簡 �� ũ��, ������index ��ȯ
		}
		else {
			return tempIndex; //startIndex+1�� �� ũ�� �� index ��ȯ
		}
	}
	
	public int[] mysort() { //mySort�� ȣ������ �ʱ⿡ ()�� �����
		int startIndex=0;
		while(startIndex<data.length-1) { 
			int tempIndex=maxIndexRec(startIndex+1); // maxIndexRec�� �ҷ���
			if(data[startIndex]<data[tempIndex]) { //startIndex+1 �� ���� �� ũ��
				swapData(startIndex, tempIndex); // �����Ͱ��� ���� �ٲٱ�
			}
			startIndex++; //�ϳ��� �÷����鼭 ��
		}
		return data;
	}
	
	private void swapData(int level, int index) {
		if(level != index) {
			int temp = data[level];
			data[level] = data[index];
			data[index] = temp;
		}
	}
	
	public int search1(int value) {
		int i =0;
		while(i<data.length) {
			if(data[i]==value) { //value�� data[i]�� ��ġ�ϸ�
				return i; // i ���� ��ȯ. (index ��ȯ)
			}
			i++; // i�� +1
		}
		return -1;
	}
	
	public int search2(int value, int i) { // �� ������ int i �� ���� ���ؼ� ��� ���ϴ� ��
		if(i==data.length) {
			return -1;
		}if(data[i]==value) {
			return i;
		}
		else {
			return search2(value, i+1); // ���� array index�� �Ѱ��ֱ�
		}
	}
	
	public int search3(int value, int start, int end) { //�ε��� ���۰� ���� �޴´�
		
		if(start>end) {
			return -1;
		}
		int mid = (start + end)/2; // ���� ���� mid�� �ִ´�
		if(data[mid]==value) { //mid���� value�� ���ٸ� 
			return mid; //mid return
		} else if(data[mid]<value) { //value���� data[mid]���� ũ�ٸ�, mid ���� �� index�� �����Ƿ�
			return search3(value, start, mid - 1); //mid-1���� end�� �����ؼ� �ٽ� search3 method�� �ִ´�.
		}
		else { //value���� data[mid]���� �۴ٸ�, mid ���� �� index�� �����Ƿ�
			return search3(value, mid+1, end); //mid+1 index���� ������ �����ؼ� �ٽ� ������.
		}
	}
	
	public static void main(String[] args) {
		int[] input = {12,23,17,32,16,37,25,19,3,22};
		RecursionSample me = new RecursionSample(input);
		System.out.println(me.toString()); //toString ����, input�迭 �״�� ���
		
		System.out.println(me.maxIndexIter()); // max�� ã�� Iteration ver
		System.out.println(me.maxIndexRec(0)); // max�� ã�� Recursion ver
		
		int val =25;
		System.out.println("Loc. of"+val+" : " + me.search1(25)); //Ư�� �� ã�� Iteration ver
		System.out.println("Loc. of"+val+" : " + me.search2(25,0)); //Ư�� �� ã�� Recursion ver
		
		me.mysort();
		System.out.println(me.toString());
		
		System.out.println("Loc. of"+val+" : " + me.search3(25,0,9));

	}
	
}
