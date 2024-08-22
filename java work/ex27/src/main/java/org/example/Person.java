package org.example;

enum Person {
    MAN(1,"MAN"),WOMAN(2, "WOMAN");

    private int num;
    private String gender;

    Person(int num, String gender) {
        this.num = num;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "num=" + num +
                ", gender='" + gender + '\'' +
                '}';
    }
}
