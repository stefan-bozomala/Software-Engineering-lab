package isp.lab10.threads;

public class Counter {

    private int counter;

    public Counter() {}

    public synchronized int increment() {
        this.counter++;
        return counter;
    }

    public int getCount() {
        return counter;
    }

    //synchronized - metode
    // o  resursa mai multe threaduri / afisam exceptii
}
