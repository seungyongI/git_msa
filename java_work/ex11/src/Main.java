import java.util.Scanner;

class Fact {
    public int fact(int num) {
        System.out.println("여기오나" + num);

//      메서드는 반환값을 적게 되면 반환값이 무조건 있어야 한다.

        if (num > 0) {
            return 2 * fact(num - 1);

            //2*fact(2)
            //2* 2* fact(1)
            //2* 2* 2* fact(0)


        } else {
            return 1;
        }
    }
}

//2*2*2 num3
//2*2*2*2 num4

public class Main {
    public static void main(String[] args) {
        /*
        String -> int = Integer.parseInt
        int -> String = 10+"";
        문자열 입력 scan.nextLine
        숫자열 입력 scan.nextInt
         */
        Scanner scanner = new Scanner(System.in);
        System.out.println("몇 승 구할래?");

        String a = scanner.nextLine();
        int num = Integer.parseInt(a);

        Fact fact = new Fact();
        int result = fact.fact(num);
        System.out.println("2의 "+num+"승은 = "+ result);

//        System.out.println(a);
//        System.out.println(num);
//        int num = scanner.nextInt();

        //클래스의 정의와 인스턴스화

    }
}