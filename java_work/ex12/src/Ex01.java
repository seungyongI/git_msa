import aa.Box;

public class Ex01 {
    public static void main(String[] args) {
        Box[] boxes = new Box[3];

        boxes[0] = new Box("체리",34560);
        boxes[1] = new Box("사과",10);
        boxes[2] = new Box("바나나", 24);

        System.out.println(boxes[0]);
        System.out.println(boxes[1]);
        System.out.println(boxes[2]);

        Box abox;
        Box bbox;
        Box cbox;
    }
}
