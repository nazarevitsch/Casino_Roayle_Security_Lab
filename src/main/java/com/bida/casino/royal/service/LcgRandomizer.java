package com.bida.casino.royal.service;

import java.util.concurrent.ThreadLocalRandom;

public class LcgRandomizer {

    private long lastNumber;
    private static final long a = 69069;
    private static final long m = (long) Math.pow(2, 32);
    private static final long c = 1170293;

    public LcgRandomizer() {
        lastNumber = Math.abs(ThreadLocalRandom.current().nextInt());
    }

    public int getNumber() {
        lastNumber = (lastNumber * a + c) % m;
        return (int) lastNumber;
    }
}
