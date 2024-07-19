public class Test11 {
    public static String solution(String code) {
        String answer = "";
        String ret = "";
        char[] codeChar = code.toCharArray();
        int mode = 0; //초기화는 0

        for (int i = 0; i < codeChar.length - 1; i++) {
            isMode(codeChar[i],0);

            if (codeChar[i] != '1') {
                if ((i & 2) == 0) {
                    ret += codeChar[i];
                }
            }
        }
        return answer;
    }

    public static int isMode(char chars, int mode) {

        if (chars == '1') {
            mode = 1;
        }

        return mode;
    }

    public static void main(String[] args) {
        String str = solution("abc1abc1abc");
    }
}
