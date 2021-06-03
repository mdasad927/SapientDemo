package com.airports.concurrency;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RejectionAbortPolicy {

	 private static Logger logger = LoggerFactory.getLogger(RejectionAbortPolicy.class);
	
	public static void main(String[] args) {

		ThreadPoolExecutor executorA = new ThreadPoolExecutor(10, 10, 5, TimeUnit.SECONDS,
				new ArrayBlockingQueue<Runnable>(0), new ThreadPoolExecutor.AbortPolicy());
		
		for (int i = 0; i < 11; i++) {
			executorA.execute(new MyTask("task" + i));
		}
		

		executorA.setRejectedExecutionHandler(new RejectedExecutionHandler() {
			
			@Override
			public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {

			throw new RejectedExecutionException("Task " + r.toString() + " rejected from " + executor.toString());
			}});
	
	}
	
	
}
