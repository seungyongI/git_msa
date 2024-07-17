
//오버로딩
//메서드와 생성자 이름이 같지만 파라메타가 다를 때 사용가능
public class Ex02 {

    public static void main(String[] args) {
        Person p1 = new Person();
        Person p2 = new Person("000309");
        Person p3 = new Person("000309", "10101010");

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);

        p1.show();
        p2.show();
        p3.show();
    }
}
