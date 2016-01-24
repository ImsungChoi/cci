package ch16;

/**
 * Created by imsungchoi on 2016. 1. 23..
 */
public class ThreadExample extends Thread {
    public int count = 0;

    public void run() {
        System.out.println("ThreadExample started.");

        while(count < 5) {
            try {
                Thread.sleep(250);
                count++;
                System.out.println(count);
            } catch (InterruptedException e) {
                System.out.println("ThreadExample interrupted");
            }
        }
        System.out.println("ThreadExample terminated");
    }
}

class Run {
    public static void main(String[] args) {
        ThreadExample thread = new ThreadExample();
        thread.start();

        while(thread.count != 5) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
