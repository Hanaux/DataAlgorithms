package Data_0409;

public class MyArrayList1 {
	String [] array;
	int arrSize;
	int numofData;
	
	public MyArrayList1(int initSize) {
		array = new String[arrSize];
		arrSize=initSize;
		numofData=0;
	}
	
	public String get(int index) { //array [index] return
		return array[index];
	}
	public void set(int index, String data) { //index�� data�� ���� ����.
		array[index]=data;
	}
	public void addFirst(String data) {
		add(0,data);
	}
	public void addLast(String data) { // ������ 
		add(numofData,data);
	}
	
	public void add(int index, String data) { // data�� add�ϴ� �޼���
		if(numofData>=arrSize) { //arrSize ���� numOfData�� ���ų� Ŀ����
			String [] bigArray = new String[arrSize*2];
			for(int i=0; i<arrSize;i++) {
				bigArray[i]=array[i]; // arrayũ�� ����.
			}
			arrSize *=2;
			array = bigArray;
		} 
		for(int j=numofData-1;j>=index; j--) { 
			array[j+1]=array[j];
		}
		array[index]=data;
		numofData++;
	}
	
	public String remove(int index) { //����. int index�� �ִ� ���� �����ϰ� index �� �ڿ� �ִ� array���� ������ ����
		if(index<0)
			return null;
		String retVal = array[index];
		for(int i=index+1; i<numofData;i++)
			array[i-1]=array[i];
		numofData--;
		return retVal;
	}

	public int remove(String data) { //String���� data�� ������ �� indexOf�� ���� ���� index�� ������ �� �޼��� ����
		int index = indexOf(data);
		remove(index);
		return index;
	}

	public int indexOf(String data) { // String���� data�� ������, for�� ������ �ش� ���� ����ִ� index�� return.
		for(int i=0; i<numofData;i++) 
			if(array[i]==data)
				return i;
		return 0;
	}

	int sizeOf() { //array �� data�� ũ��. arrSize�� �ٸ��� ����.
		return numofData;
	}
	
	public int arrSize() { // array ������. 
		return arrSize;
	}
	
	public void sort() { //sort�ؼ� �������� ����.
		for(int i=numofData-1;i>0;i--)
			for(int j=0;j<i;j++) {
				if(array[j].compareTo(array[j+1])>0) {
					String temp=array[j];
					array[j]=array[j+1];
					array[j+1]=temp;
				}
			}
	}
	public String toString() { //array�� String �������� �̾ ������ �� return
		String retVal="";
		for(int i=0; i<numofData;i++) {
			retVal=retVal+"/"+array[i];
		}
		return retVal;
	}
	
	public static void main(String[] args) {
		MyArrayList1 list = new MyArrayList1(3); //initSize�� ���� MayArrayList1 ����
		
		list.add(list.sizeOf(), "lee");
		list.add(list.sizeOf(), "kim");
		list.add(list.sizeOf(), "park");
		System.out.println(list.toString());
		System.out.println("Current Max. Size :" + list.arrSize());
		list.remove("park");
		System.out.println(list.toString());
		list.add(list.sizeOf(), "dsf");
		list.get(5);
	}

	

	

	

}
