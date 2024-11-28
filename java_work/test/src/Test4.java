import java.util.Arrays;
//문자열 곱하기
public class Test4 {
    public static String solution(String my_string, int k) {
        String answer = "";
        for (int i = 0; i < k; i++) {
            answer += my_string;
        }
        return answer;
    }

    public static void main(String[] args) {
       String result = solution("string", 3);
        System.out.println(result);
    }
}
