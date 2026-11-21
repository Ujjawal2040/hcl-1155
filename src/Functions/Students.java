package Functions;

import java.util.*;

class Student {
    String name;
    int rollNo;
    int age;
    double marks;

    Student(String name, int rollNo, int age, double marks) {
        this.name = name;
        this.rollNo = rollNo;
        this.age = age;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return name + " " + rollNo + " " + age + " " + marks;
    }
}

class MyComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        // Higher marks first
        if (s1.marks != s2.marks) {
            return Double.compare(s2.marks, s1.marks);
        }

        // If marks are equal, younger age first
        return Integer.compare(s1.age, s2.age);
    }
}

public class Students {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();

        list.add(new Student("Rahul", 101, 21, 85.5));
        list.add(new Student("Aman", 102, 20, 90.0));
        list.add(new Student("Priya", 103, 19, 85.5));
        list.add(new Student("Rohit", 104, 22, 90.0));

        Collections.sort(list, new MyComparator());

        for (Student s : list) {
            System.out.println(s);
        }
    }
}