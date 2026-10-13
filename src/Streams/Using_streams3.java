
package Streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Student {
    String name;
    int roll_no;
    int marks;
    int age;

    Student(String name, int roll_no, int marks, int age) {
        this.name = name;
        this.roll_no = roll_no;
        this.marks = marks;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + " | Roll No: " + roll_no
                + " | Marks: " + marks
                + " | Age: " + age;
    }
}

public class Using_streams3 {
    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<>();

        students.add(new Student("Rahul", 101, 85, 20));
        students.add(new Student("Amit", 102, 92, 21));
        students.add(new Student("Rohit", 103, 70, 19));
        students.add(new Student("Raj", 104, 78, 22));

        // Sort by marks in ascending order
        List<Student> sorted = students.stream()
                .sorted(Comparator.comparingInt(s -> s.marks))
                .toList();

        sorted.forEach(System.out::println);
    }
}
