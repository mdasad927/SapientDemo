package com.airports.concurrency;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class RejectionDiscardOldestPolicy {

	public static void main(String[] args) {

		ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 2, 5, TimeUnit.SECONDS,
				new LinkedBlockingDeque<Runnable>(2), new ThreadPoolExecutor.DiscardOldestPolicy());

		for (int i = 0; i < 7; i++) {
			executor.execute(new MyTask("task" + i));
		}
executor.setRejectedExecutionHandler(new RejectedExecutionHandler() {
			
			@Override
			public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {

				if (!e.isShutdown()) {
		            e.getQueue().poll();
		            e.execute(r);
		        }
			}});
	}
	

}
