public class Ex04 {

    /**
     * 5! = 5*(4*3*2*1*(0!))
     * 4! = 4*3!
     * 3! = 3*2!
     * ,재귀 함수 = 자기자신의 함수를 호출하는 것
     */

    public static int fact(int num) {


        if (num > 0) {
            return num * (fact(num - 1));
//             5 * fact(4)
        } else {
            return 1;
        }

//        fact(3);

    }

    public static void main(String[] args) {
        int result = fact(2);
        System.out.println(result);
//        String[] strary = {"aa,", "bb", "cc"};
//        System.out.println("배열선언함");
//        main(strary);
    }

}
