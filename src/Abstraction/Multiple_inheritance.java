
package Abstraction;

// First interface
interface Father {
    void showFather();
}

// Second interface
interface Mother {
    void showMother();
}

// One class implementing both interfaces
public class Multiple_inheritance implements Father, Mother {

    @Override
    public void showFather() {
        System.out.println("Father's method");
    }

    @Override
    public void showMother() {
        System.out.println("Mother's method");
    }

    public static void main(String[] args) {
        Multiple_inheritance obj = new Multiple_inheritance();

        obj.showFather();
        obj.showMother();
    }
}
