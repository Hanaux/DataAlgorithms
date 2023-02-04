package Data_0528;

import java.util.ArrayDeque;
import java.util.Deque;

public class HeapTree {
	Node heap; //root
	Node last;
	
	public HeapTree() {
		heap= null;
		last = null;
	}
	
	public void heapSort(char[] input) {
		buildHeap(input);
		sortOut();
	}
	private void sortOut() {
		System.out.println("< Max.Heap >"); //title

		while(heap!=null) {
			System.out.println(deleteHeap()+" "+ toString());
		}
	}
	private Character deleteHeap() { 
		if(heap==null) {
		return null;
		}
		char retVal = heap.key;
		
		if(heap==last) {
			heap=null;
			last=null;
		}
		else {
			heap.key = last.key;
			Node prev = getPrev(last);
			if(last==last.parent.left) {
				last.parent.left=null;
			} else {
				last.parent.right=null;
			}
			last = prev;
			heapifyDownward(heap);
		}
		return retVal;
	}
	private Node getPrev(Node node) {
		if(node == node.parent.right) {
			return node.parent.left;
		}
		Node p = node;
		while((p.parent !=null) && (p==p.parent.left)) {
			p = p.parent;
		}
		if(p.parent!=null) {
			p=p.parent.left;
		}
		while(p.right!=null) {
			p = p.right;
		}
		return p;
	}
	private void heapifyDownward(Node node) {
		if(node == null||node.left==null) {
			return;
		}
		Node larger = node.left;
		
		if(node.right!=null && node.right.key > node.left.key) {
			larger = node.right;
		}
		if(larger.key>node.key) {
			swap(larger, node);
			heapifyDownward(larger);
		}
	}

	private void buildHeap(char[] input) {
		System.out.println("<< Heap implemented in Linked-Tree >>");
		
		for(int i=0;i<input.length;i++) {
			insertHeap(input[i]);
		}
	}
	
	private void insertHeap(char c) {
		if(heap ==null) {
			heap = new Node(c, null, null, null);
			last = heap;
			return;
		}
		Node pNext = getParentOfNext(last);
		last = new Node(c, null, null, pNext);
		if(pNext.left==null) {
			pNext.left = last;
		} else {
			pNext.right = last;
		}
		heapifyUpward(last.parent);
		System.out.println(toString());
	}

	private Node getParentOfNext(Node node) {
		if(node == null || node == heap) {
			return node;
		}
		if(node.parent.right==null) {
			return node.parent;
		}
		Node p = node;
		while((p.parent != null) && (p==p.parent.right)) {
			p = p.parent;
		}
		if(p.parent!= null) {
			p = p.parent.right;
		}
		while(p.left!=null) {
			p = p.left;
		}
		return p;
	}

	private void heapifyUpward(Node node) { // parentIndex
		
		if(node==null||node.left==null) {
			return;
		}
		Node larger = node.left;
		if(node.right!=null && node.right.key>node.left.key) {
			larger = node.right;
		}
		if(larger.key>node.key) {
			swap(larger, node);
			heapifyUpward(node.parent);
		}
	}

	private void swap(Node a, Node b) {
		char temp = a.key;
		a.key = b.key;
		b.key = temp;
	}

	public String toString() {
		if(heap==null) {
			return null;
		}
		Deque<Node> q = new ArrayDeque<Node>();
		q.add(heap);
		return levelOrderTraverse(q, "");
	}	
	private String levelOrderTraverse(Deque<Node> q, String retString) {
		Node node = q.poll();
		if(node==null) {
			return retString;
		}
		retString = retString+ " " + node.key;
		if(node.left!=null) {
			q.add(node.left);
			if(node.right!=null) {
				q.add(node.right);
			}
		}
		return levelOrderTraverse(q, retString);
	}

	public static void main(String[] args) {
		char[] data = {'M', 'Y', 'U', 'N', 'G', 'I', 'S', 'W'};
		
		HeapTree h = new HeapTree();
		h.heapSort(data);
	}
	
	class Node {
		char key;
		Node left, right, parent;
		public Node(char c, Node l, Node r, Node p) {
			key = c;
			left = l;
			right = r;
			parent = p;
		}
		
		public String toString() {
			return ""+key;
		}
	}
}
