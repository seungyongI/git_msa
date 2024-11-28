public class Test13 {

    public static int solution(int[] array, int n) {
        int answer = 0;
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == n) {
                sum++;
            }
        }
        answer = sum;
        return answer;
    }

    public static void main(String[] args) {
        int[] array = {1,1,2,3,4,5};
        int result = solution(array,1);
        System.out.println(result);
    }
}
