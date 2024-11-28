package org.example;

interface Calculate {
    void cal(int a, String b);
}

interface RETCAL{
    int cal(int a, int b);
}

public class Ex01 {
    public static void main(String[] args) {
        RETCAL rc = (a, b) -> {
            System.out.println("a = " + a);
            System.out.println("b = " + b);
            return a+b;
        };
        int result = rc.cal(10,20);
        System.out.println("a + b = " + result);



        /*
        Calculate c = new Calculate() {
            @Override
            public void cal(int a, String b) {
                System.out.println("Calculate");
                System.out.println("a = " + a);
                System.out.println("b = " + b);
            }
        };
        c.cal(10, "String");
        System.out.println();

        Calculate c2 = (a, b) -> System.out.println(b + " calculate = " + a);
        c2.cal(10, "Lamda");
        System.out.println();

        c2 = (a, b) -> System.out.println(b + " calculate = " + a);
        c2.cal(20, "new Lamda");
         */
    }
}
