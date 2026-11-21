package Functions;
@FunctionalInterface
interface  Evenchecker{
    boolean check();
}
public class Even_Odd_chaecker {
    public static void main(String[] args) {
        int a=80;
        Evenchecker isEven=()->a%2==0;
        System.out.println(isEven.check());

    }
}
