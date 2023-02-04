package week4;

import week4.BST.Node;

public class AVLTree extends BST{
	public AVLTree() {
		super();
	}
	public void insert(char c) {
		Node r = insert(c, null, root);
		//find x = ÃÖÃÊ·Î ±ÕÇüÀÌ ±úÁø °÷
		Node p = r.parent;
		while(p!=null) {
			if(!isBalanced(p))
				break;
			p=p.parent;
		}
		Node x = p;
		Node y = null;
		
		if(x!=null) {
			if(c<x.key) {
				y=x.left;
				if(c<y.key) // LL imbalance
					rotateRight(x);
				else { //LR imbalance
					rotateLeft(y);
					rotateRight(x);
				}
			}
			else {
				y = x.right;
				if(c>y.key) // RR imbalance
					rotateLeft(x);
				else { // RL imbalance
					rotateRight(y);
					rotateLeft(x);
				}
			}
		}
	}
	public void deleteAVL(char c) {
		Node r = delete(c);
		Node p = r.parent;
		while(p!=null) {
			if(!isBalanced(p))
				break;
			p=p.parent;
		}
		Node x = p;
		Node y = null;
		
		if(x!=null) {
			if(c<x.key) {
				y=x.left;
				if(c<y.key) // LL imbalance
					rotateRight(x);
				else { //LR imbalance
					rotateLeft(y);
					rotateRight(x);
				}
			}
			else {
				y = x.right;
				if(c>y.key) // RR imbalance
					rotateLeft(x);
				else { // RL imbalance
					rotateRight(y);
					rotateLeft(x);
				}
			}
		}	
		
	}

	private Node rotateLeft(Node x) {
		Node y = x.right;
		y.parent = x.parent;
		if(y.parent==null)
			root=y;
		else {
			if(x==x.parent.left)
				x.parent.left=y;
			else 
				x.parent.right=y;
		}
		x.parent = y;
		x.right = y.left;
		if(y.left!=null)
			y.left.parent = x;
		y.left = x;
		return y;
	}
	
	private Node rotateRight(Node x) {
		Node y = x.left;
		y.parent = x.parent;
		if(y.parent==null)
			root=y;
		else {
			if(x==x.parent.left)
				x.parent.left=y;
			else 
				x.parent.right=y;
		}
		x.parent = y;
		x.left = y.right;
		if(y.right!=null)
			y.right.parent = x;
		y.right = x;
		return y;
	}
	private boolean isBalanced(Node p) {
		if(p==null)
			return true;
		if(Math.abs(height(p.left)-height(p.right))<=1)
			return true;
		else return false;
	}
	
	public static void main(String[] args) {
		int inputSize = 26;
		char[] data = new char[inputSize];
		
		for(int i=0;i<inputSize;i++)
			data[i] = (char)((int)'A'+i);
		
		BST bt = new BST();
		
		for(int i=0;i<inputSize;i++) {
			bt.insert(data[i]);
		}
		System.out.println("Initial Skewed Tree");
		bt.showTree();
		System.out.println("Max. Height = "+bt.height());
		System.out.println("IPL = "+bt.IPL());
		
		AVLTree bt1 = new AVLTree();
		for(int i=0;i<inputSize;i++) {
			bt1.insert(data[i]);
		}
		System.out.println("AVL Tree");
		bt1.showTree();
		System.out.println("Max. Height = "+bt1.height());
		System.out.println("IPL = "+bt1.IPL());

	}
}
