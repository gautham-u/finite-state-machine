package com.fsm.configs;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceConfig {

    private static ExecutorService executorService;
    private static final int THREAD_COUNT =1;

    private ExecutorServiceConfig() {
        executorService = Executors.newFixedThreadPool(THREAD_COUNT);
    }

    public static ExecutorService getExecutorService() {
        if (executorService == null) {
            new ExecutorServiceConfig();
        }
        return executorService;
    }
}
