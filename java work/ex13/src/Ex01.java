import java.util.Arrays;

public class Ex01 {

    /*2차원 배열은
    1차원 배열의 묶음이다.

    3차원 배열은
    2차원 배열의 묶음이다.
     */
    public static void main(String[] args) {
        
        //배열이 [][] 형식이면 2차원 배열이며 순서대로 [행][열]을 의미함
        int[][] num = new int[4][3];
        //여기서 출력하는 length는 행을 출력함
        System.out.println(num.length);
        System.out.println(num[0].length);
        System.out.println(num[1].length);
        System.out.println(num[2].length);
        System.out.println(num[3].length);

        //2차원 배열에 값 입력하는 기본적인 식
        int a = 0;
        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < num[i].length; j++) {
                num[i][j] = a++;
            }
        }
        
        //2차원 배열 출력하는 기본적인 식
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(num[i][j]+"\t");
            }
            System.out.println();
        }

        System.out.println(a);
        //문자열로 변환하여 출력하는 식
        System.out.println(Arrays.toString(num[0]));
        System.out.println(Arrays.toString(num[1]));
        System.out.println(Arrays.toString(num[2]));
        System.out.println(Arrays.toString(num[3]));
        
        Arrays.fill(num[0], 20);
        System.out.println(Arrays.toString(num[0]));
        System.out.println(Arrays.toString(num[1]));
        System.out.println(Arrays.toString(num[2]));
        System.out.println(Arrays.toString(num[3]));
    }
}
