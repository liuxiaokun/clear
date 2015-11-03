package com.fred.ejingtong;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author Fred Liu(liuxiaokun0410@gmail.com)
 * @version 1.7
 * @since 2015/7/8
 */
public class App {

    public static void main(String[] args) {

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);

        executorService.scheduleWithFixedDelay(DeleteLogRunnable.getInstance(), 0L, 1000L, TimeUnit.MILLISECONDS);
        executorService.scheduleWithFixedDelay(DeleteOrderMetaRunnable.getInstance(), 0L, 1000L, TimeUnit.MILLISECONDS);
        executorService.scheduleWithFixedDelay(DeleteOrderPersonRunnable.getInstance(), 0L, 1000L, TimeUnit.MILLISECONDS);
    }
}
