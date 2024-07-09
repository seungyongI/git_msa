import java.util.Scanner;

/* 1. 가위 바위 보 게임을 만들어 보자.

사용자로부터 가위 바위 보 중에서 하나를 입력 받는다.
그리고 컴퓨터는 난수 생성을 통해서 가위 바위 보 중에서 하나를 선택하게 한다.
 이 둘을 비교해서 승자와 패자를 가려주는 프로그램을 작성해 보자.
단 프로그램의 진행은 사용자가 질 때까지 계속되어야 하고,
마지막에 가서는 게임의 결과(예: 4승 3무)까지 출력해 주도록 하자. */
public class Exam {
    public static void main(String[] args) {
        System.out.println("가위 바위 보");
        Scanner scan = new Scanner(System.in);

        int PC = 0;
        int a = 0;
        int b = 0;
        int c = 0;

        /**
         * 가위 바위 보
         *  1   2   3
         *
         *  나   컴
         *  1    2   lose  -1
         *  2    3   lose  -1
         *  3    1   lose   2
         *
         *  == draw
         */

//        String user;
//
//        user = scan.next();

//        int resutln[] = {0,0,0};

        while (true) {
            String user = scan.next();
            System.out.println("USER = " + user);
            PC = (int) (Math.random() * 6);
            if (user.equals("가위") && 0 <= PC && PC <= 1) {
                System.out.println("PC = 바위");
                System.out.println("패배");
                c++;
                break;
            } else if (user.equals("가위") && 2 <= PC && PC <= 3) {
                System.out.println("PC = 가위");
                System.out.println("무승부");
                b++;
            } else if (user.equals("가위") && 4 <= PC && PC <= 6) {
                System.out.println("PC = 보");
                System.out.println("승리");
                a++;
            } else if (user.equals("바위") && 0 <= PC && PC <= 1) {
                System.out.println("PC = 바위");
                System.out.println("무승부");
                b++;
            } else if (user.equals("바위") && 2 <= PC && PC <= 3) {
                System.out.println("PC = 가위");
                System.out.println("승리");
                a++;
            } else if (user.equals("바위") && 4 <= PC && PC <= 6) {
                System.out.println("PC = 보");
                System.out.println("패배");
                c++;
                break;
            } else if (user.equals("보") && 0 <= PC && PC <= 1) {
                System.out.println("PC = 바위");
                System.out.println("승리");
                a++;
            } else if (user.equals("보") && 2 <= PC && PC <= 3) {
                System.out.println("PC = 가위");
                System.out.println("패배");
                c++;
                break;
            }
            if (user.equals("보") && 4 <= PC && PC <= 6) {
                System.out.println("PC = 보");
                System.out.println("무승부");
                b++;
            }
        }
        System.out.println(a+"승"+b+"무"+c+"패");
    }


}
