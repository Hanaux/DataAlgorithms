package Data_0528;

import java.util.ArrayList;

public class HeepinArrayList {
	
	private ArrayList<Character> heap = new ArrayList<>();
	
	public HeepinArrayList() {
		heap.add(null);
	}
	
	public void heapSort(char[] input) {
		buildHeap(input);
		sortOut();
	}
	private void sortOut() {
		System.out.println("< Max.Heap >"); //title

		while(heap.size()>1) {
			System.out.println(deleteHeap()+"  "+ heap.toString());
		}
	}
	
	private Character deleteHeap() { // from heapifyDownward, 
		
		if(heap.size()<=1) {
		return null;
		}
		
		char retVal = heap.remove(1);
		
		if(heap.size()>2) {
			heap.add(1, heap.remove(heap.size()-1));
			heapifyDownward(1);
		}
		
		return retVal;
	}

	private void heapifyDownward(int i) { // for deleteHeap
		int k = 2*i;
		if(k>=heap.size()||i<1) {
			return;
		}
		if(k+1<heap.size() && (heap.get(k+1))>heap.get(k)) {
			k++;
		}
		if(heap.get(k)>heap.get(i)) {
			swap(heap, k, i);
			heapifyDownward(k);
		}
	}

	private void buildHeap(char[] input) {
		System.out.println("<< Heap implemented in ArrayList >>");
		for(int i=0;i<input.length;i++) {
			insertHeap(input[i]);
		}
	}
	
	private void insertHeap(char c) { // from heapifyUpward
		int k = heap.size();
		heap.add(k,c);
		
		System.out.print(c+" ");
		int parentIndex = k/2;
		heapifyUpward(parentIndex);
		System.out.println(heap.toString());
	}

	private void heapifyUpward(int i) { // parentIndex , for insertHeap
		int k = 2*i;
		if(k>=heap.size()||i<1) {
			return;
		}
		if(k+1<heap.size() && (heap.get(k+1))>heap.get(k)) {
			k++;
		}
		if(heap.get(k)>heap.get(i)) {
			swap(heap, k, i);
			heapifyUpward(i/2);
		}
	}

	private void swap(ArrayList<Character> heap2, int k, int i) { // swap data
		char temp = heap.get(k);
		heap.set(k, heap.get(i));
		heap.set(i, temp);
	}

	public static void main(String[] args) {
		char[] data = {'M', 'Y', 'U', 'N', 'G', 'I', 'S', 'W'};
		
		HeepinArrayList h = new HeepinArrayList();
		h.heapSort(data);
	}
}
