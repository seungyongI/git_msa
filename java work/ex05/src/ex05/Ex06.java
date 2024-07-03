package ex05;

import java.util.Scanner;

public class Ex06 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int n=scan.nextInt();

		while (true) {

			n++;
			System.out.println("n=" + n);
			if (n == 10)
				break;
			int temp = scan.nextInt();
			System.out.println("temp=" + temp);
		}
		System.out.println("종료됩니다.");
	}

}
