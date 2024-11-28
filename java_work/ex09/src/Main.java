import java.util.Scanner;
import aa.bb.Fact;

public class Main {
    public static void main(String[] args) {
        //입력받는 변수 선언
        Scanner scan = new Scanner(System.in);

        System.out.println("숫자입력");
        int result = scan.nextInt();

        Fact fact1 = new Fact();
        int retValue = fact1.aa(result);

        System.out.println("result="+result);
        System.out.println("retValue="+retValue);

        result = fact1.aa(5);
        System.out.println(result);
    }
}