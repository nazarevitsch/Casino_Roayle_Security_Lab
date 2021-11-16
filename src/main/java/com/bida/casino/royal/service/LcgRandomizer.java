package com.bida.casino.royal.service;

import java.time.Instant;

public class LcgRandomizer {

    private long lastNumber;
    private static final long a = 69069;
    private static final long m = (long) Math.pow(2, 32);
    private static final long c = 1170293;


    public LcgRandomizer() {
//        lastNumber = Instant.now().getEpochSecond();
        lastNumber = 84;
    }

    public long getNumber() {
//        It is a little bit difficult to use unsigned int in java(
//        return (lastNumber * a + c) % m;

        lastNumber = lastNumber * a;
        lastNumber = lastNumber > 4294967295L ? lastNumber - 4294967296L : lastNumber;
        lastNumber = lastNumber + c;
        lastNumber = lastNumber > 4294967295L ? lastNumber - 4294967296L : lastNumber;
        lastNumber = lastNumber % m;
        return lastNumber;
    }
}
