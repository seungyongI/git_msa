public class II {
    public static void main(String[] args) {

        for (int a = 1; a < 6; a++) {

            for (int b = 1; b < 6; b++) {
                int num = a + b;

                if (num == 6) {
                    System.out.println("첫 번째 주사위= " + a);
                    System.out.println("두 번째 주사위= " + b);
                }
            }
        }
    }
}


