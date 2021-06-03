package com.airports.concurrency;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RejectionHandler {

	  private static Logger logger = LoggerFactory.getLogger(RejectionHandler.class);
	public static void main(String[] args) {

		// wait for 5 second

		ThreadPoolExecutor executorService = new ThreadPoolExecutor(10, 10, 5, TimeUnit.SECONDS,
				new ArrayBlockingQueue<Runnable>(0), new ThreadPoolExecutor.AbortPolicy());
		for (int i = 0; i < 11; i++) {
			executorService.execute(new MyTask("task" + i));
		} 
		executorService.setRejectedExecutionHandler(new RejectedExecutionHandler() {
			
			@Override
			public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {

				e.shutdown(); 
				if(!e.isTerminated()){ 
					try {
						e.awaitTermination(5,
						  TimeUnit.SECONDS); 
						} catch (InterruptedException exception) {
						  logger.info("Task " + r.toString() + " rejected from " + e.toString()); } }
			}});
	}
	
}
