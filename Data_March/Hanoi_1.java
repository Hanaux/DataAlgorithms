
public class Hanoi_1 {
	public void hanoi(int level, char from, char to, char extra) {
		if(level==1) {
			move(level, from, to);
		} else {
			hanoi(level-1, from, extra, to);
			move(level, from, to);
			hanoi(level-1, extra, to, from);
		}
	}

	public void move(int level, char from, char to) {
		System.out.println("Plate#"+level+" moved from " +from+" to " + to);
	}
	
	public static void main(String[] args) {
		Hanoi_1 me = new Hanoi_1();
		int n=4;
		me.hanoi(n, 'A', 'B', 'C');
		
	}
}
