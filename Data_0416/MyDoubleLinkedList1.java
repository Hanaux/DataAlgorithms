package Data_0416;

public class MyDoubleLinkedList1 {
//60181675 �ѽ���
	Node first, last;

	public MyDoubleLinkedList1() {
		first =null;
		last=null;
	}

	private boolean validIndex(int index) {
		if (index<sizeOf(first) && index>=0)
			return true;
		else
			return false;
	}

	public void addFirst(String data) {
	
	    Node newNode = new Node(data, first, last);
	    // ���ο� ����� ���� ���� ��带 �����մϴ�.
	    newNode.next = first;
	    // ���� ��尡 �־��ٸ� ���� ���� �� ��带 ����
	    if (first != null)
	        first.previous = newNode;
	    // �� ��带 ����
	    first = newNode;
	    if (first.next == null) {
	        last = first;
	    }


	}
	public void addLast(String data) {
	
	    Node newNode = new Node(data, first, last);
	    if (!validIndex(0)) {
	        addFirst(data);
	    } else {
	        last.next = newNode;
	        newNode.previous = last;
	        last = newNode;
	    }

	}
	public void add(int index, String data) {
	    if (index == 0) {
	        addFirst(data);
	    } else {
	        Node temp1 = node(index-1);
	        Node temp2 = temp1.next;
	        Node newNode = new Node(data, first, last);
	        temp1.next = newNode;
	        newNode.next = temp2;
	        if (temp2 != null)
	            temp2.previous = newNode;
	        newNode.previous = temp1;
	        if (newNode.next == null) {
	            last = newNode;
	        }
	    }

		
	}
	private Node node(int index) {

	        // first���� next�� �̿�, index ��� Ž��.
	        Node x = first;
	        for (int i = 0; i < index; i++)
	            x = x.next;
	        return x;
	    
	}

	private int sizeOf(Node link) {
		if (link==null)
			return 0;
		else
			return 1+sizeOf(link.next);
	}

	public String toString() {
		Node temp = first;
		String retVal="";
		while(temp!=null) {
			retVal=retVal+"/"+temp.data.toString();
			temp=temp.next;
		}
		return retVal;
	}

	public static void main(String[] args) {

		MyDoubleLinkedList1 list = new MyDoubleLinkedList1();

		list.addLast("lee");
		System.out.println(list.toString());
		list.addFirst("kim");
		System.out.println(list.toString());
		list.addLast("park");
		System.out.println(list.toString());
		list.add(1, "choi");
		System.out.println(list.toString());
		list.addFirst("jung");
		System.out.println(list.toString());
		list.add(0, "hong");
		System.out.println(list.toString());

	}

	private class Node{
		String data;
		Node previous;
		Node next;
		private Node(String input, Node f, Node n) {
			this.data=input;
			this.previous= f;
			this.next=n;
		}
	}

}
