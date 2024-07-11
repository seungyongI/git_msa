class doA{

    public static int A(int num)
    {
        System.out.println(num);

        num-=3;
        return num;
    }

}

public class Test01 {
    public static void main(String[] args) {
//        int[] k = new int[5];
//        for (int i = 0; i < 5; i++) {
//            System.out.println(k[i]);
//        }
        int k = 10;
        System.out.println(k);

        doA a = new doA();
        a.A(k);


        System.out.println(k);
        System.out.println(a.A(k));
        System.out.println(k);
//
//        for (int i = 0; i < 5; i++) {
//            System.out.println(k[i]);
//        }
//    }

    }
}
