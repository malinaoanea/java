package ex1;

public class Test2 {
    public static void main(String[] args) {
       try {
           m1();
           Object object = new Object();

           String s = (String) object;
           System.out.println(s);
       } catch (StackOverflowError stackOverflowError) {
           System.out.println( stackOverflowError);
           return;
       } catch (ClassCastException exec) {
           System.out.println(exec);
       } finally {
           System.out.println("In finally");
       }
    }

    public static void m1() {
        System.out.println("In m1");
    }
}
