package Data_0430;

import org.w3c.dom.Node;

import Data_0409.MyClass;

public class MyDoubleLinkedList<T extends Comparable<T>> {
	Node<T> first, last;
	
	public MyDoubleLinkedList() { // Node first, last null로 설정
		first = null;
		last = null;
	}
	public T get(int index) { //get part
		if(!validIndex(index)) { //validIndex가 유효하지 않을 경우
			return null;
		}
		Node<T> temp = first;
		for(int i=0;i<index;i++) {
			temp = temp.next;
		}
		return temp.data;
	}
	private boolean validIndex(int index) { //index 유효성 검사
		if(index<sizeOf(first)&& index>=0) {
			return true;
		} else {
			return false;
		}
	}
	
	public void set(int index, T data) { //set part
		if(!validIndex(index)) {
			return;
		}
		Node<T> temp = first;
		for(int i=0;i<index;i++) {
			temp =temp.next;
		}
		temp.data=data;
	}
	
	public void addFirst(T data) { //첫번째 노드에 삽입. 
		Node<T> newNode = new Node<T>(data, null, first);
		first = newNode;
		if(last==null) { //자료가 없는 경우 마지막 값임.
			last=newNode;
		} else {
			first.next.previous=newNode; 
		}
	}
	
	public void addLast(T data) { //리스트 마지막에 삽입
		Node<T> newNode = new Node<T>(data, last, null);
		last = newNode;
		if(first==null) { // 자료가 없으면 첫값임.
			first=newNode;
		} else {
			last.previous.next=newNode;
		}
	}
	
	public void add(int index, T data) { //add part
		if(index==0) { // = addFirst
			addFirst(data);
		} else if (index==sizeOf(first)) { // = addLast
			addLast(data);
		} else {
			if(!validIndex(index)) {
				return;
			}
			Node<T> temp = first; // 노드 설정
			int i = 1;
			while (i<index) {
				temp = temp.next;
				i++;
			}
			Node<T> newNode = new Node<T>(data, temp, temp.next);
			newNode.previous.next=newNode;
			newNode.next.previous=newNode;
		}
	}
	
	public T removeFirst() { //첫 인덱스 값 삭제
		if(first!=null) { //리스트에 값이 있어야 밑 함수 실행
			T retVal = first.data;
			first=first.next;
			if(first!=null) {
				first.previous=null;
			} else {
				last=null;
			}
			return retVal;
		}
		else { // 리스트에 값이 없으면 null
			return null;
		}
	}
	public T removeLast() { //마지막 인덱스 값 삭제
		if(last!=null) { //리스트에 값이 있어야 밑 함수 실행
			T retVal = last.data;
			last = last.previous;
			if(last!=null) {
				last.next = null;
			} else {
				first = null;
			}
			return retVal;
		}
		else { // 리스트에 값이 없으면 null
			return null;
		}
	}
	
	public T remove(int index) { //remove part
		if(!validIndex(index)) {
			return null;
		}
		if(index==0) { // = removeFirst
			return removeFirst();
		}
		else if(index==sizeOf()-1) { // = removeLast
			return removeLast();
		}
		else { //값이 하나 이상 있을 때 실행
			Node<T> temp = first.next;
			int i =1;
			while (i<index) {
				temp=temp.next;
				i++;
			}
			T retVal=temp.data;
			temp.previous.next=temp.next;
			temp.next.previous=temp.previous;
			return retVal;
		}
			
	}
	public int remove(T data) { //int index 반환, 위의 remove 메서드로 int index 주고 실행.
		int index = indexOf(data);
		remove(index);
		return index;
	}
	
	private int indexOf(T data) { //index of part
		Node<T> temp = first;
		for(int i=0;i<sizeOf();i++) {
			if(temp.data.compareTo(data)==0) {
				return i;
			}
			temp = temp.next;
		} 
		return -1;
	} 
	public int sizeOf() { //상위 메소드로 first Node를 넘겨줌.
		return sizeOf(first);
	}
	
	private int sizeOf(Node<T> link) { //위위 메소드로 link.next를 넘긴다
		if(link==null) { // link가 null인 경우
			return 0;
		} else { //아니면 1+sizeOf(link.next)
			return 1+sizeOf(link.next);
		} 
	}
	public void sort() {
		if(sizeOf()<=1) {
			return;
		}
		Node<T> temp = first;
		Node<T> min;
		MyDoubleLinkedList<T> sortedList = new MyDoubleLinkedList<T>(); 
		while(temp!=null) {
			min=findMin(temp);
			sortedList.addFirst(min.data);
			remove(min.data);
			temp=first;
		}
		first=sortedList.first;
	}
	
	private Node<T> findMin(Node<T> temp) {
		Node<T> min = temp;
		while(temp.next!=null) {
			temp=temp.next;
			if(temp.data.compareTo(min.data)>0) {
				min=temp;
			}
		}
		return min;
	}
	public String toString() {
		Node<T> temp = first;
		String retVal="";
		while(temp!=null) {
			retVal=retVal+"/"+temp.data.toString();
			temp=temp.next;
		}
		return retVal;
	}
	
	public static void main(String[] args) {
		MyDoubleLinkedList<MyClass> list = new MyDoubleLinkedList<>();
	}
	
	private class Node<T> {
		T data;
		Node<T> previous;
		Node<T> next;
		private Node(T input, Node<T> f, Node<T> n) {
			data=input;
			previous=f;
			next=n;
		}
	}
}
