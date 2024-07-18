import java.util.Arrays;

public class Ex02 {
    public static void main(String[] args) {
        int[][] nums = new int[3][3];
        
        /*배열에 자동으로 값을 넣는 식:
        (1차원 배열만 해당하기에 2차원 배열은 같은 행에 같은 수가 들어감)
         */
        Arrays.fill(nums[0], 10);
        Arrays.fill(nums[1], 20);
        Arrays.fill(nums[2], 30);

        System.out.println(Arrays.toString(nums[0]));
        System.out.println(Arrays.toString(nums[1]));
        System.out.println(Arrays.toString(nums[2]));

        /*행의 있는 수끼리 교체하는 식:
        (1차원 배열은 2차원 배열의 구성 요소이기에
        1차원 배열에 2차원 배열의 한 행의 값을 입력 가능함)
        */
        System.out.println();
        int[] temp = nums[2];
        nums[2] = nums[0];
        nums[0] = temp;
        
        System.out.println(Arrays.toString(nums[0]));
        System.out.println(Arrays.toString(nums[1]));
        System.out.println(Arrays.toString(nums[2]));
    }
}
