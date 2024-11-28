//공배수
public class Test7 {
    public static int solution(int number, int n, int m) {
        int answer = number%n==0 && number%m==0 ? 1 : 0;
        return answer;
    }

    public static void main(String[] args) {
        int result = solution(60,2,3);
        System.out.println(result);
    }
}
