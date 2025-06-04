package testbench;

import bench.DemoBenchmark;
import bench.IBenchmark;
import logging.ConsoleLogger;
import logging.ILogger;
import timing.ITimer;

public class TestDemoBench {

    public static void main(String[] args) {
        ITimer timer = new timing.Timer();
        ILogger log = new ConsoleLogger();

        IBenchmark bench = new DemoBenchmark();

        int workloadSize = 10000;

        log.write("Starting simple benchmark run...");

        bench.warmup();

        bench.initialize(workloadSize);

        timer.start();

        bench.run();

        long elapsedTime = timer.stop();

        log.write("Elapsed time: " + elapsedTime + " ns");

        bench.clean();
        log.close();

    }
}
