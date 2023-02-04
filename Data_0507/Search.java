package Data_0507;

public class Search {
	String[] data;
	int dataSize;
	static int seqCount =0;
	static int binCount=0;
	
	public Search() {
		
	}
	
	public Search(String[] input) { //data와 dataSize 설정
		data=input;
		dataSize=data.length;
	}
	
	public int seqSearch1(String[] input, String key) { //sequence Search1
		int n = input.length;
		int i =0;
		while(i<n && input[i].compareTo(key)!=0) {
			i++;
		}
		if(i<n) {
			return i;
		} else {
			return -1;
		}
	}
	
	public int seqSearch2(String key) { //sequence Search2
		int i =0;
		while(i<dataSize && data[i].compareTo(key)!=0) {
			i++;
		}
		if(i<dataSize) {
			return i;
		} else {
			return -1;
		}
	}
	
	public int seqSearchRecursion(int start, String key) { //seqSearch2를 기반으로 Recursion
		if(start==dataSize) {
			return -1;
		} else if(data[start].compareTo(key)==0) {
			return start;
		} else {
			return seqSearchRecursion(start+1,key);
		}
	}
	
	public void selectionSort() { // sort method
		for (int i=0;i<dataSize;i++) {
			for(int j=i+1;j<dataSize-1;j++) {
				if(data[i].compareTo(data[j])>0) {
					String temp = data[i];
					data[i] = data[j];
					data[j] = temp;
				}
			}
		}
	}
	
	public int seqSearch3(String key) { //sequence Search3
		int i =0;
		while(i<dataSize && data[i].compareTo(key)<0) {
			seqCount++;
			i++;
		}
		if(data[i].compareTo(key)==0) {
			return i;
		} else {
			return -1;
		}
	}
	
	public int seqSearchRecursion2(int start, String key) { // seqSearch3를 바탕으로 Recursion 구현
		if(start==dataSize || data[start].compareTo(key)>0) {
			return -1;
		} else if(data[start].compareTo(key)==0) {
			return start;
		} else {
			return seqSearchRecursion(start+1,key);
		}
	}
	
	public int binarySearchIteration(int start, int end, String key) { // 이진 search Iter version
		while(start<=end) {
			binCount++;
			int middle = (start+end)/2;
			if(key.compareTo(data[middle])==0) {
				return middle;
			} else if(key.compareTo(data[middle])<0) {
				end = middle-1;
			} else {
				start = middle+1;
			}
		}
		return -1;
	}
	
	public int binarySearchRecursion(int start, int end, String key) { // 이진 search Recursive Version. 더 일반적임
		if(start>end) {
			return -1;
		}
		int middle = (start+end)/2;
		if(key.compareTo(data[middle])==0) {
			return middle;
		} else if(key.compareTo(data[middle])<0) {
			return binarySearchRecursion(start, middle-1,key);
		} else {
			return binarySearchRecursion(middle+1, end, key);
		}
	}
	
	
	public static void main(String[] args) {
		String[] input = {"lee", "kim", "park", "han", "choi", "kang", "hwang"};
		
		Search test1 = new Search();
		System.out.println("case 1 : " + test1.seqSearch1(input, "kang"));
		Search test2 = new Search(input);
		System.out.println("case 2 : " + test2.seqSearch2("kang"));
		System.out.println("case 3 : " + test2.seqSearchRecursion(0,"kang"));
		test2.selectionSort();
		System.out.println("case 4 : " + test2.seqSearch3("kang" ));
		System.out.println("case 5 : " + test2.seqSearchRecursion2(0,"kang"));
		
		System.out.println("case 6 : " + test2.binarySearchIteration(0, input.length-1, "kang"));
		System.out.println("case 7 : " + test2.binarySearchRecursion(0, input.length-1, "kang"));
		
		System.out.println(seqCount + " " + binCount);
	}
}
