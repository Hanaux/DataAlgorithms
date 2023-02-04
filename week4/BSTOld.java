//package week4;
//
//import week4.BST.Node;
//
//public class BSTOld {
//	
//	Node root;
//	
//	public BSTOld() {
//		root=null;
//	}
//	
//	public void insert(char x) {
//		if (root==null)
//			root=new Node(x);
//		else if (search(root, x)!=null)
//			return;
//		else if (x<root.key)
//			insert(root.left, root, x);
//		else 
//			insert(root.right, root, x);
//	}
//	
//	private void insert(Node p, Node parent, char x) {
//		if (p==null) {
//			Node temp = new Node(x);
//			temp.parent=parent;
//			if (x<parent.key)
//				parent.left=temp;
//			else parent.right=temp;
//		}
//		else if (x<p.key)
//			insert(p.left, p, x);
//		else
//			insert(p.right, p, x);
//	}
//
//	public Node search(Node startNode, char x) {
//		Node p = startNode;
//		if (p==null||p.key==x)
//			return p;
//		else if (x<p.key)
//			return search(p.left, x);
//		else
//			return search(p.right, x);
//	}
//	
//	public void delete(char x) {
//		delete(root, x);
//	}
//	
//	private void delete(Node startNode, char x) {
//		Node v = search(startNode, x);
//		if (v==null)
//			return;
//		// case 1 : no child
//		if (v.left==null && v.right==null) {
//			if (x<v.parent.key)
//				v.parent.left = null;
//			else 
//				v.parent.right = null;
//			return;
//		}
//		// case 2 : 1 child
//		if (v.left==null || v.right==null) {
//			if (v.right!=null) {
//				v.right.parent = v.parent;
//				if (v==v.parent.left)
//					v.parent.left = v.right;
//				else 
//					v.parent.right = v.right;
//			}
//			else {
//				v.left.parent=v.parent;
//				if (v==v.parent.left)
//					v.parent.left=v.left;
//				else
//					v.parent.right=v.left;
//			}
//			return;
//		}
//		// case 3 : 2 children
//		Node q = sccessor(v);  // or ..predecessor(v);
//		v.key = q.key;
//		delete(v.right, q.key);
//	}
//
//	private Node sccessor(Node v) {
//		if (v==null)
//			return null;
//		Node p=v.right;
//		while(p.left!=null)
//			p=p.left;
//		return p;
//	}
//	private Node predecessor(Node v) {
//		if (v==null)
//			return null;
//		Node p=v.left;
//		while(p.right!=null)
//			p=p.right;
//		return p;
//	}
//
//	public void showTree() {
//		System.out.println(toString(root));
//	}
//	
//	private String toString(Node t) {
//		return inorder(t);
//	}
//	
//	private String inorder(Node t) {
//		if (t==null) 
//			return "";
//		else
//			return inorder(t.left)+" "+t.key+" "+inorder(t.right);
//	}
//
//	public static void main(String[] args) {
//
//		char [] data = {'M','Y','U','N','G','I','S','W'};
//		BSTOld bt = new BSTOld();
//		
//		for (int i=0;i<data.length;i++) {
//			bt.insert(data[i]);
//			bt.showTree();
//		}
//		System.out.print("\nTree Created :");
//		bt.showTree();
//		
//		bt.delete('S');
//		System.out.print("\nAfter deleting 'S' :");
//		bt.showTree();
//		bt.delete('G');
//		System.out.print("\nAfter deleting 'G' :");
//		bt.showTree();
//		bt.delete('U');
//		System.out.print("\nAfter deleting 'U' :");
//		bt.showTree();
//		
//	}
//
//}
