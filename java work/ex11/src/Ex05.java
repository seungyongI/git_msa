public class Ex05 {
    public static void main(String[] args) {

        String str = "안녕하세요 이승용입니다.";
//        String[] tempstr = str.split("\\|");
        String[] tempstr = str.split(" ");

        for (int i = 0; i < tempstr.length; i++) {
            System.out.println(tempstr[i]);
        }

        String a = "abcdefgh";
        System.out.println(a.length());

        System.out.println(a.charAt(0));
        System.out.println(a.charAt(1));
        System.out.println(a.charAt(2));
        System.out.println(a.charAt(3));

        System.out.println("몇 번째 부터 자를래?"+a.substring(2));
        System.out.println("어디부터 어디까지 자를래? "+a.substring(2,6));
        System.out.println(a.toUpperCase());
        System.out.println("cd를 포함하냐 = "+a.contains("cd"));

        System.out.println("배열출력시작");
        char[] test = "테스트".toCharArray();
        for (int i = 0; i < test.length; i++) {
            System.out.println("test["+i+"]"+test[i]);
        }
        System.out.println("배열출력끝");

        test[2] = '형';
        char qwer[] = {'a','b','c'};
        //String으로 바꾸고 싶어 String c = "abc"
        System.out.println(qwer[0]);
        System.out.println(qwer[1]);
        System.out.println(qwer[2]);

        String testStr = new String(test);
        System.out.println(testStr);

        int[] b = new int[3];
        System.out.println(b.length);
    }
}
