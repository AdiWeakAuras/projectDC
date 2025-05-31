package bench.hdd;

import java.io.IOException;

import bench.IBenchmark;
import logging.CustomFileWriter;

public class HDDWriteSpeed implements IBenchmark {

    private CustomFileWriter writer;

    @Override
    public void initialize(Object... params) {
        try {
            writer = new CustomFileWriter("D:\\student\\bench\\write0.dat");
        } catch (IOException e) {
            System.err.println("Failed to initialize file writer: " + e.getMessage());
        }
    }

    @Override
    public void warmup() {
        System.out.println("Warming up HDD benchmark...");
    }

    @Override
    public String run() {
        throw new UnsupportedOperationException("Method not implemented. Use run(Object) instead");
    }

    @Override
    public String run(Object... params) {
        String option = (String) params[0];
        String result = "";

        try {
            switch (option) {
                case "fs":
                    writer.write("Fixed file size benchmark");
                    result = "Fixed file size benchmark completed.";
                    break;
                case "fb":
                    writer.write("Fixed buffer size benchmark");
                    result = "Fixed buffer size benchmark completed.";
                    break;
                default:
                    throw new IllegalArgumentException("Invalid argument: " + option);
            }
        } catch (IllegalArgumentException e) {
            result = "Invalid argument provided: " + e.getMessage();
        } catch (IOException e) {
            result = "I/O error during benchmark execution: " + e.getMessage();
        }

        return result;
    }

    @Override
    public void clean() {
        System.out.println("Cleaning up temporary files...");
    }

    @Override
    public void cancel() {
        System.out.println("Benchmark canceled.");
    }
}
