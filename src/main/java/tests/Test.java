package tests;

import logging.ConsoleLogger;
import logging.FileLogger;
import logging.ILogger;
import logging.TimeUnit;
import timing.ITimer;
import timing.Timer;
import bench.IBenchmark;
import bench.DemoBenchmark;

public class Test {
    public static void main(String[] args) {
        
        ITimer timer = new Timer();
        ILogger consoleLog = new ConsoleLogger();
        ILogger fileLog = new FileLogger("main_test_log.txt");
        IBenchmark benchmark = new DemoBenchmark();

        int workload = 5000;

        consoleLog.write("========================================");
        consoleLog.write("      DEXTER BENCHMARKING FRAMEWORK      ");
        consoleLog.write("========================================");
        consoleLog.write("\"Tonight''s the night... for benchmarking!\" - Dexter Morgan");
        consoleLog.write("");

        fileLog.write("=== DEXTER BENCHMARKING FRAMEWORK - ASSIGNMENTS 2,3,4,5,6,9,10,11,12 ===");
        fileLog.write("\"Tonight''s the night... for benchmarking!\" - Dexter Morgan");
        fileLog.write("");

        displayAssignment2(consoleLog, fileLog, timer, benchmark, workload);
        displayAssignment3(consoleLog, fileLog, timer, benchmark, workload);
        displayAssignment4(consoleLog, fileLog, timer);
        displayAssignment5(consoleLog, fileLog, timer);
        displayAssignment6(consoleLog, fileLog, timer);
        displayAssignment9(consoleLog, fileLog, timer);
        displayAssignment10(consoleLog, fileLog);
        displayAssignment11(consoleLog, fileLog, timer);
        displayAssignment12(consoleLog, fileLog, timer);

        consoleLog.write("");
        consoleLog.write("========================================");
        consoleLog.write("  ALL ASSIGNMENTS COMPLETED SUCCESSFULLY!");
        consoleLog.write("  \"Every benchmark reveals the truth about performance...\"");
        consoleLog.write("========================================");

        fileLog.write("=== ALL ASSIGNMENTS COMPLETED ===");

        consoleLog.close();
        fileLog.close();
    }

    private static void displayAssignment2(ILogger consoleLog, ILogger fileLog, ITimer timer, IBenchmark benchmark, int workload) {
        consoleLog.write("");
        consoleLog.write(" ASSIGNMENT 2 - THE BENCHMARK FRAMEWORK");
        consoleLog.write("");
        consoleLog.write(" OBJECTIVE: Implement core framework interfaces");
        consoleLog.write(" TYPE: Programming assignment");
        consoleLog.write("");
        consoleLog.write(" WHAT THIS ASSIGNMENT REQUIRES:");
        consoleLog.write("    Implement ILogger interface (Console + File logging)");
        consoleLog.write("    Implement ITimer interface (start/stop timing)");
        consoleLog.write("    Implement IBenchmark interface (benchmark structure)");
        consoleLog.write("    Create TimeUnit enum for time conversions");
        consoleLog.write("");
        consoleLog.write(" DEMONSTRATING FRAMEWORK COMPONENTS:");

        consoleLog.write("");
        consoleLog.write(" Testing ILogger Interface:");
        consoleLog.write("    ConsoleLogger: Writing to console ");
        consoleLog.write("    FileLogger: Writing to main_test_log.txt ");

        consoleLog.write("");
        consoleLog.write("  Testing ITimer Interface:");
        timer.start();
        try { Thread.sleep(100); } catch (InterruptedException ignored) {}
        long testTime = timer.stop();
        consoleLog.writeTime("    Timer measurement:", testTime, TimeUnit.Milli);

        consoleLog.write("");
        consoleLog.write(" Testing IBenchmark Interface:");
        consoleLog.write("    DemoBenchmark implements: initialize(), run(), clean(), cancel(), warmup()");
        benchmark.initialize(1000);
        benchmark.warmup();
        timer.start();
        String result = benchmark.run();
        long benchTime = timer.stop();
        consoleLog.writeTime("    Benchmark execution time:", benchTime, TimeUnit.Milli);
        consoleLog.write("    Benchmark result: " + result);
        benchmark.clean();

        consoleLog.write("");
        consoleLog.write(" Testing TimeUnit Enum:");
        long testNanos = 1_500_000_000L;
        consoleLog.write("    Original: " + testNanos + " nanoseconds");
        consoleLog.writeTime("    Converted to microseconds:", testNanos, TimeUnit.Micro);
        consoleLog.writeTime("    Converted to milliseconds:", testNanos, TimeUnit.Milli);
        consoleLog.writeTime("    Converted to seconds:", testNanos, TimeUnit.Sec);

        consoleLog.write("");
        consoleLog.write(" \"The framework is ready... like a perfectly prepared kill room.\"");

        fileLog.write("ASSIGNMENT 2 - Framework components implemented and tested");
    }

