import java.util.StringTokenizer;

public class Test31 {
    public static void main(String[] args) {
        StringTokenizer st = new StringTokenizer("1 2", " ");
//        String string = st.nextToken();
//        System.out.println(string);
//        String str = st.nextToken();
//        System.out.println(str);

        while(st.hasMoreTokens()){
            System.out.println(st.nextToken());



        }
    }
}
