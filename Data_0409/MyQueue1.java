package Data_0409;

public class MyQueue1 {
	MyArrayList1 queue = new MyArrayList1(3);
	int front = 0;
	int rear = 0;
	
	public void enqueue(String data) {
		queue.add(rear, data);
		rear = queue.sizeOf();
	}
	
	public String dequeue() { //queue�� �Ѱ�. �ѹ� ���ﶧ���� ������ ��ü�� ���������� �̸� �����Ϸ��� MyQueue2
		if(front==rear)
			return null;
		else {
			String retVal = queue.remove(front); //front ���� ��������.
			rear=queue.sizeOf();
			return retVal;
		}
	}
	
	public int sizeOf() { // front�� ����Ǵ� size�� rear-front��.
		return rear-front;
	}
	
	public void showQueue() {
		System.out.println(queue.toString());
	}
	
	public static void main(String[] args) {
		MyQueue1 q = new MyQueue1();
	}

}


