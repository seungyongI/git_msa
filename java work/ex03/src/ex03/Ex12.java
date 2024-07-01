package ex03;

public class Ex12 {

	public static void main(String[] args) {

		int a = 10;
		int b = 10;
		int c = 10;
		int d = 10;

		boolean result;
		result = ((a += c) < 0) && ((b += d) > 0);
		System.out.println(result);
		System.out.println(a);
		System.out.println(b);

		result = ((a += c) < 0) || ((b += d) > 0);
		System.out.println(result);
		System.out.println(a);
		System.out.println(b);

		if ((a += c) > 0) {
			System.out.println("정답입니다.");
			System.out.println("똑똑합니다.");
		}
		
		else
			System.out.println("오답입니다.");

	}

}
