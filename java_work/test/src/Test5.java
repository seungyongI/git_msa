
public class Test5 {
    public static int solution(int a, int b) {
        int answer = 0;
        int answer1 = Integer.parseInt(Integer.toString(a) + Integer.toString(b));
        int answer2 = Integer.parseInt(Integer.toString(b) + Integer.toString(a));
        if (answer1 >= answer2) {
            answer = answer1;
        } else {
            answer = answer2;
        }
        return answer;
    }

    public static void main(String[] args) {
        int result = solution(9, 91);
        System.out.println(result);
    }
}
