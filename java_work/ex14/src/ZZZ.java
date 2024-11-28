import aa.AAA;

/*
extends 는 상속(다른 패키지에 있는 클래스의 값을 사용할 때)
ex) extends AAA : AAA의 protected 값을 상속받겠다.
 */
public class ZZZ extends AAA {

    int zzz = 10;

    ZZZ(){
        System.out.println("여기에서 할 거예요.");
        System.out.println(zzz);
        System.out.println(aaa);
    }

    public static void main(String[] args) {
        ZZZ zzz = new ZZZ();
    }
}
