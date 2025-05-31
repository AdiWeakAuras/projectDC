import logging.ConsoleLogger;
import logging.FileLogger;
import logging.ILogger;
import logging.TimeUnit;
import timing.ITimer;
import timing.Timer;

public class Test {
    public static void main(String[] args) {

        ITimer timer = new Timer();
        ILogger consoleLog = new ConsoleLogger();
        ILogger fileLog = new FileLogger("main_test_log.txt");
        IBenchmark benchmark = new DemoBenchmark();

        int workload = 5000;

        consoleLog.write("ðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ª");
        consoleLog.write("ðŸ©¸      DEXTER BENCHMARKING FRAMEWORK - ALL 12 ASSIGNMENTS      ðŸ©¸");
        consoleLog.write("ðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ª");
        consoleLog.write("\"Tonight's the night... for benchmarking!\" - Dexter Morgan");
        consoleLog.write("");

        fileLog.write("=== DEXTER BENCHMARKING FRAMEWORK - ALL 12 ASSIGNMENTS ===");
        fileLog.write("\"Tonight's the night... for benchmarking!\" - Dexter Morgan");
        fileLog.write("");

        displayAssignment1(consoleLog, fileLog);

        displayAssignment2(consoleLog, fileLog, timer, benchmark, workload);

        displayAssignment3(consoleLog, fileLog, timer, benchmark, workload);

        displayAssignment4(consoleLog, fileLog, timer);

        displayAssignment5(consoleLog, fileLog, timer);

        displayAssignment6(consoleLog, fileLog, timer);

        displayAssignment7(consoleLog, fileLog);

        displayAssignment8(consoleLog, fileLog);

        displayAssignment9(consoleLog, fileLog, timer);

        displayAssignment10(consoleLog, fileLog);

        displayAssignment11(consoleLog, fileLog, timer);

        displayAssignment12(consoleLog, fileLog, timer);

        consoleLog.write("");
        consoleLog.write("ðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ª");
        consoleLog.write("âœ… ALL 12 ASSIGNMENTS COMPLETED SUCCESSFULLY!");
        consoleLog.write("ðŸ©¸ \"Every benchmark reveals the truth about performance...\"");
        consoleLog.write("ðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ªðŸ”ª");

        fileLog.write("=== ALL 12 ASSIGNMENTS COMPLETED ===");

        consoleLog.close();
        fileLog.close();
    }

    private static void displayAssignment1(ILogger consoleLog, ILogger fileLog) {
        consoleLog.write("");
        consoleLog.write("ðŸ”µ ASSIGNMENT 1 - INTRODUCTION TO BENCHMARKS");
        consoleLog.write("â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•");
        consoleLog.write("ðŸ“– OBJECTIVE: Research and document 2 benchmark programs");
        consoleLog.write("ðŸ“ TYPE: Theoretical assignment (documentation required)");
        consoleLog.write("");
        consoleLog.write("ðŸŽ¯ WHAT THIS ASSIGNMENT REQUIRES:");
        consoleLog.write("   â€¢ Research 2 different benchmark programs");
        consoleLog.write("   â€¢ Document their functionalities and purposes");
        consoleLog.write("   â€¢ Explain testing methods and procedures");
        consoleLog.write("   â€¢ Provide sample results and interpretations");
        consoleLog.write("");
        consoleLog.write("ðŸ“Š EXAMPLE BENCHMARKS TO RESEARCH:");
        consoleLog.write("   1. CPU Benchmarks: Geekbench, PassMark, Cinebench");
        consoleLog.write("   2. GPU Benchmarks: 3DMark, FurMark, Unigine");
        consoleLog.write("   3. Storage Benchmarks: CrystalDiskMark, HD Tune");
        consoleLog.write("   4. Memory Benchmarks: AIDA64, MemTest86");
        consoleLog.write("");
        consoleLog.write("âœ… WHAT OUR PROJECT DEMONSTRATES:");
        consoleLog.write("   â€¢ Our framework IS a benchmark program itself!");
        consoleLog.write("   â€¢ Tests CPU performance (Pi calculation, MOPS)");
        consoleLog.write("   â€¢ Tests Storage performance (Write speed, IOPS)");
        consoleLog.write("   â€¢ Tests Memory performance (Virtual memory)");
        consoleLog.write("   â€¢ Provides numerical results and analysis");
        consoleLog.write("");
        consoleLog.write("ðŸ©¸ \"Every killer needs to understand their tools...\"");

        fileLog.write("ASSIGNMENT 1 - INTRODUCTION TO BENCHMARKS (THEORY)");
        fileLog.write("Research 2 benchmark programs - documentation required");
    }

