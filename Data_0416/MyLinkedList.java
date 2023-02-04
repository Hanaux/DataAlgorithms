package Data_0416;

import Data_0409.MyClass;

public class MyLinkedList<T extends Comparable<T>> {
// 60181675 ÇÑ½ÂÇå
	Node<T> first;
	int numOfNode;

	public MyLinkedList() {
		first =null; 
		numOfNode=0;
	}

	public T get(int index) {
		if (!validIndex(index))
			return null;
		Node<T> temp = first;
		for (int i=0; i<index;i++) {
			temp =temp.link;
		}
		return temp.data;
	}
	private boolean validIndex(int index) {
		if (index<numOfNode && index>=0)
			return true;
		else
			return false;
	}

	public void set(int index, T data) {
		if (!validIndex(index))
			return;
		Node<T> temp = first;
		for (int i=0; i<index;i++) {
			temp =temp.link;
		}
		temp.data=data;
	}
	public void addFirst(T data) {
		Node<T> newNode = new Node<>(data, first);
		first = newNode;
		numOfNode++;	
	}
	public void addLast(T data) {
		if (numOfNode==0)
			addFirst(data);
		else {
			Node<T> temp= first;
			while (temp.link!=null)
				temp=temp.link;
			temp.link = new Node<>(data, null);
			numOfNode++;	
		}
	}
	
	public void add(int index, T data) {
		System.out.println(">> Add "+index+"  "+data.toString());
		if (index==0)
			addFirst(data);
		else if (index==numOfNode)
			addLast(data);
		else {
			if (!validIndex(index))
				return;
			Node<T> temp= first;
			int i=0;
			while (i<index-1) {
				temp=temp.link;
				i++;
			}
			temp.link = new Node<>(data, temp.link);
			numOfNode++;
		}
	}
	public T removeFirst() {
		System.out.println(">> RemoveFirst ");

		if (first!=null) {
			T retVal=first.data;
			first=first.link;
			numOfNode--;
			return retVal;
		}
		else
			return null;
	}
	public T removeLast() {
		System.out.println(">> RemoveLast ");

		if (numOfNode==0)
			return removeFirst();
		else {
			Node<T> temp= first;
			Node<T> tempNext = temp.link;
			while (tempNext.link!=null) {
				temp=tempNext;
				tempNext=tempNext.link;
			}
			temp.link = null;
			numOfNode--;
			return tempNext.data;
		}
	}

	public T remove(int index) {
		System.out.println(">> Remove with index : "+index);

		if (!validIndex(index))
			return null;
		if (index==0)
			return removeFirst();
		else if (index==numOfNode-1)
			return removeLast();
		else {
			Node<T> temp= first;
			Node<T> tempNext = temp.link;
			int i=1;
			while (i<index) {
				temp=tempNext;
				tempNext=tempNext.link;
				i++;
			}
			temp.link = tempNext.link;;
			numOfNode--;
			return tempNext.data;
		}
	}
	public int remove(T data) {
		System.out.println(">> Remove with value : "+data);

		Node<T> temp = first;
		if (compare(temp.data, data)==0) {
			first=temp.link;
			numOfNode--;
			return 0;
		}
		Node<T> tempNext=temp.link;
		int i=1;
		while(tempNext!=null) {
			if (compare(tempNext.data, data)==0) {
				temp.link=tempNext.link;
				numOfNode--;
				return i;
			}
			else {
				i++;
				temp=tempNext;
				tempNext=tempNext.link;
			}
		}
		return -1;

	}
	
	public int indexOf(MyLinkedList<MyClass> list, MyClass myClass) {
		Node<T> temp = first;
//		for(int i=0; i<numOfNode;i++) {
//			if (compare(temp.data, data)==0)
//				return i;
//			temp=temp.link;
//		}
//		return -1;
		if(temp.data.equals(list) ) {return 0;}
		if(temp.link == null) {return -1;}
		int index = indexOf(list, myClass);

		if(index == -1) {return -1;}
		else {return 1 + index;}
	}

	public int sizeOf() {
		
		return numOfNode;
	}

	public int compare(T o1, T o2) {
		if (o1 instanceof Comparable && o2 instanceof Comparable ) {
			Comparable c1 =(Comparable) o1;
			Comparable c2 =(Comparable) o2;
			return c1.compareTo(c2);
		}
		else 
			return -1;
	}

	public void sort() { 
		if (numOfNode<=1)
			return;
		Node<T> temp = first;
		Node<T> min;
		MyLinkedList<T> sortedList = new MyLinkedList<T>();
		while(temp!=null) {
			min=findMin(temp);
			sortedList.addFirst(min.data);
			remove(min.data);
			temp=first;			
		}
		first=sortedList.first;
		numOfNode=sortedList.numOfNode;
	}

	private Node<T> findMin(Node<T> temp) {
		Node<T> min = temp;
		while(temp.link!=null) {
			temp=temp.link;
			if(compare(min.data, temp.data)>0)
				min=temp;
		}
		return min;
	}

	public String toString() {
		Node<T> temp = first;
		String retVal="";
		int index=0;
		while(temp!=null) {
			retVal=retVal+"/"+temp.data.toString();
			temp=temp.link;
			index++;
		}
		return retVal;
	}
	
	public static void main(String[] args) {

		MyLinkedList<MyClass> list = new MyLinkedList<>();
		int idNum=0;
		
	    list.addLast(new MyClass(idNum++, "lee"));
	    list.addLast(new MyClass(idNum++, "park"));
	    list.addLast(new MyClass(idNum++, "kang"));
	    System.out.println(list.toString());
	    
		for(int i=0;i<list.sizeOf();i++) {
			System.out.println(list.indexOf(list, list.get(i)));
		}
//		System.out.println(list.indexOf(list, new MyClass(3, "choi")));

	}
	
	private class Node<T>{
		T data;
		Node link;
		private Node(T input, Node<T> next) {
			data=input;
			link=next;
		}
	}
}