package ex04;

public class Ex03 {

	public static void main(String[] args) {

		int num1 = 10;

		/*
		 * 브레이크포인트...더블클릭
		 * 벌레모양 실행
		 * f6 한줄씩 실행
		 * f8 종료
		 * */
		// num++
		// num = num+1
		// num += 1
		
		System.out.println(num1++);
		System.out.println(++num1);
	
		System.out.println(num1);
		
		System.out.println(num1--);
		System.out.println(--num1);
		
		System.out.println(num1);
		
		for (int i=0; i<10; i++) {
			System.out.println(i);
			System.out.println("ㅎㅎㅎ");
		}
		
	}

}
