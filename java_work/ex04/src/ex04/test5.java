//아래는 화씨(F)를 섭씨(C)로 변환하는 코드이다.
//변환공식이 'C = (F-32)/1.8' 라고 할 때 (1)에 알맞은 코드를 넣으시오.
//단, 변환 결과값은 소수형 셋째자리에서 반올림해야 한다.(형변환 이용)

package ex04;

public class test5 {

	public static void main(String[] args) {

		int F = 100;
		float C = (float) ((F - 32) / 1.8);

		System.out.println("F=" + F);
		System.out.println("C=" + C);
		//연산에 실수와 정수가 만나면 둘 다 실수로 형변환 됨.
		System.out.println(((int)(C*100))/(double)100);
//		System.out.println(Math.ceil(C) - 0.23);
	}

}
