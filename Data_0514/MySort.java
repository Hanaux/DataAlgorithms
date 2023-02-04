package Data_0514;

public class MySort {
	int nOfCompare, nOfSwap, nOfMove;
	
	private int[] creatData(int dataSize) { // 랜덤 배열 생성
		int [] data = new int[dataSize];
		for(int i =0;i<dataSize;i++) {
			data[i] = (int)(Math.random()*dataSize*10);
		}
		
		return data;
	}
	
	private void resetCounter() { // 초기화
		nOfCompare=0;
		nOfSwap=0;
		nOfMove=0;
	}
	
	private void showStat(String algName) {
		System.out.println("\n< " + algName + " >");
		System.out.println("  - n. of comparisions : " + nOfCompare);
		if(nOfSwap!=0 ) {
			System.out.println("  - n. of swaps : " + nOfSwap);
		}
		if (nOfMove!=0) {
		System.out.println("  - n. of moves : " + nOfMove);
		}
	}
	private int[] swap(int[] data, int i, int j) {
		nOfSwap++;
		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;
		
		return data;
	}
	////////// selectionSort Part Start //////////
	public int[] selectionSort(int [] data) {
		
		int dataSize = data.length;
		for(int i=0;i<dataSize-1;i++) {
			for(int j=i+1;j<dataSize;j++ ) {
				nOfCompare++;
				if(data[i]>data[j]) {
					data=swap(data, i, j);
				}
			}
		}
		return data;
	}
	////////// selectionSort Part End //////////
	////////// bubbleSort Part Start //////////
	public int[] bubbleSort(int [] data) {
		
		int dataSize = data.length;
		for(int i=dataSize-1;i>=0;i--) {
			for(int j=0;j<i;j++ ) {
				nOfCompare++;
				if(data[j]>data[j+1]) {
					data=swap(data, j+1, j);
				}
			}
		}
		return data;
	}
	////////// bubbleSort Part End //////////
	////////// quickSort Part Start//////////
	public int[] quickSort(int[] data) {
		return quickSort(data, 0, data.length-1);
	}
	
	private int[] quickSort(int[] data, int p,int r) {
		if(p<r) {
			int q = partition(data, p, r);
			quickSort(data, p, q-1);
			quickSort(data, q+1, r);
		}
		return data;
	}
	
	private int partition(int[] data, int p, int r) {
		int pivot = r;
		int left = p;
		int right = r;
		
		while(left < right) {
			while(data[left]<data[pivot]&&left<right) {
				nOfCompare++;
				left++;
			}
			while(data[right]>=data[pivot]&&left<right) {
				nOfCompare++;
				right--;
			}
			if(left<right) {
				swap(data, left, right);
			}
		} // big while end
		swap(data, pivot, right);
		return right;
	}
	////////// quickSort Part End //////////
	////////// mergeSort Part Start //////////
	public int[] mergeSort(int[] data) {
		return mergeSort(data, 0, data.length-1);
	}
	
	private int[] mergeSort(int[] data, int p, int r) {
		if(p<r) {
			int q = (p+r)/2;
			mergeSort(data, p, q);
			mergeSort(data, p+1, r);
			merge(data, p, q, r);
		}
		return data;
	}
	
	private int[] merge(int[] data, int p, int q, int r) {
		int[] sorted = new int[data.length];
		
		int i = p;
		int j = q+1;
		int k = p;  // pointer 역할
		
		while(i<=q && j<= r) {
			nOfCompare++;
			nOfMove++;
			if(data[i]<data[j]) {
				sorted[k++] = data[i++];
			} else {
				sorted[k++] = data[j++];
			}
		} // while end
		
		while(i<=q) {
			nOfMove++;
			sorted[k++] = data[i++];
		}
		while(j<=r) {
			nOfMove++;
			sorted[k++] = data[j++];
		}
		for(int l = p; l<=r;l++) {
			nOfMove++;
			data[l] = sorted[l];
		}
		return data;
	}
	////////// mergeSort Part End //////////
	////////// insertionSort Part Start //////////
	public int[] insertionSort(int[] data) {
		int dataSize = data.length;
		if(dataSize>1) {
			for(int i=1;i<dataSize;i++) {
				int j = 0;
				while(data[i]>data[j] && j<i) {
					nOfCompare++;
					j++;
				}
				if(j<i) {
					int temp = data[i];
					for(int k=i-1;k>=j; k--) {
						nOfMove++;
						data[k+1] = data[k];
					}
					data[j] = temp;
				}
			}
		}
		return data;
	}
	////////// insertionSort Part End //////////
	////////// insertionSort with LinkedList Part Start //////////
	public int[] insertionSortLinkedList(int[] data) {
		int dataSize = data.length;
		MySortLinkedList sorted = new MySortLinkedList();
		for(int i=0;i<dataSize;i++) {
			sorted.insertAscendingOrder(data[i]);
			nOfCompare += sorted.getStatCompare();
			nOfMove++;
		}
		for (int i=0;i<dataSize;i++) {
			data[i] = sorted.removeFirst();
		}
		return data;
	}
	
	////////// insertionSort with LinkedList Part End//////////
	
	
	
	public static void main(String[] args) {
		int dataSize = 35;
		int [] data = new int[dataSize];
		int [] dataSorted = new int[dataSize];
		
		MySort sort = new MySort();
		data = sort.creatData(dataSize);
		System.out.println("\n< Initial Data Created >");
		showData(data);
		
		sort.resetCounter();
		makeCopy(dataSorted, data);
		sort.selectionSort(dataSorted);
		sort.showStat("Selection Sort");
		showData(dataSorted);
		
		sort.resetCounter();
		makeCopy(dataSorted, data);
		sort.bubbleSort(dataSorted);
		sort.showStat("Bubble Sort");
		showData(dataSorted);
		
		sort.resetCounter();
		makeCopy(dataSorted, data);
		sort.quickSort(dataSorted);
		sort.showStat("Quick Sort");
		showData(dataSorted);
		
		sort.resetCounter();
		makeCopy(dataSorted, data);
		sort.mergeSort(dataSorted);
		sort.showStat("Merge Sort");
		showData(dataSorted);
		
		sort.resetCounter();
		makeCopy(dataSorted, data);
		sort.insertionSort(dataSorted);
		sort.showStat("Insertion Sort");
		showData(dataSorted);
		
		sort.resetCounter();
		makeCopy(dataSorted, data);
		sort.insertionSortLinkedList(dataSorted);
		sort.showStat("Insertion Sort with LinkedList");
		showData(dataSorted);
	}


	private static void makeCopy(int[] dataSorted, int[] data) { //배열 하나 마들어 복사하기
		int n = data.length;
		for (int i=0;i<n;i++) {
			dataSorted[i] = data[i];
		}
	}

	private static void showData(int[] data) { // 배열 보여주기
		int n = data.length;
		System.out.println("\n -- Data Status --");
		int nRow = 1+(int)n/10; // 줄 수 설정
		for(int i=0;i<nRow;i++) {
			for(int j=i*10;j<Math.min(n, (i+1)*10);j++) {
				System.out.print("  " + data[j]);
			}
			System.out.println();
		}
	}



}
