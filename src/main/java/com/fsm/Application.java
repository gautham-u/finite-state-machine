package com.fsm;


import com.fsm.activity.ExecutionTask;
import com.fsm.configs.ExecutorServiceConfig;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) throws InterruptedException {
        List<String> data = new ArrayList<>();
        data.add("{\"event\":\"Create\",\"orderId\":\"123123123\" }");
        data.add("{\"event\":\"Create\",\"orderId\":\"0981091832\" }");
        data.add("{\"event\":\"EVENT_A\",\"orderId\":\"123123123\" }");
        data.add("{\"event\":\"EVENT_B\",\"orderId\":\"123123123\" }");
        data.add("{\"event\":\"EVENT_C\",\"orderId\":\"123123123\" }");
        for (String paylaod: data) {
            ExecutionTask executionTask = new ExecutionTask(ExecutorServiceConfig.getExecutorService(), paylaod);
            executionTask.run();
            Thread.sleep(1000);
        }
    }
}
