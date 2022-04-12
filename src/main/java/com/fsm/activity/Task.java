package com.fsm.activity;


import java.util.concurrent.Callable;

public interface Task extends Callable<Boolean> {

    String status(ConditionalTask task) throws Exception;

}
