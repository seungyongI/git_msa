package org.example;

interface Viewable {
    @Deprecated
    public void showIt(String str);
}

class Viewer implements Viewable {

    @Override
    @SuppressWarnings("deprecation")
    public void showIt(String str) {
        System.out.println("str = " + str);
    }
}

public class Ex06 {

    public static void main(String[] args) {
        Viewer viewer = new Viewer();
        viewer.showIt("Warning?");
    }
}

/*
List
순서가 있는 LIST
Set
중복허용 X
Map
키와 값이 쌍으로 있는

사용해서 Collections,sort() 함수 사용
compare
comparator
 */