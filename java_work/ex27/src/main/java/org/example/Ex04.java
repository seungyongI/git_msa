package org.example;

public class Ex04 {

    public static void main(String[] args) {
        who(Person.WOMAN);
//        who(Animal.DOG);
        System.out.println(Person.MAN);
    }

    public static void who(Person person) {
        if (person == Person.MAN) {
            System.out.println("MALE");
        } else {
            System.out.println("FEMALE");
        }
    }
}
