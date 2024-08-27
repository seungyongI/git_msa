import java.io.*;
import java.util.*;

public class Test40 {
    public static void main(String[] args) throws IOException {
        BufferedReader br
                = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw
                = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] arr = new int[29];
        int[] no = new int[2];
        List<Integer> list = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        for (int i = 1; i < 29; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            list.add(arr[i]);
        }

        for (int i = 1; i <= 30; i++) {
            list2.add(i);
        }

        for (int j = 0; j < list.size(); j++) {
            for (int i = 0; i < list2.size(); i++) {
                if (list2.get(i) == list.get(j)) {
                    list2.remove(i);
                }
            }
        }
        System.out.println("list = " + list2);

        for (int i = 0; i < 2; i++) {
            no[i] = list2.get(i);
        }

        if (no[0] > no[1]) {
            bw.write(no[1] + "\n");
            bw.write(no[0] + "");
        } else {
            bw.write(no[0] + "\n");
            bw.write(no[1] + "");
        }

        bw.flush();
        bw.close();
        br.close();

    }
}
