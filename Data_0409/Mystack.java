package Data_0409;
public class Mystack {

	MyArrayList1 stack = new MyArrayList1(3); // ArrayList를 Stack 형식으로 만듦.
	int top=0;
	
	public void push(String data) { // 데이터 넣기
		stack.addLast(data);
		top=stack.sizeOf();
	}
	
	public String pop() { // 데이터 빼기
		if(stack.sizeOf()==0) // 0이면 값이 없으므로 return null.
			return null;
		else {
			String retVal = stack.remove(top-1); //제일 윗 데이터 빼기
			top = stack.sizeOf(); //top 변수 재 설정. 현 스택 사이즈로.
			return retVal;
		}
	}
	
	public int sizeOf() { //스택의 사이즈
		return stack.sizeOf();
	}
	
	public void showStack() { //스택 출력.
		System.out.println(stack.toString());
	}
	public static void main(String[] args) {
		Mystack st = new Mystack();
		
		

	}

}
