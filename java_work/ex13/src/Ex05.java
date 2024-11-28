public class Ex05 {
    /*
    옮기고 싶은 클래스에 커서 두고
    F6 누르면 클래스 이동 가능
     */
    public static void main(String[] args) {
        Circle circle = new Circle(5, "");

        //넓이를 구하는 함수 선언
        double area = circle.getArea();
        System.out.println("넓이는 " + area);
    }
}
