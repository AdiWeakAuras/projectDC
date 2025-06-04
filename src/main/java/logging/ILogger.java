package logging;

public interface ILogger {

    void write(long value);

    void write(String value);

    void write(Object... values);

    void writeTime(long value, TimeUnit unit);

    void writeTime(String prefix, long value, TimeUnit unit);

    void close();
}
