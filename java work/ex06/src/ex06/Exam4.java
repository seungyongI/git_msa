package ex06;

import java.util.Scanner;

public class Exam4 {

	public static void main(String[] args) {

//		a = 홀수
//		b = -짝수

//		int a = 1;
//		int b = -a-1;

//		Scanner temp = new Scanner(System.in);
		int num = 0;
		int sum = 0;
		int c = 0;
		for (int a = 1; a > 0; a ++) {
			c = num-sum;
		if (a%2==0) {
			sum = a;
//			System.out.println(sum);
		}else {
			num = -a;
//			System.out.println(num);
		}
		}
		System.out.println(c);
//		System.out.println(sum);
	}
}
