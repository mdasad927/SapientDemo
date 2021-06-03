package com.airports.parellelprocessing;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Timer;
import java.util.TimerTask;



public class Producer {

	public static void main(String[] args) {
        TimerTask tasknew = new TimerScheduleFixedRateDelay();
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(tasknew, 500000, 500000);
        TimerScheduleFixedRateDelay timerScheduleFixedRateDelay =new TimerScheduleFixedRateDelay();
        timerScheduleFixedRateDelay.run();
    }
    private static class TimerScheduleFixedRateDelay extends TimerTask {
    	
    	
        @Override
        public void run() {
            try {
                for (int i = 0; i < 25; i++) {
                    Files.copy(Paths.get("D:\\Learning\\New folder\\test-file\\airports.csv"),
                            Paths.get("D:\\Learning\\New folder\\output\\test-output_" + System.currentTimeMillis() + ".csv"), StandardCopyOption.REPLACE_EXISTING);
                }
            } catch (IOException e) {
            }
        }
    }
}
