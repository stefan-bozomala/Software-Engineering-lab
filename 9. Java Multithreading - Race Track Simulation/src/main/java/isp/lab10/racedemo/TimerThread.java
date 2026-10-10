package isp.lab10.racedemo;

public class TimerThread extends Thread {
    private volatile boolean running = true;
    private volatile long time = 0;

    @Override
    public void run() {
        while (running) {
            try {
                Thread.sleep(10);
                time += 10;
            } catch (InterruptedException e) {
                running = false;
            }
        }
    }

    public void stopTimer() {
        running = false;
        interrupt();
    }

    public long getTime() {
        return time;
    }
}
