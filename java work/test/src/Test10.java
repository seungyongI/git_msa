public class Test10 {
    public static int solution(int a, int b, boolean flag) {
        int answer = 0;
        if (flag == true) {
            answer = a + b;
        } else {
            answer = a - b;
        }
        return answer;
    }

    public static void main(String[] args) {
        int result = solution(-4, 7, false);
        System.out.println(result);
    }

}
