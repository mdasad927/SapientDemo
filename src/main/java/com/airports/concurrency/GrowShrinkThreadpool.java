package com.airports.concurrency;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GrowShrinkThreadpool {

	private static Logger logger = LoggerFactory.getLogger(GrowShrinkThreadpool.class);
	public static void main(String[] args) {

		final BlockingQueue queue=new ArrayBlockingQueue<Runnable>(200);
		
		ThreadPoolExecutor threadPool = new ThreadPoolExecutor(3, 10, 5, TimeUnit.SECONDS,
				queue);
		
		threadPool.setRejectedExecutionHandler(new RejectedExecutionHandler() {
			
			@Override
			public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
				executor.setCorePoolSize(executor.getPoolSize()+1);
				//resubmit the rejected task
				try {
					executor.getQueue().put(r);
				} catch (InterruptedException e) {
					logger.info("exception>>"+e);
				}
			}
		});
	}

}
