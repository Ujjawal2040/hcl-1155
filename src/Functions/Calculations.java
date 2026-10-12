package functions;

interface Calculator {
    double calculate(double a, double b);
}

public class Calculations {
    public static void main(String[] args) {

        Calculator add = (a, b) -> a + b;
        Calculator subtract = (a, b) -> a - b;
        Calculator multiply = (a, b) -> a * b;
        Calculator divide = (a, b) -> a / b;
        Calculator modulus = (a, b) -> a % b;

        System.out.println("Addition: " + add.calculate(10, 5));
        System.out.println("Subtraction: " + subtract.calculate(10, 5));
        System.out.println("Multiplication: " + multiply.calculate(10, 5));
        System.out.println("Division: " + divide.calculate(10, 5));
        System.out.println("Modulus: " + modulus.calculate(10, 5));
    }
}