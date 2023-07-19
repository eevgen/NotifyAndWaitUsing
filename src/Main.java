import java.awt.*;
import java.util.Scanner;

public class Main {

    static String scannedPhrase;

    public static void main(String[] args) throws InterruptedException {

        scannedPhrase = (new Scanner(System.in)).nextLine();

        MyThread myThread = new MyThread();
        myThread.start();

        synchronized (myThread) {
            myThread.notify();
        }


    }

    static class MyThread extends Thread{

        @Override
        public void run() {
            synchronized (this) {
                try {
                    wait(500);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
                System.out.println(scannedPhrase);
            }
        }

    }
}