package org.example.aa;

//extends class이름을 사용하면 해당 클래스를 부모 클래스로 지정한다.
public class BizMan extends Man {


    private String company;
    private String position;

    public BizMan(String name, String company, String position) {
        /*
        super를 사용하면 부모 클래스의 생성자를 호출한다.
        (상속관계에서 부모클래스 생성자는 무조건 호출!)

        상속관계에서 기본 생성자를 호출하는 게 생략되어 있기
        때문에 기본 생성자를 따로 생성하지 않아도 된다.

        만약 부모클래스에 기본 생성자가 선언되어 있지 않으면
        다른생성자 호출을 통해 부모클래스 생성자 호출 가능
        */
        super(name);
//        super();
        this.company = company;
        this.position = position;
    }

    public void showInfo() {
        System.out.println("company = " + company);
        System.out.println("position = " + position);
        tellInfo();
    }



}
