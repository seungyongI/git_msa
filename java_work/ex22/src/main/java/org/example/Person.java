package org.example;

// comparable compareTo
// person 클래스를 배열로 가져오게 되면
public class Person implements Comparable<Person> {

    private String name;
    private int age;

    @Override
    public String toString() {
        return "Person{" +
                "name = '" + name + '\'' +
                ", age = " + age +
                '}';
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public int compareTo(Person o) {
//        System.out.println("this = " + this);
//        System.out.println("this.age = " + this.age);
//        System.out.println("((Person)o).age = " + ((Person)o).age);

//        if (this.age > ((Person) o).age) {
//            return -1;
//        } else if (this.age < ((Person) o).age) {
//            return 1;
//        } else {
//            return 0;
//        }

        return this.age - ((Person) o).age;
//        return ((Person)o).age - this.age;

    }
}
