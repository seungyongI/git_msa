package ex06;

public class Exam2 {
	
	public static void main(String[] args) {
		
		int sum = 0;
		
		for (int i = 1; i < 21; i++) {
			if (i % 2 !=0 && i % 3 !=0) {
//				System.out.println(i);
				sum +=i;
			}
		}
		System.out.println(sum);
	}
}