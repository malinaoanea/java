package ex2;

public class Test1 {
    public static void main(String[] args) {
        try {
            int x = m1();
            System.out.println(x);
        } catch (ArithmeticException e) {
            System.out.println("in catch");
        } finally {
            System.out.println("in finally");
        }
    }

    static int m1() {
        int i = 5 / 0 ;
        System.out.println("In m1: i=" + i);
        return i;
    }
}
