package isp.lab10.threads;

public class IncrementThread extends Thread {

    private Counter counter;

    public IncrementThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run(){
        System.out.println("Thread "  + this.getName() + "is running");
        for (int i = 0; i < 10000; i++) {
            counter.increment();
        }
    } // simulam acces pe counter

}