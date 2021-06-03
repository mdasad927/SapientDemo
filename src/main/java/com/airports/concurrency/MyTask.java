package com.airports.concurrency;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import helpers.PropertyHelper;

public class MyTask implements Runnable {

	private static Logger logger = LoggerFactory.getLogger(MyTask.class);

    private String name;

    public String getName() {
        return name;
    }

    public MyTask(String name) {
        this.name = name;
        
    }

    public void run() {
    	try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			logger.info("exception"+e);
		}
		System.out.println("thread:" + Thread.currentThread().getName() + " implement:" + name + "  run");
    }

}
