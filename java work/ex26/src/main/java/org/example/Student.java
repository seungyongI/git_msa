package org.example;

public class Student implements Comparable<Student>{

    private int idx;
    private String name;
    private int age;
    private String email;
    private String password;

    @Override
    public int compareTo(Student o) {
        return this.age-o.age;
    }

    @Override
    public boolean equals(Object obj) {
        return this.idx == ((Student)obj).idx;
    }

    @Override
    public int hashCode() {
        return idx;
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Student{" +
                "idx=" + idx +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
