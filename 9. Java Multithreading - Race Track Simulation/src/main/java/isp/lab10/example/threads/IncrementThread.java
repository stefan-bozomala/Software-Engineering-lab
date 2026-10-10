package isp.lab10.example.threads;

public class IncrementThread extends Thread {
    Counter counter;

    public IncrementThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        System.out.println("Thread " + getName() + " is running.");
        for (int i = 0; i < 10000; i++) {
            counter.increment();
        }
    }

}
