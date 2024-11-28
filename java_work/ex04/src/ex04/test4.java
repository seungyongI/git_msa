//아래는 변수 num의 값 중에서 백의 자리 이하를 버리는 코드이다. 만일 변수 num의 값이
//456 이라면 400이 되고 111이라면 100이 된다. (1)에 알맞은 코드를 구하시오.

package ex04;

public class test4 {

	public static void main(String[] args) {
		int num = 456;

		int result = (num / 100) * 100;
		System.out.println(result);
		
		
	}

}
