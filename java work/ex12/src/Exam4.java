//    4. 문자열을 입력받아 거꾸로 출력하는 프로그램을 작성해보자
//    예)
//     입력 abcdef
//     출력 fedcba
//
//     입력 안녕하세요
//     출력 요세하녕안

import java.util.Scanner;

public class Exam4 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("문자열을 입력하세요.");
        String a = scan.nextLine();

        System.out.println("문자열을 문자배열로 변환 중...");
        char[] chars = a.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            System.out.print(chars[i]+" ");
        }
        System.out.println();
        System.out.println("거꾸로 변환 중...");

        for (int i = chars.length-1; i >= 0; i--) {
            System.out.print(chars[i]+" ");
        }



    }

}
