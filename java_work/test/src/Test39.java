import java.io.*;

public class Test39 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] sarr = br.readLine().split(" ");
        int n = Integer.parseInt(sarr[0]);
        int m = Integer.parseInt(sarr[1]);
        int[] box = new int[n+1];
        int num = 0;

        for(int s = 1; s <= n; s++){
            box[s] = s;
        }

        for(int k = 0; k < m; k++) {
            String[] arr = br.readLine().split(" ");
            int i = Integer.parseInt(arr[0]);
            int j = Integer.parseInt(arr[1]);

            num = box[i];
            box[i] = box[j];
            box[j] = num;

        }
        for(int i = 1; i <= n; i++) {
            bw.write(box[i] + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
