import bench.DemoBenchmark;
import bench.IBenchmark;
import logging.ConsoleLogger;
import logging.FileLogger;
import logging.ILogger;
import logging.TimeUnit;
import timing.ITimer;
import timing.Timer;



public class Main {
    public static void main(String[] args) {
        ITimer timer = new Timer();
        ILogger consoleLog = new ConsoleLogger();
        ILogger fileLog = new FileLogger("main_test_log.txt"); 
        IBenchmark benchmark = new DemoBenchmark();

        int workload = 5000; 

        consoleLog.write("=== Main Test Suite Starting ===");
        fileLog.write("=== Main Test Suite Starting ===");

        consoleLog.write("\n--- Testing Basic Run ---");
        fileLog.write("\n--- Testing Basic Run ---");
        benchmark.initialize(workload);
        timer.start();
        benchmark.run();
        long basicTime = timer.stop();
        consoleLog.writeTime("Basic run time:", basicTime, TimeUnit.Milli);
        fileLog.writeTime("Basic run time:", basicTime, TimeUnit.Milli);
        benchmark.clean();

        consoleLog.write("\n--- Testing Pause/Resume ---");
        fileLog.write("\n--- Testing Pause/Resume ---");
        int iterations = 3;
        benchmark.initialize(workload / iterations);
        timer.start();
        for (int i = 0; i < iterations; i++) {
            timer.resume();
            benchmark.run();
            long iterTime = timer.pause();
            consoleLog.writeTime("Iteration " + (i + 1) + " time:", iterTime, TimeUnit.Micro);
            fileLog.writeTime("Iteration " + (i + 1) + " time:", iterTime, TimeUnit.Micro);
            try { Thread.sleep(50); } catch (InterruptedException ignored) {}
        }
        long totalTime = timer.stop();
        consoleLog.writeTime("Total Pause/Resume time:", totalTime, TimeUnit.Milli);
        fileLog.writeTime("Total Pause/Resume time:", totalTime, TimeUnit.Milli);
        benchmark.clean();
        consoleLog.write("\n--- Testing Timer Accuracy ---");
        fileLog.write("\n--- Testing Timer Accuracy ---");
        int sleepMs = 200;
        long expectedNs = (long)sleepMs * 1_000_000;
        timer.start();
        try {
            Thread.sleep(sleepMs);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        long measuredNs = timer.stop();
        consoleLog.write("Expected: " + sleepMs + " ms");
        fileLog.write("Expected: " + sleepMs + " ms");
        consoleLog.writeTime("Measured:", measuredNs, TimeUnit.Milli);
        fileLog.writeTime("Measured:", measuredNs, TimeUnit.Milli);
        double offset = 100.0 * (measuredNs - expectedNs) / expectedNs;
        consoleLog.write("Offset: " + String.format("%.2f%%", offset));
        fileLog.write("Offset: " + String.format("%.2f%%", offset));
        consoleLog.write("\n--- Testing TimeUnit Conversion ---");
        fileLog.write("\n--- Testing TimeUnit Conversion ---");
        long testNanos = 1_234_567_890L; 
        consoleLog.write("Original nanos: " + testNanos);
        fileLog.write("Original nanos: " + testNanos);
        consoleLog.writeTime("In Microseconds:", testNanos, TimeUnit.Micro);
        fileLog.writeTime("In Microseconds:", testNanos, TimeUnit.Micro);
        consoleLog.writeTime("In Milliseconds:", testNanos, TimeUnit.Milli);
        fileLog.writeTime("In Milliseconds:", testNanos, TimeUnit.Milli);
        consoleLog.writeTime("In Seconds:", testNanos, TimeUnit.Sec);
        fileLog.writeTime("In Seconds:", testNanos, TimeUnit.Sec);
        consoleLog.write("\n--- Testing Cancellation (short run) ---");
        fileLog.write("\n--- Testing Cancellation (short run) ---");
        benchmark.initialize(100000); 
        timer.start();
        new Thread(() -> {
            try { Thread.sleep(50); } catch (InterruptedException ignored) {}
            consoleLog.write("[Cancel] Requesting cancel...");
            fileLog.write("[Cancel] Requesting cancel...");
            benchmark.cancel();
        }).start();
        benchmark.run(); 
        long cancelTime = timer.stop();
        consoleLog.writeTime("Cancelled run time:", cancelTime, TimeUnit.Milli);
        fileLog.writeTime("Cancelled run time:", cancelTime, TimeUnit.Milli);
        benchmark.clean();
        consoleLog.write("\n=== Main Test Suite Finished ===");
        fileLog.write("\n=== Main Test Suite Finished ===");
        consoleLog.close();
        fileLog.close();
    }
}
