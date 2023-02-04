
public class SortingVer_1 {
	
	public int[] quickSort(int[] data, int p, int r) { // base condition p�� r�� �������� ��
		if(p<r) { //p�� r���� �������� ����
			int q = partition(data,p,r); //partition�� �� ��� 
			quickSort(data, p ,q-1); //q�� �ٿ�����
			quickSort(data, q+1 ,r); //p�� �÷�����
		}
		return data;
	}
	
	private int partition(int[] data, int p, int r) {
		int pivot = r; //pivot ����
		int left = p; //  ���ǻ� ���� ��ȯ
		int right = r; // ���ǻ� ���� ��ȯ

		while(left<right) {
			
			while(data[left]<data[pivot] && left<right) {  
				left++; //data[left]�� pivot���� �۰� right���� ������ left ����
			}
			while(data[right]>data[pivot] && left<right) {
				right--;//data[right]�� pivot���� ũ�� left���� ũ�� right ����
			}
			if( left<right) {
				swapData(data, left, right); // left�� right�� ������ �� ���� swap
			}
		}
		swapData(data, pivot, right);
		
		return right;
	}
	
	private void swapData(int[] data, int i, int j) { // data�� swap
		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}

	public static void main(String[] args) {
		int [] data = {4, 45, 31, 2, 12, 8, 18, 23, 10, 37}; //������ ���� ����
		int [] endData = new int[data.length]; // data ���̷� sortedData ����

		SortingVer_1 s = new SortingVer_1();
		endData=s.quickSort(data, 0, data.length-1);
		for(int i =0; i<endData.length;i++) {
			System.out.println(endData[i]+" ");
		}
		System.out.println();

	}
}
