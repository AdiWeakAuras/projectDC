package logging;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileLogger implements ILogger {

    private PrintWriter writer;
    private static final String DEFAULT_FILENAME="benchmark.log";

    public FileLogger() {
        this(DEFAULT_FILENAME);
    }

    public FileLogger(String filename) {
        try {
            writer = new PrintWriter(new FileWriter(filename, false), true);
        } catch (IOException e) {
            System.err.println("Error initializing FileLogger: " + e.getMessage());
            writer = null;
        }
    }

    @Override
    public void write(long value) {
        if (writer != null) {
            writer.println(value);
        }
    }

    @Override
    public void write(String value) {
        if (writer != null) {
            writer.println(value);
        }
    }

    @Override
    public void write(Object... values) {
         if (writer != null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < values.length; i++) {
                sb.append(values[i]);
                if (i < values.length - 1) {
                    sb.append(" ");
                }
            }
            writer.println(sb.toString());
        }
    }

    @Override
    public void writeTime(long value, TimeUnit unit) {
         if (writer != null) {
            writer.println(unit.format(value));
        }
    }

    @Override
    public void writeTime(String prefix, long value, TimeUnit unit) {
         if (writer != null) {
            writer.println(prefix + " " + unit.format(value));
        }
    }

    @Override
    public void close() {
        if (writer != null) {
            writer.close();
        }
    }
}
