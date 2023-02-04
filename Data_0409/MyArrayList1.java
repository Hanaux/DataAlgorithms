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
	public void set(int index, String data) { //index에 data를 직접 주입.
		array[index]=data;
	}
	public void addFirst(String data) {
		add(0,data);
	}
	public void addLast(String data) { // 마지막 
		add(numofData,data);
	}
	
	public void add(int index, String data) { // data를 add하는 메서드
		if(numofData>=arrSize) { //arrSize 보다 numOfData가 같거나 커지면
			String [] bigArray = new String[arrSize*2];
			for(int i=0; i<arrSize;i++) {
				bigArray[i]=array[i]; // array크기 증가.
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
	
	public String remove(int index) { //제거. int index에 있는 값을 제거하고 index 값 뒤에 있는 array들을 앞으로 땡김
		if(index<0)
			return null;
		String retVal = array[index];
		for(int i=index+1; i<numofData;i++)
			array[i-1]=array[i];
		numofData--;
		return retVal;
	}

	public int remove(String data) { //String형의 data가 들어왔을 때 indexOf를 통해 얻은 index를 가지고 위 메서드 실행
		int index = indexOf(data);
		remove(index);
		return index;
	}

	public int indexOf(String data) { // String형의 data를 받으면, for문 돌려서 해당 값이 들어있는 index값 return.
		for(int i=0; i<numofData;i++) 
			if(array[i]==data)
				return i;
		return 0;
	}

	int sizeOf() { //array 안 data의 크기. arrSize와 다르니 유의.
		return numofData;
	}
	
	public int arrSize() { // array 사이즈. 
		return arrSize;
	}
	
	public void sort() { //sort해서 오름차순 정렬.
		for(int i=numofData-1;i>0;i--)
			for(int j=0;j<i;j++) {
				if(array[j].compareTo(array[j+1])>0) {
					String temp=array[j];
					array[j]=array[j+1];
					array[j+1]=temp;
				}
			}
	}
	public String toString() { //array를 String 형식으로 이어서 저장한 뒤 return
		String retVal="";
		for(int i=0; i<numofData;i++) {
			retVal=retVal+"/"+array[i];
		}
		return retVal;
	}
	
	public static void main(String[] args) {
		MyArrayList1 list = new MyArrayList1(3); //initSize와 같이 MayArrayList1 실행
		
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
