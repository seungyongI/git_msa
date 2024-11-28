public class FF {

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            double result = Math.random() * 100;

            if (result < 36)
            System.out.println((int) result);
        }


    }
}
