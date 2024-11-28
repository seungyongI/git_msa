import java.util.Arrays;

public class Test {

    public static void doA(int[] a) {
        a[0] = 100;
    }

    public static void main(String[] args) {

        int[] arr = new int[5];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        doA(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        // int, double, boolean 기본타입 변수 => 메서드로 보내면 값이 복사됨
        // 객체, 배열 참조타입 변수 => 주소값을 보내서 같은 곳을 바라봄

        int x = 100;

        double res = doB(x);
        System.out.println(res);

        System.out.println(x);
    }

    public static double doB(int num) {
        // 처음에 num은 x를 복사했기때문에 값이 100
        num = 1000;
        return (double)num;
    }
}
