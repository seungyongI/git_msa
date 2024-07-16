//1. 배열 [10,20,30,40,50] 알맞은 코드를 넣어 총합과 평균을 구하세요

public class Exam {
    public static void main(String[] args) {
        int[] a = {10, 20, 30, 40, 50};
        int sum = 0;

        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        System.out.println("배열에 속한 수의 총합을 구합니다.");
        System.out.println("총합 = " + sum);

        System.out.println("배열에 속한 수의 평균을 구합니다.");
        System.out.println("평균 = " + sum / a.length);
//        딱 맞아 나눠지지 않는 수는 나누는 수를 더블로 형변환 하고 나눈 뒤 결과값을 int로 형변환
//        System.out.println((int) (sum / (double) a.length));
    }
}
