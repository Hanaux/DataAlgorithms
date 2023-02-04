package Data_0409;

public class MyQueue1 {
	MyArrayList1 queue = new MyArrayList1(3);
	int front = 0;
	int rear = 0;
	
	public void enqueue(String data) {
		queue.add(rear, data);
		rear = queue.sizeOf();
	}
	
	public String dequeue() { //queue의 한계. 한번 지울때마다 데이터 전체가 움직여야함 이를 보완하려고 MyQueue2
		if(front==rear)
			return null;
		else {
			String retVal = queue.remove(front); //front 값을 지워버림.
			rear=queue.sizeOf();
			return retVal;
		}
	}
	
	public int sizeOf() { // front가 변경되니 size는 rear-front함.
		return rear-front;
	}
	
	public void showQueue() {
		System.out.println(queue.toString());
	}
	
	public static void main(String[] args) {
		MyQueue1 q = new MyQueue1();
	}

}


