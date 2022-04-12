package com.fsm.activity;

import com.fsm.entity.Workflow;
import com.fsm.service.WorkflowService;
import com.fsm.store.StoreMap;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class ExecutionTask {

    private ExecutorService executorService;
    private JsonObject payload;
    private WorkflowService workflowService = new WorkflowService();

    public ExecutionTask(ExecutorService executorService, String payload) {
        this.executorService = executorService;
        this.payload = new JsonParser().parse(payload).getAsJsonObject();
    }

    public void run() {
        try {
            if (payload.get("event").getAsString().equalsIgnoreCase("create")) {
                workflowService.createWorkflow(payload);
            } else {
                Workflow workflow = getWorkflow();
                if (workflow != null) {
                    if (!workflow.getTasks().isEmpty()) {
                        Task task = new ConditionalTask(payload, workflow, workflow.getTasks().get(0));
                        executorService.submit(task);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Workflow getWorkflow() {
        String key = UUID.nameUUIDFromBytes(this.payload.get("orderId").getAsString().getBytes()).toString();
        return  StoreMap.getStoreMap().get(key);
    }

}
