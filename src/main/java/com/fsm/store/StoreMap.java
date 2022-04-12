package com.fsm.store;

import com.fsm.entity.Workflow;

import java.util.HashMap;
import java.util.Map;

public class StoreMap {

    private static Map<String, Workflow> workflowStore;

    private StoreMap() {
    }

    public static Map<String,Workflow> getStoreMap() {
        if (workflowStore == null) {
            workflowStore = new HashMap<>();
        }
        return workflowStore;
    }
}
