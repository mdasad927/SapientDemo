package com.airports.concurrency;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class CustomThreadPool {
    public static void main(String[] args) throws InterruptedException {
        /*final BlockingQueueDemo demo = new BlockingQueueDemo();
        IntStream.range(0, 1022).forEach(r -> {
            try {
                demo.enqueue("xx");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });*/
    	
    	final BlockingQueue queue = new ArrayBlockingQueue<Runnable>(10);
    	ThreadPoolExecutor threadPool = new ThreadPoolExecutor(15, 15,
    	       5, TimeUnit.SECONDS, queue);
    	// by default the ThreadPoolExecutor will call the rejected
    	// handler when you submit the 16th job, to have it block you do:
    	threadPool.setRejectedExecutionHandler(new RejectedExecutionHandler() {
    	   public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
    	      // this will block if the queue is full
    	      try {
				executor.getQueue().put(r);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	   }
    	});
    	
    	ThreadPoolExecutor executorA = new ThreadPoolExecutor(10, 10, 0, 
    	        TimeUnit.SECONDS, 
    	        new LinkedBlockingDeque<Runnable>(2), 
    	        new ThreadPoolExecutor.AbortPolicy());
    	
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 2, 5,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<Runnable>(2),
                new ThreadPoolExecutor.DiscardOldestPolicy());

    }

    /*static class BlockingQueueDemo {
        List queue = new LinkedList<>();

        public synchronized void enqueue(Object item) throws InterruptedException {
            if (queue.size() == 10) {
                wait();
            }
            this.queue.add(item);
            if (this.queue.size() == 1) {
                notifyAll();
            }
        }

        public synchronized void dequeue(Object item) throws InterruptedException {
            while (this.queue.size() == 0) {
                wait();
            }
            if (this.queue.size() == 10) {
                notifyAll();
            }
            this.queue.remove(0);
        }*/
        
        public static class DiscardOldestPolicy implements RejectedExecutionHandler {
            public DiscardOldestPolicy() { }
            public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
                if (!e.isShutdown()) {
                    e.getQueue().poll();
                    e.execute(r);
                }
            }
        }
        
        public static class AbortPolicy implements RejectedExecutionHandler {
            public AbortPolicy() { }
            public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
                throw new RejectedExecutionException("Task " + r.toString() +
                                                     " rejected from " +
                                                     e.toString());
            }
            
        }
        static class MyThread implements Runnable {
            String name;
            public MyThread(String name) {
                this.name = name;
            }
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread:"+Thread.currentThread().getName() +" implement:"+name +"  run");
            }
        }
    }

