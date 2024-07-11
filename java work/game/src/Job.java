import java.util.Scanner;

public class Job {
    public static String chooseJob(String job) {
        Scanner scan = new Scanner(System.in);
        System.out.println("전사, 궁수, 마법사, 해적");
        job = scan.nextLine();

        if (job == "전사") {
            System.out.println("검 종류를 선택하세요");
        } else if (job == "궁수") {
            System.out.println("활 종류를 선택하세요");
        } else if (job == "마법사") {
            System.out.println("스태프 종류를 선택하세요");
        }else {
            System.out.println("총 종류를 선택하세요");
        }
        return job;
    }
}
