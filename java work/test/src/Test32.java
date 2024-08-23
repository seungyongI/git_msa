import java.io.*;

public class Test32 {
    public static void main(String[] args) {
        try {
            BufferedReader br
                    = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw
                    = new BufferedWriter(new OutputStreamWriter(System.out));

            int t = Integer.parseInt(br.readLine());

            for (int i = 0; i < t; i++) {
                int a = Integer.parseInt(br.readLine());
                int b = Integer.parseInt(br.readLine());

                bw.write(a + b + "\n");
            }
            bw.flush();
            bw.close();
            br.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
