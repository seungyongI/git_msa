public class Test18 {

    public static int solution(int n) {
        int answer = 0;
        answer = n % 7 == 0 ? (n / 7) : (n / 7)+1;

        return answer;
    }

    public static void main(String[] args) {
        int result = solution(1);
        System.out.println(result);
    }
}
