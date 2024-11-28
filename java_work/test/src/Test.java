import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Character.isLowerCase;
import static java.lang.Character.toChars;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        char[] chars = a.toCharArray();
        for (int i = 0; i < a.length(); i++) {
            if ((int) 'a' <= (int) chars[i] && (int) chars[i] <= (int) 'z') {
                chars[i] -= 32;
            } else {
                chars[i] += 32;
            }
            System.out.print(chars[i]);
        }

//        System.out.println((int) 'a');
//        System.out.println((int) 'z');
//
//        System.out.println((int) 'A');
//        System.out.println((int) 'Z');

//        System.out.println();
    }
}