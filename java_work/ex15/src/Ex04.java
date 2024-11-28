public class Ex04 {

    public static void main(String[] args) {
        String str1 = "new String";
        String str2 = "new String";

        System.out.println(str1 == str2 ? "동일 인스턴스 참조" : "다른 인스턴스 참조");

        String str3 = new String("new String");
        String str4 = new String("new String");

        System.out.println(str3 == str4 ? "동일 인스턴스 참조" : "다른 인스턴스 참조");
        System.out.println(str3.equals(str4));


    }
}
