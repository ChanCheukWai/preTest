package preTest;

import java.util.ArrayList;
import java.util.List;

public class Q1 {
	
	public static boolean isSubset(char[] arr1, char[] arr2) {

		List<Integer> arrlist1 = new ArrayList<Integer>();
		List<Integer> arrlist2 = new ArrayList<Integer>();
		
		for (int i = 0; i < 26; i++) {
			arrlist1.add(0);
			arrlist2.add(0);
		}
		
		for (int i = 0; i < arr1.length; i++) {
			arrlist1.set((int) arr1[i] - 65, 1);
		}
		
		for (int i = 0; i < arr2.length; i++) {
			if (arrlist1.get((int) arr2[i] - 65) != 1) {
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String args[]) {
		char[] arr1 = {'A', 'C', 'D', 'E'};
		char[] arr2 = {'D', 'A', 'C'};
		if(isSubset(arr1, arr2)) System.out.print("True");
		else System.out.print("False");
	 }
}

