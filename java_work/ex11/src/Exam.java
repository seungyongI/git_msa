/*
1. 길이가 10인 배열을 선언하고 총 10개의 정수를 입력받아서,
홀수와 짝수를 구분 지어 출력하는 프로그램을 작성해 보자.
일단 홀수부터 출력하고 나서 짝수를 출력하도록 하자.
단, 10개의 정수는 main 함수 내에서 입력받도록 하고,
배열 내에 존재하는 홀수만 출력하는 함수와 배열 내에 존재하는 짝수만 출력하는 함수를 각각 정의해서
 이 두 함수를 호출하는 방식으로 프로그램을 완성하자.
 */

import java.util.Scanner;

public class Exam {

    public static String hol(int[] a) {

        String result = "";

        for (int i = 0; i < a.length; i++) {
            if (a[i] % 2 != 0) {
//                System.out.print(a[i] + "\t");
                 result = result +"\t"+ a[i];
            }
        }
//        System.out.println();

        return result;
    }
// f(x)=x+3
// x=3
// f(3)=6
// a=f(x)=6
// a=6

    public static String jjak(int[] a) {
        String result2 = "";

        for (int i = 0; i < a.length; i++) {
            if (a[i] % 2 == 0) {
//                System.out.print(a[i] + "\t");
                result2 = result2 + "\t"+a[i];
            }
        }
        return result2;

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] a = new int[10];
        for (int i = 0; i < a.length; i++) {
            a[i] = scan.nextInt();
            System.out.println(a[i]);
        }
        hol(a);
        jjak(a);

        System.out.println("홀수는 "+hol(a));
        System.out.println("짝수는 "+jjak(a));

//        String str = hol(a);
//        String str2 = jjak(a);

//        System.out.print(str+" \t\n");
//        System.out.print(str2+"\t");
    }

}
