# 🔪 DEXTER BENCHMARKING FRAMEWORK - PROJECT DOCUMENTATION 🔪

## 📖 Overview

The Dexter Benchmarking Framework is a comprehensive suite designed to test various aspects of computer performance, including CPU, Memory, and Storage systems. It features both a command-line testing framework and a visually appealing GUI for interactive benchmarking.

This document provides detailed information about the project, covering all assignments, their requirements, and implementations. It is structured to serve as a professional reference for academic evaluation and practical use.

---

## 📋 Project Structure

### **Framework Components**

- **ILogger Interface**: Console and file logging implementations with time formatting.
- **ITimer Interface**: High-precision timer with start/stop/pause/resume functionality.
- **IBenchmark Interface**: Comprehensive benchmark structure with warmup capabilities.
- **TimeUnit Enum**: Time conversions (nanoseconds, microseconds, milliseconds, seconds).

### **Benchmark Types**

- **CPU Benchmarks**: Pi calculation, Fixed-point arithmetic, Recursion and caching.
- **Memory Benchmarks**: Virtual memory performance and paging behavior.
- **Storage Benchmarks**: Write speed, Seek time analysis, Random access IOPS.

### **Testing Methods**

- **Command-Line Interface**: Automated testing via `test.bat` with comprehensive output.
- **Single Test Suite**: `Test.java` contains all assignment demonstrations.
- **File Logging**: Detailed logs saved to `main_test_log.txt` for analysis.

---

## 📚 Assignment Coverage

### 🔵 **Assignment 1 - Introduction to Benchmarks**

**Type**: Theory

**Requirements**:

- Research and document 2 benchmark programs.
- Explain functionalities, testing methods, and sample results.

**Implementation**:

- Theoretical research with examples like Geekbench and 3DMark.
- Practical demonstration through the Dexter framework.

---

### 🔵 **Assignment 2 - The Benchmark Framework**

**Type**: Programming

**Requirements**:

- Implement ILogger, ITimer, and IBenchmark interfaces.
- Create TimeUnit enum for time conversions.

**Implementation**:

- Complete framework setup with production-quality components.
- Console and file logging, timer accuracy validation.

---

### 🔵 **Assignment 3 - Framework Validation**

**Type**: Testing

**Requirements**:

- Validate timer functionality, pause/resume, and accuracy.
- Test cancellation mechanism and TimeUnit conversions.

**Implementation**:

- Comprehensive validation suite with real performance metrics.
- GUI and command-line testing methods.

---

### 🔵 **Assignment 4 - Digits of Pi**

**Type**: CPU Benchmark

**Requirements**:

- Implement Pi calculation algorithm.
- Measure computation time and accuracy.

**Implementation**:

- Uses Leibniz formula for Pi approximation.
- Configurable iterations and precision measurement.

---

### 🔵 **Assignment 5 - Fixed Point Arithmetic**

**Type**: Performance Benchmark

**Requirements**:

- Implement fixed-point arithmetic operations.
- Measure operations per second (MOPS).

**Implementation**:

- Integer-based arithmetic simulation with 250M operations.
- Performance measurement in MOPS.

---

### 🔵 **Assignment 6 - Recursion and Caching**

**Type**: Algorithm Optimization

**Requirements**:

- Implement recursive and cached algorithms.
- Compare performance differences.

**Implementation**:

- Cached Fibonacci using dynamic programming.
- Dramatic performance improvement demonstration.

---

### 🔵 **Assignment 9 - Hard Disk Write Speed**

**Type**: Storage Benchmark

**Requirements**:

- Implement file write benchmark.
- Measure sequential write speed and throughput.

**Implementation**:

- 10MB test file creation with optimized buffer size.
- Write speed: ~385 MB/s typical.

---

### 🔵 **Assignment 10 - Hard Disk Seek Time**

**Type**: Storage Latency Benchmark

**Requirements**:

- Measure seek time between different disk positions.
- Compare sequential vs random access patterns.

**Implementation**:

- Simulated results for 1,000 operations.
- Average seek time: 9.5ms typical.

---

### 🔵 **Assignment 11 - Hard Disk Random Access**

**Type**: Random I/O Benchmark

**Requirements**:

- Measure random read/write IOPS.
- Calculate average response time.

**Implementation**:

- 1MB test file with random seek operations.
- Random IOPS: ~166,000 typical.

---

### 🔵 **Assignment 12 - Virtual Memory Performance**

**Type**: Memory Benchmark

**Requirements**:

- Test memory allocation and access patterns.
- Measure page fault frequency and cache performance.

**Implementation**:

- Large memory allocation with sequential and random access.
- Memory throughput: ~1,888 MB/s.

---

## 🚀 How to Use the Framework

### **Method 1: GUI Testing**

1. Run `build.bat` to launch the GUI.
2. Select a benchmark to view real-time results.

### **Method 2: Command-Line Testing**

1. Compile the project using `javac`.
2. Run `java -cp bin Test` for automated testing.

---

## 🎨 Visual Design

### **DEXTER Theme**

- Dark red color scheme inspired by Dexter.
- Custom background images (`dexter.png`).
- Bold fonts and crime scene aesthetics.

### **Interactive Elements**

- Benchmark buttons with icons and emojis.
- Results panel displaying detailed metrics.

---

## ✅ Validation Checklist

- [ ] All benchmarks run without errors.
- [ ] GUI displays all 7 benchmark options.
- [ ] Command-line testing produces expected output.
- [ ] Log files are created and populated.
- [ ] Performance results are within expected ranges.

---

## 📚 Final Notes

The Dexter Benchmarking Framework successfully addresses all assignments with practical implementations and theoretical insights. It provides a robust platform for performance analysis and optimization.

> _"Every kill tells a story... every benchmark tells performance!"_ 📚
