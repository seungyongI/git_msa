public class Test19 {

    public static int solution(int price) {
        int answer = 0;
        if (100000 <= price && price < 300000) {
            answer = (int) (price * 0.95);
        } else if (300000 <= price && price < 500000) {
            answer = (int) (price * 0.9);
        } else if (price >= 500000) {
            answer = (int) (price * 0.8);
        } else answer = price;
        return answer;
    }

    public static void main(String[] args) {
        int result = solution(580000);
        System.out.println(result);
    }
}
