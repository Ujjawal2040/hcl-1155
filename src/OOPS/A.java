package OOPS;
public class A{
   public A(){
        System.out.println("There is constructor");
    }
}
//Default constructor cannot be accessed from  another class

     class Demo {
    public static void main(String[] args) {
        A a = new A();
    }
}
