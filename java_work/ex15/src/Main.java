import java.util.Arrays;

/*
1. "Hello.java" 문자열에서 파일명은 Hello와 확장자인 java를 분리시켜보자.

    입력 >>Hello.java
    출력
    파일명 Hello
    확장자 java
*/
public class Main {

    public static void main(String[] args) {
        
        //정규표현식 사용법
        String str = "Hello.java";
        String[] temp = str.split("\\.");

        System.out.println("파일명 " + temp[0]);
        System.out.println("확장명 " + temp[1]);

        str = "Hello.Java";
        temp = str.split("[A-Z]");

        System.out.println(Arrays.toString(temp));

        str = "안녕하세요1이승용2이라고3합니다.";
        temp = str.split("\\d");

        System.out.println(Arrays.toString(temp));

        str = "안녕하세요1이승용2이라고3합니다.";
        temp = str.split("\\D");

        System.out.println(Arrays.toString(temp));

        if (temp[0].equals("exe"))
            return;

        }

    }