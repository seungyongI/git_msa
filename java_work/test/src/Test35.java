import java.io.*;
import java.util.*;

public class Test35 {
    public static void main(String[] args) throws IOException{
        BufferedReader br
                = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw
                = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");
        int v = Integer.parseInt(br.readLine());
        int cnt = 0;
        int num = 0;

        for(int i = 0; i < n; i++) {
            num = Integer.parseInt(arr[i]);

            if(v == num) {
                cnt++;
            }
        }
        bw.write("" + cnt);

        bw.flush();
        bw.close();
        br.close();
    }
}
