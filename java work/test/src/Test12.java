public class Test12 {
    public static int solution(int[] numbers) {
        int answer = 0;
        int max = 0;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (max < (numbers[i] * numbers[j])) {
                    max = numbers[i] * numbers[j];
                }
            }
        }
        answer = max;

        return answer;
    }


    public static void main(String[] args) {
        int[] num = {1, 2, 3, 4, 5};

        int result = solution(num);
        System.out.println(result);
    }
}
