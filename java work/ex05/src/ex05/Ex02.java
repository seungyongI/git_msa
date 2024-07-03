package ex05;

import java.util.Scanner;

public class Ex02 {

	public static void main(String[] args) {
		
		//계속 입력해서 진행
		Scanner a = new Scanner(System.in);
//		System.out.println("직접입력");
		
		while (true) {
			
			int num = a.nextInt();		
			System.out.println("num="+num);
			
			if (num == 0) {
				break;
			}
			
		}
		
		System.out.println("종료됩니다.");
	}

}
