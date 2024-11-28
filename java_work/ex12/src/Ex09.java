import java.util.Arrays;

public class Ex09 {
    public static void main(String[] args) {

        String[] str = {"aa", "bb", "cc"};

        for (String temp : str) {
            System.out.println(temp);
        }

        int[] ar = {1, 2, 3, 4, 5};

        System.out.println(Arrays.toString(ar));

        for (int i = 0; i < ar.length; i++) {
            System.out.print(ar[i] + "\t");
        }

        System.out.println();

        for (int e : ar) {
            System.out.println(e);
        }
    }
}
