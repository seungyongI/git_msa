import java.util.*;
import java.io.*;

public class Test34 {
    public static void main(String[] args) throws IOException{
        BufferedReader br
                = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw
                = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            for(int j = n-1; j > i; j--) {
                bw.write(" ");
            }
            for (int k = 0; k <= i; k++) {
                bw.write("*");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();

    }
}
