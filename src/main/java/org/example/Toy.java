package org.example;

public class Toy implements Runnable {
    public static final int TOTAL_ITERATIONS = 5;
    public static final int SLEEP_TIME_MILLIS = 1000;

    @Override
    public void run() {
        for (int i = 0; i < TOTAL_ITERATIONS; i++) {
            if (Switch.compareAndSet(false, true)) {
                System.out.printf("+ поток-игрушка ВКЛЮЧАЕТ переключатель (итерация %d)\n",i+1);
            } else {
                System.out.printf("поток-игрушка: переключатель уже включен (итерация %d)\n",i+1);
            }
            try {
                Thread.sleep(SLEEP_TIME_MILLIS);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
