public class Test15 {
    public static int[] solution(int[] numbers) {
        int[] answer =new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            answer[i] = numbers[i]*2;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,5};
        int[] result = solution(numbers);
        for (int e : result){
            System.out.println(e);
        }

    }
}
