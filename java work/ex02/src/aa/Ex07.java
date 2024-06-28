package aa;

//정수는 무조건 int, 실수는 무조건 double로 약속되어 있음.
public class Ex07 {
	public static void main(String[] args) {

		final int MAX_SIZE = 100;
		System.out.println(MAX_SIZE);

		final int A = 100;
		System.out.println(A);

		final int B = 100;
		System.out.println(B);

		System.out.println(A + B);

		final double AA = 220;
		System.out.println(AA);

		final String C = "변경불가";
		System.out.println(C);

		int a = 20;
		a = 30;
		System.out.println(a);

		float result = (float) (3.3 + 4.5);
		System.out.println(result);

		System.out.printf("정수는 %d 실수는 %f ", 10,20.33);
		
		System.out.println(3147483647L + 3147483648L);
		System.out.println(3.4*100000000);
		

	}

}
