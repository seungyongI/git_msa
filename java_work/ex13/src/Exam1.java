/*
1. 문자열을 입력받아 시계방향으로 90도 돌려서 아래 입출력 예와 같이 출력하는 코드를 작성해 보세요.
    제한사항 1<= str의 길이 <=10
    입력 #1
    abcde
    출력
    a
    b
    c
    d
    e
 */
import java.util.Scanner;

public class Exam1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str;
        str = scan.nextLine();
        System.out.println(str);

        char[] chars = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            System.out.println(chars[i]);
        }
    }


}
