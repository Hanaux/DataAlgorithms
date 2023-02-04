
public class SortingVer_1 {
	
	public int[] quickSort(int[] data, int p, int r) { // base condition p랑 r이 같아지면 끝
		if(p<r) { //p가 r보다 작을때만 실행
			int q = partition(data,p,r); //partition을 한 결과 
			quickSort(data, p ,q-1); //q를 줄여나감
			quickSort(data, q+1 ,r); //p를 늘려나감
		}
		return data;
	}
	
	private int partition(int[] data, int p, int r) {
		int pivot = r; //pivot 설정
		int left = p; //  편의상 변수 변환
		int right = r; // 편의상 변수 변환

		while(left<right) {
			
			while(data[left]<data[pivot] && left<right) {  
				left++; //data[left]이 pivot보다 작고 right보다 작으면 left 증가
			}
			while(data[right]>data[pivot] && left<right) {
				right--;//data[right]이 pivot보다 크고 left보다 크면 right 감소
			}
			if( left<right) {
				swapData(data, left, right); // left가 right와 같아질 때 까지 swap
			}
		}
		swapData(data, pivot, right);
		
		return right;
	}
	
	private void swapData(int[] data, int i, int j) { // data를 swap
		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}

	public static void main(String[] args) {
		int [] data = {4, 45, 31, 2, 12, 8, 18, 23, 10, 37}; //데이터 임의 지정
		int [] endData = new int[data.length]; // data 길이로 sortedData 생성

		SortingVer_1 s = new SortingVer_1();
		endData=s.quickSort(data, 0, data.length-1);
		for(int i =0; i<endData.length;i++) {
			System.out.println(endData[i]+" ");
		}
		System.out.println();

	}
}
