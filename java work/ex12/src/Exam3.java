//3. 프로그램 사용자로부터 10진수 형태로 정수를 하나 입력받은 다음, 이를 2진수로 변환해서 출력하는 프로그램을 작성해 보자.

import java.util.Scanner;

public class Exam3 {

    //스트링에 문자열을 하나하나 넣으면 지 알아서 더한다.
    //입력받은 숫자를 2로 계속 나눠서 나머지를 뒤집는다.
    //피보나치 수열 하듯이

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("정수를 입력하세요.");
        int a = scan.nextInt();
        String str = "";

//        while (a > 0) {
//            int result = a / 2;
//            if (a % 2 == 0) {
//                System.out.println("0");
//                str += "0";
//
//            } else {
//                System.out.println("1");
//                str += "1";
//            }
//            a = result;
//        }

        while (a > 0) {
            int result = a / 2;
            if (result * 2 == a) {
                System.out.println("0");
                str = str + "0";
            } else if (result * 2 != a) {
                System.out.println("1");
                str = str + "1";
            }
            a = result;
        }

        System.out.println("str  = " + str);
        char[] chars = str.toCharArray();

        for (int i = chars.length - 1; i >= 0; i--) {
            System.out.print(chars[i]);
        }

    }

}
