package isp.lab10.example.threads;

public class ThreadRunner {
    public static void main(String[] args) {
        Counter counter = new Counter();

        Thread incrementThread1 = new IncrementThread(counter);
        incrementThread1.start();

        Thread incrementThread2 = new IncrementThread(counter);
        incrementThread2.start();

        Thread incrementThread3 = new IncrementThread(counter);
        incrementThread3.start();

        Thread incrementThread4 = new IncrementThread(counter);
        incrementThread4.start();

        Runnable incrementRunnable = () -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        };
        Thread incrementThread5 = new Thread(incrementRunnable);
        incrementThread5.start();

        try {
            incrementThread1.join();
            incrementThread2.join();
            incrementThread3.join();
            incrementThread4.join();
        } catch (
                InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(counter.getCount());
    }
}
