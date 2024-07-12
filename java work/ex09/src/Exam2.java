/*
*2. 피보나치 수열 은 앞을 두 수를 더해서 다음 수를 만들어 나가는 수열이다

    예를 들어 앞의 두 수가 1과 1이라면 그 다음 수는 2가 되고 그 다음 수는 1과 2를 더해서 3이 된다.
    0,1,1,2,3,5,8,13,21,... 이렇게 진행된다
    피보나치수열의 10 번째 수는 무엇인지 계산하는 프로그램을 완성하시오
    1,1,2,3,5,8,13,21,34,55
*/
//i,j,(i+j),j+(i+j),(i+j)+(j+(i+j)).....
//i j  i  j  i  j  i  j
//i+j가 i의 값이 되고 다시 j와 더한 값이 i가 되게 해서 쭉쭉쭉 10번 반복.
public class Exam2 {
    public static void main(String[] args) {

//        int i = 1;
//        int j = 1;
//
//        while (i < 100 && j < 100) {
//            i += j;
//            j += i;
//
//            if (j < 60) {
//                System.out.println("i = " + i);
//                System.out.println("j = " + j);
//            }
//        }
//0,1,1,2,3,5,8...

        int start = 0;
        int next = 1;
        int sum = 0;
        for (int i = 2; i <= 11; i++) {
            sum = start + next;
            start = next;
            next = sum;
            System.out.println(start);
        }

//        int count = 0;
//            count++;
//            if (count == 10) {
//                System.out.println("start = " + start);
//                break;
//            }
    }
}
