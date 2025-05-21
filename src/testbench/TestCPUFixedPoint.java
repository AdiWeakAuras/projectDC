package testbench;

import logging.ConsoleLogger;
import logging.ILog;
import logging.TimeUnit;
import timing.ITimer;
import timing.Timer;
import bench.IBenchmark;
import bench.cpu.CPUFixedPoint;

public class TestCPUFixedPoint {
    public static void main(String[] args) {
        ITimer timer = new Timer();
        ILog log = new ConsoleLogger();
        TimeUnit timeUnit = TimeUnit.Milli;

        IBenchmark bench = new CPUFixedPoint();
        bench.initialize(10_000_000); // 10M iterations
        bench.warmUp();

        timer.start();
        bench.run();
        long time = timer.stop();

        log.writeTime("Finished in", time, timeUnit);
        log.write(bench.getResult());

        double mops = ((CPUFixedPoint) bench).getMOPS(time);
        log.write("MOPS: " + String.format("%.2f", mops));

        bench.clean();
        log.close();
    }
}