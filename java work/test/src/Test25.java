import java.util.ArrayList;
import java.util.Arrays;

public class Test25 {

    public static void main(String[] args) {
        boolean[] arr = new boolean[102];

        Arrays.fill(arr, true);

        arr[0] = false;
        arr[1] = false;

        ArrayList<Integer> primeArr = new ArrayList<>();

        for (int i = 2; i < arr.length; i++) {
            if (arr[i] == true) {
                primeArr.add(i);
                for (int j = i+i; j < arr.length; j+=i) {
                    arr[j] = false;
                }
            }
        }

        for (int i : primeArr) {
            System.out.print(i + " ");
        }
    }
}
