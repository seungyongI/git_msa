public class HH {
    public static void main(String[] args) {

        int i = 0;
        int j = 6;
        int num = i + j;

        while (i < 5 && 0 < j && j <=6){
            i += 1;
            j -= 1;
            num = i + j;
            if (num == 6) {

                System.out.println("i=" + i);
                System.out.println("j=" + j);
            }
        }
    }
}
