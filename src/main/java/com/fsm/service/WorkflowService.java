package com.fsm.service;

import com.fsm.entity.Workflow;
import com.fsm.store.StoreMap;
import com.fsm.util.Constants;
import com.fsm.util.OpertionStatus;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class WorkflowService {

    public void createWorkflow(final JsonObject data) throws JsonSyntaxException,Exception {
        try {
            final Workflow workflow = getWorkflow(data);
            StoreMap.getStoreMap().put(workflow.getWorkflowID().toString(), workflow);
        }catch (JsonSyntaxException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
    }

    private Workflow getWorkflow(JsonObject payload) {
        final Workflow workflow = new Workflow();
        workflow.setWorkflowID(UUID.nameUUIDFromBytes(payload.get("orderId").getAsString().getBytes()));
        workflow.setWorkflowName(Constants.AA_CREATE_WORKFLOW);
        workflow.setPayloadData(payload.toString());
        workflow.setCreatedOn(new Timestamp(new Date().getTime()));
        workflow.setStatus(OpertionStatus.IN_PROGRESS.name());
        workflow.setNext(OpertionStatus.EVENT_A.name());
        List<String> tasks = new ArrayList<>();
        tasks.add(OpertionStatus.EVENT_A.name());
        tasks.add(OpertionStatus.EVENT_B.name());
        tasks.add(OpertionStatus.EVENT_C.name());
        workflow.setTasks(tasks);
        return workflow;
    }


}
