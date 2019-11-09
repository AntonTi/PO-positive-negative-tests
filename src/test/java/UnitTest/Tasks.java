package test.java.UnitTest;

public class Tasks {

    public int minValue(int a, int b, int c) {
        if (b >= a && c >= a) {
            return a;
        } else if (a >= b && c >= b) {
            return b;
        } else return c;
    }

    public String validateAge(int age) {
        if (age < 18) {
            return "Too young";
        } else if (age >= 90) {
            return "Too old";
        } else {
            return "Welcome!";
        }
    }

}
