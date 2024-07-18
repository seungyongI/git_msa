package aa;

public class Circle {
    /*
    static은 프로그램 시작 시 바로 메모리에 적재
    고로 static 선언이 많아지면 메모리 사용량이 많아짐
    */
    public static final double PI = 3.1415;
    public static int a = 10;

    public void do둘레(){
        System.out.println(2*PI*a);
    }

    public void do넓이(){
        System.out.println(a*a*PI);
    }

    public int doA(){
        int sum = 0;
        int aa = 10;
        int bb = 20;

        for (int i = 1; i < 10; i++) {
            sum += i;
        }
        return sum;
    }
}
