//1.두 개의 주사위 던졌을 때, 눈의 합이 6이 되는 모든 경우의 수를 출력하는 프로그램을 작성하시오.
//2. Math.random을 이용해서 1부터 6사이의 임의의 정수를 변수 value에 저장하는 코드를 완성하여라.
//        (1)에 알맞은 코드를 넣으세요.
//1,2번 다 풀었으면 함수로 해주세요.


public class GG {

    public static void main(String[] args) {

        for (int i = 1; i < 11; i++) {
            double result = Math.random() * 10;
            int value = ((int) result);

            if (1 <= result && result <= 6) {
                System.out.println("value =" + value);
            }
        }

//        for (int i = 1; i < 2; i++) {
//            int result = (int)(Math.random() * 6 + 1);
//            int value = (result);
//
//            System.out.println("value =" + value);
//        }


    }
}
