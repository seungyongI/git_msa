package org.example.box;
/*
상속관계 다형성(부모클래스는 자식클래스를 참조할 수 있는 규칙)
메서드 오버라이딩 기법
instanceof 클래스 비교
*/

public class PaperBox extends Box{

    public void paperbox(){
        System.out.println("종이 박스");
    }
}
