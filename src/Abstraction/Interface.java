package Abstraction;

// Interface
interface Animal {
    void sound();  // Abstract method
}

// Class implementing interface
public class Interface implements Animal {

    @Override
    public void sound() {
        System.out.println("Animal makes a sound");
    }

    public static void main(String[] args) {

        Interface obj = new Interface();
        obj.sound();
    }
}