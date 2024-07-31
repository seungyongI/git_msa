public class Review {
//    public static String solution(String code) {
//        String ret = "";
//        int mode = 0;
//
//        for (int idx = 0; idx < code.length(); idx++) {
//            if (code.charAt(idx) == '1') {
//                mode = 1-mode;
//            } else if (idx % 2 == mode) {
//                ret += code.charAt(idx);
//            }
//        }
//        if (ret.isEmpty()) {
//            ret = "EMPTY";
//        }
//        return ret;
//    }

    public static String solution(String code) {
        String ret = "";
        int mode = 0;
        char[] codeChars = code.toCharArray();

        for (int idx = 0; idx < codeChars.length; idx++) {
            int num = -1;
            try {
                num = Integer.parseInt("" + codeChars[idx]);
            } catch (Exception e) {
            }

            if (mode == 0) {
                if (num == 1) {
                    mode = 1;
                } else if (idx % 2 == 0) {
                    ret += codeChars[idx];
                }
            } else {
                if (num == 1) {
                    mode = 0;
                } else if (idx % 2 == 1) {
                    ret += codeChars[idx];
                }
            }
        }
        if (ret.isEmpty()) {
            ret = "EMPTY";
        }
        return ret;
    }

    public static void main(String[] args) {
        String result = solution("abc1abc1abc");
        System.out.println(result);
    }
}
