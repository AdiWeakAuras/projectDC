# DEXTER Benchmarking Framework

This project implements a comprehensive benchmarking framework designed to test various aspects of computer performance, including CPU, Memory, and Storage systems. Named after the meticulous serial killer from the TV series, this framework approaches performance testing with surgical precision.

## Project Structure

The project is organized into the following packages:

- **`bench`**: Contains the core benchmarking interface and implementations.
  - `IBenchmark`: Interface defining the contract for all benchmarks (`initialize`, `run`, `clean`, `cancel`, `warmup`).
  - `DemoBenchmark`: A sample implementation performing array summation tasks.
  - `DigitsOfPiBenchmark`: CPU computation benchmark calculating Pi to specified precision.
  - `FixedPointArithmeticBenchmark`: Arithmetic performance comparison (fixed vs floating point).
  - `RecursionAndCachingBenchmark`: CPU recursion limits and caching performance tests.
  - `HardDiskWriteSpeedBenchmark`: Storage write performance and throughput measurement.
  - `HardDiskRandomAccessBenchmark`: Random I/O performance and IOPS testing.
  - `VirtualMemoryBenchmark`: Memory subsystem performance and paging behavior analysis.
- **`timing`**: Handles precise time measurement.
  - `ITimer`: Interface defining timing operations (`start`, `stop`, `pause`, `resume`).
  - `Timer`: High-precision implementation using `System.nanoTime()`.
  - `TimerState`: Enum for timer state management.
- **`logging`**: Provides comprehensive logging capabilities.
  - `ILogger`: Interface for logging messages and formatted time output.
  - `TimeUnit`: Enum for time unit constants and conversion utilities (Nano, Micro, Milli, Sec).
  - `ConsoleLogger`: Real-time console output implementation.
  - `FileLogger`: File-based logging with customizable output files.
- **`tests`**: Contains the main test suite.
  - `Test`: Comprehensive test showcasing all assignments (2,3,4,5,6,9,10,11,12) with detailed explanations.
- **`gui`**: Interactive GUI for visual benchmarking.
  - `DexterBenchmarkGUI_ULTIMATE`: Advanced GUI with real-time results and professional interface.

## Running the Framework

### Command Line Testing

Run the comprehensive test suite using the batch script:

```bash
test.bat
```

This will:

1. Clean previous outputs
2. Compile all necessary components
3. Execute the full test suite with detailed assignment explanations

### Manual Execution

You can also run individual components:

```bash
# Compile the framework
javac -d bin -cp bin src/main/java/tests/Test.java

# Run the comprehensive test
java -cp bin tests.Test
```

## Features

- **Educational Content**: Detailed explanations of each assignment and framework capabilities
- **Performance Metrics**: MOPS, IOPS, MB/s, latency measurements
- **Real Benchmarks**: Actual CPU, memory, and storage performance tests
- **Professional Logging**: Both console and file output with time formatting
- **Modular Design**: Clean interfaces allowing easy extension and customization

## Assignment Coverage

The framework demonstrates implementations for assignments 2, 3, 4, 5, 6, 9, 10, 11, and 12, covering:

- Framework validation and timing accuracy
- CPU computation benchmarks (Pi calculation)
- Arithmetic performance analysis
- Recursion and caching behavior
- Storage performance testing (write speed, seek time, random access)
- Virtual memory performance analysis