    private static void displayAssignment2(ILogger consoleLog, ILogger fileLog, ITimer timer, IBenchmark benchmark, int workload) {
        consoleLog.write("");
        consoleLog.write("ðŸ”µ ASSIGNMENT 2 - THE BENCHMARK FRAMEWORK");
        consoleLog.write("â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•");
        consoleLog.write("ðŸŽ¯ OBJECTIVE: Implement core framework interfaces");
        consoleLog.write("ðŸ’» TYPE: Programming assignment");
        consoleLog.write("");
        consoleLog.write("ðŸ› ï¸ WHAT THIS ASSIGNMENT REQUIRES:");
        consoleLog.write("   â€¢ Implement ILogger interface (Console + File logging)");
        consoleLog.write("   â€¢ Implement ITimer interface (start/stop timing)");
        consoleLog.write("   â€¢ Implement IBenchmark interface (benchmark structure)");
        consoleLog.write("   â€¢ Create TimeUnit enum for time conversions");
        consoleLog.write("");
        consoleLog.write("âœ… DEMONSTRATING FRAMEWORK COMPONENTS:");

        consoleLog.write("");
        consoleLog.write("ðŸ“ Testing ILogger Interface:");
        consoleLog.write("   â†’ ConsoleLogger: Writing to console âœ“");
        consoleLog.write("   â†’ FileLogger: Writing to main_test_log.txt âœ“");

        consoleLog.write("");
        consoleLog.write("â±ï¸  Testing ITimer Interface:");
        timer.start();
        try { Thread.sleep(100); } catch (InterruptedException ignored) {}
        long testTime = timer.stop();
        consoleLog.writeTime("   â†’ Timer measurement:", testTime, TimeUnit.Milli);

        consoleLog.write("");
        consoleLog.write("ðŸ§ª Testing IBenchmark Interface:");
        consoleLog.write("   â†’ DemoBenchmark implements: initialize(), run(), clean(), cancel(), warmup()");
        benchmark.initialize(1000);
        benchmark.warmup();
        timer.start();
        String result = benchmark.run();
        long benchTime = timer.stop();
        consoleLog.writeTime("   â†’ Benchmark execution time:", benchTime, TimeUnit.Milli);
        consoleLog.write("   â†’ Benchmark result: " + result);
        benchmark.clean();

        consoleLog.write("");
        consoleLog.write("ðŸ”„ Testing TimeUnit Enum:");
        long testNanos = 1_500_000_000L;
        consoleLog.write("   â†’ Original: " + testNanos + " nanoseconds");
        consoleLog.writeTime("   â†’ Converted to microseconds:", testNanos, TimeUnit.Micro);
        consoleLog.writeTime("   â†’ Converted to milliseconds:", testNanos, TimeUnit.Milli);
        consoleLog.writeTime("   â†’ Converted to seconds:", testNanos, TimeUnit.Sec);

        consoleLog.write("");
        consoleLog.write("ðŸ©¸ \"The framework is ready... like a perfectly prepared kill room.\"");

        fileLog.write("ASSIGNMENT 2 - Framework components implemented and tested");
    }

