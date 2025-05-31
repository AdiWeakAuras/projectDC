package testbench;

import logging.ConsoleLogger;
import logging.ILogger;
import logging.TimeUnit;
import timing.ITimer;
import timing.Timer;
import bench.IBenchmark;
import bench.cpu.CPUFixedVsFloatingPoint;

public class TestCPUFixedVsFloatingPoint {

    public static void main(String[] args) {
        ITimer timer = new Timer();
        ILogger log = new ConsoleLogger();
        TimeUnit timeUnit = TimeUnit.Milli;

        IBenchmark bench = new CPUFixedVsFloatingPoint();
        bench.initialize(1000);
        bench.warmup();

        timer.start();
        bench.run();
        long time = timer.stop();

        log.write("Finished benchmark in " + timeUnit.toTimeUnit(time, TimeUnit.Milli) + " ms");
    }
}
