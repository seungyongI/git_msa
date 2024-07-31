import java.util.Arrays;

public class Test22 {

    public static int[] solution(int[] num_list) {
        int[] answer = new int[num_list.length];
        int n = 0;
        for (int i = num_list.length-1; i >= 0; i--) {
            answer[n] = num_list[i];
            n++;
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] num_list = {1,2,3,4,5};
        int[] result = solution(num_list);
        System.out.println(Arrays.toString(result));

    }

}
