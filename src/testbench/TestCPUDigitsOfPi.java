
package testbench;

import bench.IBenchmark;
import bench.cpu.CPUDigitsOfPi;
import logging.ConsoleLogger;
import logging.ILog;
import timing.ITimer;
import timing.Timer;

public class TestCPUDigitsOfPi {
    public static void main(String[] args) {
        IBenchmark benchmark = new CPUDigitsOfPi();
        ILog log = new ConsoleLogger();
        ITimer timer = new Timer();

        int digits = 1000; // Adjust number of digits as needed
        int runs = 5;

        benchmark.initialize(digits);
        benchmark.warmup();

        for (int i = 0; i < runs; i++) {
            timer.start();
            benchmark.run();
            long elapsed = timer.stop();
            log.writeTime("Run " + (i + 1), elapsed, timer.getUnit());
        }

        benchmark.clean();
    }
}