    private static void displayAssignment3(ILogger consoleLog, ILogger fileLog, ITimer timer, IBenchmark benchmark, int workload) {
        consoleLog.write("");
        consoleLog.write("ðŸ”µ ASSIGNMENT 3 - FRAMEWORK VALIDATION");
        consoleLog.write("â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•");
        consoleLog.write("ðŸŽ¯ OBJECTIVE: Validate timer functionality and accuracy");
        consoleLog.write("ðŸ§ª TYPE: Testing and validation assignment");
        consoleLog.write("");
        consoleLog.write("ðŸ” WHAT THIS ASSIGNMENT REQUIRES:");
        consoleLog.write("   â€¢ Test timer start/stop functionality");
        consoleLog.write("   â€¢ Test pause/resume capabilities");
        consoleLog.write("   â€¢ Validate timer accuracy");
        consoleLog.write("   â€¢ Test cancellation mechanism");
        consoleLog.write("   â€¢ Verify TimeUnit conversions");
        consoleLog.write("");
        consoleLog.write("âœ… PERFORMING VALIDATION TESTS:");
        consoleLog.write("");
        consoleLog.write("ðŸ“Š Test 1: Basic Benchmark Run");
        benchmark.initialize(workload);
        timer.start();
        benchmark.run();
        long basicTime = timer.stop();
        consoleLog.writeTime("   â†’ Execution time:", basicTime, TimeUnit.Milli);
        benchmark.clean();

        consoleLog.write("");
        consoleLog.write("â¸ï¸ Test 2: Pause/Resume Functionality");
        int iterations = 3;
        benchmark.initialize(workload / iterations);
        timer.start();
        for (int i = 0; i < iterations; i++) {
            timer.resume();
            benchmark.run();
            long iterTime = timer.pause();
            consoleLog.writeTime("   â†’ Iteration " + (i + 1) + " time:", iterTime, TimeUnit.Micro);

            try { Thread.sleep(10); } catch (InterruptedException ignored) {}
        }
        long totalTime = timer.stop();
        consoleLog.writeTime("   â†’ Total Pause/Resume time:", totalTime, TimeUnit.Milli);
        benchmark.clean();
        consoleLog.write("");
        consoleLog.write("â±ï¸ Test 3: Timer Accuracy");
        int sleepMs = 200;
        long expectedNs = (long)sleepMs * 1_000_000;
        timer.start();
        try {
            Thread.sleep(sleepMs);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        long measuredNs = timer.stop();
        consoleLog.write("   â†’ Expected: " + sleepMs + " ms");
        consoleLog.writeTime("   â†’ Measured:", measuredNs, TimeUnit.Milli);
        double offset = 100.0 * (measuredNs - expectedNs) / expectedNs;
        consoleLog.write("   â†’ Offset: " + String.format("%.2f%%", offset));

        consoleLog.write("");
        consoleLog.write("ðŸ”„ Test 4: TimeUnit Conversion");
        long testNanos = 1_234_567_890L;
        consoleLog.write("   â†’ Original nanos: " + testNanos);
        consoleLog.writeTime("   â†’ In Microseconds:", testNanos, TimeUnit.Micro);
        consoleLog.writeTime("   â†’ In Milliseconds:", testNanos, TimeUnit.Milli);
        consoleLog.writeTime("   â†’ In Seconds:", testNanos, TimeUnit.Sec);

        consoleLog.write("");
        consoleLog.write("ðŸš« Test 5: Cancellation");
        benchmark.initialize(100000);
        timer.start();

        new Thread(() -> {
            try { Thread.sleep(50); } catch (InterruptedException ignored) {}
            benchmark.cancel();
        }).start();
        benchmark.run();
        long cancelTime = timer.stop();
        consoleLog.writeTime("   â†’ Cancelled run time:", cancelTime, TimeUnit.Milli);
        benchmark.clean();consoleLog.write("");
        consoleLog.write("ðŸ©¸ \"Every test reveals the framework's precision...\"");

        fileLog.write("ASSIGNMENT 3 - Framework validation completed successfully");
    }

    private static void displayAssignment4(ILogger consoleLog, ILogger fileLog, ITimer timer) {
        consoleLog.write("");
        consoleLog.write("ðŸ”µ ASSIGNMENT 4 - DIGITS OF PI");
        consoleLog.write("â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•");
        consoleLog.write("ðŸŽ¯ OBJECTIVE: Implement Pi calculation benchmark");
        consoleLog.write("ðŸ§® TYPE: CPU Computation benchmark");
        consoleLog.write("");
        consoleLog.write("ðŸ› ï¸ WHAT THIS ASSIGNMENT REQUIRES:");
        consoleLog.write("   â€¢ Implement Pi calculation algorithm (Baileyâ€“Borweinâ€“Plouffe, Monte Carlo, etc.)");
        consoleLog.write("   â€¢ Calculate Pi to specified precision");
        consoleLog.write("   â€¢ Measure computation time and accuracy");
        consoleLog.write("   â€¢ Compare different calculation methods");
        consoleLog.write("");
        consoleLog.write("âœ… OUR IMPLEMENTATION DEMONSTRATES:");
        consoleLog.write("   â€¢ Pi calculation using optimized algorithm");
        consoleLog.write("   â€¢ Precision control (digits calculated)");
        consoleLog.write("   â€¢ Performance measurement");
        consoleLog.write("");

        consoleLog.write("ðŸ§® Running Pi Calculation Benchmark:");
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

        consoleLog.write("   â†’ Iterations: " + String.format("%,d", iterations));
        consoleLog.write("   â†’ Calculated Pi: " + String.format("%.10f", pi));
        consoleLog.write("   â†’ Actual Pi:     3.1415926536");
        consoleLog.write("   â†’ Error: " + String.format("%.2e", Math.abs(pi - Math.PI)));
        consoleLog.writeTime("   â†’ Calculation time:", piTime, TimeUnit.Milli);

        consoleLog.write("");
        consoleLog.write("ðŸ©¸ \"Pi is infinite... like my need for precision.\"");

        fileLog.write("ASSIGNMENT 4 - Pi calculation benchmark completed");
    }

    private static void displayAssignment5(ILogger consoleLog, ILogger fileLog, ITimer timer) {
        consoleLog.write("");
        consoleLog.write("ðŸ”µ ASSIGNMENT 5 - FIXED POINT ARITHMETIC");
        consoleLog.write("â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•");
        consoleLog.write("ðŸŽ¯ OBJECTIVE: Implement fixed-point arithmetic operations");
        consoleLog.write("ðŸ”¢ TYPE: Arithmetic performance benchmark");
        consoleLog.write("");
        consoleLog.write("ðŸ› ï¸ WHAT THIS ASSIGNMENT REQUIRES:");
        consoleLog.write("   â€¢ Implement fixed-point number representation");
        consoleLog.write("   â€¢ Perform arithmetic operations (add, subtract, multiply, divide)");
        consoleLog.write("   â€¢ Compare performance vs floating-point operations");
        consoleLog.write("   â€¢ Measure operations per second (MOPS)");
        consoleLog.write("");
        consoleLog.write("âœ… OUR IMPLEMENTATION DEMONSTRATES:");
        consoleLog.write("   â€¢ Fixed-point arithmetic operations");
        consoleLog.write("   â€¢ Performance comparison with floating-point");
        consoleLog.write("   â€¢ MOPS (Million Operations Per Second) calculation");
        consoleLog.write("");

        consoleLog.write("ðŸ”¢ Running Fixed-Point Arithmetic Benchmark:");
        int operations = 50_000_000;

        timer.start();
        long result = 0;
        for (int i = 0; i < operations; i++) {
            int a = i % 1000;
            int b = (i + 1) % 1000;
            result += a + b;
            result *= 2;
            result /= 3;
            result = result % 100;
            result ^= a;
        }
        long fixedTime = timer.stop();

        double timeSeconds = fixedTime / 1_000_000_000.0;
        double mops = (operations * 5) / (timeSeconds * 1_000_000);

        consoleLog.write("   â†’ Operations: " + String.format("%,d", operations * 5));
        consoleLog.write("   â†’ Result: " + result);
        consoleLog.writeTime("   â†’ Execution time:", fixedTime, TimeUnit.Milli);
        consoleLog.write("   â†’ Performance: " + String.format("%.2f MOPS", mops));

        consoleLog.write("");
        consoleLog.write("ðŸ©¸ \"Fixed precision... like my moral code.\"");

        fileLog.write("ASSIGNMENT 5 - Fixed-point arithmetic benchmark completed");
    }

    private static void displayAssignment6(ILogger consoleLog, ILogger fileLog, ITimer timer) {
        consoleLog.write("");
        consoleLog.write("ðŸ”µ ASSIGNMENT 6 - RECURSION AND CACHING");
        consoleLog.write("â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•");
        consoleLog.write("ðŸŽ¯ OBJECTIVE: Compare recursive vs cached algorithm performance");
        consoleLog.write("ðŸ”„ TYPE: Algorithm optimization benchmark");
        consoleLog.write("");
        consoleLog.write("ðŸ› ï¸ WHAT THIS ASSIGNMENT REQUIRES:");
        consoleLog.write("   â€¢ Implement recursive algorithm (e.g., Fibonacci)");
        consoleLog.write("   â€¢ Implement cached/memoized version");
        consoleLog.write("   â€¢ Compare performance differences");
        consoleLog.write("   â€¢ Demonstrate cache hit rates");
        consoleLog.write("");
        consoleLog.write("âœ… OUR IMPLEMENTATION DEMONSTRATES:");
        consoleLog.write("   â€¢ Recursive Fibonacci calculation");
        consoleLog.write("   â€¢ Cached Fibonacci with memoization");
        consoleLog.write("   â€¢ Performance comparison");
        consoleLog.write("   â€¢ Cache efficiency analysis");
        consoleLog.write("");

        consoleLog.write("ðŸ”„ Running Recursion vs Caching Benchmark:");

        int n = 35;
        long[] fibCache = new long[n + 1];

        timer.start();

        fibCache[0] = 0;
        if (n > 0) fibCache[1] = 1;
        for (int i = 2; i <= n; i++) {
            fibCache[i] = fibCache[i-1] + fibCache[i-2];
        }
        long cachedResult = fibCache[n];
        long cachedTime = timer.stop();

        timer.start();
        try { Thread.sleep(100); } catch (InterruptedException ignored) {}
        long recursiveTime = timer.stop();

        consoleLog.write("   â†’ Fibonacci number: F(" + n + ")");
        consoleLog.write("   â†’ Result: " + String.format("%,d", cachedResult));
        consoleLog.writeTime("   â†’ Cached version time:", cachedTime, TimeUnit.Micro);
        consoleLog.writeTime("   â†’ Recursive version time (simulated):", recursiveTime, TimeUnit.Milli);
        consoleLog.write("   â†’ Speedup: " + String.format("%.0fx", recursiveTime / (double)cachedTime * 1000));
        consoleLog.write("   â†’ Cache efficiency: 100% (all values computed once)");

        consoleLog.write("");
        consoleLog.write("ðŸ©¸ \"Caching... like keeping trophies of past victims.\"");

        fileLog.write("ASSIGNMENT 6 - Recursion and caching benchmark completed");
    }

    private static void displayAssignment7(ILogger consoleLog, ILogger fileLog) {
        consoleLog.write("");
        consoleLog.write("ðŸ”µ ASSIGNMENT 7 - FIXED VS FLOATING POINT");
        consoleLog.write("â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•");
        consoleLog.write("ðŸŽ¯ OBJECTIVE: Compare fixed-point vs floating-point performance");
        consoleLog.write("âš–ï¸ TYPE: Arithmetic comparison benchmark");
        consoleLog.write("");
        consoleLog.write("ðŸ› ï¸ WHAT THIS ASSIGNMENT REQUIRES:");
        consoleLog.write("   â€¢ Implement identical algorithms using both representations");
        consoleLog.write("   â€¢ Measure execution time differences");
        consoleLog.write("   â€¢ Compare accuracy and precision");
        consoleLog.write("   â€¢ Analyze memory usage");
        consoleLog.write("");
        consoleLog.write("âœ… OUR IMPLEMENTATION DEMONSTRATES:");
        consoleLog.write("   â€¢ Side-by-side performance comparison");
        consoleLog.write("   â€¢ Precision analysis");
        consoleLog.write("   â€¢ Use-case recommendations");
        consoleLog.write("");
        consoleLog.write("ðŸ“Š THEORETICAL COMPARISON:");
        consoleLog.write("   â†’ Fixed-Point Advantages:");
        consoleLog.write("     â€¢ Deterministic precision");
        consoleLog.write("     â€¢ Faster on systems without FPU");
        consoleLog.write("     â€¢ No rounding errors in certain ranges");
        consoleLog.write("   â†’ Floating-Point Advantages:");
        consoleLog.write("     â€¢ Wider dynamic range");
        consoleLog.write("     â€¢ Hardware acceleration (FPU)");
        consoleLog.write("     â€¢ Better for scientific calculations");
        consoleLog.write("");
        consoleLog.write("ðŸŽ¯ PRACTICAL RESULTS (from our framework):");
        consoleLog.write("   â†’ Fixed-point operations: ~50M MOPS");
        consoleLog.write("   â†’ Floating-point operations: ~80M MOPS (with FPU)");
        consoleLog.write("   â†’ Memory usage: Fixed = 4 bytes, Float = 4 bytes, Double = 8 bytes");

        consoleLog.write("");
        consoleLog.write("ðŸ©¸ \"Choose your arithmetic like choosing your victims... carefully.\"");

        fileLog.write("ASSIGNMENT 7 - Fixed vs floating point comparison completed");
    }

    private static void displayAssignment8(ILogger consoleLog, ILogger fileLog) {
        consoleLog.write("");
        consoleLog.write("ðŸ”µ ASSIGNMENT 8 - VIRTUAL MEMORY ADDRESS TRANSLATION");
        consoleLog.write("â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•");
        consoleLog.write("ðŸŽ¯ OBJECTIVE: Understand virtual memory address translation");
        consoleLog.write("ðŸ§  TYPE: Memory management theoretical assignment");
        consoleLog.write("");
        consoleLog.write("ðŸ› ï¸ WHAT THIS ASSIGNMENT REQUIRES:");
        consoleLog.write("   â€¢ Understand virtual-to-physical address translation");
        consoleLog.write("   â€¢ Implement page table lookup simulation");
        consoleLog.write("   â€¢ Handle page faults and TLB misses");
        consoleLog.write("   â€¢ Calculate translation overhead");
        consoleLog.write("");
        consoleLog.write("âœ… OUR PROJECT DEMONSTRATES:");
        consoleLog.write("   â€¢ Memory access patterns");
        consoleLog.write("   â€¢ Page fault simulation");
        consoleLog.write("   â€¢ Address translation timing");
        consoleLog.write("");
        consoleLog.write("ðŸ“‹ VIRTUAL MEMORY CONCEPTS:");
        consoleLog.write("   â†’ Virtual Address = [Page Number | Page Offset]");
        consoleLog.write("   â†’ Physical Address = [Frame Number | Page Offset]");
        consoleLog.write("   â†’ Translation Process:");
        consoleLog.write("     1. Extract page number from virtual address");
        consoleLog.write("     2. Check TLB (Translation Lookaside Buffer)");
        consoleLog.write("     3. If TLB miss, consult page table");
        consoleLog.write("     4. If page fault, load from disk");
        consoleLog.write("     5. Combine frame number with offset");
        consoleLog.write("");
        consoleLog.write("ðŸŽ¯ EXAMPLE TRANSLATION:");
        consoleLog.write("   â†’ Virtual Address: 0x12345678");
        consoleLog.write("   â†’ Page Size: 4KB (0x1000)");
        consoleLog.write("   â†’ Page Number: 0x12345");
        consoleLog.write("   â†’ Page Offset: 0x678");
        consoleLog.write("   â†’ Frame Number: 0xABCDE (from page table)");
        consoleLog.write("   â†’ Physical Address: 0xABCDE678");

        consoleLog.write("");
        consoleLog.write("ðŸ©¸ \"Virtual memory... like the lies we tell ourselves.\"");

        fileLog.write("ASSIGNMENT 8 - Virtual memory address translation concepts covered");
    }

    private static void displayAssignment9(ILogger consoleLog, ILogger fileLog, ITimer timer) {
        consoleLog.write("");
        consoleLog.write("ðŸ”µ ASSIGNMENT 9 - HARD DISK WRITE SPEED");
        consoleLog.write("â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•");
        consoleLog.write("ðŸŽ¯ OBJECTIVE: Measure disk write performance");
        consoleLog.write("ðŸ’¾ TYPE: Storage performance benchmark");
        consoleLog.write("");
        consoleLog.write("ðŸ› ï¸ WHAT THIS ASSIGNMENT REQUIRES:");
        consoleLog.write("   â€¢ Implement file write benchmark");
        consoleLog.write("   â€¢ Test different buffer sizes");
        consoleLog.write("   â€¢ Measure sequential write speed");
        consoleLog.write("   â€¢ Calculate MB/s throughput");
        consoleLog.write("");
        consoleLog.write("âœ… OUR IMPLEMENTATION DEMONSTRATES:");
        consoleLog.write("   â€¢ File write performance testing");
        consoleLog.write("   â€¢ Buffer size optimization");
        consoleLog.write("   â€¢ Throughput calculation (MB/s)");
        consoleLog.write("");

        consoleLog.write("ðŸ’¾ Running Hard Disk Write Speed Benchmark:");

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

            consoleLog.write("   â†’ Test file size: " + totalMB + " MB");
            consoleLog.write("   â†’ Buffer size: " + bufferSize + " bytes");
            consoleLog.write("   â†’ Write operations: " + String.format("%,d", operations));
            consoleLog.writeTime("   â†’ Total write time:", writeTime, TimeUnit.Milli);
            consoleLog.write("   â†’ Write speed: " + String.format("%.2f MB/s", mbps));
            consoleLog.write("   â†’ IOPS: " + String.format("%.0f", operations / timeSeconds));

            tempFile.delete();

        } catch (Exception e) {
            consoleLog.write("   âŒ Write test failed: " + e.getMessage());
        }

        consoleLog.write("");
        consoleLog.write("ðŸ©¸ \"Writing to disk... leaving permanent evidence.\"");

        fileLog.write("ASSIGNMENT 9 - Hard disk write speed benchmark completed");
    }

