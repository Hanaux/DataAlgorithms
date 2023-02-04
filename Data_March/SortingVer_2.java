
public class SortingVer_2 {
	int[] data; // 미리 data 정하기
	
	public SortingVer_2(int[] input) { // constructor에서 data 받기
		data = new int[input.length];
		data=input;
	}
	
	public int[] quickSort(int p, int r) {
		if(p<r) {
			int q = partition(p, r);
			quickSort(p,q-1);
			quickSort(q+1,r);
		}
		return data;
	}
	
	private int partition(int p, int r) {
		int pivot = r;
		int left = p;
		int right = r;
		
		while(left<right) {
			
			while(data[left]<data[pivot] && left<right) {
				left++;
			}
			while(data[right]<data[pivot] && left<right) {
				right--;
			}
			if(left<right) {
				swapData(left, right);
			}
		}
		swapData(pivot, right);
		
		return right;
	}
	
	private void swapData(int i, int j) {
		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}

	public static void main(String[] args) {
		int [] data = {4, 45, 31, 2, 12, 8, 18, 23, 10, 37};
		int [] endData = new int[data.length];
		
		SortingVer_2 s2 = new SortingVer_2(data);
		endData = s2.quickSort(0, data.length-1);
		for(int i=0; i<endData.length;i++) {
			System.out.println(endData[i]+" ");
		}
		System.out.println();
	}
}
