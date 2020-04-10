package ex5;

public class Test3 {
    public static void main(String[] args) {
        try (R2 r1 = new R2("res1"); R2 r2 = new R2("res2")) {

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("in finally");
        }
    }
}
