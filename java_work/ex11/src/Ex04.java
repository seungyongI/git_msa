class Box {
    String conts;

//    alt + insert 생성자 만들기
//    alt + insert  toString 만들기
    /*
    int 형 배열은 0으로 초기화
    String(객체) 배열은 null로 초기화
     */

    public Box(String conts) {
        this.conts = conts;
    }

    public String toString() {
        return "Box{ conts=' " + conts + " ' }";
    }
}

public class Ex04 {
    public static void main(String[] args) {
        Box[] boxs = new Box[5];
        boxs[0] = new Box("사과");

        for (int i = 0; i < boxs.length; i++) {
            System.out.println(boxs[i]);
        }

//        Box b = new Box("내 자동차");
//        String a = b.toString();
//        System.out.println(a);
    }
}
