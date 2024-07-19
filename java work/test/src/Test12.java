public class Test12 {
    public static int solution(int n) {
        int answer = 0;
        for (int i = 0; i <= n; i++) {
            if (i % 2 == 0) {
                i+=i;
                answer = i;
            }
        }
        return answer;
    }


public static void main(String[] args) {
    int result = solution(10);
    System.out.println(result);
}
}
