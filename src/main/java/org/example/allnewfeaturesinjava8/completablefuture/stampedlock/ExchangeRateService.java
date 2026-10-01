package org.example.allnewfeaturesinjava8.completablefuture.stampedlock;

import java.util.concurrent.locks.StampedLock;

public class ExchangeRateService {
    private final StampedLock lock = new StampedLock();
    private double usdToKhr = 4100;
    private long lastUpdated = System.currentTimeMillis();

    public void updateRate(double newRate) {
        long stamp = lock.writeLock();
        try {
            usdToKhr = newRate;
            lastUpdated = System.currentTimeMillis();
        } finally {
            lock.unlockWrite(stamp);
        }
    }

    public ExchangeRate getRate() {
        long stamp = lock.tryOptimisticRead();
        double rate = usdToKhr;
        long updatedAt = lastUpdated;
        if (!lock.validate(stamp)) {
            stamp = lock.readLock();
            try {
                rate = usdToKhr;
                updatedAt = lastUpdated;
            } finally {
                lock.unlockRead(stamp);
            }
        }
        return new ExchangeRate(rate, updatedAt);
    }
}
