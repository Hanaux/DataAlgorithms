package Data_0409;
public class MyArrayList3<T> { //generic type. String�̴� Integer�� �� ���� �� �ְ�
	T[] array; // type�� �ش��ϴ� �κ��� ��� T�� �ٲ�
	int arrSize;
	int numofData;
	
	public MyArrayList3(int initSize) {
		arrSize=initSize;
		array = (T[])new Object[arrSize]; //new �� �� �޸� ũ�Ⱑ �ʿ��ѵ�, T�� ���� Ÿ������ ���� �Ҵ����� �� ���� 
		numofData=0; //�׷��� Object�� �ٲ� �� �� runtime �� T[]�� ����ȯ
	
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
			if(compare(array[i],data)==0) //Equals�� � ���µ� �� ������ ������
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
		if(o1 instanceof Comparable && o2 instanceof Comparable) { //Comparable�� implement/ �Ÿ���̶� �� �����ϰ� ���ִ°�.
			Comparable c1 = (Comparable) o1; // ����ȯ
			Comparable c2 = (Comparable) o2;
			return c1.compareTo(c2);
		} else {
			return -1;
		}}
	
	public void sort() {
		for(int i=numofData-1;i>0;i--)
			for(int j=0;j<i;j++) {
				if(compare(array[j],array[j+1])>0) { // object class���� compareTo�� ����
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
