package Data_0409;
public class MyArrayList3<T> { //generic type. String이던 Integer던 다 받을 수 있게
	T[] array; // type에 해당하는 부분을 모두 T로 바꿈
	int arrSize;
	int numofData;
	
	public MyArrayList3(int initSize) {
		arrSize=initSize;
		array = (T[])new Object[arrSize]; //new 할 때 메모리 크기가 필요한데, T가 무슨 타입인지 몰라 할당해줄 수 없음 
		numofData=0; //그래서 Object로 바꿈 그 후 runtime 때 T[]로 형변환
	
	}
	
	public T get(int index) {
		return array[index];
	}
	public void set(int index, T data) {
		array[index]=data;
	}
	public void addFirst(T data) {
		add(0,data);
	}
	public void addLast(T data) {
		add(numofData,data);
	}
	
	public void add(int index, T data) {
		if(numofData>=arrSize) {
			T [] bigArray = (T[])new Object[arrSize*2];
			for(int i=0; i<arrSize;i++) {
				bigArray[i]=array[i];
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
	
	public T remove(int index) {
		if(index<0)
			return null;
		T retVal = array[index];
		for(int i=index+1; i<numofData;i++)
			array[i-1]=array[i];
		numofData--;
		return retVal;
	}

	public int remove(T data) {
		int index = indexOf(data);
		remove(index);
		return index;
	}

	public int indexOf(T data) {
		for(int i=0; i<numofData;i++) 
			if(compare(array[i],data)==0) //Equals는 어떤 형태도 다 적용은 가능함
				return i;		
		return -1;
	}

	public int sizeOf() {	
		return numofData;
	}
	
	public int arrSize() {
		return arrSize;
	}
	
	public int compare(T o1, T o2) {
		if(o1 instanceof Comparable && o2 instanceof Comparable) { //Comparable을 implement/ 어떤타입이라도 비교 가능하게 해주는거.
			Comparable c1 = (Comparable) o1; // 형변환
			Comparable c2 = (Comparable) o2;
			return c1.compareTo(c2);
		} else {
			return -1;
		}}
	
	public void sort() {
		for(int i=numofData-1;i>0;i--)
			for(int j=0;j<i;j++) {
				if(compare(array[j],array[j+1])>0) { // object class에는 compareTo가 없음
					T temp=array[j];
					array[j]=array[j+1];
					array[j+1]=temp;
				}
			}}
	public String toString() {
		String retVal="";
		for(int i=0; i<numofData;i++) {
			retVal=retVal+"/"+array[i];
		}return retVal;	}

	public static void main(String[] args) {
		MyArrayList3<MyClass> list = new MyArrayList3<>(3);
		int idNum=0;
		list.addLast(new MyClass(idNum++, "lee"));
		list.addLast(new MyClass(idNum++, "kim"));
		list.addLast(new MyClass(idNum++, "park"));
		list.addLast(new MyClass(idNum++, "choi"));
		list.addLast(new MyClass(idNum++, "jung"));
		list.addLast(new MyClass(idNum++, "song"));
		System.out.println(list.toString());
		System.out.println("Current Max. Size :" + list.arrSize());
		
	}

	

	

	

}
