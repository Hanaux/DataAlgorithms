package Data_0409;
public class MyClass implements Comparable<MyClass>{
	int idNumber;
	String name;
	public MyClass(int i, String s) {
		idNumber=i;
		name=s;
	}
//	public int compareTo(MyClass that) {
//		if(this.idNumber>that.idNumber)
//			return 1;
//		else if(this.idNumber<that.idNumber)
//			return -1;
//		else
//			return 0;
//	}
	public int compareTo(MyClass that) {		// 대조해서 compareTo 실행 후 값 return 
		return this.name.compareTo(that.name);	// 위 매서드와 동일한데, 다른 방법임.
	}											
	public boolean equals(MyClass that) {		
		return this.name.equals(that.name);		
	}
	public String toString() {
		return name+ " ["+idNumber+"] ";
	}
}
