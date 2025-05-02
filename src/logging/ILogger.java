package logging;

public interface ILogger {

    /**
    * @param value The long value to write.
     */
    void write(long value);

    /**
     * @param value The String value to write.
     */
    void write(String value);

    /**
     * @param values The objects to write.
     */
    void write(Object... values);

    /**
     * @param value The time value in nanoseconds.
     * @param unit The target TimeUnit for formatting.
     */
    void writeTime(long value, TimeUnit unit);

     /**.
     * @param prefix The string to print before the time.
     * @param value The time value in nanoseconds.
     * @param unit The target TimeUnit for formatting.
     */
    void writeTime(String prefix, long value, TimeUnit unit);
    void close();
}
