package workwiththreads;

import java.util.stream.Stream;

public class MyRunnable implements Runnable {

    @Override
    public void run() {
        Stream.iterate(0, i -> i + 2).limit(10)
                .forEach(i -> System.out.println(i + " on thread " + Thread.currentThread().getName()));
    }
}