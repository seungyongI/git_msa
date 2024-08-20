import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int min1 = 100;
        int min2 = 100;
        int N = scan.nextInt();
        int M = scan.nextInt();
        String[][] sarr = new String[N][M];
        int x = 0;
        String[][] sarr2 = new String[8][8];
        String[][] sarr1 = new String[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i % 2 == 0 && j % 2 == 0) {
                    sarr2[i][j] = "B";
                } else if (i % 2 == 0 && j % 2 != 0) {
                    sarr2[i][j] = "W";
                } else if (i % 2 != 0 && j % 2 == 0) {
                    sarr2[i][j] = "W";
                } else {
                    sarr2[i][j] = "B";
                }
            }
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i % 2 == 0 && j % 2 == 0) {
                    sarr1[i][j] = "W";
                } else if (i % 2 == 0 && j % 2 != 0) {
                    sarr1[i][j] = "B";
                } else if (i % 2 != 0 && j % 2 == 0) {
                    sarr1[i][j] = "B";
                } else {
                    sarr1[i][j] = "W";
                }
            }
        }
        for (int i = 0; i < N - 8; i++) {

            for (int j = 0; j < M - 8; j++) {
                x = 0;
                for (int k = i; k < i + 8; k++) {
                    for (int l = j; l < j + 8; l++) {
                        if (!sarr[k][l].equals(sarr2[k][l])) {
                            x++;
                        }
                    }
                }
                if (min2 > x) {
                    min1 = x;
                }
            }
        }
        for (int i = 0; i < N - 8; i++) {

            for (int j = 0; j < M - 8; j++) {
                x = 0;
                for (int k = i; k < i + 8; k++) {
                    for (int l = j; l < j + 8; l++) {
                        if (!sarr[k][l].equals(sarr1[k][l])) {
                            x++;
                        }
                    }
                }
                if (min2 > x) {
                    min2 = x;
                }
            }
        }
        if (min1 < min2) {
            System.out.println(min1);
        } else System.out.println(min2);

    }
}