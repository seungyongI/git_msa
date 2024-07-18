/*
코딩테스트 문자열 겹쳐쓰기

my_string	overwrite_string	s	result
"He11oWor1d"	 "lloWorl"	    2	"HelloWorld"
"Program29b8UYP" "merS123"	    7	"ProgrammerS123"
 */


import java.util.Arrays;

public class Test1_1 {

    public Test1_1() {
        String result = solution("He11oWor1d", "lloWorl",2);
        System.out.println(result);

    }

    public String solution(String my_string, String overwrite_string, int s) {
        String answer = "";

        char[] c_my_string = my_string.toCharArray();
        char[] c_overwrite_string = overwrite_string.toCharArray();

        System.out.println(Arrays.toString(c_my_string));
        System.out.println(Arrays.toString(c_overwrite_string));

        System.arraycopy(c_overwrite_string,0,c_my_string,s,c_overwrite_string.length);

        System.out.println(Arrays.toString(c_my_string));
        answer = new String(c_my_string);

        return answer;
    }

    public static void main(String[] args) {
        new Test1_1();
    }
}
