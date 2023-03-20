package org.example;

public class Main {
    public static final int TOTAL_USER_THREADS = 3;

    public static void main(String[] args) {
        Thread toyThread = new Thread(new Toy());
        toyThread.start();

        ThreadGroup threadGroup = new ThreadGroup("userThreads");
        for (int i = 0; i < TOTAL_USER_THREADS; i++) {
            new Thread(threadGroup, new User(i+1)).start();
        }

        try {
            toyThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        threadGroup.interrupt();
    }
}