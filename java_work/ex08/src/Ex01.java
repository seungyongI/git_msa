public class Ex01 {
    public static void main(String[] args) {
        /*  주사위 눈의 합이 6이 되는 모든 경우의 수를 출력하는 프로그램
         * */
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5; j++) {
                if ((i + j) == 6) {
                    System.out.print("i="+i+" ");
                    System.out.println("j="+j);
                }
            }
        }
    }
}
