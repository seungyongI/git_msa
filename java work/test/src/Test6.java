//n의 배수
public class Test6 {
    public static int solution(int num, int n) {
        int answer = num % n == 0 ? 1 : 0;

        return answer;
    }

    public static void main(String[] args) {
        int result = solution(34, 3);
        System.out.println(result);
    }
}
