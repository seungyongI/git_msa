package exam;

import java.util.Scanner;

public class Ex01 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        double doubleValue = scan.nextDouble();
        int intValue = (int) (doubleValue * 100);
        System.out.println(intValue);
        System.out.println(intValue / (double) 100);

    }
}
