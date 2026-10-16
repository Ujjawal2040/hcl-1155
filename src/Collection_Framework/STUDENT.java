package Collections_Framework;

import java.util.*;
public class STUDENT {
    int roll,age;
    String name;
    double marks;
    STUDENT(int roll,double marks,int age,String name){
        this.roll=roll;
        this.marks=marks;
        this.age=age;
        this.name=name;
    }

    public static void main(String[] args) {
        ArrayList<STUDENT> list=new ArrayList<>();
        list.add(new STUDENT(1,35,20,"Aman Y"));
        list.add(new STUDENT(2,45,21,"Aman V"));
        list.add(new STUDENT(3,55,22,"Aman S"));
        list.add(new STUDENT(4,65,19,"Ankit P"));
        list.add(new STUDENT(5,65,18,"Ankit M"));
        list.add(new STUDENT(6,85,17,"Ankit Y"));
        list.add(new STUDENT(7,95,24,"Adarsh"));
        list.add(new STUDENT(8,25,22,"Pradeep"));
        list.add(new STUDENT(9,15,25,"Prince"));
        list.add(new STUDENT(10,5,21,"Ujjwal"));
//        for(STUDENT s:list){
//            System.out.println(s.roll+" "+s.marks+" "+s.age+" "+s.name);
//        }
//        list.sort((a,b)->Integer.compare(a.age, b.age));
//        for(STUDENT s:list){
//            System.out.println("ROLL NO="+s.roll+" "+"Marks="+s.marks+" "+"AGE="+s.age+" "+"Name="+s.name);
//        }
        list.sort((a, b) -> {
            if (a.marks == b.marks) {
                return Integer.compare(a.age, b.age);
            }
            return Double.compare(a.marks, b.marks);
        });
        for(STUDENT s:list){
            System.out.println("ROLL NO="+s.roll+" "+"Marks="+s.marks+" "+"AGE="+s.age+" "+"Name="+s.name);
        }

    }
}