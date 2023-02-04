
public class RecursionSample {
	
	int [] data;
	public RecursionSample(int[] input) {
		data = input;
	}
	
	public String toString() { // object의 toString을 override
		String res="";
		for(int i=0;i<data.length;i++) {
			res +=(data[i]+", ");
		}
		return res;
	}
	
	public int maxIndexIter() {
		if(data.length<1) { //작으면 찾을 필요 없어서 -1 리턴
			return -1;
		}
		int index = 0;
		int max = data[0]; //data[0]을 max로 지정
		int i = 1;
		while(i<data.length) {
			if(data[i]>max) { //data[i] 값과 max를 비교해  data[i]가 더 크면 그 값을 max에 지정 
			max=data[i];
			index=i;
		}
		i++; //i의 값을 +1
		}
		return index; //array중에서 가장 큰 값을 가진 index를 반환
	}
	
	public int maxIndexRec(int startIndex) { //index 값을 받음
		
		if(startIndex==(data.length-1)) { //data array의 마지막 값이 data.length-1 이게 startIndex와 같으면
			return startIndex; //startIndex를 반환 하고 종료
		}
		int tempIndex = maxIndexRec(startIndex+1); //현 start index와 startIndex에 1을 더한 값을 넣었을 때의 return값
		if(data[startIndex]>data[tempIndex]) { //의 index를 data index에 넣고 비교
			return startIndex; //현재가 더 크면, 현재의index 반환
		}
		else {
			return tempIndex; //startIndex+1이 더 크면 그 index 반환
		}
	}
	
	public int[] mysort() { //mySort를 호출하지 않기에 ()는 비워짐
		int startIndex=0;
		while(startIndex<data.length-1) { 
			int tempIndex=maxIndexRec(startIndex+1); // maxIndexRec를 불러줌
			if(data[startIndex]<data[tempIndex]) { //startIndex+1 한 값이 더 크면
				swapData(startIndex, tempIndex); // 데이터값을 서로 바꾸기
			}
			startIndex++; //하나씩 올려가면서 비교
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
			if(data[i]==value) { //value와 data[i]가 일치하면
				return i; // i 값을 반환. (index 반환)
			}
			i++; // i를 +1
		}
		return -1;
	}
	
	public int search2(int value, int i) { // 위 예시의 int i 와 같음 더해서 계속 비교하는 것
		if(i==data.length) {
			return -1;
		}if(data[i]==value) {
			return i;
		}
		else {
			return search2(value, i+1); // 다음 array index를 넘겨주기
		}
	}
	
	public int search3(int value, int start, int end) { //인덱스 시작과 끝을 받는다
		
		if(start>end) {
			return -1;
		}
		int mid = (start + end)/2; // 절반 값을 mid에 넣는다
		if(data[mid]==value) { //mid값이 value와 같다면 
			return mid; //mid return
		} else if(data[mid]<value) { //value값이 data[mid]보다 크다면, mid 보다 앞 index에 있으므로
			return search3(value, start, mid - 1); //mid-1값을 end로 설정해서 다시 search3 method에 넣는다.
		}
		else { //value값이 data[mid]보다 작다면, mid 보다 뒤 index에 있으므로
			return search3(value, mid+1, end); //mid+1 index부터 끝까지 설정해서 다시 돌린다.
		}
	}
	
	public static void main(String[] args) {
		int[] input = {12,23,17,32,16,37,25,19,3,22};
		RecursionSample me = new RecursionSample(input);
		System.out.println(me.toString()); //toString 실행, input배열 그대로 출력
		
		System.out.println(me.maxIndexIter()); // max값 찾기 Iteration ver
		System.out.println(me.maxIndexRec(0)); // max값 찾기 Recursion ver
		
		int val =25;
		System.out.println("Loc. of"+val+" : " + me.search1(25)); //특정 값 찾기 Iteration ver
		System.out.println("Loc. of"+val+" : " + me.search2(25,0)); //특정 값 찾기 Recursion ver
		
		me.mysort();
		System.out.println(me.toString());
		
		System.out.println("Loc. of"+val+" : " + me.search3(25,0,9));

	}
	
}
