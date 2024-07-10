class A {
}


public class Ex01 {

    public static void main(String[] args) {
        A a = new A();
        A b = a;

        System.out.println(a == b);

        //int double float
        //String => class
        String str1 = new String("Happy");
//        String str2 = "Birthday";
        String str2 = "Happy";
        String str3 = "Happy";
//      문자열 비교 .equals
        System.out.println(str1 + " " + str2);
        System.out.println(str1.equals(str2));
        System.out.println(str2 == str3);
    }
}
