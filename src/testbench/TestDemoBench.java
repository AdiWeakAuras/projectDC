package testbench;

import bench.DemoBenchmark;
import bench.IBenchmark;
import logging.ConsoleLogger;
import logging.ILogger;
import logging.TimeUnit;
import timing.ITimer;
import timing.Timer;

public class TestDemoBench {

    public static void main(String[] args) {
        ITimer timer = new Timer();
        ILogger log = new ConsoleLogger();
        // ILogger fileLog = new FileLogger("testlog.txt"); 
        IBenchmark bench = new DemoBenchmark();

        int workloadSize = 10000;

        log.write("Starting simple benchmark run...");
        bench.initialize(workloadSize);
        timer.start();
        bench.run();
        long time = timer.stop();
        log.writeTime("simple run finished in", time, TimeUnit.Milli);
        bench.clean();
        log.write("------------------------------------");

        log.write("Testing pause/resume/stop sequence...");
        int numIterations = 5;
        long totalMeasuredTime = 0;
        bench.initialize(workloadSize / numIterations);

        timer.start();
        for (int i = 0; i < numIterations; i++) {
            timer.resume();
            bench.run();
            long iterationTime = timer.pause();
            log.writeTime("Iteration " + (i+1) + " time (paused)", iterationTime, TimeUnit.Micro);
        }
        totalMeasuredTime = timer.stop();
        log.writeTime("Total measured time (stop)", totalMeasuredTime, TimeUnit.Milli);
        bench.clean();
        log.write("------------------------------------");

        log.write("Testing timer accuracy with Thread.sleep...");
        int sleepMillis = 500;
        long expectedNanos = (long)sleepMillis * 1_000_000;

        timer.start();
        try {
            Thread.sleep(sleepMillis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.write("Sleep interrupted!");
        }
        long measuredNanos = timer.stop();

        log.write("Expected time: " + sleepMillis + " ms");
        log.writeTime("Measured time", measuredNanos, TimeUnit.Milli);

        double offset = 0;
        if (expectedNanos > 0) {
             offset = 100.0 * (measuredNanos - expectedNanos) / expectedNanos;
        }
        log.write("Offset: " + String.format("%.2f", offset) + "%");
        log.write("------------------------------------");

        log.write("Testing cancellation (will run for ~1 second)...");
        IBenchmark cancelBench = new DemoBenchmark();
        cancelBench.initialize(1000000);

        Thread cancelThread = new Thread(() -> {
            try {
                Thread.sleep(1000);
                log.write("[Cancel Thread] Requesting cancellation...");
                cancelBench.cancel();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        timer.start();
        cancelThread.start();
        cancelBench.run();
        long cancelTime = timer.stop();

        try {
            cancelThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        log.writeTime("Cancelled run finished in", cancelTime, TimeUnit.Milli);
        cancelBench.clean();
        log.write("------------------------------------");


        log.close();
        // fileLog.close(); 
    }
}
