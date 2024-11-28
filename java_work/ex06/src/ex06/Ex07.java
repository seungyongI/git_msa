package ex06;

public class Ex07 {

	public static void main(String[] args) {
		int result = doA(4);
		String temp = doB("안녕하세요");
		System.out.println(doA(4));
		System.out.println(doB("안녕하세요"));

		System.out.println(doA(4));
		System.out.println(doB("안녕하세요"));
	}

	public static int doA(int num) {
		return num * num;
	}

	public static String doB(String str) {
		return str + str;
	}
}
