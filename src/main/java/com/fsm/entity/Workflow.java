package com.fsm.entity;

import com.fsm.activity.ConditionalTask;
import com.fsm.activity.Task;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

public class Workflow {

    private UUID workflowID;
    private String workflowName;
    private String resourceName;
    private String payloadData;
    private String status;
    private String next;
    private Timestamp createdOn;
    private List<String> tasks;

    public List<String> getTasks() {
        return tasks;
    }

    public void setTasks(List<String> tasks) {
        this.tasks = tasks;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public UUID getWorkflowID() {
        return workflowID;
    }

    public void setWorkflowID(UUID workflowID) {
        this.workflowID = workflowID;
    }

    public String getWorkflowName() {
        return workflowName;
    }

    public void setWorkflowName(String workflowName) {
        this.workflowName = workflowName;
    }

    public String getPayloadData() {
        return payloadData;
    }

    public void setPayloadData(String payloadData) {
        this.payloadData = payloadData;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Timestamp createdOn) {
        this.createdOn = createdOn;
    }

    @Override
    public String toString() {
        return "Workflow{" +
                "workflowID=" + workflowID +
                ", workflowName='" + workflowName + '\'' +
                ", payloadData='" + payloadData + '\'' +
                ", status='" + status + '\'' +
                ", createdOn=" + createdOn +
                '}';
    }

}
