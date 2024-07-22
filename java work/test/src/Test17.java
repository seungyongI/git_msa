import java.util.Arrays;

public class Test17 {

    public static int[] solution(int n) {
        int[] answer = {};
        int a = 0;

        if (n % 2 == 0) {
            answer = new int[n / 2];
        } else {
            answer = new int[n / 2 + 1];
        }

        for (int i = 0; i <= n; i++) {
            if (i % 2 == 1) {
                answer[a] = i;
                a++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] result = solution(10);
        System.out.println(Arrays.toString(result));
    }
}
