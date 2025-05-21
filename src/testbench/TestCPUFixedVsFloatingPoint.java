package testbench;

import logging.ConsoleLogger;
import logging.ILog;
import logging.TimeUnit;
import timing.ITimer;
import timing.Timer;
import bench.IBenchmark;
import bench.cpu.CPUFixedVsFloatingPoint;
import bench.cpu.NumberRepresentation;

public class TestCPUFixedVsFloatingPoint {
	public static void main(String[] args) {
		// Initialize tools
		ITimer timer = new Timer();
		ILog log = new ConsoleLogger();
		TimeUnit timeUnit = TimeUnit.Milli;

		// Create and initialize benchmark
		IBenchmark bench = new CPUFixedVsFloatingPoint();
		final int workload = 100_000_000; // 100 million iterations
		bench.initialize(workload);

		// Warm-up phase
		log.write("Warming up...");
		bench.warmUp();

		// Test fixed-point
		log.write("\nTesting FIXED POINT performance");
		timer.start();
		bench.run(NumberRepresentation.FIXED);
		long fixedTime = timer.stop();

		double fixedTimeSec = TimeUnit.toTimeUnit(fixedTime, TimeUnit.Sec);
		long fixedOps = ((CPUFixedVsFloatingPoint)bench).getOperations();
		double fixedMOPS = fixedOps / (fixedTimeSec * 1e6);

		log.writeTime("Fixed-point finished in", fixedTime, timeUnit);
		log.write("Operations: " + String.format("%,d", fixedOps));
		log.write("MOPS: " + String.format("%.2f", fixedMOPS));

		// Test floating-point
		log.write("\nTesting FLOATING POINT performance");
		timer.start();
		bench.run(NumberRepresentation.FLOATING);
		long floatTime = timer.stop();

		double floatTimeSec = TimeUnit.toTimeUnit(floatTime, TimeUnit.Sec);
		long floatOps = ((CPUFixedVsFloatingPoint)bench).getOperations();
		double floatMOPS = floatOps / (floatTimeSec * 1e6);

		log.writeTime("Floating-point finished in", floatTime, timeUnit);
		log.write("Operations: " + String.format("%,d", floatOps));
		log.write("MOPS: " + String.format("%.2f", floatMOPS));

		// Calculate speedup
		double speedup = floatTime / (double)fixedTime;
		log.write("\nSpeedup (fixed vs float): " + String.format("%.2fx", speedup));

		// Cleanup
		bench.clean();
		log.close();
	}
}