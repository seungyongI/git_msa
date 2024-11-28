import java.util.Arrays;

public class Test21 {

    public static int[] solution(int[] numbers, int num1, int num2) {
        int[] answer = new int[numbers.length];
        answer = Arrays.copyOfRange(numbers, num1, num2 + 1);

        return answer;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 3, 5};
        int[] result = solution(numbers, 1, 2);
        System.out.println(Arrays.toString(result));
    }
}