//아래는 변수 num의 값에 따라 "양수", "음수", "0"을 출력하는 코드이다.
//삼향 연산자를 이용해서 (1)에 알맞은 코드를 넣으시오

package ex04;

import java.util.Scanner;

public class test3 {

	public static void main(String[] args) {

//		int num = 10;
//
//		String result = num > 0 ? "num은 양수입니다." : "num은 음수입니다.";
//
//		System.out.println(result);
		
		Scanner scan = new Scanner(System.in);
		System.out.println("숫자입력");
		
		int num = scan.nextInt();
		
//		if (num>0 || num<0) {
//			System.out.println("num="+num+(num>0 ? "양수입니다." : "음수입니다."));
//		} else { 
//			System.out.println("0입니다.");
//
//		}
		
		System.out.println("num="+num+(num>0 ? "양수" : num==0 ? "0":"음수"));
		}
		

	}
