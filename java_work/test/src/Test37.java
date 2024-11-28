import java.util.Scanner;

public class Test37 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[] ball = new int[n];

        for(int k = 0; k < m+1; k++) {
            int i = scan.nextInt();
            int j = scan.nextInt();

            ball[i-1] = i;
            ball[j-1] = j;
            ball[i-1] = ball[j-1];
            ball[j-1] = ball[i-1];

        }
        for(int s = 0; s < n; s++) {
            System.out.print(ball[s]+" ");
        }

    }
}
