package Data_0409;
public class MyQueue3<T> { // circular queue , 단점 : array 크기 제한을 벗어나려고 array를 쓴건데
	int qSize = 5; // array size를 지정해줘 버림.
	T []queue = (T[])new Object[qSize];
	int front = 0;
	int rear = 0;
	
	public boolean enqueue(T data) {
		if((rear+1)%qSize==front) //dequeue와 구분을 위해 (rear+1)%qSize로 한다.
			return false;
		else {
			queue[rear]=data;
			rear=(rear+1)%qSize;
			return true;
		}
	}
	
	public T dequeue() {
		if(front==rear)
			return null;
		else {
			T retVal = queue[front];
			queue[front]=null;
			front=(front+1)%qSize;
			return retVal;
		}
	}
	
	public int sizeOf() {
		System.out.println("Array Size : " + queue.length);
		return (rear>=front) ? (rear-front):(rear-front+qSize);
	}
	
	public void showQueue() {
		for(int i=0;i<qSize;i++)
			System.out.print(queue[i]+" - ");
		System.out.println();
	}
	
	public static void main(String[] args) {
		MyQueue3<MyClass> list = new MyQueue3<>();
		int idNum=0;
		
		list.enqueue(new MyClass(idNum++,"lee"));
		list.enqueue(new MyClass(idNum++,"kim"));
		list.enqueue(new MyClass(idNum++,"park"));
		list.enqueue(new MyClass(idNum++,"choi"));
		list.showQueue();
		list.dequeue();
		list.showQueue();
	}

}
