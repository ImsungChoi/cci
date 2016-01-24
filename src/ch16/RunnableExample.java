package ch16;

/**
 * Created by imsungchoi on 2016. 1. 23..
 */
public class RunnableExample implements Runnable {
    public int count = 0;

    public void run() {
        System.out.println("RunnableThread starting.");
        try {
            while(count < 5) {
                Thread.sleep(500);
                count++;
                System.out.println(count);
            }
        } catch (InterruptedException e) {
            System.out.println("RunnableThread interrupted");
        }
        System.out.println("RunnableThread terminated");
    }

    public static void main(String[] args) {
        RunnableExample instance = new RunnableExample();
        Thread thread = new Thread(instance);
        thread.start();

        while(instance.count != 5) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
