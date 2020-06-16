package volatile1;

public class EX1 {
    private static volatile int outer;

    public static void main(String[] args) throws InterruptedException {

        Thread rt = new Thread(new ReaderThread(), "reader");
        rt.start();
        Thread wt = new Thread(new WriterThread(), "writer");
        wt.start();

        rt.join();
        wt.join();
    }

    static class ReaderThread implements Runnable {
        @Override
        public void run() {
            int local = outer; // without volatile, the variable will be read from cpu cache, not from main memory
            while (local < 3) {
                if (local != outer) {
                    local = outer;
                    System.out.println("local var value from " + Thread.currentThread().getName() + " is " + local);
                }
            }
        }
    }

    static class WriterThread implements Runnable {
        @Override
        public void run() {
            int local = outer;
            while (outer < 3) {
                System.out.println("local var value from " + Thread.currentThread().getName() + " is " + local);
                outer = ++local;
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
