package org.example;

import java.util.Random;

public class User extends Thread {
    public static int SLEEP_TIME_MILLIS;
    public User(int threadId) {
        SLEEP_TIME_MILLIS = new Random().nextInt(10) * 100;
        setName(String.format("поток-пользователь %d (спит по %d мс)", threadId, SLEEP_TIME_MILLIS));
    }

    @Override
    public void run() {
        System.out.printf("! запущен %s\n",getName());
        while (! isInterrupted()) {
            if (Switch.compareAndSet(true, false)) {
                System.out.printf("- %s ВЫКЛЮЧАЕТ переключатель\n", getName());
            } else {
                System.out.printf("%s: переключатель уже выключен\n", getName());
            }
            try {
                Thread.sleep(SLEEP_TIME_MILLIS);
            } catch (InterruptedException e) {
                break;
            }
        }
        System.out.printf("! %s остановлен\n", getName());
    }
}
