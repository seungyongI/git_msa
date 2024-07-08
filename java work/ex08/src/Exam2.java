//2.  프로그램 사용자로부터 초(second)를 입력받은 후에,
//이를 [시, 분, 초]의 형태로 출력하는 프로그램을 작성해 보자.

import java.util.Scanner;

public class Exam2 {

    public static void main(String[] args) {
        Scanner second = new Scanner(System.in);

        int a = second.nextInt();

        System.out.println(a);

        if (a >= 3600) {
            System.out.println(a / 3600 + "시" + a % 3600 / 60 + "분" + a % 3600 % 60 + "초");
        } else if (360 <= a && a <= 3600) {
            System.out.println(a / 3600 + "시" + a % 3600 / 60 + "분" + a % 3600 % 60 + "초");
        } else {
            System.out.println(a / 3600 + "시" + a % 3600 / 60 + "분" + a % 3600 % 60 + "초");
        }
    }

}
