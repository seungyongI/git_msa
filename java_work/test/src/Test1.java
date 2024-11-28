//코딩테스트 문자열 겹쳐쓰기

public class Test1 {

    public static String solution(String my_string, String overwrite_string, int s) {
        String answer = "";
        char[] myChar = my_string.toCharArray();
        char[] overChar = overwrite_string.toCharArray();
        char[] result = answer.toCharArray();
        //myChar[s]부분부터 overChar.length까지 부분의 값을 overChar[]로 변경

        for (int i = 0; i < overChar.length; i++) {
            myChar[s] = overChar[i];
            s++;
        }
        my_string = new String(myChar);
        answer = my_string;

        return answer;

    }

    public static void main(String[] args) {
        String result = solution("He11oWor1d", "lloWorl", 2);
        System.out.println(result);
    }

}

