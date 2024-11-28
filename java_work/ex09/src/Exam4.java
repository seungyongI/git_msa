public class Exam4 {
    public static void main(String[] args) {
        int sum = 0;
        int num = 0;

        for (int k = 0; k <= 9; k += 3) {

            for (int i = 1; i <= 3; i++) {

                for (int j = 2; j <= 4; j++) {
                    sum = i * j;
                    num = j + k;
                    if (num < 10) {
                        System.out.print(num + " * " + i + " = " + sum + "\t");
                    }
                }
                System.out.println("\t");
            }
            System.out.println();
        }

    }
}
