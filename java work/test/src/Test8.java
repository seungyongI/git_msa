import java.util.stream.IntStream;

//홀짝에 따른 다른 값 반환하기
public class Test8 {
    public static int solution(int n) {
        int answer;
        if (n % 2 == 0) {
            answer = IntStream.rangeClosed(1, n)
                    .filter(data -> data % 2 == 0)
                    .map(data1 -> data1 * data1)
                    .sum();
        } else {
            answer = IntStream.rangeClosed(1, n)
                    .filter(data1 -> data1 % 2 != 0)
                    .sum();
        }
        return answer;
    }

    public static void main(String[] args) {
        int result = solution(10);
        System.out.println(result);
    }
}