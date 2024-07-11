public class Ex06 {
    public static void main(String[] args) {
        /*
        주어진 과제
        String -> char[]
        char[] -> String
         */
        //문자열
        String str = "우리는 할 수 있다.";

        //문자배열
        char[] chars = str.toCharArray();

        System.out.print(chars[0]);
        System.out.print(chars[1]);
        System.out.print(chars[2]);
        System.out.print(chars[3]);
        System.out.print(chars[4]);
        System.out.print(chars[5]);
        System.out.print(chars[6]);
        System.out.print(chars[7]);
        System.out.print(chars[8]);
        System.out.print(chars[9]);
        System.out.print(chars[10]);
        System.out.println("\n");

        chars[4] = 'A';
        System.out.println(chars[4]);

        String aa = new String(chars);
        System.out.println(aa);

    }
}
