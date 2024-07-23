public class Review {
//    public static String solution(String code) {
//        String answer = "";
//        int mode = 0;
//
//        for (int i = 0; i < code.length(); i++) {
//            if (code.charAt(i) == '1') {
//                mode = 1-mode;
//            } else if (i % 2 == mode) {
//                answer += code.charAt(i);
//            }
//        }
//        if (answer.isEmpty()) {
//            answer = "EMPTY";
//        }
//        return answer;
//    }

    public static String solution(String code) {
        String answer = "";
        int mode = 0;
        char[] codeChars = code.toCharArray();

        for (int i = 0; i < codeChars.length; i++) {
            int num = -1;
            try {
                num = Integer.parseInt("" + codeChars[i]);
            } catch (Exception e) {
            }

            if (mode == 0) {
                if (num == 1) {
                    mode = 1;
                } else if (i % 2 == 0) {
                    answer += codeChars[i];
                }
            } else {
                if (num == 1) {
                    mode = 0;
                } else if (i % 2 == 1) {
                    answer += codeChars[i];
                }
            }
        }
        if (answer.isEmpty()) {
            answer = "EMPTY";
        }
        return answer;
    }

    public static void main(String[] args) {
        String str = solution("abc1abc1abc");
        System.out.println(str);
    }
}
