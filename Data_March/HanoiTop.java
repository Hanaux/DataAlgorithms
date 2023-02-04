import java.util.Scanner;

public class HanoiTop {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num;
		num = scanner.nextInt();
		hanoi(1,2,3,num);		
	}
	public static void hanoi(int from, int mid, int to, int num) {
		if(num==0) 
			return;
		
		hanoi(from, to, mid, num-1);
			System.out.printf("%d : %d >> %d%n", num, from, to);
			hanoi(mid, from, to, num-1);
		
	}
}
