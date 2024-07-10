//1.  2의 n승을 구하는 함수를 재귀적으로 구현해 보자.
//그리고 그에 따른 적절한 함수를 구현해 보자.
//참고로 재귀 함수의 구현이 처음에는 어려운 편이기 때문에 여기서는 쉬운 문제를 제시하였다

//2.  프로그램 사용자로부터 초(second)를 입력받은 후에,
//이를 [시, 분, 초]의 형태로 출력하는 프로그램을 작성해 보자.

//3.  필자가 좋아하는 것 중 하나가 금요일 저녁 퇴근길에 DVD나 만화책을 잔뜩 빌리고,
//동네 슈퍼에 들러서 군것질거리를 사 가지고 집에 들어가는 것이다.
//오늘은 금요일이다. 현재 필자의 주머니에는 5천 원이 있다.
//DVD 한 편을 빌리면 3,500원이 남는다.
//슈퍼에 들려서 크림빵(500원), 새우깡(700원), 콜라(400원)를 사려한다.
//잔돈을 하나도 남기지 않고 이 세 가지 물건을 하나 이상 반드시 구매하려면
//어떻게 구매를 진행해야 하겠는가? 물론 여기에는 여러 가지 경우의 수가 있을 것이다.

//필자가 어떠한 선택을 할 수 있는지 여러분이 제시해 주기 바란다.

//4.  두 개의 정수를 입력받아서 최대 공약수(GCD)를 구하는 프로그램을 작성해 보자.

//-----------------------------------------------------------------------------------
//5. 다음 방정식 의 모든 해를 구하시오 단 x 와 y는 정수이고
// 각각의 범위는 0<=x<=10, 0<=y<=10.
// 2x+4y=10일 때 x y 값을 구하여라.
//2x = 10-4y / x = 5-2y
//4y = 10-2x / 2y = 5-x

public class Ex06 {
    public static void main(String[] args) {
        int num = 1;

        for (int x = 0; x <= 10; x++) {

            for (int y = 0; y <= 10; y++) {

                if (x == 5 - (2 * y)) {
                    System.out.print(num +"번째 x = " + x + "\t");
                    System.out.print(num +"번째 y = " + y + "\t");
                    num++;
                    break;
                }
            }
            System.out.println();
        }

    }
}
