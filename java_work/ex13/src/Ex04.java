public class Ex04 {
    /*
    return 쓰이는 경우
    1. 값을 반환할 때
    2. 메서드(함수) 종료할 때
     */
    public static void main(String[] args) {
        Circle circle1 = new Circle(3, "");

        circle1.setRad(-10);

        System.out.println(circle1.getRad());
        System.out.println(circle1.getName());
    }
}
