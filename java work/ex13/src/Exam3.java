import java.util.Arrays;

/*
3. 다음은 answer 배열 에 담긴 데이터를 읽고 각 숫자의 개수를 세어서 개수만큼 ‘*’을 찍어서
    그래프를 그리는 프로그램이다 에 알맞은 코드를 넣어서 완성하시오 .
    int[] answer = { 1,4,4,3,1,4,4,2,1,3,2}
    실행결과
    1***
    2**
    3**
    4****
 */
public class Exam3 {
    public static void main(String[] args) {

        /*
        i번째 들어가는 수들을 카운팅 해서 그 수만큼 별을 출력하는 배열 생성해야 됨
         */
        int[] answer = {1, 4, 4, 3, 1, 4, 4, 2, 1, 3, 2, 9};
        System.out.println(Arrays.toString(answer));
        for (int i = 1; i < 10; i++) {
            String str = "";
            for (int j = 0; j < answer.length; j++) {
                if (i == answer[j]) {
                    str += "*";
                }
            }
            if (!str.equals("")) {
                System.out.println("수의 갯수만큼 *을 추가합니다.");
                System.out.println(i + str);
            }
        }
    }
}
