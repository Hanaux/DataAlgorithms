package Data_0521;

public class BST {
	
	Node root;
	
	public BST() {
		root = null;
	}
	
	public void insert(char x) {
		if(root==null) {
			root=new Node(x);
		}
		else if(search(root, x)!=null) {
			return;
		} else if(x<root.data) {
			insert(root.left,root, x);

		} else {
			insert(root.right,root, x);
		}
	}
	private void insert(Node p, Node parent, char x) {
		if(p==null) {
			Node temp = new Node(x);
			temp.parent=parent;
			if(x<parent.data) {
				parent.left = temp;
			} else {
				parent.right = temp;
			}
		} else if(x<p.data) {
			insert(p.left, p, x);
		} else {
			insert(p.right, p, x);
		}
	}
	
	public Node search(Node startNode, char x) {
		Node p = startNode;
		if(p==null || p.data==x) {
			return p;
		} else if(x<p.data) {
			return search(p.left, x);
		} else {
			return search(p.right, x);	
		}

	}

	public void delete(char x) {
		delete(root, x);
		
	}
	private void delete(Node startNode, char x) {
		Node v = search(startNode, x);
		if(v==null) {
			return;
		}
		if(v.left==null&&v.right==null) { // case 1 : no child
			if(x<v.parent.data) {
				v.parent.left = null;
			} else {
				v.parent.right = null;
			}
			return;
		} // case 1 end
		if(v.left==null || v.right ==null) { //case 2 : 1 child
			if(v.right!=null) {
				v.right.parent = v.parent;
				if(v==v.parent.left) {
					v.parent.left = v.right;
				} else {
					v.parent.right = v.right;
				}
			} else {
				v.left.parent = v.parent;
				if(v==v.parent.left) {
					v.parent.left = v.left;
				} else {
					v.parent.right = v.left;
				}
			}
			return;
		} // case 2 end
		// case 3 : 3 children
		Node q = successor(v); // or predecessor(v);
		v.data = q.data;
		delete(v.right,q.data);
		// case 3 end
	}

	private Node successor(Node v) {
		if(v==null) {
			return null;
		}
		Node p=v.right;
		while(p.left!=null) {
			p=p.left;
		}
		return p;
	}
	
	private Node predecessor(Node v) {
		if(v==null) {
			return null;
		}
		Node p=v.left;
		while(p.right!=null) {
			p=p.right;
		}
		return p;
	}

	public void showTree() {
		System.out.println(toString(root));
	}
	
	public Object toString(Node t) {
		return inorder(t);
	}
	
	public String inorder(Node t) { // inorder case
		if(t==null) {
			return "";
		} else {
		return inorder(t.left) + " " + t.data + " " + inorder(t.right);
		}
	}
	
	public static void main(String[] args) {
		char[] data = {'M', 'Y', 'U', 'N', 'G', 'I', 'S', 'W'};
		BST bt = new BST();
		
		for(int i=0;i<data.length;i++) {
			bt.insert(data[i]);
		}
		System.out.println("\n Tree Created : ");
		bt.showTree();
		
		bt.delete('S');
		System.out.println("\n After deleting 'S' : ");
		bt.showTree();
		bt.delete('G');
		System.out.println("\n After deleting 'G' : ");
		bt.showTree();
		bt.delete('U');
		System.out.println("\n After deleting 'U' : ");
		bt.showTree();
	}

}
