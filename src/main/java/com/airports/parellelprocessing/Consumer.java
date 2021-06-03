package com.airports.parellelprocessing;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;
import java.util.stream.Stream;


public class Consumer {
	
	

	    
	    public void readFile() throws IOException, InterruptedException {
	        Supplier<Stream<Path>> supp = () -> {
	            try {
	                return Files.list(Paths.get("D:\\Learning\\New folder\\output"));
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	            return null;
	        };
	        long count = supp.get().count();
	        System.out.println(count);
	        
	        ExecutorService service = Executors.newFixedThreadPool(50);
	        Runnable cons = new Consumers(supp);
	        
	        service.execute(cons);
	    }

	  

	    public static class Consumers implements Runnable {
	        private Supplier<Stream<Path>> str;

	        public Consumers(Supplier<Stream<Path>> str) {
	            this.str = str;
	        }

	        public void run() {
	            str.get().forEach(s -> {
	                try {
	                    Files.readString(s).lines().sorted();
	                    Files.deleteIfExists(s);
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            });
	        }
	    }

	    public static void main(String[] args) throws IOException, InterruptedException {
	        Consumer consumer = new Consumer();
	        consumer.readFile();
	    }
	
}
