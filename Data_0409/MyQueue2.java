package Data_0409;
public class MyQueue2 {
	MyArrayList1 queue = new MyArrayList1(3);
	int front = 0;
	int rear = 0;
	
	public void enqueue(String data) {
		queue.add(rear, data);
		rear = queue.sizeOf();
	}
	
	public String dequeue() { // 기존 단점을 보완하기 위해 프론트 값을 아예 다음 값으로 떙긴다.
		if(front==rear)
			return null;
		else {
			String retVal = queue.get(front);
			queue.set(front, null);
			front++;
			return retVal;
		}
	}
	
	public int sizeOf() {
		System.out.println("Array Size : " + queue.arrSize());
		return rear-front;
	}
	
	public void showQueue() {
		System.out.println(queue.toString());
	}
	
	public static void main(String[] args) {
		MyQueue2 q = new MyQueue2();
	}

}
