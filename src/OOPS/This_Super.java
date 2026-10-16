package OOPS;



class Student {

    String name;
    int roll_number;

    Student(String name, int roll_number) {
        this.name = name;
        this.roll_number = roll_number;
    }

    void display() {
        System.out.println(name);
        System.out.println(roll_number);
    }
}

public class This_Super extends Student {

    String name;
    int marks;

    This_Super(String name, int roll_number, int marks) {

        // super() calls parent class constructor
        super(name, roll_number);

        // this refers to current class object
        this.name = name;
        this.marks = marks;
    }

    void show() {
        System.out.println("Parent Name: " + super.name);
        System.out.println("Parent Roll Number: " + super.roll_number);

        System.out.println("Child Name: " + this.name);
        System.out.println("Marks: " + this.marks);
    }

    public static void main(String[] args) {

        This_Super obj = new This_Super("Ujjawal", 101, 90);

        obj.show();
    }
}