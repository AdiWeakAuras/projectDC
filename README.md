# Java Benchmarking Framework (ProjectDC)

This project implements a basic Java framework for benchmarking code execution time. It provides interfaces and implementations for timing, logging, and defining benchmark tasks.

## Project Structure

The project is organized into the following packages:

*   **`bench`**: Contains the core benchmarking interface and implementations.
    *   `IBenchmark`: Interface defining the contract for all benchmarks (`initialize`, `run`, `clean`, `cancel`).
    *   `DemoBenchmark`: A sample implementation of `IBenchmark` performing a simple array summation task.
*   **`timing`**: Handles time measurement.
    *   `ITimer`: Interface defining timing operations (`start`, `stop`, `pause`, `resume`).
    *   `Timer`: Implementation of `ITimer` using `System.nanoTime()`.
*   **`logging`**: Provides logging capabilities.
    *   `ILogger`: Interface for logging messages and formatted time (`write`, `writeTime`, `close`).
    *   `TimeUnit`: Enum for time unit constants (Nano, Micro, Milli, Sec) and conversion/formatting utilities.
    *   `ConsoleLogger`: Implementation of `ILogger` that writes to the standard console output.
    *   `FileLogger`: Implementation of `ILogger` that writes to a specified file (defaults to `benchmark.log`).
*   **`testbench`**: Contains classes to run and test the benchmarks.
    *   `TestDemoBench`: A class demonstrating various features like basic runs, pause/resume testing, timer accuracy checks, and cancellation.

## Running Tests

You can run the tests and demonstrations using the `main` method in:

*   `src/testbench/TestDemoBench.java`: Demonstrates specific features and validation steps as outlined in the assignments.
*   `src/Main.java`: Provides a consolidated test suite executing various components of the framework.

Compile and run these classes using your preferred Java IDE or the command line. Ensure the necessary source files are compiled and accessible via the classpath.
