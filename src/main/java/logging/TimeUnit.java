package logging;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public enum TimeUnit {
    Nano(1, "ns"),
    Micro(1_000, "us"),
    Milli(1_000_000, "ms"),
    Sec(1_000_000_000, "s");

    private final long factor;
    private final String unit;
    private static final DecimalFormat df = new DecimalFormat("#.###", new DecimalFormatSymbols(Locale.US));

    TimeUnit(long factor, String unit) {
        this.factor = factor;
        this.unit = unit;
    }

    public double convert(long nanos) {
        return (double) nanos / factor;
    }

    public String format(long nanos) {
         return df.format(convert(nanos)) + " " + this.unit;
    }

    public static double convert(double value, TimeUnit sourceUnit, TimeUnit targetUnit) {
        double valueInNanos = value * sourceUnit.factor;
        return valueInNanos / targetUnit.factor;
    }

    public long toTimeUnit(long time, TimeUnit targetUnit) {
        return time / targetUnit.factor;
    }
}
