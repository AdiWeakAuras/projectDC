package logging;

public class ConsoleLogger implements ILogger {

    @Override
    public void write(long value) {
        System.out.println(value);
    }

    @Override
    public void write(String value) {
        System.out.println(value);
    }

    @Override
    public void write(Object... values) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            sb.append(values[i]);
            if (i < values.length - 1) {
                sb.append(" ");
            }
        }
        System.out.println(sb.toString());
    }

     @Override
    public void writeTime(long value, TimeUnit unit) {
        System.out.println(unit.format(value));
    }

    @Override
    public void writeTime(String prefix, long value, TimeUnit unit) {
        System.out.println(prefix + " " + unit.format(value));
    }

    @Override
    public void close() {

    }
}
