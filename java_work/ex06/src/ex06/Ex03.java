package ex06;

public class Ex03 {

	// method 설명
	public static void main(String[] args) {
		int k = 20;
		System.out.println("===프로그램 시작 ===" + k);
		hieveryone(12);
		hieveryone(13);
		System.out.println("===프로그램 끝===");
	}

	// 아래 메소드는 어디에 있든 상관 X
	public static void hieveryone(int age) {

		System.out.println("여기온다" + age);

		if (age == 12) {
			System.out.println("age= 12입니다.");
		}
		for (int k = 0; k < 3; k++) {
			System.out.println("k=" + k);
		}
	}

}
