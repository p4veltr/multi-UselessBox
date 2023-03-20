package org.example;

import java.util.concurrent.atomic.AtomicBoolean;

public class Switch {
    private static final AtomicBoolean switchState = new AtomicBoolean(false);

    public static boolean compareAndSet(boolean expectedValue, boolean newValue) {
        return Switch.switchState.compareAndSet(expectedValue, newValue);
    }
}
