import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("그린 2024");
        System.out.println("시작하기 (Y/N)");
        Scanner scan = new Scanner(System.in);
        String ctn = scan.nextLine();

        if (ctn.equals("Y") || ctn.equals("y")) {
            System.out.println("새 게임을 하시겠습니까? (Y/N)");
            String a = scan.nextLine();
            if (a.equals("Y") || a.equals("y")) {
                System.out.println("사용자 이름을 입력하세요.");
                String name = scan.nextLine();
                System.out.println(name + "님 성별을 선택하세요(남/여)");
                String s = scan.nextLine();
                if (s.equals("남")) {
                    System.out.println("남성을 선택하였습니다.");
                } else if (s.equals("여")) {
                    System.out.println("여성을 선택하였습니다.");
                } else {
                    System.out.println("다시 입력하세요.");
                }
            }else {
                System.out.println("기존 계정을 입력하세요.");
                String b = scan.nextLine();
                System.out.println("저장된 데이터를 불러옵니다.");
            }
        }
    else

        {
            System.out.println("게임이 종료됩니다.");
        }
    }

}