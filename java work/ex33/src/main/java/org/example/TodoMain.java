package org.example;

import org.example.student.Student;
import org.example.student.StudentRepository;
import org.example.todo.TodoRepository;

import java.util.Scanner;

public class TodoMain {

    private StudentRepository studentRepository =
            new StudentRepository();
    private TodoRepository todoRepository = new TodoRepository();
    private String info = """
            뭐할래?
            0. 로그인
            1. student select()
            2. student insert()
            3. student update()
            4. student delete()
            5. todo select() -> user 사용자
            6. todo insert() -> user 정보...
            7. todo update()
            8. todo delete()
            """;
    public static Student student;

    TodoMain() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(info);
            int ra = scanner.nextInt();
            if (ra == 0) {
                System.out.println("who are you?");
                int student_idx = scanner.nextInt();
                student = studentRepository.findByIdx(student_idx);
                if (student == null) {
                    System.out.println("login fail");
                } else if (student != null) {
                    System.out.println("login success");
                    System.out.println(TodoMain.student);
                }
            } else if (ra == 1) {
                studentRepository.select();
            } else if (ra == 2) {
                studentRepository.insert();
            } else if (ra == 3) {
                studentRepository.update();
            } else if (ra == 6) {
                todoRepository.insert();
            } else {
                System.out.println("종료됩니다.");
                break;
            }
        }
    }

    public static void main(String[] args) {
        new TodoMain();
    }
}