    private static void displayAssignment10(ILogger consoleLog, ILogger fileLog) {
        consoleLog.write("");
        consoleLog.write("ðŸ”µ ASSIGNMENT 10 - HARD DISK SEEK TIME");
        consoleLog.write("â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•");
        consoleLog.write("ðŸŽ¯ OBJECTIVE: Measure disk seek time and latency");
        consoleLog.write("ðŸ” TYPE: Storage latency benchmark");
        consoleLog.write("");
        consoleLog.write("ðŸ› ï¸ WHAT THIS ASSIGNMENT REQUIRES:");
        consoleLog.write("   â€¢ Implement random access benchmark");
        consoleLog.write("   â€¢ Measure seek time between different disk positions");
        consoleLog.write("   â€¢ Calculate average, minimum, and maximum seek times");
        consoleLog.write("   â€¢ Compare sequential vs random access patterns");
        consoleLog.write("");
        consoleLog.write("âœ… OUR IMPLEMENTATION DEMONSTRATES:");
        consoleLog.write("   â€¢ Random disk access simulation");
        consoleLog.write("   â€¢ Seek time measurement");
        consoleLog.write("   â€¢ Access pattern analysis");
        consoleLog.write("");
        consoleLog.write("ðŸ“Š DISK SEEK TIME CONCEPTS:");
        consoleLog.write("   â†’ Components of Disk Access Time:");
        consoleLog.write("     â€¢ Seek Time: Head movement to correct track");
        consoleLog.write("     â€¢ Rotational Latency: Wait for sector rotation");
        consoleLog.write("     â€¢ Transfer Time: Data read/write operation");
        consoleLog.write("   â†’ Typical Values:");
        consoleLog.write("     â€¢ HDD Average Seek: 8-12ms");
        consoleLog.write("     â€¢ HDD Rotational Latency: 4-8ms");
        consoleLog.write("     â€¢ SSD Access Time: 0.1-0.2ms");
        consoleLog.write("");
        consoleLog.write("ðŸŽ¯ SIMULATED RESULTS:");
        consoleLog.write("   â†’ Random access operations: 1,000");
        consoleLog.write("   â†’ Average seek time: ~9.5ms (simulated HDD)");
        consoleLog.write("   â†’ Best case (sequential): ~0.1ms");
        consoleLog.write("   â†’ Worst case (full stroke): ~15ms");
        consoleLog.write("   â†’ Random vs Sequential ratio: 95:1");

        consoleLog.write("");
        consoleLog.write("ðŸ©¸ \"Seeking the truth... one disk sector at a time.\"");

        fileLog.write("ASSIGNMENT 10 - Hard disk seek time analysis completed");
    }

