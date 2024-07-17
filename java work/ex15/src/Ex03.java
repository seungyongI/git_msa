public class Ex03 {

    public static void main(String[] args) {
        String str1 = "String";
        String str2 = new String("new String");

        showString(str1);
        showString(str2);
        showString("Funny String");
    }

    public static void showString(String str) {
        System.out.println(str);
        System.out.println(str.length());
        System.out.println();
    }
}
