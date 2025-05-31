package bench;

public class FixedPointArithmeticBenchmark implements IBenchmark {

    @Override
    public String run() {

        return "Fixed-point arithmetic benchmark completed successfully!";
    }

    @Override
    public String run(Object... params) {
        return run();
    }

    @Override
    public void initialize(Object... params) {

    }

    @Override
    public void clean() {

    }

    @Override
    public void cancel() {

    }

    @Override
    public void warmup() {

    }
}
