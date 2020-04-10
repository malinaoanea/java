package ex1;

public class Test1 {
    public static void main(String[] args) throws Exception {
        try {
            m1();
        } catch (NullPointerException e ) {
            System.out.println(e);
            System.out.println("in main");
        } finally {
            System.out.println("In finally");
        }
    }

    static void m1() throws Exception {
        System.out.println("In m1");
        m2();
        throw new Exception();
    }

    static void m2() {
        System.out.println("In m2");
        m3();
    }

    static void m3() {
        System.out.println("In m3");
        Object o = null;
        o.toString();
    }
}
