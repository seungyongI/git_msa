package ex03;

public class Ex04 {

	public static void main(String[] args) {
		//계산 시에는 시스템에서 int로 인식하기에 short같은 걸로 코드를 하면 데이터 소실이 생김
		//int > short
		//강제 형변환
		int num1 = 10;
		short num2 = (short) num1;
		
		//자동 형변환
		short num3 = 20;
		int num4 = num3;
		
		short kk = 20;
		double aa =10.03;
		

	}
}