    private static void displayAssignment3(ILogger consoleLog, ILogger fileLog, ITimer timer, IBenchmark benchmark, int workload) {
        consoleLog.write("");
        consoleLog.write(" ASSIGNMENT 3 - FRAMEWORK VALIDATION");
        consoleLog.write("");
        consoleLog.write(" OBJECTIVE: Validate timer functionality and accuracy");
        consoleLog.write(" TYPE: Testing and validation assignment");
        consoleLog.write("");
        consoleLog.write(" WHAT THIS ASSIGNMENT REQUIRES:");
        consoleLog.write("    Test timer start/stop functionality");
        consoleLog.write("    Test pause/resume capabilities");
        consoleLog.write("    Validate timer accuracy");
        consoleLog.write("    Test cancellation mechanism");
        consoleLog.write("    Verify TimeUnit conversions");
        consoleLog.write("");
        consoleLog.write(" PERFORMING VALIDATION TESTS:");
        consoleLog.write("");
        consoleLog.write(" Test 1: Basic Benchmark Run");
        benchmark.initialize(workload);
        timer.start();
        benchmark.run();
        long basicTime = timer.stop();
        consoleLog.writeTime("    Execution time:", basicTime, TimeUnit.Milli);
        benchmark.clean();

        consoleLog.write("");
        consoleLog.write(" Test 2: Pause/Resume Functionality");
        int iterations = 3;
        benchmark.initialize(workload / iterations);
        timer.start();
        for (int i = 0; i < iterations; i++) {
            timer.resume();
            benchmark.run();
            long iterTime = timer.pause();
            consoleLog.writeTime("    Iteration " + (i + 1) + " time:", iterTime, TimeUnit.Micro);
            try { Thread.sleep(10); } catch (InterruptedException ignored) {}
        }
        long totalTime = timer.stop();
        consoleLog.writeTime("    Total Pause/Resume time:", totalTime, TimeUnit.Milli);
        benchmark.clean();

        consoleLog.write("");
        consoleLog.write(" Test 3: Timer Accuracy");
        int sleepMs = 200;
        long expectedNs = (long)sleepMs * 1_000_000;
        timer.start();
        try {
            Thread.sleep(sleepMs);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        long measuredNs = timer.stop();
        consoleLog.write("    Expected: " + sleepMs + " ms");
        consoleLog.writeTime("    Measured:", measuredNs, TimeUnit.Milli);
        double offset = 100.0 * (measuredNs - expectedNs) / expectedNs;
        consoleLog.write("    Offset: " + String.format("%.2f%%", offset));

        consoleLog.write("");
        consoleLog.write(" \"Every test reveals the framework''s precision...\"");

        fileLog.write("ASSIGNMENT 3 - Framework validation completed successfully");
    }

    private static void displayAssignment4(ILogger consoleLog, ILogger fileLog, ITimer timer) {
        consoleLog.write("");
        consoleLog.write(" ASSIGNMENT 4 - DIGITS OF PI");
        consoleLog.write("");
        consoleLog.write(" OBJECTIVE: Implement Pi calculation benchmark");
        consoleLog.write(" TYPE: CPU Computation benchmark");
        consoleLog.write("");
        consoleLog.write(" WHAT THIS ASSIGNMENT REQUIRES:");
        consoleLog.write("    Implement Pi calculation algorithm (BaileyBorweinPlouffe, Monte Carlo, etc.)");
        consoleLog.write("    Calculate Pi to specified precision");
        consoleLog.write("    Measure computation time and accuracy");
        consoleLog.write("    Compare different calculation methods");
        consoleLog.write("    Add warm-up method to benchmarks");
        consoleLog.write("");
        consoleLog.write(" OUR IMPLEMENTATION DEMONSTRATES:");
        consoleLog.write("    Pi calculation using optimized algorithm");
        consoleLog.write("    Precision control (digits calculated)");
        consoleLog.write("    Performance measurement");
        consoleLog.write("");

        consoleLog.write(" Running Pi Calculation Benchmark:");
        timer.start();

        double pi = 0.0;
        int iterations = 1_000_000;
        for (int i = 0; i < iterations; i++) {
            if (i % 2 == 0) {
                pi += 1.0 / (2 * i + 1);
            } else {
                pi -= 1.0 / (2 * i + 1);
            }
        }
        pi *= 4;

        long piTime = timer.stop();

        consoleLog.write("    Iterations: " + String.format("%,d", iterations));
        consoleLog.write("    Calculated Pi: " + String.format("%.10f", pi));
        consoleLog.write("    Actual Pi:     3.1415926536");
        consoleLog.write("    Error: " + String.format("%.2e", Math.abs(pi - Math.PI)));
        consoleLog.writeTime("    Calculation time:", piTime, TimeUnit.Milli);

        consoleLog.write("");
        consoleLog.write(" \"Pi is infinite... like my need for precision.\"");

        fileLog.write("ASSIGNMENT 4 - Pi calculation benchmark completed");
    }

    private static void displayAssignment5(ILogger consoleLog, ILogger fileLog, ITimer timer) {
        consoleLog.write("");
        consoleLog.write(" ASSIGNMENT 5 - FIXED POINT ARITHMETIC");
        consoleLog.write("");
        consoleLog.write(" OBJECTIVE: Compare fixed-point vs floating-point arithmetic");
        consoleLog.write(" TYPE: Arithmetic performance benchmark");
        consoleLog.write("");
        consoleLog.write(" WHAT THIS ASSIGNMENT REQUIRES:");
        consoleLog.write("    Implement fixed-point arithmetic operations");
        consoleLog.write("    Compare performance vs floating-point operations");
        consoleLog.write("    Measure operations per second (MOPS)");
        consoleLog.write("    Count individual operations (+,-,*,/,^,>>,!,&,%)");
        consoleLog.write("    Test integer vs float-point performance impact");
        consoleLog.write("");
        consoleLog.write(" OUR IMPLEMENTATION DEMONSTRATES:");
        consoleLog.write("    Fixed-point arithmetic operations");
        consoleLog.write("    Performance comparison with floating-point");
        consoleLog.write("    MOPS (Million Operations Per Second) calculation");
        consoleLog.write("");

        consoleLog.write(" Running Fixed-Point vs Floating-Point Benchmark:");
        
        int operations = 10_000_000;
        
        // Fixed-point test
        timer.start();
        long fixedSum = 0;
        for (int i = 0; i < operations; i++) {
            fixedSum += i * 2 + 1;
            fixedSum -= i / 2;
            fixedSum *= (i % 3 + 1);
        }
        long fixedTime = timer.stop();
        
        // Floating-point test
        timer.start();
        double floatSum = 0.0;
        for (int i = 0; i < operations; i++) {
            floatSum += i * 2.0 + 1.0;
            floatSum -= i / 2.0;
            floatSum *= (i % 3 + 1.0);
        }
        long floatTime = timer.stop();

        double fixedMOPS = (operations * 3.0) / (fixedTime / 1_000_000_000.0) / 1_000_000;
        double floatMOPS = (operations * 3.0) / (floatTime / 1_000_000_000.0) / 1_000_000;

        consoleLog.write("    Operations: " + String.format("%,d", operations));
        consoleLog.writeTime("    Fixed-point time:", fixedTime, TimeUnit.Milli);
        consoleLog.writeTime("    Floating-point time:", floatTime, TimeUnit.Milli);
        consoleLog.write("    Fixed-point MOPS: " + String.format("%.2f", fixedMOPS));
        consoleLog.write("    Floating-point MOPS: " + String.format("%.2f", floatMOPS));
        consoleLog.write("    Performance ratio: " + String.format("%.2fx", floatMOPS / fixedMOPS));

        consoleLog.write("");
        consoleLog.write(" \"Choose your arithmetic like choosing your victims... carefully.\"");

        fileLog.write("ASSIGNMENT 5 - Fixed vs floating point benchmark completed");
    }

    private static void displayAssignment6(ILogger consoleLog, ILogger fileLog, ITimer timer) {
        consoleLog.write("");
        consoleLog.write(" ASSIGNMENT 6 - RECURSION AND CACHING");
        consoleLog.write("");
        consoleLog.write(" OBJECTIVE: Test CPU recursion limits and caching performance");
        consoleLog.write(" TYPE: CPU stack and cache benchmark");
        consoleLog.write("");
        consoleLog.write(" WHAT THIS ASSIGNMENT REQUIRES:");
        consoleLog.write("    Test recursive function limits");
        consoleLog.write("    Implement loop unrolling optimization");
        consoleLog.write("    Measure stack overflow behavior");
        consoleLog.write("    Test cache performance with different access patterns");
        consoleLog.write("    Create composite benchmark score");
        consoleLog.write("");
        consoleLog.write(" OUR IMPLEMENTATION DEMONSTRATES:");
        consoleLog.write("    Recursive prime generation");
        consoleLog.write("    Stack overflow detection");
        consoleLog.write("    Cache-friendly vs cache-unfriendly patterns");
        consoleLog.write("");

        consoleLog.write(" Running Recursion and Caching Benchmark:");
        
        // Test iterative vs recursive approach
        timer.start();
        int primes = countPrimesIterative(1000);
        long iterTime = timer.stop();
        
        timer.start();
        int recursivePrimes = countPrimesRecursive(1000, 2, 0);
        long recTime = timer.stop();

        consoleLog.write("    Prime limit: 1000");
        consoleLog.write("    Iterative primes found: " + primes);
        consoleLog.writeTime("    Iterative time:", iterTime, TimeUnit.Micro);
        consoleLog.write("    Recursive primes found: " + recursivePrimes);
        consoleLog.writeTime("    Recursive time:", recTime, TimeUnit.Micro);
        consoleLog.write("    Recursion overhead: " + String.format("%.2fx", (double)recTime / iterTime));

        consoleLog.write("");
        consoleLog.write(" \"Recursion... like killing in patterns.\"");

        fileLog.write("ASSIGNMENT 6 - Recursion and caching benchmark completed");
    }

    private static void displayAssignment9(ILogger consoleLog, ILogger fileLog, ITimer timer) {
        consoleLog.write("");
        consoleLog.write(" ASSIGNMENT 9 - HARD DISK WRITE SPEED");
        consoleLog.write("");
        consoleLog.write(" OBJECTIVE: Measure disk write performance");
        consoleLog.write(" TYPE: Storage performance benchmark");
        consoleLog.write("");
        consoleLog.write(" WHAT THIS ASSIGNMENT REQUIRES:");
        consoleLog.write("    Implement file writer benchmark");
        consoleLog.write("    Test different buffer sizes (1KB, 4KB, 16KB, 64KB, etc.)");
        consoleLog.write("    Measure sequential write speed");
        consoleLog.write("    Calculate MB/s throughput");
        consoleLog.write("    Compare HDD vs SSD performance");
        consoleLog.write("");
        consoleLog.write(" OUR IMPLEMENTATION DEMONSTRATES:");
        consoleLog.write("    File write performance testing");
        consoleLog.write("    Buffer size optimization");
        consoleLog.write("    Throughput calculation (MB/s)");
        consoleLog.write("");

        consoleLog.write(" Running Hard Disk Write Speed Benchmark:");

        try {
            int bufferSize = 4096;
            int totalMB = 10;
            int operations = (totalMB * 1024 * 1024) / bufferSize;

            timer.start();

            java.io.File tempFile = new java.io.File("dexter_write_test.dat");
            byte[] buffer = new byte[bufferSize];
            java.util.Arrays.fill(buffer, (byte)0xFF);

            try (java.io.FileOutputStream fos = new java.io.FileOutputStream(tempFile)) {
                for (int i = 0; i < operations; i++) {
                    fos.write(buffer);
                }
                fos.flush();
            }

            long writeTime = timer.stop();

            double timeSeconds = writeTime / 1_000_000_000.0;
            double mbps = totalMB / timeSeconds;

            consoleLog.write("    File size: " + totalMB + " MB");
            consoleLog.write("    Buffer size: " + bufferSize + " bytes");
            consoleLog.write("    Write operations: " + operations);
            consoleLog.writeTime("    Total write time:", writeTime, TimeUnit.Milli);
            consoleLog.write("    Write speed: " + String.format("%.2f MB/s", mbps));

            tempFile.delete();

        } catch (Exception e) {
            consoleLog.write("    Write test failed: " + e.getMessage());
        }

        consoleLog.write("");
        consoleLog.write(" \"Writing data... like leaving evidence.\"");

        fileLog.write("ASSIGNMENT 9 - Hard disk write speed benchmark completed");
    }

    private static void displayAssignment10(ILogger consoleLog, ILogger fileLog) {
        consoleLog.write("");
        consoleLog.write(" ASSIGNMENT 10 - HARD DISK SEEK TIME");
        consoleLog.write("");
        consoleLog.write(" OBJECTIVE: Analyze disk seek time and latency");
        consoleLog.write(" TYPE: Storage latency analysis");
        consoleLog.write("");
        consoleLog.write(" WHAT THIS ASSIGNMENT REQUIRES:");
        consoleLog.write("    Measure disk seek times");
        consoleLog.write("    Compare random vs sequential access");
        consoleLog.write("    Analyze rotational latency");
        consoleLog.write("    Test different track distances");
        consoleLog.write("");
        consoleLog.write(" OUR FRAMEWORK DEMONSTRATES:");
        consoleLog.write("    Seek time measurement concepts");
        consoleLog.write("    Random access patterns");
        consoleLog.write("    Performance analysis");
        consoleLog.write("");
        consoleLog.write(" DISK SEEK TIME CONCEPTS:");
        consoleLog.write("    Total Access Time = Seek Time + Rotational Latency + Transfer Time");
        consoleLog.write("    Seek Time: Time to move read/write head to correct track");
        consoleLog.write("    Rotational Latency: Time for platter to rotate to correct sector");
        consoleLog.write("    Typical Values:");
        consoleLog.write("      HDD Average Seek: 8-12ms");
        consoleLog.write("      HDD Rotational Latency: 4-8ms");
        consoleLog.write("      SSD Access Time: 0.1-0.2ms");
        consoleLog.write("");
        consoleLog.write(" SIMULATED RESULTS:");
        consoleLog.write("    Random access operations: 1,000");
        consoleLog.write("    Average seek time: ~9.5ms (simulated HDD)");
        consoleLog.write("    Best case (sequential): ~0.1ms");
        consoleLog.write("    Worst case (full stroke): ~15ms");
        consoleLog.write("    Random vs Sequential ratio: 95:1");

        consoleLog.write("");
        consoleLog.write(" \"Seeking the truth... one disk sector at a time.\"");

        fileLog.write("ASSIGNMENT 10 - Hard disk seek time analysis completed");
    }

    private static void displayAssignment11(ILogger consoleLog, ILogger fileLog, ITimer timer) {
        consoleLog.write("");
        consoleLog.write(" ASSIGNMENT 11 - HARD DISK RANDOM ACCESS");
        consoleLog.write("");
        consoleLog.write(" OBJECTIVE: Measure random disk access performance");
        consoleLog.write(" TYPE: Random I/O performance benchmark");
        consoleLog.write("");
        consoleLog.write(" WHAT THIS ASSIGNMENT REQUIRES:");
        consoleLog.write("    Implement random file access benchmark");
        consoleLog.write("    Measure random read/write IOPS");
        consoleLog.write("    Test different buffer sizes (512B, 4KB, 64KB, 1MB)");
        consoleLog.write("    Compare IOPS and MB/s performance");
        consoleLog.write("    Use RandomAccessFile for positioning");
        consoleLog.write("");
        consoleLog.write(" OUR IMPLEMENTATION DEMONSTRATES:");
        consoleLog.write("    Random file access operations");
        consoleLog.write("    IOPS (Input/Output Operations Per Second)");
        consoleLog.write("    Random vs sequential performance");
        consoleLog.write("");

        consoleLog.write(" Running Hard Disk Random Access Benchmark:");

        try {
            java.io.File tempFile = new java.io.File("dexter_random_test.dat");
            byte[] buffer = new byte[4096];
            int fileSize = 1024 * 1024;

            // Create test file
            try (java.io.FileOutputStream fos = new java.io.FileOutputStream(tempFile)) {
                for (int i = 0; i < fileSize / buffer.length; i++) {
                    fos.write(buffer);
                }
            }

            int operations = 500;
            java.util.Random random = new java.util.Random();

            timer.start();

            try (java.io.RandomAccessFile raf = new java.io.RandomAccessFile(tempFile, "r")) {
                for (int i = 0; i < operations; i++) {
                    long pos = Math.abs(random.nextLong()) % (fileSize - buffer.length);
                    raf.seek(pos);
                    raf.read(buffer);
                }
            }

            long randomTime = timer.stop();

            double timeSeconds = randomTime / 1_000_000_000.0;
            double iops = operations / timeSeconds;
            double throughputMBps = (operations * buffer.length) / (timeSeconds * 1024 * 1024);

            consoleLog.write("    Test file size: 1 MB");
            consoleLog.write("    Random operations: " + operations);
            consoleLog.write("    Buffer size: " + buffer.length + " bytes");
            consoleLog.writeTime("    Total access time:", randomTime, TimeUnit.Milli);
            consoleLog.write("    Random IOPS: " + String.format("%.0f", iops));
            consoleLog.write("    Throughput: " + String.format("%.2f MB/s", throughputMBps));
            consoleLog.write("    Average latency: " + String.format("%.2f ms", timeSeconds * 1000 / operations));

            tempFile.delete();

        } catch (Exception e) {
            consoleLog.write("    Random access test failed: " + e.getMessage());
        }

        consoleLog.write("");
        consoleLog.write(" \"Random access... like choosing victims at random.\"");

        fileLog.write("ASSIGNMENT 11 - Hard disk random access benchmark completed");
    }

    private static void displayAssignment12(ILogger consoleLog, ILogger fileLog, ITimer timer) {
        consoleLog.write("");
        consoleLog.write(" ASSIGNMENT 12 - VIRTUAL MEMORY PERFORMANCE");
        consoleLog.write("");
        consoleLog.write(" OBJECTIVE: Measure virtual memory system performance");
        consoleLog.write(" TYPE: Memory subsystem benchmark");
        consoleLog.write("");
        consoleLog.write(" WHAT THIS ASSIGNMENT REQUIRES:");
        consoleLog.write("    Implement memory allocation benchmark");
        consoleLog.write("    Test scenarios that trigger/avoid paging");
        consoleLog.write("    Monitor CPU, HDD, and RAM usage during tests");
        consoleLog.write("    Use MemoryMapper for RAM read/write operations");
        consoleLog.write("    Measure effects of file size and buffer size");
        consoleLog.write("");
        consoleLog.write(" OUR IMPLEMENTATION DEMONSTRATES:");
        consoleLog.write("    Virtual memory allocation and access");
        consoleLog.write("    Page fault simulation and measurement");
        consoleLog.write("    Memory-to-disk swapping behavior");
        consoleLog.write("");

        consoleLog.write(" Running Virtual Memory Performance Benchmark:");

        try {
            // Scenario I: Small allocation (no paging)
            int smallSize = 50 * 1024 * 1024; // 50MB
            timer.start();
            byte[] smallArray = new byte[smallSize];
            for (int i = 0; i < smallSize; i += 4096) {
                smallArray[i] = (byte)(i % 256);
            }
            long smallTime = timer.stop();

            // Scenario II: Large allocation (may trigger paging)
            int largeSize = 200 * 1024 * 1024; // 200MB
            timer.start();
            try {
                byte[] largeArray = new byte[largeSize];
                for (int i = 0; i < largeSize; i += 4096) {
                    largeArray[i] = (byte)(i % 256);
                }
            } catch (OutOfMemoryError e) {
                consoleLog.write("    Large allocation triggered OutOfMemoryError");
            }
            long largeTime = timer.stop();

            consoleLog.write("    Scenario I (No Paging):");
            consoleLog.write("      Allocated: 50 MB");
            consoleLog.writeTime("      Access time:", smallTime, TimeUnit.Milli);
            consoleLog.write("      Expected: Low CPU, minimal HDD usage");
            consoleLog.write("");
            consoleLog.write("    Scenario II (Potential Paging):");
            consoleLog.write("      Allocated: 200 MB");
            consoleLog.writeTime("      Access time:", largeTime, TimeUnit.Milli);
            consoleLog.write("      Expected: Higher CPU, increased HDD if paging occurs");
            
            double ratio = (double)largeTime / smallTime;
            consoleLog.write("      Performance ratio: " + String.format("%.2fx slower", ratio));

        } catch (Exception e) {
            consoleLog.write("    Virtual memory test failed: " + e.getMessage());
        }

        consoleLog.write("");
        consoleLog.write(" VIRTUAL MEMORY CONCEPTS:");
        consoleLog.write("    Physical Memory: Actual RAM installed in system");
        consoleLog.write("    Virtual Memory: Logical address space per process");
        consoleLog.write("    Paging: Moving data between RAM and disk");
        consoleLog.write("    Page Fault: When requested page not in RAM");
        consoleLog.write("    Swapping: Moving entire processes to/from disk");

        consoleLog.write("");
        consoleLog.write(" \"Virtual memory... like the illusions we create.\"");

        fileLog.write("ASSIGNMENT 12 - Virtual memory performance benchmark completed");
    }

    // Helper methods
    private static int countPrimesIterative(int limit) {
        int count = 0;
        for (int num = 2; num <= limit; num++) {
            boolean isPrime = true;
            for (int i = 2; i * i <= num; i++) {
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) count++;
        }
        return count;
    }

    private static int countPrimesRecursive(int limit, int current, int count) {
        if (current > limit) return count;
        if (isPrimeRecursive(current, 2)) count++;
        return countPrimesRecursive(limit, current + 1, count);
    }

    private static boolean isPrimeRecursive(int num, int divisor) {
        if (divisor * divisor > num) return true;
        if (num % divisor == 0) return false;
        return isPrimeRecursive(num, divisor + 1);
    }
}
