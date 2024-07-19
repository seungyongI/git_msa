package org.example.phone;

public class SmartPhone  extends MobilePhone{

    private String androidVer;
    public SmartPhone(String aver, int number) {
        super(number);
        this.androidVer = aver;
    }
    
    /*
    부모클래스의 함수와 같은 이름이면
    재정의한다고 판단해서 부모클래스의 값은 출력되지 않음
    (override했다고 말함)
     - 부모함수도 같이 출력하고 싶으면 show를 쓰면 됨.
     */
    @Override
    public void show(){
        super.show();
        System.out.println("androidVer = " + androidVer);

    }
}
