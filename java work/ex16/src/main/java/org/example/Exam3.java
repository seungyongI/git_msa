package org.example;

/*
3. 다음 형태로 표현된 2차원 배열이 존재한다고 가정해보자
1   2   3   //1행
4   5   6   //2행
7   8   9   //3행
이러한 형태를 갖는 int형 2차원 배열이 인자로 전달되면, 다음의 형태로 배열의 구조를 변경시키는 메소드를 정의하자
7   8   9   //1행
1   2   3   //2행
4   5   6   //3행
물론 배열의 가로와 세로길이에 상관없이 위와 같이 동작하도록 메소드를 정의해야 한다.

 */

import java.util.Arrays;

public class Exam3 {

    public static void twoDArr(int[][] arr) {

        int[][] temp = new int[arr.length][arr[0].length];

        //arr[0] = temp[1], arr[1] = temp [2], arr[2] = temp[0]
        int i = 0;
        int j = 1;
        
        //완전 자동화 시켜봐

        while (i < arr.length && j < arr.length) {
            temp[j] = arr[i];
            i++;
            j++;
            if (j == arr.length) {
                j = 0;
                temp[j] = arr[i];
                break;
            }
        }
        
        for (int[] e : temp) {
            System.out.println(Arrays.toString(e));
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3,4}, {4, 5, 6,7}, {7, 8, 9,10}};
        twoDArr(arr);
    }
}
