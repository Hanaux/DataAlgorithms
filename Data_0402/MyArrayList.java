package Data_0402;

public class MyArrayList {
	int initSize = 3;
	String [] array;
	int arrSize;
	int numOfData;
	
	public MyArrayList() {
		arrSize = initSize;
		array = new String[arrSize];
		numOfData=0;
	}
	
	public String get(int index) {
		if(index<0 || (index>arrSize-1)) {
			System.out.println("OutOfIndex...");
			return null;
			}else {
		return array[index];}
		}
	public void add(int index, String data) {
		if(numOfData>=arrSize) {
			String [] bigArray = new String[arrSize*2];
			for(int i=0;i<arrSize;i++) {
				bigArray[i] = array[i];
			}
			arrSize *= 2;
			array = bigArray;
		}
		for(int j=numOfData-1;j>=index;j--) {
			array[j+1]=array[j];
		}
		array[index] = data;
		numOfData++;
		
	}
	public String remove(int index) {
		
		for(int i=numOfData-2;i>=index;i--) {
			array[i] = array[i+1];
		}
		array[numOfData-1] = null;
		
		numOfData--;
		
		return array[index];
	}
	public int remove(String data) {
		int index = indexOf(data);
		remove(index);
		return index;
	}
	private int indexOf(String data) {
		int result=0;
		for(int i=0;i<array.length;i++) {
			if(array[i]==data) {
				result = i;
			}
		} // for i 
		return result;
	}

	public int sizeOf() {
		return numOfData;
	}
	public int arrSize() {
		return arrSize;
	}
	public String toString() {
		String retVal ="";
		for(int i=0;i<numOfData;i++) {
			retVal=retVal+"/"+array[i];
		}
		return retVal;
	}
	public static void main(String[] args) {
		MyArrayList list = new MyArrayList();
		
		list.add(list.sizeOf(), "lee");
		list.add(list.sizeOf(), "kim");		
		list.add(list.sizeOf(), "park");
//		System.out.println(list.toString());
//		System.out.println("Current Max. Size : "+list.arrSize());
		list.remove("kim");
		System.out.println(list.toString());
		list.add(list.sizeOf(),"Han");
		System.out.println(list.toString());
		list.get(1000);
	}
}
