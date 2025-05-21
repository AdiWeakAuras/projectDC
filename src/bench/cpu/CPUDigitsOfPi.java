
package bench.cpu;

import bench.IBenchmark;

import java.math.BigDecimal;
import java.math.MathContext;

public class CPUDigitsOfPi implements IBenchmark {
    private int digits;

    @Override
    public void initialize(Object... params) {
        this.digits = (int) params[0];
    }

    @Override
    public void warmup() {
        computePi(1000); // Warmup with 1000 digits
    }

    @Override
    public void run() {
        computePi(digits);
    }

    @Override
    public void run(Object... options) {
        computePi(digits);
    }

    @Override
    public void clean() {
        // No cleanup needed
    }

    private void computePi(int digits) {
        MathContext mc = new MathContext(digits);
        BigDecimal pi = BigDecimal.ZERO;
        BigDecimal one = BigDecimal.ONE;
        BigDecimal sixteen = new BigDecimal(16);
        for (int k = 0; k < digits; k++) {
            BigDecimal kBD = new BigDecimal(k);
            BigDecimal term = (one.divide(sixteen.pow(k), mc))
                    .multiply(
                            new BigDecimal(4).divide(new BigDecimal(8 * k + 1), mc)
                                    .subtract(new BigDecimal(2).divide(new BigDecimal(8 * k + 4), mc))
                                    .subtract(new BigDecimal(1).divide(new BigDecimal(8 * k + 5), mc))
                                    .subtract(new BigDecimal(1).divide(new BigDecimal(8 * k + 6), mc))
                    );
            pi = pi.add(term);
        }
        // Uncomment to print the computed value:
        // System.out.println("Computed Pi: " + pi);
    }
}
