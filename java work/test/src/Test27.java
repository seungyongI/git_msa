public class Test27 {

    public static int solution(int n, int k) {
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 10 == 0) {
                k--;
            }
        }
        answer = 12000 * n + 2000 * k;

        return answer;
    }

    public static void main(String[] args) {
        int result = solution(64, 6);
        System.out.println(result);
    }
}
