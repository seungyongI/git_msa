//4.  두 개의 정수를 입력받아서 최대 공약수(GCD)를 구하는 프로그램을 작성해 보자.

import java.util.Scanner;

public class Exam4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("첫 번째 수를 입력하세요");
        int a = scan.nextInt();
        System.out.println("두 번째 수를 입력하세요");
        int b = scan.nextInt();
        int c = 0;

        System.out.println("a="+a);
        System.out.println("b="+b);

        for (int i = 1; i < 100; i++) {
            if (a%i==0 && b%i==0){
                System.out.print("약수="+i+"\t");
                c = i;
            }
        }
                System.out.println();
            System.out.println("최대공약수="+c);
    }
}
