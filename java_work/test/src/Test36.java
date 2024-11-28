import java.io.*;

public class Test36 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int max = 0;
        int num = 0;
        int min = 0;

        for(int i = 0; i < n; i++) {
            num = Integer.parseInt(input[i]);
            min = Integer.parseInt(input[0]);
            max = Integer.parseInt(input[0]);

            if(num > max) {
                max = num;
            }
            if(num < min) {
                min = num;
            }
        }
        bw.write(min+" "+max);
        bw.flush();
        bw.close();
        br.close();
    }
}
