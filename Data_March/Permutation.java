import java.util.Arrays;

public class Permutation {

	char[] data; //암시적 매개변수
	int numberOfPatterns=0; // 암시적 매개변수
	
	public Permutation(char [] input) {
		data=input;
	}
	
	public void permIteration() {
		int size = data.length;
		numberOfPatterns=0;
		for (int i0=0;i0<size;i0++) {
			swapData(0,i0);
			for (int i1=1;i1<size;i1++) {
				swapData(1,i1);
				for (int i2=2;i2<size;i2++) {
					swapData(2,i2);
					
					numberOfPatterns++; //글로벌 변수 증가
					System.out.println(numberOfPatterns+" : "+toString()); // toString method로 가서 String 변수인 res에 배열을 합쳐 출력
					swapData(3,4);
					numberOfPatterns++;
					System.out.println(numberOfPatterns+" : "+toString());
					
					swapData(3,4); // 바꾼상태에서 다시 상위 for문을 돌면 중복 발생 제자리로 위치시켜야함 이 뒤에 실행하는
					swapData(2,i2); // method 안 swapData는 모두 위와 같은 목적
				}
				swapData(1,i1); //바꾼걸 프린트 한뒤에는 원위치
			}
			swapData(0,i0); // swapData를 이용해 원래대로 위치하게 함
		}
	}

	public void permRecursion(char[] input, String res) {
		if(input.length==1) { //밑의 copyOfRange에서 정해진 배열이 1과 같을 때, 즉, 인덱스 1의 값만 array로 복사되었을 때
			System.out.println(numberOfPatterns+" "+res+input[0]); //res에 input[0] 추가
			numberOfPatterns++;
		}
		for (int i=0;i<input.length;i++) {
			swapData(input,0,i);
			res+=input[0]; //첫 값 주입
			permRecursion(Arrays.copyOfRange(input, 1, input.length), res); //input array에서 index 1에서 input length 전까지의 배열 복사 
			res = res.substring(0,res.length()-1); //index 1부터 res length-1의 전까지만 res에 저장
		}
	}
	public void permRecursion() {
		permRecursion(this.data,"");
	}
	private void swapData(int level, int index) { //두 개 Int 바꾸는 method
		if(level!=index) { //data array는 암시적, level, index는 명시적임
			char temp = data[level];
			data[level]=data[index];
			data[index]=temp;
		}
	}
	private void swapData(char[] data, int level, int index) { //두개의 int 값을 받아 해당 index 값끼리 교환
		if(level!=index) {
			char temp = data[level];
			data[level]=data[index];
			data[index]=temp;
		}
	}
	public String toString() {
		String res="";
		for (int i=0;i<data.length;i++) //data array를 String res에 저장
			res+=data[i];
		return res;
	} 
	public static void main(String[] args) {
		char data[] = {'a','b','c'};
		Permutation p = new Permutation(data);

//		p.permIteration();
		p.permRecursion();
	}
}
