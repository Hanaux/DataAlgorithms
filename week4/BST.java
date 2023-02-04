package week4;

import java.util.ArrayDeque;
import java.util.Deque;

public class BST {

	public class Node {
		char key;
		Node parent;
		Node left;
		Node right;
		
		public Node(char c) {
			key = c;
			parent = null;
			left = null;
			right = null;
		}
		public String toString() {
			String retVal = " ";
			return retVal+key+"("+height(this)+")";
		}
	}
	Node root;
	int numNode;
	
	public BST() {
		root = null;
		numNode = 0;
	}
	public void insert(char x) {
		insert(x, null, root); // null : parent of root
	}

	
	protected Node insert(char x, Node parent, Node r) {
		if(r==null) {
			if(parent==null) { //root인 경우
				root = insertNode(x, null);
				return root;
			}
			else { // leaf에 도달한 경우
				if(x <parent.key) {	// left child
					parent.left=insertNode(x, parent);
					return parent.left;
				}
				else if (x >parent.key) {	// right child
					parent.right=insertNode(x, parent);
					return parent.right;
				}
				else //never happens
					return null;
			}
		}
		else {
			if(x < r.key)
				return insert(x, r, r.left);
			else if(x>r.key)
				return insert(x, r, r.right);
			else //never happens
				return null;
		}
	}
	private Node insertNode(char x, Node parent) {
		Node newNode = new Node(x);
		newNode.parent = parent;
		numNode++;
		return newNode;
	}
	
	public Node search(Node startNode, char x) {
		Node p = startNode;
		if(p==null||p.key==x)
			return p;
		else if(x<p.key)
			return search(p.left, x);
		else
			return search(p.right, x);
	}
	
	public Node delete(char x) {
		Node r = search(root, x);
		if (r!=null) {
			numNode--;
			return delete(r);
		} else
			return null;
	}
	protected Node delete(Node r) {
		if(r.parent==null) {// r = root
			root = deleteNode(r);
			return null;
		} else if(r==r.parent.left) {
			r.parent.left = deleteNode(r);
			return r.parent;
		} else {
			r.parent.right = deleteNode(r);
			return r.parent;
		}
		
	}
		private Node deleteNode(Node r) {

		if(r.left==null && r.right==null) {return null;} // no child
		
		else if(r.left==null&&r.right!=null) { //1 child
			r.right.parent = r.parent;
			return r.right;
		}
		else if(r.left!=null&&r.right==null) { //1 child
			r.left.parent = r.parent;
			return r.left;
		}
		else { //2 children
			Node s = sccessor(r);
			r.key=s.key;
			if(s==s.parent.left)
				s.parent.left = s.right;
			else 
				s.parent.right = s.right;
			return s.parent;
		}
	}

	
	private Node sccessor(Node v) {
		if(v==null)
			return null;
		Node p = v.right;
		while(p.left!=null)
			p=p.left;
		return p;
	}
	private Node predecessor(Node v) {
		if(v==null)
			return null;
		Node p = v.left;
		while(p.right!=null)
			p=p.right;
		return p;
	}
	
	public void showTree() {
		if(root==null)
			return;
		Deque<Node> que = new ArrayDeque<Node>();
		que.add(root);
		int depthLevel = 0;
		while(que.peek()!=null) {
			Deque<Node> temp = new ArrayDeque<Node>();
			System.out.print("Depth-Level "+ depthLevel + "  :  ");
			while(que.peek()!=null) {
				temp.add(que.poll());
			}
			while(temp.peek()!=null) {
				Node e = temp.poll();
				System.out.print(e.toString()+ " ");
				if(e.left!=null)
					que.add(e.left);
				if(e.right!=null)
					que.add(e.right);
			}
			System.out.println();
			depthLevel++;
		}
	}
	private String toString(Node t) {
		return inorder(t);
	}
	private String inorder(Node t) {
		if(t==null)
			return "";
		else
			return inorder(t.left)+" "+t.toString()+" "+inorder(t.right);
	}
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	public int height() {
		return height(root);
	}
	
	protected int height(Node r) {
		if(r==null)
			return -1;
		else 
			return 1 + Math.max(height(r.left), height(r.right));
	}
	
	public int IPL() {
		int count = 0;
		return IPLCount(root, count);
	}
	
	private int IPLCount(Node r, int count) {
		if(r==null)
			return count;
		count++;
		int lCount = IPLCount(r.left, count);
		int rCount = IPLCount(r.right, count);
		return count + lCount + rCount;
		
	}
	
	
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public static void main(String[] args) {
		char[] data = {'M', 'Y', 'U', 'N', 'G', 'I', 'S', 'W'};
		BST bt = new BST();
		for(int i=0;i<data.length;i++) {
			bt.insert(data[i]);
			bt.showTree();
		}
		System.out.print("\nTree Created : ");
		bt.showTree();
		
		bt.delete('S');
		System.out.print("\nAfter deleting 'S' : ");
		bt.showTree();
		bt.delete('G');
		System.out.print("\nAfter deleting 'G' : ");
		bt.showTree();								
		bt.delete('U');								
		System.out.print("\nAfter deleting 'U' : ");
		bt.showTree();
	}

}
