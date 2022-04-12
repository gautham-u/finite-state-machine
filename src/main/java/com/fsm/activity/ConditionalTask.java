package com.fsm.activity;

import com.fsm.entity.Workflow;
import com.fsm.store.StoreMap;
import com.fsm.util.OpertionStatus;
import com.google.gson.JsonObject;

public class ConditionalTask implements Task{

    private JsonObject payload;
    private Workflow workflow;
    private String next;

    public ConditionalTask(JsonObject data, Workflow workflow, String next) {
        this.payload = data;
        this.workflow = workflow;
        this.next = next;
    }

    @Override
    public String status(ConditionalTask task) throws Exception {
        if (workflow == null) {
            throw new Exception("Workflow not Found");
        }
        return workflow.getStatus();
    }

    @Override
    public Boolean call() throws Exception {
        System.out.println(this.next);
        if (workflow == null)
            return false;

        if (workflow.getStatus().equalsIgnoreCase(OpertionStatus.CANCELLED.name()) || workflow.getStatus().equalsIgnoreCase(OpertionStatus.COMPLETE.name()))
            return false;

        if (workflow.getNext().equalsIgnoreCase(this.payload.get("event").getAsString())) {

            if (workflow.getTasks().size() ==1 )  {
                workflow.setStatus(OpertionStatus.COMPLETE.name());
            } else {
                workflow.setStatus(this.next);
                if (!workflow.getTasks().get(1).isEmpty())
                    workflow.setNext(workflow.getTasks().get(1));
                else
                    workflow.setNext(null);
            }
            workflow.getTasks().remove(0);
            StoreMap.getStoreMap().put(workflow.getWorkflowID().toString(), workflow);
            return true;
        }
        return false;
    }
}
