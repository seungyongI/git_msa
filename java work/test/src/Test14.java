public class Test14 {

    public static int solution(int[] array, int height) {
        int answer = 0;
        int friend = 0;
        for (int i = 0; i < array.length; i++) {
            if (height < array[i]) {
                friend++;
            }
        }
        answer = friend;

        return answer;
    }

    public static void main(String[] args) {
        int[] array = {149,180,192,170};
        int result = solution(array, 167);
    }
}
