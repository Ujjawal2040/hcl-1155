package Abstraction;

public class Abstract_Class {
    abstract class A{
       abstract void m1();
         abstract void m2(int a);
    }
    class B extends A{
        @Override
        void m1(){
            System.out.println("Print M1!!!!");
        }
        @Override
        void m2(int a){
            System.out.println("print m2!!!! :"+ a);
        }
    }
    public void main(String[] args){
        B b=new B();
        b.m1();
        b.m2(83);
    }
}
