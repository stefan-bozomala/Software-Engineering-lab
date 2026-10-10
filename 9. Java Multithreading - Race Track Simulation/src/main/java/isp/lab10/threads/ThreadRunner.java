package isp.lab10.threads;

public class ThreadRunner {
    public static void main(String[] args) { // main thread
        Counter counter = new Counter();

        Thread incrementThread1 = new IncrementThread(counter);
        incrementThread1.start(); // pornim thread 1

        Thread  incrementThread2 = new IncrementThread(counter);
        incrementThread2.start();

        Thread incrementThread3 = new IncrementThread(counter);
        incrementThread3.start();

        Thread incrementThread4 = new IncrementThread(counter);
        incrementThread4.start();

        try {
            incrementThread1.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        try {
            incrementThread2.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        try {
            incrementThread3.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        try {
            incrementThread4.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println(counter.getCount());

//        Runnnable incrementRunnable = ()->{
//            for(int i=0;i<10;i++) {
//                counter.increment();
//            }
//        }
//        Runnnable incrementRunnable = new Runnable(){
//            @Override
//            public void run() {}
//        };

    }
}
