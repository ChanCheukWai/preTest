package preTest;

public class Q3 {
	
	public static double cal(double n, double cur) {
		double iterateTime = n;
		if (n < 2) {
			System.out.print("Invalid input");
			return 0;
		}
		for (int i = 0; i < iterateTime - 2 || n > 2; i++) {
			if (cur > -1 && cur < 1) cur = 0;
			cur = cur + 1 / (n * (n - 1));
			n = n -1;
			if (cur > -1 && cur < 1) cur = 0;
		}
		return 1 / n + cur;
	}
	
	 public static void main(String args[]) {
		 int n = 5;
		 double cur = 3;
		 if (cal(n,cur) != 0) System.out.print(cal(n,cur));

	 }
}
