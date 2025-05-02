package cpu;

import bench.IBenchmark;
import java.math.BigDecimal;
import java.math.MathContext;

public class CPUDigitsOfPi implements IBenchmark {

    private volatile boolean running = true;
    private int digits;
    private BigDecimal result;

    @Override
    public void initialize(Object... params) {
        if (params.length == 0 || !(params[0] instanceof Integer)) {
            throw new IllegalArgumentException("Need number of digits (Integer)");
        }
        digits = (Integer) params[0];
        running = true;
    }

    @Override
    public void run() {
        result = computePi(digits);
    }

    @Override
    public void run(Object... options) {
        run(); // you can later add algo switching here
    }

    @Override
    public void cancel() {
        running = false;
    }

    @Override
    public void clean() {
        result = null;
    }

    @Override
    public void warmup() {
        computePi(500); // or less, just enough to trigger JIT
    }

    private BigDecimal computePi(int digits) {
        MathContext mc = new MathContext(digits + 5);
        BigDecimal arctan1_5 = arctan(BigDecimal.valueOf(1.0 / 5), mc);
        BigDecimal arctan1_239 = arctan(BigDecimal.valueOf(1.0 / 239), mc);
        BigDecimal pi = arctan1_5.multiply(BigDecimal.valueOf(4), mc)
                .subtract(arctan1_239, mc)
                .multiply(BigDecimal.valueOf(4), mc);
        return pi.round(new MathContext(digits));
    }

    private BigDecimal arctan(BigDecimal x, MathContext mc) {
        BigDecimal result = BigDecimal.ZERO;
        BigDecimal term;
        int k = 0;
        do {
            term = x.pow(2 * k + 1, mc).divide(BigDecimal.valueOf(2 * k + 1), mc);
            if (k % 2 != 0) term = term.negate();
            result = result.add(term, mc);
            k++;
        } while (term.abs().compareTo(BigDecimal.ZERO) > 0 && running && k < 10000);
        return result;
    }
}