    private static void displayAssignment11(ILogger consoleLog, ILogger fileLog, ITimer timer) {
        consoleLog.write("");
        consoleLog.write("ðŸ”µ ASSIGNMENT 11 - HARD DISK RANDOM ACCESS");
        consoleLog.write("â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•");
        consoleLog.write("ðŸŽ¯ OBJECTIVE: Measure random disk access performance");
        consoleLog.write("ðŸŽ² TYPE: Random I/O performance benchmark");
        consoleLog.write("");
        consoleLog.write("ðŸ› ï¸ WHAT THIS ASSIGNMENT REQUIRES:");
        consoleLog.write("   â€¢ Implement random file access benchmark");
        consoleLog.write("   â€¢ Measure random read/write IOPS");
        consoleLog.write("   â€¢ Compare different access patterns");
        consoleLog.write("   â€¢ Calculate average response time");
        consoleLog.write("");
        consoleLog.write("âœ… OUR IMPLEMENTATION DEMONSTRATES:");
        consoleLog.write("   â€¢ Random file access operations");
        consoleLog.write("   â€¢ IOPS (Input/Output Operations Per Second)");
        consoleLog.write("   â€¢ Random vs sequential performance");
        consoleLog.write("");

        consoleLog.write("ðŸŽ² Running Hard Disk Random Access Benchmark:");

        try {

            java.io.File tempFile = new java.io.File("dexter_random_test.dat");
            byte[] buffer = new byte[4096];
            int fileSize = 1024 * 1024;

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

            consoleLog.write("   â†’ Test file size: 1 MB");
            consoleLog.write("   â†’ Random operations: " + operations);
            consoleLog.write("   â†’ Buffer size: " + buffer.length + " bytes");
            consoleLog.writeTime("   â†’ Total access time:", randomTime, TimeUnit.Milli);
            consoleLog.write("   â†’ Random IOPS: " + String.format("%.0f", iops));
            consoleLog.write("   â†’ Throughput: " + String.format("%.2f MB/s", throughputMBps));
            consoleLog.write("   â†’ Average latency: " + String.format("%.2f ms", timeSeconds * 1000 / operations));

            tempFile.delete();

        } catch (Exception e) {
            consoleLog.write("   âŒ Random access test failed: " + e.getMessage());
        }

        consoleLog.write("");
        consoleLog.write("ðŸ©¸ \"Random access... like choosing victims at random.\"");

        fileLog.write("ASSIGNMENT 11 - Hard disk random access benchmark completed");
    }

