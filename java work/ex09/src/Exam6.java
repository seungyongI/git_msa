public class Exam6 {
    public static void main(String[] args) {
        int sum = 0;
        int num = 0;
        for (int i = 1; i <= 10; i++) {
            for (int j = 2; j <= i; j++) {
                sum = sum + j;
            }

        }
        System.out.print(sum);
        System.out.println();
    }
}
