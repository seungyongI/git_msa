import java.io.*;
import java.util.StringTokenizer;

public class Test33 {
        public static void main(String[] args) throws IOException{
            BufferedReader br
                    = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw
                    = new BufferedWriter(new OutputStreamWriter(System.out));

            int t = Integer.parseInt(br.readLine());

            for(int x = 1; x <= t; x++) {
                StringTokenizer st
                        = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = a+b;

                bw.write("Case #"+x+": "+a+" + "+b+" = "+c);
            }
            bw.flush();
            bw.close();
            br.close();

        }
    }
