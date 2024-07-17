/*
함수에 private 쓰면 정보 은닉
정보 은닉을 해야하는 이유:
반지름 같은 고정 값을 실수로라도
음수로 설정할 수 없게 하기 위해
 */
class Circle {
    /*
    private 변수는 setter getter 로 참조 가능하다.
    alt + insert 키로 setter getter constructor 생성 가능
     */
    private int rad;
    private String name;

    /*
    기본생성자는 생략가능
    다른생성자 선언 시 기본생성자 생략불가
    */

    public Circle() {}
    //    rad = 반지름
    public Circle(int rad,String name) {
        this.rad = rad;
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.equals("")) {
            this.name = "이승용";
            return;
        }
        this.name = name;
    }

    //이 함수를 통해서만 반지름을 설정해라.
    public int getRad() {
        return rad;
    }

    public void setRad(int rad) {
        if (rad < 0) {
            rad = 0;
            return;
        }
        this.rad = rad;
    }

    public double getArea() {
        return 3.14 * rad * rad;
    }
}