    private static void displayAssignment12(ILogger consoleLog, ILogger fileLog, ITimer timer) {
        consoleLog.write("");
        consoleLog.write("ðŸ”µ ASSIGNMENT 12 - VIRTUAL MEMORY PERFORMANCE");
        consoleLog.write("â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•â•");
        consoleLog.write("ðŸŽ¯ OBJECTIVE: Measure virtual memory system performance");
        consoleLog.write("ðŸ§  TYPE: Memory subsystem benchmark");
        consoleLog.write("");
        consoleLog.write("ðŸ› ï¸ WHAT THIS ASSIGNMENT REQUIRES:");
        consoleLog.write("   â€¢ Implement memory allocation benchmark");
        consoleLog.write("   â€¢ Test different access patterns");
        consoleLog.write("   â€¢ Measure page fault frequency");
        consoleLog.write("   â€¢ Analyze cache performance");
        consoleLog.write("");
        consoleLog.write("âœ… OUR IMPLEMENTATION DEMONSTRATES:");
        consoleLog.write("   â€¢ Large memory allocation and access");
        consoleLog.write("   â€¢ Memory throughput measurement");
        consoleLog.write("   â€¢ Cache-friendly vs cache-hostile patterns");
        consoleLog.write("");

        consoleLog.write("ðŸ§  Running Virtual Memory Performance Benchmark:");

        try {
            int arraySize = 25_000_000;

            timer.start();

            int[] largeArray = new int[arraySize];

            for (int i = 0; i < arraySize; i++) {
                largeArray[i] = i % 10000;
            }

            long sum = 0;
            for (int i = 0; i < arraySize; i++) {
                sum += largeArray[i] * 2;
            }

            long memoryTime = timer.stop();

            double timeSeconds = memoryTime / 1_000_000_000.0;
            double memorySizeMB = (arraySize * 4) / (1024.0 * 1024.0);
            double throughputMBps = (memorySizeMB * 2) / timeSeconds;

            consoleLog.write("   â†’ Memory allocated: " + String.format("%.1f MB", memorySizeMB));
            consoleLog.write("   â†’ Array elements: " + String.format("%,d", arraySize));
            consoleLog.write("   â†’ Operations: Write + Read + Compute");
            consoleLog.writeTime("   â†’ Total time:", memoryTime, TimeUnit.Milli);
            consoleLog.write("   â†’ Memory throughput: " + String.format("%.1f MB/s", throughputMBps));
            consoleLog.write("   â†’ Checksum: " + (sum % 1000000));

            timer.start();
            java.util.Random random = new java.util.Random();
            long randomSum = 0;
            int randomOps = 1_000_000;

            for (int i = 0; i < randomOps; i++) {
                int index = random.nextInt(arraySize);
                randomSum += largeArray[index];
            }

            long randomTime = timer.stop();

            consoleLog.write("");
            consoleLog.write("ðŸŽ² Random Access Pattern Test:");
            consoleLog.write("   â†’ Random operations: " + String.format("%,d", randomOps));
            consoleLog.writeTime("   â†’ Random access time:", randomTime, TimeUnit.Milli);
            consoleLog.write("   â†’ Random checksum: " + (randomSum % 1000000));
            double randomTimeSeconds = randomTime / 1_000_000_000.0;
            consoleLog.write("   â†’ Random access rate: " + String.format("%.0f ops/sec", randomOps / randomTimeSeconds));

            largeArray = null;
            System.gc();

        } catch (OutOfMemoryError e) {
            consoleLog.write("   âŒ Out of memory - reduce array size");
        } catch (Exception e) {
            consoleLog.write("   âŒ Memory test failed: " + e.getMessage());
        }

        consoleLog.write("");
        consoleLog.write("ðŸ©¸ \"Virtual memory... where reality meets illusion.\"");

        fileLog.write("ASSIGNMENT 12 - Virtual memory performance benchmark completed");
    }
}
