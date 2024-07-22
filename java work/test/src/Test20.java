import java.util.Arrays;

public class Test20 {

    public static int[] solution(int money) {
        int[] answer = new int[2];
        int ice = 5500;
        answer[0] = money / ice;
        answer[1] = money % ice;

        return answer;
    }

    public static void main(String[] args) {
        int[] result = solution(5500);
        System.out.println(Arrays.toString(result));
    }
}
