import java.io.*;
import java.util.*;

public class Test38 {
    public static void main(String[] args) throws IOException {
        BufferedReader br
                = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw
                = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] sarr = br.readLine().split(" ");
        int n = Integer.parseInt(sarr[0]);
        int m = Integer.parseInt(sarr[1]);
        int[] box = new int[n];

        for(int temp = 0; temp < m; temp++) {
            String[] arr = br.readLine().split(" ");
            int i = Integer.parseInt(arr[0]);
            int j = Integer.parseInt(arr[1]);
            int k = Integer.parseInt(arr[2]);

            for(int t = i; t<=j; t++) {
                box[t-1] = k;
            }
        }
        for(int i : box){
            bw.write(i+" ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
