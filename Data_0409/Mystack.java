package Data_0409;
public class Mystack {

	MyArrayList1 stack = new MyArrayList1(3); // ArrayList�� Stack �������� ����.
	int top=0;
	
	public void push(String data) { // ������ �ֱ�
		stack.addLast(data);
		top=stack.sizeOf();
	}
	
	public String pop() { // ������ ����
		if(stack.sizeOf()==0) // 0�̸� ���� �����Ƿ� return null.
			return null;
		else {
			String retVal = stack.remove(top-1); //���� �� ������ ����
			top = stack.sizeOf(); //top ���� �� ����. �� ���� �������.
			return retVal;
		}
	}
	
	public int sizeOf() { //������ ������
		return stack.sizeOf();
	}
	
	public void showStack() { //���� ���.
		System.out.println(stack.toString());
	}
	public static void main(String[] args) {
		Mystack st = new Mystack();
		
		

	}

}
